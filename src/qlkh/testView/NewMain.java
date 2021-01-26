/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qlkh.testView;

import java.util.List;
import qlkh.daoimpl.ReportsDaoImpl;
import qlkh.utils.custombarchart.BarChartItems;

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
      List<BarChartItems> items = rest.getReports(1);
        for (BarChartItems item : items) {
            System.out.println(item.getItem1().getValue());
        }
    }
    
}
