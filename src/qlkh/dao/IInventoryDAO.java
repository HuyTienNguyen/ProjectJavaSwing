/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qlkh.dao;

import java.util.List;

/**
 *
 * @author GIANG
 * @param <E>
 * @param <K>
 */
public interface IInventoryDAO<E,K> {
    public void insert(E element);
    public void update(E element);
    public void delete(K key);
   
   
}
