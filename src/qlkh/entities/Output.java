/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qlkh.entities;

import java.sql.Date;
import qlkh.utils.Constants;

/**
 *
 * @author GIANG
 */
public class Output {

    private String id;
    private Date dateOutput;

    public Output() {
    }

    public Output(String id, Date dateOutput) {
        this.id = id;
        this.dateOutput = dateOutput;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getDateOutput() {
        return dateOutput;
    }

    public void setDateOutput(Date dateOutput) {
        this.dateOutput = dateOutput;
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
                    this.getDateOutput()

                };
                break;
            case Constants.ACTION_UPDATE:
                param = new Object[]{
                    this.getDateOutput(),
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
