/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qlkh.dao;

import java.util.List;
import qlkh.entities.Category;

/**
 *
 * @author user
 */
public interface ICategoryDAO extends IInventoryDAO<Category, Integer>{
    public List<Category> getCategoies();
    public Category getCateById(Integer key);
}
