/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qlkh.daoimpl;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import qlkh.dao.IReportsDAO;
import qlkh.entities.InvoiceImport;
import qlkh.utils.DatabaseHelper;
import qlkh.utils.custombarchart.BarChartItems;
import qlkh.utils.custombarchart.ChartItem;

/**
 *
 * @author GIANG
 */
public class ReportsDaoImpl implements IReportsDAO {

    public static final String SQL_SELECT_TOTAL_REPORTS_NEAR_WEEK = "{call sp_get_total_reports_from_nearest_week}";
    public static final String SQL_SELECT_TOTAL_REPORTS_6_MOST_RECENT_MONTH = "{call sp_get_total_reports_from_6_most_recent_months}";
    public static final String SQL_SELECT_TOTAL_REPORTS_5_MOST_YEAR = "{call sp_get_total_reports_from_atmost_5year_to_now}";

    public static final String SQL_SELECT_TOTAL_INVENTORIES_BY_CATE = "{call sp_get_inventories_at_current_by_category}";

    public static final String SQL_SELECT_TOP_10_PROFITS_3_MOST_RECENT_MONTHS = "{call sp_get_top_10_profits_from_3_most_recent_months}";
    public static final String SQL_SELECT_TOP_10_PROFITS_RECENT_WEEK = "{call sp_get_top_10_profits_from_nearest_week}";

    public static final int CBB_ACTION_SELECT_FIRST = 0;
    public static final int CBB_ACTION_SELECT_SECOND = 1;
    public static final int CBB_ACTION_SELECT_THIRD = 2;

    @Override
    public List<BarChartItems> getReports(int action) {
        String sql = "";
        switch (action) {
            case CBB_ACTION_SELECT_SECOND:
                sql = SQL_SELECT_TOTAL_REPORTS_6_MOST_RECENT_MONTH;
                break;
            case CBB_ACTION_SELECT_THIRD:
                sql = SQL_SELECT_TOTAL_REPORTS_5_MOST_YEAR;
                break;
            default:
                sql = SQL_SELECT_TOTAL_REPORTS_NEAR_WEEK;
                break;
        }

        List<BarChartItems> items = new ArrayList<>();
        String[] param = new String[]{};
        try (ResultSet rs = DatabaseHelper.selectDataByCallableStatement(sql, param)) {
            while (rs.next()) {
                ChartItem item1 = new ChartItem("", Double.valueOf(rs.getString("TotalImport")));
                ChartItem item2 = new ChartItem("", Double.valueOf(rs.getString("Totalexport")));
                BarChartItems item = new BarChartItems(rs.getString("TimeToGet"), item1, item2);
                items.add(item);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                DatabaseHelper.getInstance().closeDatabaseConnection();
            } catch (SQLException ex) {
                Logger.getLogger(ReportsDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
       
        return items;
    }

    @Override
    public List<BarChartItems> getProfits(int action) {
        String sql = "";
        switch (action) {
            case CBB_ACTION_SELECT_SECOND:
                sql = SQL_SELECT_TOP_10_PROFITS_3_MOST_RECENT_MONTHS;
                break;
            default:
                sql = SQL_SELECT_TOP_10_PROFITS_RECENT_WEEK;
                break;
        }
        List<BarChartItems> items = new ArrayList<>();
        String[] param = new String[]{};
        try (ResultSet rs = DatabaseHelper.selectDataByCallableStatement(sql, param)) {
            while (rs.next()) {
                ChartItem item1 = new ChartItem("", Double.valueOf(rs.getString("totalProfits")));
                BarChartItems item = new BarChartItems(rs.getString("ProductName"), item1);
                items.add(item);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                DatabaseHelper.getInstance().closeDatabaseConnection();
            } catch (SQLException ex) {
                Logger.getLogger(ReportsDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
       
        return items;
    }

    @Override
    public List<ChartItem> getTotalInventoryByCate() {
        String[] param = new String[]{};
        List<ChartItem> items = new ArrayList<>();
        try (ResultSet rs = DatabaseHelper.selectDataByCallableStatement(SQL_SELECT_TOTAL_INVENTORIES_BY_CATE, param)) {
            while (rs.next()) {
                ChartItem item = new ChartItem(rs.getString("CateName"), Double.valueOf(rs.getString("total")));
                items.add(item);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                DatabaseHelper.getInstance().closeDatabaseConnection();
            } catch (SQLException ex) {
                Logger.getLogger(ReportsDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return items;
    }
}
