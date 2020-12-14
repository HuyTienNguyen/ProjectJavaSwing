/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qlkh.entities;

import qlkh.utils.Constants;

/**
 *
 * @author user
 */
public class Category {
    private int id;
    private String name;
    private String characters;

    public Category() {
    }

    public Category(int id, String name, String characters) {
        this.id = id;
        this.name = name;
        this.characters = characters;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCharacters() {
        return characters;
    }

    public void setCharacters(String characters) {
        this.characters = characters;
    }
    
    public Object[] getParam(int action){
        Object param[] = null;
        switch (action) {
            case Constants.ACTION_INSERT:
                param = new Object[]{
                    this.getId(),
                    this.getName(),
                    this.getCharacters()
                };
                break;
            case Constants.ACTION_UPDATE:
                param = new Object[]{
                    this.getName(),
                    this.getCharacters(),
                    this.getId()
                };
                break;

            case Constants.ACTION_DELETE:
                param = new Object[]{
                    this.getId()
                };
                break;
        }
        return param;
    }

    @Override
    public String toString() {
        return "Category{" + "id=" + id + ", name=" + name + ", characters=" + characters + '}';
    }
    
}
