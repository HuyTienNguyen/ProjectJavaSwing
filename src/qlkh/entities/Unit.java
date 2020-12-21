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
 * @author GIANG
 */
public class Unit {

    private int id;
    private String name;
    private int status;

    public Unit() {
    }

    public Unit(String name) {
        this.name = name;
    }

    public Unit(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Unit(int id, String name, int status) {
        this.id = id;
        this.name = name;
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

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    

    /**
     * Hàm trả về mảng dữ liệu của entity cho việc INSERT, UPDATE, DELETE
     *
     * @return Mảng dữ liệu String
     */
    public Object[] getParam(int action) {
        Object param[] = null;
        switch (action) {
            case Constants.ACTION_INSERT:
                param = new Object[]{
                    this.getName()
                };
                break;
            case Constants.ACTION_UPDATE:
                param = new Object[]{
                    this.getName(),
                    this.getId()
                };
                break;

            case Constants.ACTION_DELETE:
                param = new Object[]{
                    this.getId()
                };
                break;
            case Constants.ACTION_INSERT_BY_PROC:
                param = new Object[]{
                    Types.INTEGER,
                    this.getName()
                };
                break;
            case Constants.ACTION_UPDATE_BY_PROC:
                param = new Object[]{
                    Types.INTEGER,
                    this.getId(),
                    this.getName()
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
        return  name ;
    }

}
