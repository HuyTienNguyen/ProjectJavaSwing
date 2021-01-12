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
public class Customers {

    private int id;
    private String name;
    private String address;
    private String phone;
    private String email;
    private String moreInfo;
    private Timestamp contractDate;

    public Customers() {
    }

    public Customers(String name, String address, String phone, String email, String moreInfo, Timestamp contractDate) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.moreInfo = moreInfo;
        this.contractDate = contractDate;
    }

    public Customers(int id, String name, String address, String phone, String email, String moreInfo, Timestamp contractDate) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.moreInfo = moreInfo;
        this.contractDate = contractDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMoreInfo() {
        return moreInfo;
    }

    public void setMoreInfo(String moreInfo) {
        this.moreInfo = moreInfo;
    }

    public Timestamp getContractDate() {
        return contractDate;
    }

    public void setContractDate(Timestamp contractDate) {
        this.contractDate = contractDate;
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
                    this.getName(),
                    this.getAddress(),
                    this.getPhone(),
                    this.getEmail(),
                    this.getMoreInfo(),
                    this.getContractDate()
                };
                break;
            case Constants.ACTION_UPDATE:
                param = new Object[]{
                    this.getName(),
                    this.getAddress(),
                    this.getPhone(),
                    this.getEmail(),
                    this.getMoreInfo(),
                    this.getContractDate(),
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
        return "Customers{" + "id=" + id + ", name=" + name + ", address=" + address + ", phone=" + phone + ", email=" + email + ", moreInfo=" + moreInfo + ", contractDate=" + Utils.getSimpleDateFormat(contractDate) + '}';
    }
    
}
