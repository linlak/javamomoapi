/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package products;

import commons.MomoConstants;
import commons.MomoLinks;
import interfaces.TransferInterface;
import java.util.Map;
import javamomoapi.MomoApp;
import models.RequestToPay;

/**
 *
 * @author Linus
 */
public class Disbursements extends MomoApp implements TransferInterface {

    public Disbursements(String apiPrimaryKey, String apiSecondary) {
        super(apiPrimaryKey, apiSecondary);
    }

    public Disbursements(String apiPrimaryKey, String apiSecondary, String environ) {
        super(apiPrimaryKey, apiSecondary, environ);
    }

   

    @Override
    public Map<String,Object> requestToken() {
       setAuth();
       return send(genRequest("POST", MomoLinks.D_TOKEN_URI, null));
    }

    @Override
    public Map<String,Object> requestBalance() {
        setAuth();
       return send(genRequest("POST", MomoLinks.D_BALANCE_URI, null));
    }

    @Override
    public Map<String,Object> acountHolder(String accountHolderIdType, String accountHolderId) {
       setAuth();
       return send(genRequest("POST", MomoLinks.D_ACCOUNT_HOLDER_URI+accountHolderIdType+"/"+accountHolderId, null));
    }

    @Override
    public Map<String, Object> transfer(RequestToPay requestBody, String ref, String callbackUri) {
        if(null!=callbackUri){
            setHeaders(MomoConstants.H_CALL_BACK, callbackUri);
        }
        setHeaders(MomoConstants.H_REF_ID, ref);
       setAuth();
        if(this.environ.equals(MomoConstants.ENV_SANDBOX)){
            requestBody.setCurrency(MomoConstants.C_EUR);
        }
       return send(genRequest("POST", MomoLinks.D_TRANSFER_URI, requestBody.generateRequestBody()));
    }

    @Override
    public Map<String, Object> transferStatus(String resourceId) {
        setAuth();
        return send(genRequest("GET", MomoLinks.D_TRANSFER_URI+"/"+resourceId, null));
    }
    
}
