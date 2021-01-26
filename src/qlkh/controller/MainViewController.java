/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qlkh.controller;

import java.awt.event.ActionEvent;
import qlkh.MainView2;
import qlkh.views.Home;

/**
 *
 * @author user
 */
public class MainViewController {

    private CategoryController category;
    private CustomerController customer;
    private ProductsController product;
    private SuplierController suplier;
    private UnitController unit;
    private UsersController user;
    private InvoiceImportDetailController importDetail;
    private InvoiceExportDetailController exportDetail;
    private ReportsController report;

    private Home home;
    private MainView2 view;

    public MainViewController() {
        category = new CategoryController();
        customer = new CustomerController();
        product = new ProductsController();
        suplier = new SuplierController();
        unit = new UnitController();
        user = new UsersController();
        report = new ReportsController();
        importDetail = new InvoiceImportDetailController();
        exportDetail = new InvoiceExportDetailController();
        home = new Home();
        view = new MainView2();
        view.addBtnShowHome(this::showViewHome, home);

        view.addBtnShowCategory(this::showViewCategory, category);

        view.addBtnShowProducts(this::showViewProduct, product);

        view.addBtnShowSupliers(this::showViewSuplier, suplier);
        // suplier.showView();
        view.addBtnShowCustomer(this::showViewCustomer, customer);

        view.addBtnShowUnit(this::showViewUnit, unit);

        view.addBtnShowUsers(this::showViewUser, user);
        view.addBtnShowImportDetail(this::showViewImportDetail, importDetail);
        view.addBtnShowExportDetail(this::showViewExportDetail, exportDetail);
        view.addBtnShowReports(this::showViewReport, report);
    }

    public void showView() {
        view.showView();
    }

    private void showViewHome(ActionEvent e) {
        view.goToPageMainPanel(view.homeView);
    }

    private void showViewCategory(ActionEvent e) {
        view.goToPageMainPanel(view.cateView);
        category.showView();
    }

    private void showViewCustomer(ActionEvent e) {
        view.goToPageMainPanel(view.customerView);
        customer.showView();
    }

    private void showViewProduct(ActionEvent e) {
        view.goToPageMainPanel(view.productView);
        product.showView();
    }

    private void showViewSuplier(ActionEvent e) {
        view.goToPageMainPanel(view.suplierView);
        suplier.showView();
    }

    private void showViewUnit(ActionEvent e) {
        view.goToPageMainPanel(view.unitView);
        unit.showView();
    }

    private void showViewUser(ActionEvent e) {
        view.goToPageMainPanel(view.userView);
        user.showView();
    }

    private void showViewImportDetail(ActionEvent e) {
        view.goToPageMainPanel(view.importView);
        importDetail.showView();
    }

    private void showViewReport(ActionEvent e) {
        view.goToPageMainPanel(view.reportView);
        report.showView();
    }

    private void showViewExportDetail(ActionEvent e) {
        view.goToPageMainPanel(view.exportView);
        exportDetail.showView();
    }

}
