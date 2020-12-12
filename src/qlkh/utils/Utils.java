/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qlkh.utils;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

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
     * @param time kiểu timestamp
     * @return Chuỗi thời gian trả về
     * @see DateFormat
     */
    public static String getSimpleDateFormat(Timestamp time) {
        return new SimpleDateFormat(Constants.DATE_FORMAT).format(time);

    }
}
