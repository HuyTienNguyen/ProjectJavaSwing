/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qlkh.dao;
import java.util.List;
import qlkh.entities.Customers;


/**
 *
 * @author GIANG
 */
public interface ICustomerDAO extends IInventoryDAO<Customers , Integer> {
    public  List<Customers> getAllCustomers();
    public Customers getCustomersByName(String key);
    
  
}
