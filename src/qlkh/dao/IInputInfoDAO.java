/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qlkh.dao;
import java.util.List;
import qlkh.entities.InputInfo;

/**
 *
 * @author GIANG
 */
public interface IInputInfoDAO extends IInventoryDAO<InputInfo , String> {
    public  List<InputInfo> getAllInputInfos();
    public InputInfo getInputInfoByID(String key);

  
}
