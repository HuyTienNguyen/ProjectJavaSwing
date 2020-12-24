/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package request;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author GIANG
 */
public abstract class GuiRequest {
    public  abstract  Map<String, String> rules();

    public abstract Map<String, String> mesages();

    public Map<String, String> getRules() {
        Map<String, String> myList = rules();
        // myList = rules();
        return myList;
    }

    public Map<String, String> getMessages() {
        Map<String, String> mess = mesages();
        //  mess = mesages();
        return mess;
    }

    
   

  
}
