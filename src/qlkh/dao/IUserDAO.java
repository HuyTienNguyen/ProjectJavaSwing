/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qlkh.dao;
import java.util.List;
import qlkh.entities.Users;
/**
 *
 * @author GIANG
 */
public interface IUserDAO extends IInventoryDAO<Users , String> {
    public  List<Users> getUsers();
    public Users getUserByNameOrEmail(String key);
    public Users getUserById(int id);
    public boolean login(Users user);
    public Users getUserByVerifyCode(Users user);
  
}
