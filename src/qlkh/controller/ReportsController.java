/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qlkh.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;
import qlkh.daoimpl.CategoryDaoImpl;
import qlkh.daoimpl.InvoiceImportDaoImpl;
import qlkh.daoimpl.InvoiceImportDetailDaoImpl;
import qlkh.daoimpl.ProductDaoImpl;
import qlkh.entities.Category;
import qlkh.entities.InvoiceImport;
import qlkh.entities.InvoiceImportDetail;
import qlkh.entities.Products;
import qlkh.request.IRequest;
import qlkh.request.InvoiceImportDetailRequest;
import qlkh.testView.GiangTestFrameInvoiceImportDetail;
import qlkh.utils.Constants;
import qlkh.utils.Validator;
import qlkh.views.InvoiceImportDetail2View;
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
