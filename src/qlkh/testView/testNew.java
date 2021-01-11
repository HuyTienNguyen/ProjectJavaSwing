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
import java.util.Properties;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;

import qlkh.utils.Utils;

/**
 *
 * @author user
 */
public class testNew {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
//        String contentMail= "5";
//        Utils.sendMail("danvohoix4@gmail.com",contentMail);
        String regex = "unique:users,email";
        String rules = regex.split(":")[1];
        String[] ruless = rules.split(",");
        ArrayList<String> newList = new ArrayList<>();
        
        System.out.println(ruless[0]);
        
        ruless[2] = "hi";
        for(String x : ruless){
            System.out.println(x);
        }
        String xx = "select * from  ? where ? = ?";
    }
}
