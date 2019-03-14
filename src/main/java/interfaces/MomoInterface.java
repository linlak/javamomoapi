/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import java.net.HttpURLConnection;
import java.util.Map;
import org.json.simple.JSONObject;

/**
 *
 * @author Linus
 */
public interface MomoInterface {
    void setHeaders(String key,String value);
    void removeHeader(String key);
    JSONObject send(HttpURLConnection request);
    HttpURLConnection genRequest(String mtd,String url,JSONObject body);
    void setAuth();
    String gen_uuid();
    void setApiKey(String apiKey);
}
