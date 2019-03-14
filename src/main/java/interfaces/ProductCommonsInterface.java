/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import java.util.Map;

/**
 *
 * @author Linus
 */
public interface ProductCommonsInterface {
    Map<String,Object> requestToken();
    Map<String,Object> requestBalance();
    Map<String,Object> acountHolder(String accountHolderIdType,String accountHolderId);
}
