/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qlkh.dao;

import java.util.List;
import qlkh.entities.Products;

/**
 *
 * @author GIANG
 */
public interface IProductDAO extends IInventoryDAO<Products, String> {

    public List<Products> getAllProducts();

    public Products getProductById(String key);

    int getCountProducts();

}
