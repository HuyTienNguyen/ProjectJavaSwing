/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qlkh.testView;

import java.io.File;

/**
 *
 * @author user
 */
public class testNew {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        //This will be the file where the username and password will be saved
File file = new File(System.getProperty("user.home")+"/Desktop/save.txt");
        System.out.println(file);
    }
    
}
