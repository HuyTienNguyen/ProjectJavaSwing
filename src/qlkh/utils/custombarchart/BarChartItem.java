/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qlkh.utils.custombarchart;

/**
 *
 * @author Windows 10
 */
public class BarChartItem {
     private double value;
        private String rowKey;

        public BarChartItem() {
        }

        public BarChartItem(double value, String rowKey) {

            this.value = value;
            this.rowKey = rowKey;

        }

        public double getValue() {
            return value;
        }

        public void setValue(double value) {
            this.value = value;
        }

        public String getRowKey() {
            return rowKey;
        }

        public void setRowKey(String rowKey) {
            this.rowKey = rowKey;
        }

    @Override
    public String toString() {
        return "BarChartItem{" + "value=" + value + ", rowKey=" + rowKey + '}';
    }

      
}
