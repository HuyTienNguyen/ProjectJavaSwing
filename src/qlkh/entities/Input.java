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
public class Input {

    private String id;
    private Timestamp dateInput;

    public Input() {
    }

    public Input(String id, Timestamp dateInput) {
        this.id = id;
        this.dateInput = dateInput;
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
                    this.getDateInput()

                };
                break;
            case Constants.ACTION_UPDATE:
                param = new Object[]{
                    this.getDateInput(),
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
        return "Input{" + "id=" + id + ", dateInput=" + dateInput + '}';
    }

}
