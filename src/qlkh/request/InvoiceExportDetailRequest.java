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
public class InvoiceExportDetailRequest extends IRequest{

    @Override
    protected Map<String, String> setRules() {
        Map<String, String> maps = new HashMap();
        maps.put("cate", "required");
        maps.put("counts", "required|integer|min:1");
        maps.put("idCustomer", "required|exists:customer,id");
        return maps;
    }

    @Override
    protected Map<String, String> setMesages() {
        Map<String, String> messMaps = new HashMap<>();
        messMaps.put("cate.required", "The Cate  is required");
        
        messMaps.put("counts.required", "The price  is required");
        messMaps.put("counts.float", "The Price need be a integer number");
        messMaps.put("counts.min", "The Price minimum is value!Please try again!");
         
        messMaps.put("idCustomer.required", "The IdCustomer  is required");
        messMaps.put("idCustomer.exists", "The IdCustomer is not exists");
        return messMaps;
    }
    
}
