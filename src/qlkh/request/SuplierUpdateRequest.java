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
public class SuplierUpdateRequest extends IRequest {

    @Override
    public Map<String, String> setRules() {
        Map<String, String> maps = new HashMap();
        maps.put("id", "required");
        maps.put("name", "required|max:100|unique:suplier,name");
        maps.put("address", "required|max:255");
        maps.put("phone", "required|regex:(03|05|07|08|09|01[2|6|8|9])([0-9]{8})|unique:suplier,phone");
        maps.put("mail", "required|regex:^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$|unique:suplier,email");
        maps.put("character", "max:50");
        return maps;
    }

    @Override
    public Map<String, String> setMesages() {
        Map<String, String> messMaps = new HashMap<>();
        messMaps.put("name.required", "The name field is required");
        messMaps.put("name.unique", "Name already exists!Please try again");

        messMaps.put("address.required", "The address field is required");
        messMaps.put("address.max", "The adress field is a maximum of value character");

        messMaps.put("phone.required", "The phone field is required");
        messMaps.put("phone.regex", "The address field is not a valid phone number pattern");
        messMaps.put("phone.unique", "Phone already exists!Please try again");
        messMaps.put("phone.max", "The phone field is a maximum of value character");

        messMaps.put("mail.required", "The mail field is required");
        messMaps.put("mail.max", "The mail field is not a valid phone number pattern");
        messMaps.put("mail.unique", "Email  already exists!Please try again");
        messMaps.put("mail.max", "The email field is a maximum of value character");

        messMaps.put("character.max", "The character field is a maximum of value character");

        return messMaps;

    }

}
