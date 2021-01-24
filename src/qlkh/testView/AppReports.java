/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qlkh.testView;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.SwingUtilities;
import qlkh.controller.ReportsController;

/**
 *
 * @author GIANG
 */
public class AppReports {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException ex) {
                    Logger.getLogger(AppUsers.class.getName()).log(Level.SEVERE, null, ex);
                }
                ReportsController controller = new ReportsController();
                
            }
        });
    }
}
