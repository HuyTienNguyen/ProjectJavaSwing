/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qlkh.dao;
import java.util.List;
import qlkh.entities.UserRole;
/**
 *
 * @author GIANG
 */
public interface IUserRoleDAO extends IInventoryDAO<UserRole , Integer> {
    public  List<UserRole> getAllUserRole();
    public UserRole getUserRoleByID( Integer key);
  
}
