/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qlkh.test;
import java.util.ArrayList;
import java.util.List;
import qlkh.dao.ICustomerDAO;
import qlkh.dao.IOutputDAO;
import qlkh.daoimpl.CustomerDaoImpl;
import qlkh.daoimpl.OutputDaoImpl;
import qlkh.daoimpl.UserDaoImpl;
import qlkh.entities.Customers;
import qlkh.entities.Output;

import qlkh.entities.Users;
import qlkh.utils.Utils;

/**
 *
 * @author GIANG
 */
public class TestGiang {

    public static void main(String[] args) {
        List<Output> listCus = new ArrayList<>();
        IOutputDAO outputDao = new OutputDaoImpl();
        Output outputa = outputDao.getOutputByID("abc");
        System.out.println(outputa);
//        outputDao.insert(outputa);
//        listCus = outputDao.getAllOutputs();
//        for (Output listCu : listCus) {
//            System.out.println(listCu);
//        }
          
    
        
       
    }
}
