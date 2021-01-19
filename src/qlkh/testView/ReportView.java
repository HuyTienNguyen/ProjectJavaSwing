/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qlkh.testView;

import qlkh.views.*;
import java.awt.CardLayout;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.Vector;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import qlkh.entities.Category;
import qlkh.entities.CustomObject1;
import qlkh.entities.Products;
import qlkh.entities.Supliers;
import qlkh.entities.Unit;
import qlkh.utils.Constants;
import qlkh.utils.custombarchart.BarChartItem;
import qlkh.utils.custombarchart.BarChart_AWT;
import qlkh.utils.pagination.ObjectTableModel;
import qlkh.utils.pagination.PaginatedTableDecorator;
import qlkh.utils.pagination.PaginationDataProvider;

/**
 *
 * @author user
 */
public class ReportView extends javax.swing.JPanel {

    /**
     * Creates new form UnitView
     */
    ResourceBundle bundle;
    private static Map<Integer, String> suplierMap = new HashMap<>();
    private static Map<Integer, String> unitMap = new HashMap<>();
    private static Map<Integer, String> cateMap = new HashMap<>();
    private static int[] pageSizes = new int[]{ 100};

    //button để hiện phân trang maximum 7
    private static final int maxPagingCompToShow = 7;
    //item for table 0
    private static final String[] valueOfCbbBarchart = {"7 ngày gần nhất", "Năm gần nhất", "Những năm gần nhất",};
    private static List<BarChartItem> items = new ArrayList<>();
    private static Map<Integer, List<BarChartItem>> mapItems = new HashMap<>();

    // item for table 1
    private static List<CustomObject1> numberOneObjects = new ArrayList<>();
    private static final int defaultPageSize1 = pageSizes[0];
    JTable table1;
    PaginatedTableDecorator<CustomObject1> paginatedDecorator1;

    public ReportView() {
        Locale local = Locale.getDefault();
        setResourceBundle(local);
        
        initComponents();
    }

    // Show view with listUnit on Unit Table
    public void showView() {
        this.setVisible(true);

    }

    public JPanel getContent() {
        return this;
    }

    // Set ResourceBundle to this view
    private void setResourceBundle(Locale locale) {
        //Set Resources Bundle theo local 
        bundle = ResourceBundle.getBundle("qlkh/utils/languages", locale);

    }

    // Load list Unit on Unit Table
    public void loadAllUnit(List<Unit> listUnit) {
        DefaultTableModel unitModel = new DefaultTableModel();
        unitModel.setColumnIdentifiers(Constants.HEADER_UNIT_TABLE);
        int startNumber = 1;
        for (Unit unit : listUnit) {
            Vector row = new Vector();
            row.add(startNumber);
            row.add(unit);

            row.add((unit.getStatus() > 0) ? bundle.getString(Constants.STATUS_SHOW) : bundle.getString(Constants.STATUS_HIDE));
            startNumber++;
            unitModel.addRow(row);
        }
    }

    public Map<Integer, List<BarChartItem>> mapBarChartItems(List<BarChartItem> items, Integer number) {
       
        
   
//           if(items!=null){
//              mapItems.put(number, items);
//           }
       
       
       return mapItems;
    }

    public void loadTable0() {
        String title1 = "Car Usage Statistics";
        String title2 = "Which car do you like?";
        String horizontalTitle = "Month";
        String verticalTitle = " no thing";
        BarChart_AWT chart = new BarChart_AWT("aaaâ",
                title2, mapItems, horizontalTitle, verticalTitle);
        tablePanel0.add(chart);
    }

    public void loadTable1(List<CustomObject1> objects) {
        // set data for List<Product> lists
        this.numberOneObjects = objects;
        table1 = new JTable(createObjectDataModel1());
        table1.setAutoCreateRowSorter(true);
        PaginationDataProvider<CustomObject1> dataProvider = createDataProvider1();
       // paginatedDecorator1 = PaginatedTableDecorator.decorate(table1,
        //        dataProvider, pageSizes, defaultPageSize1, maxPagingCompToShow);
        tablePanel1.removeAll();
        tablePanel1.add(paginatedDecorator1.getContentPanel());
    }

    // Crete objectdatamodel for table 2
    private static TableModel createObjectDataModel1() {
        return new ObjectTableModel<CustomObject1>() {
            @Override
            public Object getValueAt(CustomObject1 obj, int columnIndex) {
                switch (columnIndex) {
                    case 0:

                        return " Hello";
                }
                return null;
            }

            @Override
            public int getColumnCount() {
                return Constants.HEADER_REPORT_TABLE1.length;
            }

            @Override
            public String getColumnName(int column) {
                switch (column) {
                    case 0:
                        return Constants.HEADER_REPORT_TABLE1[0];
                    case 1:
                        return Constants.HEADER_REPORT_TABLE1[1];
                    case 2:
                        return Constants.HEADER_REPORT_TABLE1[2];
                    case 3:
                        return Constants.HEADER_REPORT_TABLE1[3];

                }
                return null;
            }

        };
    }

    // Crete createDataProvider for table 2

    private static PaginationDataProvider<CustomObject1> createDataProvider1() {

        return new PaginationDataProvider<CustomObject1>() {
            String searchText;

            @Override
            public String getSearchText() {
                return searchText;
            }

            @Override
            public void setSearchText(String searchText) {
                this.searchText = searchText;
            }

            @Override
            public int getTotalRowCount(boolean isSearch) {
                return (isSearch == false ? numberOneObjects.size() : getListsSearchByText().size());
            }

            @Override
            public List<CustomObject1> getRows(int startIndex, int endIndex, boolean isSearch) {

                if (startIndex < endIndex) {
                    if (isSearch == false) {
                        return numberOneObjects.subList(startIndex, endIndex);
                    } else {
                        List<CustomObject1> newLists = getListsSearchByText();
                        return newLists.subList(startIndex, endIndex);
                    }
                }
                return new ArrayList<>();
            }

            @Override
            public List<CustomObject1> getListsSearchByText() {

                List<CustomObject1> newLists = new ArrayList<>();
                for (CustomObject1 em : numberOneObjects) {

                }
                return newLists;
            }

            @Override
            public void setList(List<CustomObject1> lists) {
                numberOneObjects = lists;
            }

        };

    }

    // Add event to button addNewUnit
    public void addBtnAddNewUnitActionListener(ActionListener listener) {
    }

    public void addBtnEditUnitActionListener(ActionListener listener) {
    }

    public void addBtnDeleteUnitActionListener(ActionListener listener) {
    }

    public void addTableUnitMouseListener(MouseListener listener) {
    }

    // Get text from txtNewUnitField
    public void setNewUnitText(String text) {
    }

    public void showMessage(String message, int color) {

    }

    public void focusTxtUnitField() {
    }

    public boolean checkUnitName(String unitName) {
        return (unitName != null && unitName.equals("") == false);
    }

    public int showDialogMesage(JFrame frame, String message, String title) {
        return JOptionPane.showConfirmDialog(frame, bundle.getString(message), bundle.getString(title), JOptionPane.OK_CANCEL_OPTION, JOptionPane.ERROR_MESSAGE);
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
        leftPanel = new javax.swing.JPanel();
        subPanelLeftUp = new javax.swing.JPanel();
        tablePanel0 = new javax.swing.JPanel();
        cbbReport0 = new javax.swing.JComboBox();
        subPanelRightUp = new javax.swing.JPanel();
        cbbReport1 = new javax.swing.JComboBox();
        tablePanel1 = new javax.swing.JPanel();
        rightPanel = new javax.swing.JPanel();
        subPanelLeftDown = new javax.swing.JPanel();
        tablePanel2 = new javax.swing.JPanel();
        cbbReport2 = new javax.swing.JComboBox();
        subPanelLefDown = new javax.swing.JPanel();
        tablePanel3 = new javax.swing.JPanel();
        cbbReport3 = new javax.swing.JComboBox();

        mainPanel.setLayout(new javax.swing.BoxLayout(mainPanel, javax.swing.BoxLayout.PAGE_AXIS));

        leftPanel.setBackground(new java.awt.Color(255, 153, 204));
        leftPanel.setLayout(new javax.swing.BoxLayout(leftPanel, javax.swing.BoxLayout.LINE_AXIS));

        subPanelLeftUp.setBackground(new java.awt.Color(255, 153, 51));

        tablePanel0.setBackground(new java.awt.Color(255, 204, 0));
        tablePanel0.setLayout(new java.awt.CardLayout());

        cbbReport0.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbReport0ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout subPanelLeftUpLayout = new javax.swing.GroupLayout(subPanelLeftUp);
        subPanelLeftUp.setLayout(subPanelLeftUpLayout);
        subPanelLeftUpLayout.setHorizontalGroup(
            subPanelLeftUpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tablePanel0, javax.swing.GroupLayout.DEFAULT_SIZE, 459, Short.MAX_VALUE)
            .addGroup(subPanelLeftUpLayout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(cbbReport0, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        subPanelLeftUpLayout.setVerticalGroup(
            subPanelLeftUpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, subPanelLeftUpLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(cbbReport0, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(tablePanel0, javax.swing.GroupLayout.DEFAULT_SIZE, 409, Short.MAX_VALUE))
        );

        leftPanel.add(subPanelLeftUp);

        subPanelRightUp.setBackground(new java.awt.Color(102, 255, 0));

        cbbReport1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbReport1ActionPerformed(evt);
            }
        });

        tablePanel1.setBackground(new java.awt.Color(255, 204, 0));
        tablePanel1.setLayout(new java.awt.CardLayout());

        javax.swing.GroupLayout subPanelRightUpLayout = new javax.swing.GroupLayout(subPanelRightUp);
        subPanelRightUp.setLayout(subPanelRightUpLayout);
        subPanelRightUpLayout.setHorizontalGroup(
            subPanelRightUpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tablePanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 459, Short.MAX_VALUE)
            .addGroup(subPanelRightUpLayout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(cbbReport1, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        subPanelRightUpLayout.setVerticalGroup(
            subPanelRightUpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, subPanelRightUpLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(cbbReport1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(tablePanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 409, Short.MAX_VALUE))
        );

        leftPanel.add(subPanelRightUp);

        mainPanel.add(leftPanel);

        rightPanel.setBackground(new java.awt.Color(0, 255, 102));
        rightPanel.setLayout(new javax.swing.BoxLayout(rightPanel, javax.swing.BoxLayout.LINE_AXIS));

        subPanelLeftDown.setBackground(new java.awt.Color(0, 255, 255));

        tablePanel2.setBackground(new java.awt.Color(255, 204, 0));
        tablePanel2.setLayout(new java.awt.CardLayout());

        cbbReport2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbReport2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout subPanelLeftDownLayout = new javax.swing.GroupLayout(subPanelLeftDown);
        subPanelLeftDown.setLayout(subPanelLeftDownLayout);
        subPanelLeftDownLayout.setHorizontalGroup(
            subPanelLeftDownLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tablePanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 459, Short.MAX_VALUE)
            .addGroup(subPanelLeftDownLayout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(cbbReport2, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        subPanelLeftDownLayout.setVerticalGroup(
            subPanelLeftDownLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, subPanelLeftDownLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(cbbReport2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(tablePanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 409, Short.MAX_VALUE))
        );

        rightPanel.add(subPanelLeftDown);

        subPanelLefDown.setBackground(new java.awt.Color(0, 204, 102));

        tablePanel3.setBackground(new java.awt.Color(255, 204, 0));
        tablePanel3.setLayout(new java.awt.CardLayout());

        cbbReport3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbReport3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout subPanelLefDownLayout = new javax.swing.GroupLayout(subPanelLefDown);
        subPanelLefDown.setLayout(subPanelLefDownLayout);
        subPanelLefDownLayout.setHorizontalGroup(
            subPanelLefDownLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tablePanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 459, Short.MAX_VALUE)
            .addGroup(subPanelLefDownLayout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(cbbReport3, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        subPanelLefDownLayout.setVerticalGroup(
            subPanelLefDownLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, subPanelLefDownLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(cbbReport3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(tablePanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 409, Short.MAX_VALUE))
        );

        rightPanel.add(subPanelLefDown);

        mainPanel.add(rightPanel);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 490, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void cbbReport1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbReport1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbbReport1ActionPerformed

    private void cbbReport2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbReport2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbbReport2ActionPerformed

    private void cbbReport3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbReport3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbbReport3ActionPerformed

    private void cbbReport0ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbReport0ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbbReport0ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox cbbReport0;
    private javax.swing.JComboBox cbbReport1;
    private javax.swing.JComboBox cbbReport2;
    private javax.swing.JComboBox cbbReport3;
    private javax.swing.JPanel leftPanel;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JPanel rightPanel;
    private javax.swing.JPanel subPanelLefDown;
    private javax.swing.JPanel subPanelLeftDown;
    private javax.swing.JPanel subPanelLeftUp;
    private javax.swing.JPanel subPanelRightUp;
    private javax.swing.JPanel tablePanel0;
    private javax.swing.JPanel tablePanel1;
    private javax.swing.JPanel tablePanel2;
    private javax.swing.JPanel tablePanel3;
    // End of variables declaration//GEN-END:variables
}
