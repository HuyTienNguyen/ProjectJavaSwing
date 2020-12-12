/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qlkh.dao;
import java.util.List;
import qlkh.entities.Objects;


/**
 *
 * @author GIANG
 */
public interface IObjectDAO extends IInventoryDAO<Objects , String> {
    public  List<Objects> getAllObjects();
    public Objects getObjectById(String key);
    
  
}
