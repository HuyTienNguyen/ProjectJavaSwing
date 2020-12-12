/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qlkh.dao;
import java.util.List;
import qlkh.entities.OutputInfo;

/**
 *
 * @author GIANG
 */
public interface IOutputInfoDAO extends IInventoryDAO<OutputInfo , String> {
    public  List<OutputInfo> getAllOutputInfos();
    public OutputInfo getOutputInfoByID(String key);

  
}
