/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qlkh.testView;

import qlkh.daoimpl.ReportsDaoImpl;

/**
 *
 * @author GIANG
 */
public class NewMain {
    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ReportsDaoImpl rest = new ReportsDaoImpl();
        rest.getReportsInTheLastWeek();
    }
    
}
