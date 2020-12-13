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
public class OutputInfo {

    private String id;
    private String idObjects;
    private String idInputInfo;
    private String idOutput;
    private int idCustomer;
    private int counts;
    private String status;

    public OutputInfo() {
    }

    public OutputInfo(String id, String idObjects, String idInputInfo, String idOutput, int idCustomer, int counts, String status) {
        this.id = id;
        this.idObjects = idObjects;
        this.idInputInfo = idInputInfo;
        this.idOutput = idOutput;
        this.idCustomer = idCustomer;
        this.counts = counts;
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIdObjects() {
        return idObjects;
    }

    public void setIdObjects(String idObjects) {
        this.idObjects = idObjects;
    }

    public String getIdInputInfo() {
        return idInputInfo;
    }

    public void setIdInputInfo(String idInputInfo) {
        this.idInputInfo = idInputInfo;
    }

    public String getIdOutput() {
        return idOutput;
    }

    public void setIdOutput(String idOutput) {
        this.idOutput = idOutput;
    }

    public int getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(int idCustomer) {
        this.idCustomer = idCustomer;
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
                    this.getIdObjects(),
                    this.getIdInputInfo(),
                    this.getIdOutput(),
                    this.getIdCustomer(),
                    this.getCounts(),
                    this.getStatus()

                };
                break;
            case Constants.ACTION_UPDATE:
                param = new Object[]{
                    this.getIdObjects(),
                    this.getIdInputInfo(),
                    this.getIdOutput(),
                    this.getIdCustomer(),
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
        return "OutputInfo{" + "id=" + id + ", idObjects=" + idObjects + ", idInputInfo=" + idInputInfo + ", idOutput=" + idOutput + ", idCustomer=" + idCustomer + ", counts=" + counts + ", status=" + status + '}';
    }
    
}
