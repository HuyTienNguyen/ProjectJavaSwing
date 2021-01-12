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
 * @author user
 */
public class CustomersRequest extends IRequest{

    @Override
    protected Map<String, String> setRules() {
        Map<String, String> maps = new HashMap();
        maps.put("name", "required|max:100|unique:customer,name");
        maps.put("address", "required|max:100");
        maps.put("phone", "required|max:20|regex:(03|05|07|08|09|01[2|6|8|9])([0-9]{8})|unique:customer,phone");
        maps.put("email", "required|max:200|regex:^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$|unique:customer,email");
        return maps;
    }

    @Override
    protected Map<String, String> setMesages() {
        Map<String, String> messMaps = new HashMap<>();
        messMaps.put("name.required", "The name field is required");
        messMaps.put("name.unique", "Name already exists!Please try again");
        messMaps.put("name.max", "The name field is a maximum of value character");

        messMaps.put("address.required", "The address field is required");
        messMaps.put("address.max", "The adress field is a maximum of value character");
        
        messMaps.put("phone.required", "The phone field is required");
        messMaps.put("phone.max", "The phone field is a maximum of value character");
        messMaps.put("phone.regex", "The phone field is not a valid phone number pattern");
        messMaps.put("phone.unique", "Phone already exists!Please try again");
        
        messMaps.put("email.required", "The mail field is required");
        messMaps.put("email.max", "The mail field is a maximum of value character");
        messMaps.put("email.unique", "Email already exists!Please try again");
        messMaps.put("email.regex", "The email field is not a valid email pattern");

        

        return messMaps;
    }
    
}
