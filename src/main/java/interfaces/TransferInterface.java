/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import java.util.Map;
import models.RequestToPay;

/**
 *
 * @author Linus
 */
public interface TransferInterface extends ProductCommonsInterface{
    Map<String,Object> transfer(RequestToPay requestBody,String ref,String callbackUri);
    Map<String,Object> transferStatus(String resourceId);
}
