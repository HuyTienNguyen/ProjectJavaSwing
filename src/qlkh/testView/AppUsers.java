/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qlkh.testView;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.SwingUtilities;
import qlkh.controller.CategoryController;
import qlkh.controller.SuplierController;
import qlkh.controller.UnitController;
import qlkh.controller.UsersController;
import qlkh.entities.Category;

/**
 *
 * @author GIANG
 */
public class AppUsers {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException ex) {
                    Logger.getLogger(AppUsers.class.getName()).log(Level.SEVERE, null, ex);
                }
//                StudentView stview = new StudentView();
//                StudentController studentController = new StudentController(stview);
//                studentController.showStudentView();
                // ILogin controller = new LoginController();                     
                // controller.showLoginView();  
                UsersController cateController = new UsersController();
                cateController.showView();
//                UnitController unit  = new UnitController();
//                unit.showView();

            }

        });
    }
}
