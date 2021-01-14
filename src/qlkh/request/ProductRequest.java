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
public class ProductRequest extends IRequest {

    @Override
    public Map<String, String> setRules() {
        Map<String, String> maps = new HashMap();
        maps.put("name", "required|max:100|unique:Products,name");
        maps.put("unit", "required");
        maps.put("suplier", "required");
        maps.put("category", "required");
        return maps;
    }

    @Override
    public Map<String, String> setMesages() {
        Map<String, String> messes = new HashMap<>();
        messes.put("name.required", "The name  is required");
        messes.put("name.unique", "Name already exists!Please try again");
        messes.put("name.max", "The name field is a maximum of value character");
       
       

        return messes;

    }

}
