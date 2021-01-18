/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qlkh.test;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.SwingUtilities;
import qlkh.controller.MainViewController;
import qlkh.controller.UnitController;
import qlkh.testView.AppUnit;

/**
 *
 * @author user
 */
public class AppTestMainView {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException ex) {
                    Logger.getLogger(AppUnit.class.getName()).log(Level.SEVERE, null, ex);
                }
//                StudentView stview = new StudentView();
//                StudentController studentController = new StudentController(stview);
//                studentController.showStudentView();
                // ILogin controller = new LoginController();                     
                // controller.showLoginView();  

                MainViewController c = new MainViewController();
                c.showView();

            }

        });
    }
    
}
