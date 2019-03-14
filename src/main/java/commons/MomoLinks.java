/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package commons;

/**
 *
 * @author Linus
 */
public class MomoLinks {

    private MomoLinks() {
    }
    
	public static final String BASE_URI="https://ericssonbasicapi2.azure-api.net/";

	//collection
	public static final String REQUEST_TO_PAY_URI="https://ericssonbasicapi2.azure-api.net/collection/v1_0/requesttopay";
	public static final String TOKEN_URI="https://ericssonbasicapi2.azure-api.net/collection/token";
	public static final String BALANCE_URI="https://ericssonbasicapi2.azure-api.net/collection/v1_0/account/balance";
	public static final String ACOUNT_HOLDER_URI="https://ericssonbasicapi2.azure-api.net/collection/v1_0/accountholder/";// "{accountHolderIdType}/{accountHolderId}/active"

	//disbursment
	public static final String D_TOKEN_URI="https://ericssonbasicapi2.azure-api.net/disbursement/token/";
	public static final String D_TRANSFER_URI="https://ericssonbasicapi2.azure-api.net/disbursement/v1_0/transfer";// status resource id
	public static final String D_BALANCE_URI="https://ericssonbasicapi2.azure-api.net/disbursement/v1_0/account/balance";
	public static final String D_ACCOUNT_HOLDER_URI="https://ericssonbasicapi2.azure-api.net/disbursement/v1_0/accountholder/";
	//"{accountHolderIdType}/{accountHolderId}/active"; IDTYPES [msisdn, email, party_code]
	
	//remitence
	public static final String R_TOKEN_URI="https://ericssonbasicapi2.azure-api.net/remittance/token/";
	public static final String R_TRANSFER_URI="https://ericssonbasicapi2.azure-api.net/remittance/v1_0/transfer";
	// status resourceId
	public static final String R_BALANCE_URI="https://ericssonbasicapi2.azure-api.net/remittance/v1_0/account/balance";
	public static final String R_ACCOUNT_HOLDER_URI="https://ericssonbasicapi2.azure-api.net/remittance/v1_0/accountholder/";//{accountHolderIdType}/{accountHolderId}/active";
	//apiUser
	public static final String USER_URI="https://ericssonbasicapi2.azure-api.net/v1_0/apiuser";
	// info /{referenceId}
	//apikey {referenceId}/apikey
}
