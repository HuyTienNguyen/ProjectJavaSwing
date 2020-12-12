/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qlkh.dao;
import java.util.List;
import qlkh.entities.Output;

/**
 *
 * @author GIANG
 */
public interface IOutputDAO extends IInventoryDAO<Output , Integer> {
    public  List<Output> getAllInputs();
    public Output getInputByID(Integer key);

  
}
