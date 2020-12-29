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
    //    myMap.put("name", "required");
     //   myMap.put("address", "required|max:5");
        myMap.put("phone", "required|regex:(03\\|05\\|07|08|09|01[2|6|8|9])([0-9]{8})");
            //    myMap.put("phone", "required|regex:([A-Z\\|a-z]{4})");

    //    myMap.put("email", "required|regex:^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$");
      //  myMap.put("character", "required|regex:^[A-Z]+$");

        return myMap;
    }

    @Override
    public Map<String, String> setMesages() {
        Map<String, String> innerMap = new HashMap<>();
        innerMap.put("name.required", "The name field is required");
        innerMap.put("address.required", "The address field is required");
        innerMap.put("address.max", "The adress field is a maximum of value character");
        innerMap.put("phone.required", "The phone field is required");
        innerMap.put("phone.regex", "The address field is not a valid phone number pattern");
        innerMap.put("mail.required", "The mail field is required");
        innerMap.put("mail.regex", "The mail field is not a valid phone number pattern");

        return innerMap;

    }

}
