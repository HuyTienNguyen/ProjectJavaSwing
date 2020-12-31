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
public abstract class GuiRequest {                
    protected  abstract  Map<String, String> setRules();

    protected abstract Map<String, String> setMesages();

    public Map<String, String> getRules() {
        Map<String, String> myList = setRules();  
        return myList;
    }

    public Map<String, String> getMessages() {
        Map<String, String> mess = setMesages();    
        return mess;
    }

    
   

  
}
