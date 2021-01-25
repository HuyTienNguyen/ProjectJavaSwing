/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qlkh.utils.custombarchart;

import java.awt.Color;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JPanel;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.data.category.CategoryDataset;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.PieSectionLabelGenerator;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;

/**
 *
 * @author GIANG
 */
public class PieChart_AWT extends JPanel {

    private static List<ChartItem> items = new ArrayList<>();

    private void setContentPane(ChartPanel chartPanel) {
        this.add(chartPanel);
    }

    public PieChart_AWT(String chartTitle, List<ChartItem> items) {
        //  super(applicationTitle);
        JFreeChart chart = ChartFactory.createPieChart(
                chartTitle,
                createDataset(items),
                true, true, false);
        PieSectionLabelGenerator labelGenerator = new StandardPieSectionLabelGenerator(
                "{0}: ({2})", new DecimalFormat("0"), new DecimalFormat("0%"));
        ((PiePlot) chart.getPlot()).setLabelGenerator(labelGenerator);
        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new java.awt.Dimension(600, 300));
        setContentPane(chartPanel);
    }

    public JPanel getContentPage() {
        return this;
    }

    private PieDataset createDataset(List<ChartItem> items) {
        final DefaultPieDataset dataset
                = new DefaultPieDataset();
        for (ChartItem item : items) {
            dataset.setValue(item.getRowKey(), item.getValue());
        }
        return dataset;
    }

    // private String 
}
