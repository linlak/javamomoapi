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
public class MomoConstants {


    private MomoConstants() {
    }
    public static final String C_EUR="EUR";
    public static final String H_ENVIRON="X-Target-Environment";
    public static final String H_OCP_APIM="Ocp-Apim-Subscription-Key";
    public static final String H_AUTH="Authorization";
    public static final String H_C_TYPE="Content-Type";
    public static final String H_REF_ID="X-Reference-Id";
    public static final String H_CALL_BACK="X-Callback-Url";
    public static final String ENV_LIVE="live";
    public static final String ENV_SANDBOX="sandbox";

    public static byte[] toByte(String str)
    {
        return str.getBytes();
    }
}
