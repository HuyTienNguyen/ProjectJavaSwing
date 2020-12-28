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
import java.util.Scanner;

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
}
