/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qlkh.controller;

import java.awt.event.ItemEvent;
import java.text.SimpleDateFormat;

import javax.swing.JPanel;
import qlkh.daoimpl.CategoryDaoImpl;
import qlkh.daoimpl.InvoiceImportDaoImpl;
import qlkh.daoimpl.InvoiceImportDetailDaoImpl;
import qlkh.daoimpl.ProductDaoImpl;
import qlkh.utils.Utils;

import qlkh.views.ReportView;

/**
 *
 * @author user
 */
public class ReportsController {

    ReportView view;
    ProductDaoImpl proDao;
    InvoiceImportDetailDaoImpl invoiceImDetailDao;
    InvoiceImportDaoImpl invoiceImDao;
    CategoryDaoImpl cateDao;

    public ReportsController() {
        view = new ReportView();
        view.showView();
        SimpleDateFormat dateFormat = new SimpleDateFormat( "yyyy-MM-dd" );
        System.out.println(dateFormat.format(Utils.getDateToday()));
                System.out.println(dateFormat.format(Utils.getDateIncrementer(7)));

    }

    public JPanel getContentPage() {
        return view.getContent();
    }

    private void cateBoxStateChanged(ItemEvent e) {
//        Category cate = view.getCateSelected();
//        if (cate != null) {
//            view.loadProducts(view.getListProduct(cate), cate);
//        }

    }

}
