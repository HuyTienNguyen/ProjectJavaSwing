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
    private BarChartItem item1;
    private BarChartItem item2;

    public BarChartItems() {
    }

    public BarChartItems(String name, BarChartItem item1, BarChartItem item2) {
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

    public BarChartItem getItem1() {
        return item1;
    }

    public void setItem1(BarChartItem item1) {
        this.item1 = item1;
    }

    public BarChartItem getItem2() {
        return item2;
    }

    public void setItem2(BarChartItem item2) {
        this.item2 = item2;
    }
    
}
