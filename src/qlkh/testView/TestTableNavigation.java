/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qlkh.testView;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author GIANG
 */
class Product {

    private int id;
    private String name;
    private String supName;
    private String untiName;
    private String cateName;

    public Product() {
    }

    public Product(int id, String name, String supName, String untiName, String cateName) {
        this.id = id;
        this.name = name;
        this.supName = supName;
        this.untiName = untiName;
        this.cateName = cateName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSupName() {
        return supName;
    }

    public void setSupName(String supName) {
        this.supName = supName;
    }

    public String getUntiName() {
        return untiName;
    }

    public void setUntiName(String untiName) {
        this.untiName = untiName;
    }

    public String getCateName() {
        return cateName;
    }

    public void setCateName(String cateName) {
        this.cateName = cateName;
    }

}

public class TestTableNavigation extends javax.swing.JFrame {

    /**
     * Creates new form TestTableNavigation
     */
    public TestTableNavigation() {
        initComponents();
        addList();
        loadTable();
        mainRun();
        panelToAdd.setLayout(new FlowLayout());
        List<String> a = new ArrayList<>();
        a.add("1");
        System.out.println("size: " + a.size());

    }
    private int currentNumber;
    private int pageLimit;
    private int pages = 6;
    private int currentPage = 4;
    private final int MAXPAGES = 7;
    private List<JButton> buttons ;
    private static List<Product> products = new ArrayList<>();
    private int counts = 0;

    private void mainRun() {
        buttons= new ArrayList<>();

        currentNumber = 1;
        //  btnCurrentPage.setText(String.valueOf(currentNumber));
        //   pageLimit = Integer.parseInt(String.valueOf(cbbPageLimit.getSelectedItem()));

        for (int i = 0; i <= pages; i++) {
            JButton btn = new JButton();
            if (i == currentPage) {
                btn.setBackground(Color.RED);
                btn.setText(String.valueOf(i + 10));
                btn.setPreferredSize(new Dimension(45, 30));
                btn.setVisible(true);
                buttons.add(btn);
            } else if (i < 3 || i == pages||i==currentPage-1||i==currentPage+1) {

                btn.setBackground(Color.WHITE);
                btn.setText(String.valueOf(i + 10));
                // addBtnActionListener(new TestAddJButtonToJPanel.ButtonActionListener(btn), btn);
                // a.setSize(30, 40);
                btn.setPreferredSize(new Dimension(45, 30));
                btn.setVisible(true);
                buttons.add(btn);
            } else {
                btn.setBackground(Color.WHITE);
                btn.setText(".");
                // addBtnActionListener(new TestAddJButtonToJPanel.ButtonActionListener(btn), btn);
                // a.setSize(30, 40);
                btn.setPreferredSize(new Dimension(45, 30));
                btn.setVisible(true);
                buttons.add(btn);
            }
          
        }
        refreshPanel();

    }

    private void refreshPanel() {
  
        for (JButton btn : buttons) {
            panelToAdd.add(btn);

        }

        panelToAdd.revalidate();

        panelToAdd.repaint();

    }

    private void refreshView() {
        // btnCurrentPage.setText(String.valueOf(currentNumber));
    }

    private void addList() {
        for (int i = 0; i < 100; i++) {
            Product pro = new Product(i, "name" + i, "suplierName" + i, "unitName" + i, "cateName" + i);
            products.add(pro);
        }
    }
    private static String[] HEADER_TABLE = {"STT", "id", "name", "suplier", "unit", "cate"};

    private void loadTable() {
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(HEADER_TABLE);
        int startNumber = 1;

        for (Product product : products) {
            Vector rows = new Vector();
            rows.add(startNumber);
            rows.add(product.getId());
            rows.add(product.getName());

            rows.add(product.getSupName());
            rows.add(product.getUntiName());
            rows.add(product.getCateName());
            startNumber++;
            model.addRow(rows);
        }
        //table.setModel(model);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnPrevious = new javax.swing.JButton();
        btnNext = new javax.swing.JButton();
        btnFirst = new javax.swing.JButton();
        btnLast = new javax.swing.JButton();
        cbbPageLimit = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        panelToAdd = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnPrevious.setText("Previous");
        btnPrevious.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPreviousActionPerformed(evt);
            }
        });

        btnNext.setText("Next");
        btnNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNextActionPerformed(evt);
            }
        });

        btnFirst.setText("First");
        btnFirst.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFirstActionPerformed(evt);
            }
        });

        btnLast.setText("Last");
        btnLast.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLastActionPerformed(evt);
            }
        });

        cbbPageLimit.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "10", "20", "50", "100", " " }));

        jLabel1.setText("Page Limit");

        javax.swing.GroupLayout panelToAddLayout = new javax.swing.GroupLayout(panelToAdd);
        panelToAdd.setLayout(panelToAddLayout);
        panelToAddLayout.setHorizontalGroup(
            panelToAddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 244, Short.MAX_VALUE)
        );
        panelToAddLayout.setVerticalGroup(
            panelToAddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 63, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnFirst)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cbbPageLimit, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(81, 81, 81))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(panelToAdd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGap(28, 28, 28)
                                .addComponent(btnPrevious)
                                .addGap(161, 161, 161)
                                .addComponent(btnNext)))
                        .addGap(22, 22, 22)
                        .addComponent(btnLast)
                        .addContainerGap(162, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbbPageLimit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNext)
                    .addComponent(btnFirst)
                    .addComponent(btnLast)
                    .addComponent(btnPrevious))
                .addGap(44, 44, 44)
                .addComponent(panelToAdd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(293, 293, 293))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNextActionPerformed
        int size = products.size();
        if (currentPage < size) {
            currentPage++;
        }
        mainRun();
    }//GEN-LAST:event_btnNextActionPerformed

    private void btnPreviousActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPreviousActionPerformed

        if (currentPage > 0) {
            currentPage--;
        }
        mainRun();

    }//GEN-LAST:event_btnPreviousActionPerformed

    private void btnFirstActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFirstActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnFirstActionPerformed

    private void btnLastActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLastActionPerformed
        JButton btn = new JButton();
        btn.setBackground(Color.WHITE);
        btn.setText("1");
        //  addBtnActionListener(new TestAddJButtonToJPanel.ButtonActionListener(btn), btn);
        // a.setSize(30, 40);
        btn.setPreferredSize(new Dimension(50, 40));
        btn.setVisible(true);
        buttons.add(btn);
        //    number++;
        refreshPanel();
        System.out.println("2");
    }//GEN-LAST:event_btnLastActionPerformed

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
            java.util.logging.Logger.getLogger(TestTableNavigation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TestTableNavigation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TestTableNavigation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TestTableNavigation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TestTableNavigation().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnFirst;
    private javax.swing.JButton btnLast;
    private javax.swing.JButton btnNext;
    private javax.swing.JButton btnPrevious;
    private javax.swing.JComboBox cbbPageLimit;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel panelToAdd;
    // End of variables declaration//GEN-END:variables

}
