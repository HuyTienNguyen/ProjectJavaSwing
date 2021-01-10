/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qlkh.entities;

import java.sql.Date;
import java.sql.Timestamp;
import java.sql.Types;
import qlkh.utils.Constants;
import qlkh.utils.DatabaseHelper;
import qlkh.utils.Utils;

/**
 *
 * @author GIANG
 */
public class Supliers extends MyObject {

    private int id;
    private String name;
    private String address;
    private String phone;
    private String email;
    private String moreInfo;
    private Timestamp contractDate;
    private String characters;
    private int status;

    public Supliers() {
    }

    public Supliers(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Supliers(int id, String name, String address, String phone, String email, String moreInfo, Timestamp contractDate, String characters) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.moreInfo = moreInfo;
        this.contractDate = contractDate;
        this.characters = characters;
        this.status = 1;
    }

    public Supliers(int id, String name, String address, String phone, String email, String moreInfo, Timestamp contractDate, int status, String characters) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.moreInfo = moreInfo;
        this.contractDate = contractDate;
        this.characters = characters;
        this.status = status;
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

    public String getCharacters() {
        return characters;
    }

    public void setCharacters(String characters) {
        this.characters = characters;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
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
                    this.getName(),
                    this.getAddress(),
                    this.getPhone(),
                    this.getEmail(),
                    this.getMoreInfo(),
                    this.getContractDate(),
                    this.getCharacters()
                };
                break;
            case Constants.ACTION_UPDATE:
                param = new Object[]{
                    this.getName(),
                    this.getAddress(),
                    this.getPhone(),
                    this.getEmail(),
                    this.getMoreInfo(),
                    this.getCharacters(),
                    this.getId()
                };
                break;

            case Constants.ACTION_DELETE:
                param = new Object[]{
                    this.getId()
                };
                break;
            case Constants.ACTION_DELETE_BY_PROC:
                param = new Object[]{
                    Types.INTEGER,
                    this.getId()

                };
                break;
        }
        return param;
    }

    @Override
    public String toString() {
        return name;
    }

}
