/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qlkh.entities;

import java.sql.Types;
import qlkh.utils.Constants;

/**
 *
 * @author user
 */
public class Category extends MyObject {

    private int id;
    private String name;
    private String characters;
    private int status;

    public Category() {
    }

    public Category(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Category(int id, String name, String characters) {
        this.id = id;
        this.name = name;
        this.characters = characters;
        this.status =1;
    }

    public Category(int id, String name, String characters, int status) {
        this.id = id;
        this.name = name;
        this.characters = characters;
        this.status = status;
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

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Object[] getParam(int action) {
        Object param[] = null;
        switch (action) {
            case Constants.ACTION_INSERT:
                param = new Object[]{
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
            case Constants.ACTION_DELETE_BY_PROC:
                param = new Object[]{
                    Types.INTEGER,
                    this.getId()

                };
                break;
        }
        return param;
    }

    @Override
    public String toString() {
        return name;
    }

}
