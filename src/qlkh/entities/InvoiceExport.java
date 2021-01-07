/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qlkh.entities;

import java.sql.Date;
import java.sql.Timestamp;
import qlkh.utils.Constants;

/**
 *
 * @author GIANG
 */
public class InvoiceExport {

    private String id;
    private Timestamp dateOutput;
    private int IdCustomer;

    public InvoiceExport() {
    }

    public InvoiceExport(String id, Timestamp dateOutput, int IdCustomer) {
        this.id = id;
        this.dateOutput = dateOutput;
        this.IdCustomer = IdCustomer;
    }

    

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Timestamp getDateOutput() {
        return dateOutput;
    }

    public void setDateOutput(Timestamp dateOutput) {
        this.dateOutput = dateOutput;
    }

    public int getIdCustomer() {
        return IdCustomer;
    }

    public void setIdCustomer(int IdCustomer) {
        this.IdCustomer = IdCustomer;
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
                    this.getDateOutput(),
                    this.getIdCustomer()

                };
                break;
            case Constants.ACTION_UPDATE:
                param = new Object[]{
                    this.getDateOutput(),
                    this.getIdCustomer(),
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
        return "InvoiceExport{" + "id=" + id + ", dateOutput=" + dateOutput + ", IdCustomer=" + IdCustomer + '}';
    }

    

}
