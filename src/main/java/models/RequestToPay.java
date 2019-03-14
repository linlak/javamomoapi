/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import org.json.simple.JSONObject;

/**
 *
 * @author Linus
 */
public class RequestToPay {
        private String amount="";
	private String currency="UGX";
	private String externalId="";
	private String payeeNote="";
	private String payerMessage="";
	private final JSONObject payer=new JSONObject();
	public RequestToPay(String externalId,String amount,String partyId,String partyIdType,String payeeNote,String payerMessage){
		this.amount=amount;
		this.externalId=externalId;
		this.payeeNote=payeeNote;
		this.payerMessage=payerMessage;
		this.payer.put("partyId",partyId);	
                this.payer.put("partyIdType",partyIdType);

	}
	public void setCurrency(String currency){
		this.currency=currency;
	}
	public JSONObject generateRequestBody(){
            JSONObject output = new JSONObject();                        
                output.put("amount", amount);
                output.put("currency",currency);
                output.put("externalId", externalId);
                output.put("payer",payer);
                output.put("payerMessage",payerMessage);
                output.put("payeeNote",payeeNote);
            return output;
	}
}
