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
public class InvoiceImportDetailRequest extends IRequest {

    @Override
    public Map<String, String> setRules() {
        Map<String, String> maps = new HashMap();
        maps.put("product", "required");
        maps.put("inputPrice", "required|float|min:1");
        maps.put("outputPrice", "required|float|min:1");
        maps.put("number", "required|integer");
        return maps;
    }

    @Override
    public Map<String, String> setMesages() {
        Map<String, String> messMaps = new HashMap<>();
        messMaps.put("product.required", "The Product  is required");
        
           messMaps.put("inputPrice.required", "The price  is required");
        messMaps.put("inputPrice.float", "The Price need be a float number");
        messMaps.put("inputPrice.min", "The Price minimum is   value!Please try again!");

           messMaps.put("outputPrice.required", "The price  is required");
        messMaps.put("outputPrice.float", "The Price need be a float number");
        messMaps.put("outputPrice.min", "The Price minimum is   value!Please try again!");

        messMaps.put("number.unique", "The Number  is required");
        messMaps.put("number.integer", "The Number need be a float number");
        return messMaps;

    }

}
