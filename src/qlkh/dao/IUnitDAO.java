/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qlkh.dao;
import java.util.List;
import qlkh.entities.Unit;

/**
 *
 * @author GIANG
 */
public interface IUnitDAO extends IInventoryDAO<Unit , Integer> {
    public  List<Unit> getAllUnits();
    public Unit getUnitByID(Integer key);

  
}
