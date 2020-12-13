/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qlkh.test;

import java.util.ArrayList;
import java.util.List;
import qlkh.daoimpl.UserRoleDaoImpl;
import qlkh.entities.UserRole;

/**
 *
 * @author GIANG
 */
public class TestGiang {

    public static void main(String[] args) {
        List<UserRole> listRole = new ArrayList<>();
        UserRoleDaoImpl userRoleDao = new UserRoleDaoImpl();
        listRole = userRoleDao.getAllUserRole();
        for (UserRole listRole1 : listRole) {
            System.out.println(listRole1);
        }
    }
}
