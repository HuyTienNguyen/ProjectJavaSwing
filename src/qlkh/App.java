/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qlkh;

import java.awt.Window;
import java.io.File;
import java.io.IOException;
import java.lang.management.ManagementFactory;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.SwingUtilities;
import qlkh.controller.SignInController;

/**
 *
 * @author user
 */
public class App {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException ex) {
                    Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
                }
                ResourceBundle newBundle = ResourceBundle.getBundle("qlkh/utils/languages");
                Locale myLocale = Locale.getDefault(); 
                SignIn signIn = new SignIn(myLocale);
                SignInController mainController = new SignInController(signIn);
                mainController.showSignIn();

            }

        });
    }

    public void restartApplication() throws IOException, URISyntaxException {
        StringBuilder cmd = new StringBuilder();
                cmd.append(System.getProperty("java.home") + File.separator + "bin" + File.separator + "java ");
                for (String jvmArg : ManagementFactory.getRuntimeMXBean().getInputArguments()) 
                {
                    cmd.append(jvmArg + " ");
                }
                 
                cmd.append("-cp ").append(ManagementFactory.getRuntimeMXBean().getClassPath()).append(" ");
                cmd.append(Window.class.getName()).append(" ");
     
                try
                {
                    Runtime.getRuntime().exec(cmd.toString());
                } 
                catch (IOException e1) 
                {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
                System.exit(0);
    }

}
