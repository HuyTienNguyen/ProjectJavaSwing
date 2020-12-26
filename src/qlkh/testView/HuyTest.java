/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qlkh.testView;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.SwingUtilities;
import qlkh.controller.SuplierController;
import qlkh.controller.UnitController;
import qlkh.dao.IUnitDAO;
import qlkh.daoimpl.UnitDaoImpl;
import qlkh.entities.Unit;

/**
 *
 * @author GIANG
 */
public class HuyTest {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException ex) {
                    Logger.getLogger(HuyTest.class.getName()).log(Level.SEVERE, null, ex);
                }
//                StudentView stview = new StudentView();
//                StudentController studentController = new StudentController(stview);
//                studentController.showStudentView();
                // ILogin controller = new LoginController();                     
                // controller.showLoginView();  
//                SuplierController supli = new SuplierController();
//                supli.showView();
//                StudentView stview = new StudentView();
//                StudentController studentController = new StudentController(stview);
//                studentController.showStudentView();
                // ILogin controller = new LoginController();                     
                // controller.showLoginView();  
                UnitController unit =  new UnitController();
                unit.showView();

            }

        });
    }
}
