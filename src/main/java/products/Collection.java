/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package products;

import commons.MomoConstants;
import commons.MomoLinks;
import interfaces.CollectionInterface;
import java.util.Map;
import javamomoapi.MomoApp;
import models.RequestToPay;

/**
 *
 * @author Linus
 */
public class Collection extends MomoApp implements CollectionInterface{

    
    public Collection(String apiPrimaryKey, String apiSecondary) {
        super(apiPrimaryKey, apiSecondary);
    }
    public Collection(String apiPrimaryKey, String apiSecondary, String environ) {
        super(apiPrimaryKey, apiSecondary, environ);
    }

    
    @Override
    public Map<String,Object> requestToPay(RequestToPay requestBody, String ref, String callbackUri) {
        if(null!=callbackUri){
            setHeaders(MomoConstants.H_CALL_BACK, callbackUri);
        }
        setHeaders(MomoConstants.H_REF_ID, ref);
        if(this.environ.equals(MomoConstants.ENV_SANDBOX)){
            requestBody.setCurrency(MomoConstants.C_EUR);
        }
        setAuth();
            return send(genRequest("POST", MomoLinks.REQUEST_TO_PAY_URI, requestBody.generateRequestBody()));
    }

    @Override
    public Map<String,Object> requestToPayStatus(String resourceId) {
        setAuth();
        return send(genRequest("GET", MomoLinks.REQUEST_TO_PAY_URI+"/"+resourceId, null));
    }

    @Override
    public Map<String,Object> requestToken() {
        setAuth();
        return send(genRequest("POST", MomoLinks.TOKEN_URI, null));
    }

    @Override
    public Map<String,Object> requestBalance() {
        setAuth();
        return send(genRequest("GET", MomoLinks.BALANCE_URI, null));
    }

    @Override
    public Map<String,Object> acountHolder(String accountHolderIdType, String accountHolderId) {
        setAuth();   
        return send(genRequest("GET", MomoLinks.ACOUNT_HOLDER_URI+accountHolderIdType+"/"+accountHolderId, null));
    }
    
}
