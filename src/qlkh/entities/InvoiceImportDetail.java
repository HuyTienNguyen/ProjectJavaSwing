/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qlkh.entities;

import java.sql.Types;
import qlkh.utils.Constants;
import qlkh.utils.Utils;

/**
 *
 * @author GIANG
 */
public class InvoiceImportDetail {

    private String id;
    private String idProduct;
    private String idInvoiceImport;
    private int number;
    private float inputPrice;
    private float outputPrice;
    private String status;

    public InvoiceImportDetail() {
    }

    public InvoiceImportDetail(String id, String idProduct, String idInvoiceImport, int number, float inputPrice, float outputPrice, String status) {
        this.id = id;
        this.idProduct = idProduct;
        this.idInvoiceImport = idInvoiceImport;
        this.number = number;
        this.inputPrice = inputPrice;
        this.outputPrice = outputPrice;
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(String idProduct) {
        this.idProduct = idProduct;
    }

    public String getIdInvoiceImport() {
        return idInvoiceImport;
    }

    public void setIdInvoiceImport(String idInvoiceImport) {
        this.idInvoiceImport = idInvoiceImport;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public float getInputPrice() {
        return inputPrice;
    }

    public void setInputPrice(float inputPrice) {
        this.inputPrice = inputPrice;
    }

    public float getOutputPrice() {
        return outputPrice;
    }

    public void setOutputPrice(float outputPrice) {
        this.outputPrice = outputPrice;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
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
            case Constants.ACTION_INSERT_BY_PROC:
                param = new Object[]{
                    Types.INTEGER,
                    Utils.getTimestampNow(),
                    this.getIdProduct(),
                    this.getNumber(),
                    this.getInputPrice(),
                    this.getOutputPrice() 
                };
                break;
            case Constants.ACTION_UPDATE:
                param = new Object[]{
                    this.getIdProduct(),
                    this.getIdInvoiceImport(),
                    this.getNumber(),
                    this.getInputPrice(),
                    this.getOutputPrice(),
                    this.getStatus(),
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
        return "InvoiceImportDetail{" + "id=" + id + ", idProduct=" + idProduct + ", idInvoiceImport=" + idInvoiceImport + ", number=" + number + ", inputPrice=" + inputPrice + ", outputPrice=" + outputPrice + ", status=" + status + '}';
    }

    

}
