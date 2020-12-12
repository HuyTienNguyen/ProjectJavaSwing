/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qlkh.entities;

import qlkh.utils.Constants;

/**
 *
 * @author GIANG
 */
public class Objects {

    private String id;
    private String name;
    private int idUnit;
    private int idSuplier;

    public Objects() {
    }

    public Objects(String id, String name, int idUnit, int idSuplier) {
        this.id = id;
        this.name = name;
        this.idUnit = idUnit;
        this.idSuplier = idSuplier;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIdUnit() {
        return idUnit;
    }

    public void setIdUnit(int idUnit) {
        this.idUnit = idUnit;
    }

    public int getIdSuplier() {
        return idSuplier;
    }

    public void setIdSuplier(int idSuplier) {
        this.idSuplier = idSuplier;
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
                    this.getId(),
                    this.getName(),
                    this.getIdUnit(),
                    this.getIdSuplier()
                };
                break;
            case Constants.ACTION_UPDATE:
                param = new Object[]{
                    this.getName(),
                    this.getIdUnit(),
                    this.getIdSuplier(),
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

}
