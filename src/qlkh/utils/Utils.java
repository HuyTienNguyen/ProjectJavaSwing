/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qlkh.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.Properties;
import java.util.Random;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


/**
 *
 * @author GIANG
 */
public class Utils {

    /**
     * Hàm lấy về thời gian hiện tại
     *
     * @return Chuỗi thời gian trả về
     * @see DateFormat
     */
    public static Timestamp getTimestampNow() {
        return new Timestamp(System.currentTimeMillis());

    }

    /**
     * Hàm trả về định dạng chuỗi theo simpleformat
     *
     * @param time kiểu timestamp
     * @return Chuỗi thời gian trả về
     * @see DateFormat
     */
    public static String getSimpleDateFormat(Timestamp time) {
        return new SimpleDateFormat(Constants.DATE_FORMAT).format(time);

    }

    /*
     *
     Hàm set Locale
     *
     */
    public static void setLocale(String country) {
        try {
            //Bước 1: Tạo đối tượng luồng và liên kết nguồn dữ liệu
            String configFile = System.getProperty("user.dir");
            File f = new File(configFile + "\\src\\qlkh\\utils\\languages.properties");
            FileWriter fw = new FileWriter(f);
            //Bước 2: Ghi dữ liệu
            fw.write((country.equals("EN")) ? "country=en \nlang=US" : "country =vi \nlang =VN");
            //Bước 3: Đóng luồng
            fw.close();
        } catch (IOException ex) {
            System.out.println("Loi ghi file: " + ex);
        }
    }

    /*
     *
     Hàm get Locale
     *
     */
    public static Locale getLocale() {
        // đọc lại file
        Locale newLocale = null;
        try {
            String configFile = System.getProperty("user.dir");
            File readFile = new File(configFile + "\\src\\qlkh\\utils\\languages.properties");
            Scanner readData = new Scanner(readFile);
            while (readData.hasNextLine()) {
                String data = readData.nextLine();
                data = data.split("=")[1];
                if (data.equals("vi") || data.equals("VN")) {
                    newLocale = new Locale("vi", "VN");
                } else {
                    newLocale = new Locale("en", "US");
                }
            }
            readData.close();
        } catch (FileNotFoundException ex) {
            System.out.println("An error occurred.");
            ex.printStackTrace();
        }
        return newLocale;
    }
    
    /*
     *
     Hàm send mail
     *
     */
    public static void sendMail(String recepient,String content) throws Exception{
        System.out.println("starting");
        Properties properties = new Properties();
        
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host","smtp.gmail.com");
        properties.put("mail.smtp.port", "587");
        
        String myAccountEmail = "tienhuy031001@gmail.com";
        String password = "tienhuy0310";
        
        Session session = Session.getInstance(properties,new Authenticator() {

            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(myAccountEmail, password); //To change body of generated methods, choose Tools | Templates.
            }
            
        });
        Message message = prepareMessage(session,myAccountEmail,recepient,content);
        Transport.send(message);
        System.out.println("finished");
    }
    
    private static Message prepareMessage(Session session, String myAccountEmail,String recepient,String content) {
        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(myAccountEmail));
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(recepient));
            message.setSubject("My firt email from app java");
            message.setText(content);
            return message;
        } catch (Exception ex) {
            Logger.getLogger(Utils.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    /*
     *
     Hàm tạo random 6 số
     *
     */
    public static String randomNumber(){
        Random rnd = new Random();
        int number = rnd.nextInt(999999);

    // this will convert any number sequence into 6 character.
        return String.format("%06d", number);
    }
}
