/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package products;

import commons.MomoConstants;
import commons.MomoLinks;
import java.util.Map;
import javamomoapi.MomoApp;

/**
 *
 * @author Linus
 */
public class ApiUser extends MomoApp{
    
    public ApiUser(String apiPrimaryKey, String apiSecondary) {
        super(apiPrimaryKey, apiSecondary);
    }

    public ApiUser(String apiPrimaryKey, String apiSecondary, String environ) {
        super(apiPrimaryKey, apiSecondary, environ);
    }
    void createApiUser(String uid,String callbackUri){
		setHeaders(MomoConstants.H_REF_ID,uid);
		removeHeader(MomoConstants.H_AUTH);
		removeHeader(MomoConstants.H_ENVIRON);
//		$body=['providerCallbackHost'=>$callbackUri];
//		return send(genRequest("POST",MomoLinks::USER_URI,$body));		
	}
	Map<String,Object> getApiUser(String uid){
		removeHeader(MomoConstants.H_AUTH);
		removeHeader(MomoConstants.H_ENVIRON);
		return send(genRequest("GET",MomoLinks.USER_URI+"/"+uid,null));
	}
	Map<String,Object> getApikey(String uid){
		removeHeader(MomoConstants.H_AUTH);
		removeHeader(MomoConstants.H_ENVIRON);
		return send(genRequest("POST",MomoLinks.USER_URI+"/"+uid+"/apikey",null));
	}
	Map<String,Object>  apiUserHook(){
            return null;
        }
}
