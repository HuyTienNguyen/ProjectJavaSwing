/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qlkh.dao;
import java.util.List;
import qlkh.entities.Input;

/**
 *
 * @author GIANG
 */
public interface IInputDAO extends IInventoryDAO<Input , String> {
    public  List<Input> getAllInputs();
    public Input getInputByID(String key);

  
}
