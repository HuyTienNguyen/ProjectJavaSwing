/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qlkh.testView;

import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.management.ManagementFactory;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;

/**
 *
 * @author user
 */
public class testNew {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        JButton button = new JButton();
        button.setSize(100,100);
        button.setLocation(200,200);
        button.setVisible(true);
        frame.add(button);
        frame.setSize(400, 400);
        frame.setVisible(true);
         
        button.addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent e) 
            {
                StringBuilder cmd = new StringBuilder();
        cmd.append(System.getProperty("java.home") + File.separator + "bin" + File.separator + "java ");
        for (String jvmArg : ManagementFactory.getRuntimeMXBean().getInputArguments()) {
            cmd.append(jvmArg + " ");
        }
        cmd.append("-cp ").append(ManagementFactory.getRuntimeMXBean().getClassPath()).append(" ");
        cmd.append(App.class.getName()).append(" ");
        for (String arg : args) {
            cmd.append(arg).append(" ");
        }
                try {
                    Thread.currentThread().sleep(1000); // 10 seconds delay before restart
                } catch (InterruptedException ex) {
                    Logger.getLogger(testNew.class.getName()).log(Level.SEVERE, null, ex);
                }
                try {
                    Runtime.getRuntime().exec(cmd.toString());
                } catch (IOException ex) {
                    Logger.getLogger(testNew.class.getName()).log(Level.SEVERE, null, ex);
                }
        System.exit(0);
            }
        });
    }
    
}
