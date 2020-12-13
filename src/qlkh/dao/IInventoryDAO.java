/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qlkh.dao;

import java.sql.ResultSet;
import java.util.List;

/**
 *
 * @author GIANG
 * @param <E>
 * @param <K>
 */
public interface IInventoryDAO<E,K> {
    public int insert(E element);
    public int update(E element);
    public int delete(K key);
}
