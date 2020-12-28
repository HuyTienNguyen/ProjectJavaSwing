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
public class SuplierRequest extends GuiRequest {

    @Override
    public Map<String, String> setRules() {
        Map<String, String> myMap = new HashMap();
        myMap.put("name", "required");
        myMap.put("address", "confirmed|min:5");
        myMap.put("address_confirmation", "required");
        //myMap.put("email", "required|regex:^[0-9]{4,}$");
       // myMap.put("character", "required|regex:^[0-9]{4,}$");

        return myMap;
    }

    @Override
    public Map<String, String> setMesages() {
        Map<String, String> innerMap = new HashMap<>();
        innerMap.put("name.required", "Name is required");
        innerMap.put("address.required", "Address is required");
        innerMap.put("address.max", "Phone is required");

        return innerMap;

    }

}
