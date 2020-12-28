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
public class Users {

    private int id;
    private String name;
    private String userName;
    private String password;
    private int idRole;
    private String email;
    private int verifyCode;
    private String rePassword;

    public Users() {
    }

    public Users(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public Users(String name, String userName, String password, String email, String rePassword) {
        this.name = name;
        this.userName = userName;
        this.password = password;
        this.email = email;
        this.rePassword = rePassword;
    }
    
    
    public Users(int id, String name, String userName, String password, int idRole) {
        this.id = id;
        this.name = name;
        this.userName = userName;
        this.password = password;
        this.idRole = idRole;
    }

    public Users(int id, String name, String userName, int idRole, String email) {
        this.id = id;
        this.name = name;
        this.userName = userName;
        this.idRole = idRole;
        this.email = email;
    }

    public Users(String name, String userName, String password, int idRole) {
        this.name = name;
        this.userName = userName;
        this.password = password;
        this.idRole = idRole;
    }

    public Users(String name, String userName, String password, int idRole, String email) {
        this.name = name;
        this.userName = userName;
        this.password = password;
        this.idRole = idRole;
        this.email = email;
    }

    public Users(int id, String name, String userName, String password, int idRole, String email, int verifyCode) {
        this.id = id;
        this.name = name;
        this.userName = userName;
        this.password = password;
        this.idRole = idRole;
        this.email = email;
        this.verifyCode = verifyCode;
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

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getIdRole() {
        return idRole;
    }

    public void setIdRole(int idRole) {
        this.idRole = idRole;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getVerifyCode() {
        return verifyCode;
    }

    public void setVerifyCode(int verifyCode) {
        this.verifyCode = verifyCode;
    }

    public String getRePassword() {
        return rePassword;
    }

    public void setRePassword(String rePassword) {
        this.rePassword = rePassword;
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
                    this.getUserName(),
                    this.getPassword(),
                    this.getIdRole(),
                    this.getEmail()
                };
                break;
            case Constants.ACTION_UPDATE:
                param = new Object[]{
                    this.getName(),
                    this.getUserName(),
                    this.getPassword(),
                    this.getIdRole(),
                    this.getId()
                };
                break;

            case Constants.ACTION_DELETE:
                param = new Object[]{
                    this.getId()
                };
                break;
            case Constants.ACTION_GET_USER_BY_CODE:
                param = new Object[]{
                    this.getUserName(),
                    this.getEmail(),
                    this.getVerifyCode()
                };
                break;
            case Constants.ACTION_GET_USER_BY_USERNAME_PASS:
                param = new Object[]{
                    this.getUserName(),
                    this.getPassword()
                };
            break;
        }
        return param;
    }

    @Override
    public String toString() {
        return "Users{" + "id=" + id + ", name=" + name + ", userName=" + userName + ", password=" + password + ", idRole=" + idRole + ", email=" + email + ", verifyCode=" + verifyCode + '}';
    }

}
