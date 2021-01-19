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
import java.util.logging.Level;
import java.util.logging.Logger;
import qlkh.dao.IReportsDAO;
import qlkh.entities.InvoiceImport;
import qlkh.utils.DatabaseHelper;

/**
 *
 * @author GIANG
 */
public class ReportsDaoImpl  implements IReportsDAO{
    private static final String SQL_SELECT_TOTAL_REPORTS_LAST_WEEK ="{call sp_get_total_reports_from_nearest_week}";
    @Override
    public void getReportsInTheLastWeek() {
          String[] param = new String[]{};         
          try ( ResultSet rs  = DatabaseHelper.selectDataByCallableStatement(SQL_SELECT_TOTAL_REPORTS_LAST_WEEK, param) )
                  {                      
            while (rs.next()) {
                System.out.println(rs.getString("dateofweek")+" "+rs.getString("totalimport")+" "+rs.getString("totalexport"));
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
      }   
}
