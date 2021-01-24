/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qlkh.utils.custombarchart;

import java.awt.Color;
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
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.CategoryLabelPositions;
import org.jfree.chart.labels.ItemLabelAnchor;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.renderer.category.CategoryItemRenderer;
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

    public BarChart_AWT(String applicationTitle, String chartTitle, List<BarChartItems> items, String horizontalTitle, String verticalTitle) {
        //  super(applicationTitle);

        JFreeChart barChart = ChartFactory.createBarChart(
                chartTitle,
                horizontalTitle,
                verticalTitle,
                createDataset(items),
                PlotOrientation.VERTICAL,
                true, true, false);
        CategoryPlot plot = barChart.getCategoryPlot();
        CategoryAxis axis = plot.getDomainAxis();
        // Set Margin left of table
        axis.setLowerMargin(0.01);
        //Set margin right of table
        axis.setUpperMargin(0.01);
        // set margin of each category 
        axis.setCategoryMargin(0.2);
        BarRenderer renderer = (BarRenderer) plot.getRenderer();
        //set margin of each item of category
        renderer.setItemMargin(0.01);
        plot.setOutlinePaint(new Color (240,240,240));
        plot.setBackgroundPaint(new Color (240,240,240));
        barChart.setBackgroundPaint(new Color (240,240,240));
        barChart.setBorderVisible(false);
        
        //barChart.setBackgroundPaint(plot.getBackgroundPaint());

        ChartPanel chartPanel = new ChartPanel(barChart);
        chartPanel.setPreferredSize(new java.awt.Dimension(600, 300));
        setContentPane(chartPanel);
    }

    public JPanel getContentPage() {
        return this;
    }

    private CategoryDataset createDataset(List<BarChartItems> items) {
        final DefaultCategoryDataset dataset
                = new DefaultCategoryDataset();
        for (BarChartItems item : items) {
            dataset.addValue(item.getItem1().getValue(), item.getItem1().getRowKey(), item.getName());
            dataset.addValue(item.getItem2().getValue(), item.getItem2().getRowKey(), item.getName());
        }
        return dataset;
    }

    // private String 
}
