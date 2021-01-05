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
public class UnitRequest extends GuiRequest {

    @Override
    public Map<String, String> setRules() {
        Map<String, String> myMap = new HashMap();
        myMap.put("name", "unique:unit,name,email");
      
        return myMap;
    }

    @Override
    public Map<String, String> setMesages() {
        Map<String, String> innerMap = new HashMap<>();
        innerMap.put("name.required", "Mail is required");
      

        return innerMap;

    }

}
