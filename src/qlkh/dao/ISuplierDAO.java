/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qlkh.dao;
import java.util.List;
import qlkh.entities.Supliers;

/**
 *
 * @author GIANG
 */
public interface ISuplierDAO extends IInventoryDAO<Supliers , Integer> {
    public  List<Supliers> getAllSupliers();
    public Supliers getSuplierById(Integer key);
    
  
}
