/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qlkh.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.swing.JPanel;
import qlkh.daoimpl.CategoryDaoImpl;
import qlkh.daoimpl.InvoiceImportDaoImpl;
import qlkh.daoimpl.InvoiceImportDetailDaoImpl;
import qlkh.daoimpl.ProductDaoImpl;
import qlkh.daoimpl.ReportsDaoImpl;
import qlkh.testView.ReportViewFrame;
import qlkh.utils.Utils;
import qlkh.utils.custombarchart.BarChartItems;
import qlkh.utils.custombarchart.ChartItem;
import qlkh.views.ReportView;

//import qlkh.views.ReportView;
/**
 *
 * @author user
 */
public class ReportsController {

//    ReportView view;
    ReportView view;
    ReportsDaoImpl reportDao;

    public ReportsController() {
        view = new ReportView();
        reportDao = new ReportsDaoImpl();
        // Lấy về list Barchart Item cho dòng đầu tiên
        view.addBtnTable1Action(this::btnTable1Action);
        view.addBtnTable3Action(this::btnTable3Action);

    }

    public JPanel getContentPage() {
        return view.getContent();
    }

    public void showView() {
        List<BarChartItems> listItem1 = reportDao.getReports(0);
        if (listItem1 != null&& listItem1.size()>0) {
            view.showTable1(listItem1, 0);
        }
         List<BarChartItems> listItem2 = reportDao.getProfits(0);
        if (listItem2 != null && listItem2.size()>0) {
            view.showTable3(listItem2, 0);
        }
        List<ChartItem>listItem3 = reportDao.getTotalInventoryByCate();
        if(listItem3 != null && listItem3.size()>0){
        view.showTable2(listItem3);
        }
    }

    private void btnTable1Action(ActionEvent e) {
        if (view.isFirstTimeLoad() == false) {
            int action = view.getComboBoxTable1Index();
            List<BarChartItems> items = reportDao.getReports(action);
            if (items != null) {
                view.showTable1(items, action);
            }
        }
    }
     private void btnTable3Action(ActionEvent e) {
        if (view.isFirstTimeLoad() == false) {
            int action = view.getComboBoxTable3Index();
            List<BarChartItems> items = reportDao.getProfits(action);
            if (items != null) {
                view.showTable3(items, action);
            }
        }
    }

   
    private void cbbTable2StateChanged(ItemEvent e) {
        if (view.isFirstTimeLoad() == false) {
            int action = view.getComboBoxTable3Index();
            List<BarChartItems> items = reportDao.getReports(action);
            if (items != null) {
                view.showTable1(items, action);
            }
        }

    }
}
