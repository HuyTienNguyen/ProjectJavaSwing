/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qlkh.test;
import java.util.ArrayList;
import java.util.List;
import qlkh.dao.ICustomerDAO;
import qlkh.daoimpl.CustomerDaoImpl;
import qlkh.daoimpl.UserDaoImpl;
import qlkh.entities.Customers;

import qlkh.entities.Users;
import qlkh.utils.Utils;

/**
 *
 * @author GIANG
 */
public class TestGiang {

    public static void main(String[] args) {
        List<Customers> listCus = new ArrayList<>();
        ICustomerDAO customerDao = new CustomerDaoImpl();
   
     Customers custo1 = customerDao.getCustomersByName("giang1111vvvvvv1");
        System.out.println(custo1);
 customerDao.delete(custo1.getId());
        listCus = customerDao.getAllCustomers();
       for (Customers listCu : listCus) {
                System.out.println(listCu);
            }
        
       
    }
}
