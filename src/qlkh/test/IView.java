/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qlkh.test;

import java.util.List;
import java.util.Map;

/**
 *
 * @author GIANG
 */
public interface IView {
    List<Object> getListElements();
    void showErrors(Map<String,String> errors);
}
