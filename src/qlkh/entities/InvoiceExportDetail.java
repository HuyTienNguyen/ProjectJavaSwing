/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qlkh.entities;

import java.sql.Timestamp;
import java.sql.Types;
import qlkh.utils.Constants;
import qlkh.utils.Utils;

/**
 *
 * @author GIANG
 */
public class InvoiceExportDetail {

    private String id;
    private String idInvoiceImportDetail;
    private String idInvoiceExport;
    private int counts;
    private String status;
    
    private String idProduct;
    
    
    private String nameProduct;
    private double money;
    private String userName;
    private Timestamp dateOutput;
    private String nameCustomer;
    private String idUser;
    private String idCustomer;
    public InvoiceExportDetail() {
    }

    public InvoiceExportDetail(String id, String idInvoiceImportDetail, String idInvoiceExport, int counts, String status) {
        this.id = id;
        this.idInvoiceImportDetail = idInvoiceImportDetail;
        this.idInvoiceExport = idInvoiceExport;
        this.counts = counts;
        this.status = status;
    }

    public InvoiceExportDetail(String id, String idInvoiceExport,String nameCustomer, int counts, String nameProduct, double money, String userName, Timestamp dateOutput) {
        this.id = id;
        this.idInvoiceExport = idInvoiceExport;
        this.nameCustomer = nameCustomer;
        this.counts = counts;
        this.nameProduct = nameProduct;
        this.money = money;
        this.userName = userName;
        this.dateOutput = dateOutput;
    }

    public String getNameCustomer() {
        return nameCustomer;
    }

    public void setNameCustomer(String nameCustomer) {
        this.nameCustomer = nameCustomer;
    }

    
    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Timestamp getDateOutput() {
        return dateOutput;
    }

    public void setDateOutput(Timestamp dateOutput) {
        this.dateOutput = dateOutput;
    }
    
    
    
    

    public String getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(String idProduct) {
        this.idProduct = idProduct;
    }
    
    

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIdInvoiceImportDetail() {
        return idInvoiceImportDetail;
    }

    public void setIdInvoiceImportDetail(String idInvoiceImportDetail) {
        this.idInvoiceImportDetail = idInvoiceImportDetail;
    }

    public String getIdInvoiceExport() {
        return idInvoiceExport;
    }

    public void setIdInvoiceExport(String idInvoiceExport) {
        this.idInvoiceExport = idInvoiceExport;
    }

    public int getCounts() {
        return counts;
    }

    public void setCounts(int counts) {
        this.counts = counts;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getIdUser() {
        return idUser;
    }

    public void setIdUser(String idUser) {
        this.idUser = idUser;
    }

    public String getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(String idCustomer) {
        this.idCustomer = idCustomer;
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
                    this.getNameProduct(),
                    this.getCounts(),
                    this.getIdUser(),
                    this.getIdCustomer(),
                    this.getIdInvoiceExport(),
                    
                };
                break;
            case Constants.ACTION_UPDATE:
                param = new Object[]{
                    this.getIdInvoiceImportDetail(),
                    this.getIdInvoiceExport(),
                    this.getCounts(),
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
        return "InvoiceExportDetail{" + "id=" + id + ", idInvoiceImportDetail=" + idInvoiceImportDetail + ", idInvoiceExport=" + idInvoiceExport + ", counts=" + counts + ", status=" + status + '}';
    }

  

    

    

    
    
}
