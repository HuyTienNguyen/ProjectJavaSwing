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
public class CategoryUpdateRequest extends GuiRequest {

    @Override
    public Map<String, String> setRules() {
        Map<String, String> maps = new HashMap();
        maps.put("id", "required");
        maps.put("name", "required|unique:category,name|max:100");
        maps.put("character", "max:20|unique:category,characters");
        return maps;
    }

    @Override
    public Map<String, String> setMesages() {
        Map<String, String> messMaps = new HashMap<>();
        messMaps.put("name.required", "The name field is required");
        messMaps.put("name.unique", "Name already exists!Please try again");
        messMaps.put("name.max", "The name field is a maximum of value character");

        messMaps.put("character.unique", "Character already exists!Please try again");
        messMaps.put("character.max", "The character field is a maximum of value character");
        return messMaps;

    }

}
