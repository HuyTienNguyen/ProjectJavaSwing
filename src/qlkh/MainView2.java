/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qlkh;

import qlkh.testView.*;
import qlkh.*;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import qlkh.controller.CategoryController;
import qlkh.controller.CustomerController;
import qlkh.controller.InvoiceImportDetailController;
import qlkh.controller.ProductsController;
import qlkh.controller.ReportsController;
import qlkh.controller.SuplierController;
import qlkh.controller.UnitController;
import qlkh.controller.UsersController;
import qlkh.testView.GiangTestFrameInvoiceImportDetail;
import qlkh.views.CustomerView;
import qlkh.views.Home;
import qlkh.views.InvoiceImportDetail2View;


/**
 *
 * @author user
 */
public class MainView2 extends javax.swing.JFrame {

    /**
     * Creates new form MainView
     */
    int xMouse;
    int yMouse;
    public static final String homeView = "home";
    public static final String cateView = "cate";
    public static final String customerView = "customer";
    public static final String productView = "product";
    public static final String suplierView = "suplier";
    public static final String unitView = "unit";
    public static final String userView = "user";
    public static final String reportView = "report";

    public MainView2() {

        initComponents();
        setLocationRelativeTo(null);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainPanel = new javax.swing.JPanel();
        headerPanel = new javax.swing.JPanel();
        iconminmaxclose = new javax.swing.JPanel();
        ButtonClose = new javax.swing.JPanel();
        close = new javax.swing.JLabel();
        ButtonScreen = new javax.swing.JPanel();
        RestoreDown = new javax.swing.JLabel();
        ButtonHide = new javax.swing.JPanel();
        minimize = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        FrameDrag = new javax.swing.JLabel();
        sidebarPanel = new javax.swing.JPanel();
        menuMain = new javax.swing.JPanel();
        btnCustomer = new keeptoo.KButton();
        btnCategory = new keeptoo.KButton();
        btnProducts = new keeptoo.KButton();
        btnSuplier = new keeptoo.KButton();
        btnHome = new keeptoo.KButton();
        btnUnit = new keeptoo.KButton();
        btnUsers = new keeptoo.KButton();
        btnReports = new keeptoo.KButton();
        contentPanel = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        mainPanel.setBackground(new java.awt.Color(153, 255, 153));

        headerPanel.setBackground(new java.awt.Color(102, 255, 0));
        headerPanel.setLayout(new java.awt.BorderLayout());

        iconminmaxclose.setBackground(new java.awt.Color(255, 0, 153));
        iconminmaxclose.setPreferredSize(new java.awt.Dimension(150, 70));
        iconminmaxclose.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        ButtonClose.setBackground(new java.awt.Color(231, 234, 237));
        ButtonClose.setLayout(new java.awt.BorderLayout());

        close.setBackground(new java.awt.Color(23, 169, 204));
        close.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        close.setIcon(new javax.swing.ImageIcon(getClass().getResource("/qlkh/icons/icons8-delete-15.png"))); // NOI18N
        close.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                closeMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                closeMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                closeMouseExited(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                closeMouseReleased(evt);
            }
        });
        ButtonClose.add(close, java.awt.BorderLayout.CENTER);

        iconminmaxclose.add(ButtonClose, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 0, 50, 30));

        ButtonScreen.setBackground(new java.awt.Color(231, 234, 237));
        ButtonScreen.setLayout(new java.awt.BorderLayout());

        RestoreDown.setBackground(new Color(0,0,0,0));
        RestoreDown.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        RestoreDown.setIcon(new javax.swing.ImageIcon(getClass().getResource("/qlkh/icons/icons8-restore-down-15.png"))); // NOI18N
        RestoreDown.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                RestoreDownMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                RestoreDownMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                RestoreDownMouseExited(evt);
            }
        });
        ButtonScreen.add(RestoreDown, java.awt.BorderLayout.CENTER);

        iconminmaxclose.add(ButtonScreen, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 0, 50, 30));

        ButtonHide.setBackground(new java.awt.Color(231, 234, 237));
        ButtonHide.setLayout(new java.awt.BorderLayout());

        minimize.setBackground(new java.awt.Color(23, 169, 204));
        minimize.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        minimize.setIcon(new javax.swing.ImageIcon(getClass().getResource("/qlkh/icons/icons8-compress-15.png"))); // NOI18N
        minimize.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                minimizeMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                minimizeMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                minimizeMouseExited(evt);
            }
        });
        ButtonHide.add(minimize, java.awt.BorderLayout.CENTER);

        iconminmaxclose.add(ButtonHide, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 50, 30));

        headerPanel.add(iconminmaxclose, java.awt.BorderLayout.LINE_END);

        jPanel2.setBackground(new java.awt.Color(231, 234, 237));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/qlkh/icons/icons8-online-store-25.png"))); // NOI18N
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, -1, 30));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel1.setText("Store Manager");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 0, 150, 30));

        FrameDrag.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                FrameDragMouseDragged(evt);
            }
        });
        FrameDrag.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                FrameDragMousePressed(evt);
            }
        });
        jPanel2.add(FrameDrag, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 970, 30));

        headerPanel.add(jPanel2, java.awt.BorderLayout.CENTER);

        sidebarPanel.setBackground(new java.awt.Color(0, 102, 51));

        menuMain.setBackground(new java.awt.Color(28, 43, 65));
        menuMain.setPreferredSize(new java.awt.Dimension(200, 575));

        btnCustomer.setText("Customers");
        btnCustomer.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnCustomer.setkBorderRadius(0);
        btnCustomer.setkEndColor(new java.awt.Color(28, 43, 65));
        btnCustomer.setkHoverEndColor(new java.awt.Color(48, 125, 245));
        btnCustomer.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        btnCustomer.setkHoverStartColor(new java.awt.Color(48, 125, 245));
        btnCustomer.setkStartColor(new java.awt.Color(28, 43, 65));
        btnCustomer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCustomerActionPerformed(evt);
            }
        });

        btnCategory.setText("Category");
        btnCategory.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnCategory.setkBorderRadius(0);
        btnCategory.setkEndColor(new java.awt.Color(28, 43, 65));
        btnCategory.setkHoverEndColor(new java.awt.Color(48, 125, 245));
        btnCategory.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        btnCategory.setkHoverStartColor(new java.awt.Color(48, 125, 245));
        btnCategory.setkStartColor(new java.awt.Color(28, 43, 65));
        btnCategory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCategoryActionPerformed(evt);
            }
        });

        btnProducts.setText("Products");
        btnProducts.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnProducts.setkBorderRadius(0);
        btnProducts.setkEndColor(new java.awt.Color(28, 43, 65));
        btnProducts.setkHoverEndColor(new java.awt.Color(48, 125, 245));
        btnProducts.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        btnProducts.setkHoverStartColor(new java.awt.Color(48, 125, 245));
        btnProducts.setkStartColor(new java.awt.Color(28, 43, 65));
        btnProducts.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProductsActionPerformed(evt);
            }
        });

        btnSuplier.setText("Supliers");
        btnSuplier.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnSuplier.setkBorderRadius(0);
        btnSuplier.setkEndColor(new java.awt.Color(28, 43, 65));
        btnSuplier.setkHoverEndColor(new java.awt.Color(48, 125, 245));
        btnSuplier.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        btnSuplier.setkHoverStartColor(new java.awt.Color(48, 125, 245));
        btnSuplier.setkStartColor(new java.awt.Color(28, 43, 65));
        btnSuplier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuplierActionPerformed(evt);
            }
        });

        btnHome.setText("Home");
        btnHome.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnHome.setkBorderRadius(0);
        btnHome.setkEndColor(new java.awt.Color(28, 43, 65));
        btnHome.setkHoverEndColor(new java.awt.Color(48, 125, 245));
        btnHome.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        btnHome.setkHoverStartColor(new java.awt.Color(48, 125, 245));
        btnHome.setkStartColor(new java.awt.Color(28, 43, 65));
        btnHome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHomeActionPerformed(evt);
            }
        });

        btnUnit.setText("Unit");
        btnUnit.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnUnit.setkBorderRadius(0);
        btnUnit.setkEndColor(new java.awt.Color(28, 43, 65));
        btnUnit.setkHoverEndColor(new java.awt.Color(48, 125, 245));
        btnUnit.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        btnUnit.setkHoverStartColor(new java.awt.Color(48, 125, 245));
        btnUnit.setkStartColor(new java.awt.Color(28, 43, 65));
        btnUnit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUnitActionPerformed(evt);
            }
        });

        btnUsers.setText("Users");
        btnUsers.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnUsers.setkBorderRadius(0);
        btnUsers.setkEndColor(new java.awt.Color(28, 43, 65));
        btnUsers.setkHoverEndColor(new java.awt.Color(48, 125, 245));
        btnUsers.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        btnUsers.setkHoverStartColor(new java.awt.Color(48, 125, 245));
        btnUsers.setkStartColor(new java.awt.Color(28, 43, 65));
        btnUsers.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUsersActionPerformed(evt);
            }
        });

        btnReports.setText("Reports");
        btnReports.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnReports.setkBorderRadius(0);
        btnReports.setkEndColor(new java.awt.Color(28, 43, 65));
        btnReports.setkHoverEndColor(new java.awt.Color(48, 125, 245));
        btnReports.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        btnReports.setkHoverStartColor(new java.awt.Color(48, 125, 245));
        btnReports.setkStartColor(new java.awt.Color(28, 43, 65));
        btnReports.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReportsActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout menuMainLayout = new javax.swing.GroupLayout(menuMain);
        menuMain.setLayout(menuMainLayout);
        menuMainLayout.setHorizontalGroup(
            menuMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnCustomer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnProducts, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnSuplier, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnCategory, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnHome, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnUnit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnUsers, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnReports, javax.swing.GroupLayout.DEFAULT_SIZE, 228, Short.MAX_VALUE)
        );
        menuMainLayout.setVerticalGroup(
            menuMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menuMainLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnHome, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(btnCategory, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(btnCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(btnProducts, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(btnSuplier, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(btnUnit, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(btnUsers, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(btnReports, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(361, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout sidebarPanelLayout = new javax.swing.GroupLayout(sidebarPanel);
        sidebarPanel.setLayout(sidebarPanelLayout);
        sidebarPanelLayout.setHorizontalGroup(
            sidebarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 228, Short.MAX_VALUE)
            .addGroup(sidebarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(menuMain, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 228, Short.MAX_VALUE))
        );
        sidebarPanelLayout.setVerticalGroup(
            sidebarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 744, Short.MAX_VALUE)
            .addGroup(sidebarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(menuMain, javax.swing.GroupLayout.DEFAULT_SIZE, 744, Short.MAX_VALUE))
        );

        contentPanel.setBackground(new java.awt.Color(255, 0, 51));
        contentPanel.setLayout(new java.awt.CardLayout());

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(headerPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 1162, Short.MAX_VALUE)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addComponent(sidebarPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(contentPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addComponent(headerPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(sidebarPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(contentPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        setSize(new java.awt.Dimension(1162, 772));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void closeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_closeMouseClicked
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_closeMouseClicked

    private void closeMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_closeMouseEntered
        // TODO add your handling code here:
        changeColor(ButtonClose, new Color(232, 17, 35));
    }//GEN-LAST:event_closeMouseEntered

    private void closeMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_closeMouseExited
        changeColor(ButtonClose, new Color(231, 234, 237));
    }//GEN-LAST:event_closeMouseExited

    private void closeMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_closeMouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_closeMouseReleased

    private void RestoreDownMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_RestoreDownMouseClicked
        // TODO add your handling code here:
        if (this.getExtendedState() != MainView2.MAXIMIZED_BOTH) {
            this.setExtendedState(MainView2.MAXIMIZED_BOTH);
        } else {
            this.setExtendedState(MainView2.NORMAL);
        }
    }//GEN-LAST:event_RestoreDownMouseClicked

    private void RestoreDownMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_RestoreDownMouseEntered
        // TODO add your handling code here:
        changeColor(ButtonScreen, new Color(229, 229, 229));
    }//GEN-LAST:event_RestoreDownMouseEntered

    private void RestoreDownMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_RestoreDownMouseExited
        changeColor(ButtonScreen, new Color(231, 234, 237));
    }//GEN-LAST:event_RestoreDownMouseExited

    private void minimizeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_minimizeMouseClicked
        // TODO add your handling code here:
        this.setState(MainView2.ICONIFIED);
    }//GEN-LAST:event_minimizeMouseClicked

    private void minimizeMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_minimizeMouseEntered
        // TODO add your handling code here:
        changeColor(ButtonHide, new Color(229, 229, 229));
    }//GEN-LAST:event_minimizeMouseEntered

    private void minimizeMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_minimizeMouseExited
        // TODO add your handling code here:
        changeColor(ButtonHide, new Color(231, 234, 237));
    }//GEN-LAST:event_minimizeMouseExited

    private void FrameDragMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_FrameDragMouseDragged
        // TODO add your handling code here:
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.setLocation(x - xMouse, y - yMouse);
    }//GEN-LAST:event_FrameDragMouseDragged

    private void FrameDragMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_FrameDragMousePressed
        // TODO add your handling code here:
        xMouse = evt.getX();
        yMouse = evt.getY();
    }//GEN-LAST:event_FrameDragMousePressed

    private void btnCustomerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCustomerActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_btnCustomerActionPerformed

    private void btnCategoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCategoryActionPerformed

    }//GEN-LAST:event_btnCategoryActionPerformed

    private void btnProductsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProductsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnProductsActionPerformed

    private void btnSuplierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuplierActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnSuplierActionPerformed

    private void btnHomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnHomeActionPerformed

    private void btnUnitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUnitActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnUnitActionPerformed

    private void btnUsersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUsersActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnUsersActionPerformed

    private void btnReportsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReportsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnReportsActionPerformed

    public void changeColor(JPanel hover, Color rand) {
        hover.setBackground(rand);
    }

    public void goToPageMainPanel(String name) {
        CardLayout layout = (CardLayout) contentPanel.getLayout();
        layout.show(contentPanel, name);
        this.pack();
    }

    public void addBtnShowHome(ActionListener listener, Home view) {
        btnHome.addActionListener(listener);
        contentPanel.add( homeView,view);
    }

    public void addBtnShowCategory(ActionListener listener, CategoryController c) {
        btnCategory.addActionListener(listener);
        contentPanel.add(c.getContentPage(),cateView);
    }

    public void addBtnShowCustomer(ActionListener listener, CustomerController c) {
        btnCustomer.addActionListener(listener);
        contentPanel.add(c.getContentPage(),customerView);

    }

    public void addBtnShowProducts(ActionListener listener, ProductsController c) {
        btnProducts.addActionListener(listener);
        contentPanel.add(c.getContentPage(),productView);

    }

    public void addBtnShowSupliers(ActionListener listener, SuplierController c) {
        btnSuplier.addActionListener(listener);
        contentPanel.add(c.getContentPage(),suplierView);

    }

    public void addBtnShowUnit(ActionListener listener, UnitController c) {
        btnUnit.addActionListener(listener);
        contentPanel.add(c.getContentPage(),unitView);

    }

    public void addBtnShowUsers(ActionListener listener, UsersController c) {
        btnUsers.addActionListener(listener);
        contentPanel.add(c.getContentPage(),userView);

    }

//    public void addBtnShowReports(ActionListener listener, ReportsController c) {
//        btnReports.addActionListener(listener);
//        contentPanel.add(c.getContentPage(),reportView);
//
//    }

    public void showView() {
        this.setVisible(true);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainView2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainView2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainView2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainView2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainView2().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel ButtonClose;
    private javax.swing.JPanel ButtonHide;
    private javax.swing.JPanel ButtonScreen;
    private javax.swing.JLabel FrameDrag;
    private javax.swing.JLabel RestoreDown;
    private keeptoo.KButton btnCategory;
    private keeptoo.KButton btnCustomer;
    private keeptoo.KButton btnHome;
    private keeptoo.KButton btnProducts;
    private keeptoo.KButton btnReports;
    private keeptoo.KButton btnSuplier;
    private keeptoo.KButton btnUnit;
    private keeptoo.KButton btnUsers;
    private javax.swing.JLabel close;
    private javax.swing.JPanel contentPanel;
    private javax.swing.JPanel headerPanel;
    private javax.swing.JPanel iconminmaxclose;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JPanel menuMain;
    private javax.swing.JLabel minimize;
    private javax.swing.JPanel sidebarPanel;
    // End of variables declaration//GEN-END:variables
}
