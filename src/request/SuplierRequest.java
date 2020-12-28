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
        myMap.put("address", "required|max:255");
        myMap.put("phone", "required|regex:^[0-9]{4,}$");
        myMap.put("email", "required|regex:^[0-9]{4,}$");

        myMap.put("character", "required|regex:^[0-9]{4,}$");

        return myMap;
    }

    @Override
    public Map<String, String> setMesages() {
        Map<String, String> innerMap = new HashMap<>();
        innerMap.put("txtEmail.required", "Mail is required");
        innerMap.put("txtPhone.required", "Phone is required");
        // innerMap.put("txtPhone.number", "Phone is number");
        innerMap.put("txtPhone.min", "Please add min value");
        innerMap.put("textArea.regex", "Please add at least 5 number");

        return innerMap;

    }

}
