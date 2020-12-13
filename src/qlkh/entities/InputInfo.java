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
public class InputInfo {

    private String id;
    private String idObjects;
    private String idInput;
    private int counts;
    private float inputPrice;
    private float outputPrice;
    private String status;

    public InputInfo() {
    }

    public InputInfo(String id, String idObjects, String idInput, int counts, float inputPrice, float outputPrice, String status) {
        this.id = id;
        this.idObjects = idObjects;
        this.idInput = idInput;
        this.counts = counts;
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

    public String getIdObjects() {
        return idObjects;
    }

    public void setIdObjects(String idObjects) {
        this.idObjects = idObjects;
    }

    public String getIdInput() {
        return idInput;
    }

    public void setIdInput(String idInput) {
        this.idInput = idInput;
    }

    public int getCounts() {
        return counts;
    }

    public void setCounts(int counts) {
        this.counts = counts;
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
            case Constants.ACTION_INSERT:
                param = new Object[]{
                    this.getId(),
                    this.getIdObjects(),
                    this.getIdInput(),
                    this.getCounts(),
                    this.getInputPrice(),
                    this.getOutputPrice(),
                    this.getStatus()

                };
                break;
            case Constants.ACTION_UPDATE:
                param = new Object[]{
                    this.getIdObjects(),
                    this.getIdInput(),
                    this.getCounts(),
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
        return "InputInfo{" + "id=" + id + ", idObjects=" + idObjects + ", idInput=" + idInput + ", counts=" + counts + ", inputPrice=" + inputPrice + ", outputPrice=" + outputPrice + ", status=" + status + '}';
    }

}
