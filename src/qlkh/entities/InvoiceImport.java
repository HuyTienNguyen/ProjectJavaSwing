/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qlkh.entities;

import java.sql.Date;
import java.sql.Timestamp;
import qlkh.utils.Constants;
import qlkh.utils.Utils;

/**
 *
 * @author GIANG
 */
public class InvoiceImport {

    private String id;
    private Timestamp dateInput;
    private int idUser;

    public InvoiceImport() {
    }

    public InvoiceImport(String id, Timestamp dateInput) {
        this.id = id;
        this.dateInput = dateInput;
    }
    

    public InvoiceImport(String id, Timestamp dateInput, int idUser) {
        this.id = id;
        this.dateInput = dateInput;
        this.idUser = idUser;
    }

    
 
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Timestamp getDateInput() {
        return dateInput;
    }

    public void setDateInput(Timestamp dateInput) {
        this.dateInput = dateInput;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
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
                    this.getDateInput(),
                    this.getIdUser()

                };
                break;
            case Constants.ACTION_UPDATE:
                param = new Object[]{
                    this.getDateInput(),
                    this.getIdUser(),
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
        return  Utils.getSimpleDateFormatWithHours(dateInput) ;
    }

  
    

}
