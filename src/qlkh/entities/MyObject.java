/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qlkh.entities;

import java.sql.Types;
import qlkh.utils.Constants;

/**
 *
 * @author GIANG
 */
public class MyObject {

    public Object[] getParam(int action) {
        Object param[] = null;
        switch (action) {

            case Constants.ACTION_DELETE_BY_PROC:
                param = new Object[]{
                    Types.INTEGER

                };
                break;
        }
        return param;
    }
}
