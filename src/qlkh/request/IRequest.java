/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qlkh.request;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author GIANG
 */
public abstract class IRequest {                
    protected  abstract  Map<String, String> setRules();

    protected abstract Map<String, String> setMesages();

    public Map<String, String> getRules() {
      
        return setRules();
    }

    public Map<String, String> getMessages() {
        
        return setMesages();
    }  
}
