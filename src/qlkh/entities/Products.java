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
public class Products {

    private String id;
    private String name;
    private int idUnit;
    private int idSuplier;
    private int idCate;
    private float price;
    private float taxProduct;

    public Products() {
    }

    public Products(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public Products(String id, String name, int idUnit, int idSuplier, int idCate) {
        this.id = id;
        this.name = name;
        this.idUnit = idUnit;
        this.idSuplier = idSuplier;
        this.idCate = idCate;
    }

    public Products(String id, String name, int idUnit, int idSuplier, int idCate, float price, float taxProduct) {
        this.id = id;
        this.name = name;
        this.idUnit = idUnit;
        this.idSuplier = idSuplier;
        this.idCate = idCate;
        this.price = price;
        this.taxProduct = taxProduct;
    }

    public Products(String id, String name, int idUnit, int idSuplier, int idCate, float price) {
        this.id = id;
        this.name = name;
        this.idUnit = idUnit;
        this.idSuplier = idSuplier;
        this.idCate = idCate;
        this.price = price;
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

    public int getIdCate() {
        return idCate;
    }

    public void setIdCate(int idCate) {
        this.idCate = idCate;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public float getTaxProduct() {
        return taxProduct;
    }

    public void setTaxProduct(float taxProduct) {
        this.taxProduct = taxProduct;
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
                    this.getIdSuplier(),
                    this.getIdCate(),
                    this.getPrice(),
                    this.getTaxProduct()
                };
                break;
            case Constants.ACTION_UPDATE:
                param = new Object[]{
                    this.getName(),
                    this.getIdUnit(),
                    this.getIdSuplier(),
                    this.getIdCate(),
                     this.getPrice(),
                    this.getTaxProduct(),
                    this.getId(),
                   
                };
                break;

            case Constants.ACTION_DELETE:
                param = new Object[]{
                    this.getId()
                };
                break;
            case Constants.ACTION_DELETE_BY_PROC:
                param = new Object[]{
                    Types.INTEGER

                };
                break;
        }
        return param;
    }

    @Override
    public String toString() {
        return name;
    }

    public String showAll() {
        return "Products{" + "id=" + id + ", name=" + name + ", idUnit=" + idUnit + ", idSuplier=" + idSuplier + ", idCate=" + idCate + '}';
    }

}
