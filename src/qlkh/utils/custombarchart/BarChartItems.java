/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qlkh.utils.custombarchart;

/**
 *
 * @author GIANG
 */
public class BarChartItems {

    private String name;
    private ChartItem item1;
    private ChartItem item2;

    public BarChartItems() {
    }

    public BarChartItems(String name, ChartItem item1) {
        this.name = name;
        this.item1 = item1;
    }

    public BarChartItems(String name, ChartItem item1, ChartItem item2) {
        this.name = name;
        this.item1 = item1;
        this.item2 = item2;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ChartItem getItem1() {
        return item1;
    }

    public void setItem1(ChartItem item1) {
        this.item1 = item1;
    }

    public ChartItem getItem2() {
        return item2;
    }

    public void setItem2(ChartItem item2) {
        this.item2 = item2;
    }
    
}
