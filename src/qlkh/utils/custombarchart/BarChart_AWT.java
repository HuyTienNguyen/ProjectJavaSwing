/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qlkh.utils.custombarchart;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import javax.swing.JFrame;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;


/**
 *
 * @author GIANG
 */
public class BarChart_AWT extends JPanel {

    private static List<BarChartItem> items = new ArrayList<>();
    private static Map<Integer, List<BarChartItem>> mapItems = new HashMap<>();

    private void setContentPane(ChartPanel chartPanel) {       
        this.add(chartPanel);
      }

    

    public BarChart_AWT(String applicationTitle, String chartTitle, Map<Integer, List<BarChartItem>> mapItem,String horizontalTitle,String verticalTitle) {
      //  super(applicationTitle);
        mapItems = getMapSortByKeyASC(mapItem);

        JFreeChart barChart = ChartFactory.createBarChart(
                chartTitle,
               horizontalTitle,
               verticalTitle,
                createDataset(mapItems),
                PlotOrientation.VERTICAL,
                true, true, false);

        ChartPanel chartPanel = new ChartPanel(barChart);
        chartPanel.setPreferredSize(new java.awt.Dimension(600, 367));
        setContentPane(chartPanel);
    }

    private TreeMap getMapSortByKeyASC(Map<Integer, List<BarChartItem>> mapItem) {
        return new TreeMap(mapItem);
    }

    private CategoryDataset createDataset(Map<Integer, List<BarChartItem>> mapItem) {

        final DefaultCategoryDataset dataset
                = new DefaultCategoryDataset();


        for (Map.Entry<Integer, List<BarChartItem>> entrySet : mapItem.entrySet()) {
            String key = entrySet.getKey().toString();
            List<BarChartItem> value = entrySet.getValue();
            for (BarChartItem value1 : value) {
                dataset.addValue(value1.getValue(), value1.getRowKey(), key);
            }
        }
        return dataset;
    }

    // private String 
    
}
