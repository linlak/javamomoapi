/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javamomoapi;

import commons.MomoConstants;
import interfaces.MomoInterface;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.SecureRandom;
import java.util.Base64;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.simple.JSONObject;

/**
 *
 * @author Linus
 */
public class MomoApp implements MomoInterface{
    protected String environ;//live
	protected String apiVersion="v1_0";
	protected String apiPrimaryKey,apiSecondary;
	protected String apiKey="";
	private String apiToken;
	protected String apiUserId="";
        protected Map<String,String> headers=new HashMap<>();
        private static final long MSB = 0x8000000000000000L;
    public MomoApp(String apiPrimaryKey, String apiSecondary) {
        this(apiPrimaryKey,apiSecondary,"sandbox");
    }

    public MomoApp(String apiPrimaryKey, String apiSecondary,String environ) {
        this.apiPrimaryKey = apiPrimaryKey;
        this.apiSecondary = apiSecondary;
        this.environ=environ;
        genHeaders();
    }
    private void genHeaders(){
        setHeaders(MomoConstants.H_ENVIRON,environ);  
        setHeaders(MomoConstants.H_OCP_APIM, apiPrimaryKey);
//        setHeaders(MomoConstants.H_ENVIRON,environ);
    }
    @Override
    public void setHeaders(String key, String value) {
        headers.put(key,value);
    }

    @Override
    public void removeHeader(String key) {
        if(headers.containsKey(key)){
            headers.remove(key);
        }
    }

    @Override
    public JSONObject send(HttpURLConnection request) {
       JSONObject result=new JSONObject();
        if(request!=null){
            StringBuilder sb=new StringBuilder();
            JSONObject data=null;
            try {
                int code=request.getResponseCode();
                String status=request.getResponseMessage();
                result.put("status_code", code);
                result.put("status_phrase", status);

                if(code==HttpURLConnection.HTTP_OK){
                    BufferedReader br;
                    br = new BufferedReader(new InputStreamReader(request.getInputStream(),"utf-8"));
                    String line;
                    while ((line=br.readLine())!=null) {                        
                        sb.append(line);
                        sb.append("\n\r");
                    }
                    br.close();
                }
            } catch (IOException ex) {
                Logger.getLogger(MomoApp.class.getName()).log(Level.SEVERE, null, ex);
            }       
     
            result.put("data",data);
        }else{
            result.put("status_code", 0);
            result.put("status_phrase", "Connection Error");
        }
        return result;
   }

    @Override
    public HttpURLConnection genRequest(String mtd, String url, JSONObject body) {
        try {
            URL uri=new URL(url);
            HttpURLConnection conn=(HttpURLConnection) uri.openConnection();
            conn.setDoInput(true);
            conn.setDoOutput(true);
            conn.setRequestMethod(mtd);
           Iterator it=headers.entrySet().iterator();
           while (it.hasNext()) {
               Map.Entry<String,String> pair=(Map.Entry<String,String>) it.next();
               conn.setRequestProperty(pair.getKey(), pair.getValue()); 
               it.remove();
            }
           if(body!=null){ 
               conn.setRequestProperty(MomoConstants.H_C_TYPE, "application/json");
                OutputStream os;
                os = conn.getOutputStream();
                os.write(body.toJSONString().getBytes("UTF-8"));
                os.close();
           }
            return conn;
           
        } catch (MalformedURLException ex) {
            Logger.getLogger(MomoApp.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) { 
            Logger.getLogger(MomoApp.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
   }

    @Override
    public void setAuth() {
        if(apiToken!=null){
            setHeaders(MomoConstants.H_AUTH, apiToken);
            return;
        }
        String authKey="";
        
        setHeaders(MomoConstants.H_AUTH, "Basic "+Base64.getEncoder().encodeToString(MomoConstants.toByte(authKey)));
    }

    @Override
    public String gen_uuid() {
        SecureRandom ng=new SecureRandom();
        return Long.toHexString(MSB | ng.nextLong()) + Long.toHexString(MSB | ng.nextLong());
    }

    @Override
    public void setApiKey(String apiKey) {
       this.apiKey=apiKey;
    }    
    
}
