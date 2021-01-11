/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qlkh.request;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author user
 */
public class SignUpRequest extends IRequest{

    @Override
    protected Map<String, String> setRules() {
        Map<String,String> myMap = new HashMap();
        myMap.put("name", "required");
        myMap.put("email","required|regex:^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$|unique:users,email");
        myMap.put("username","required|regex:^[a-zA-Z0-9]{8,30}$|unique:users,username");
        myMap.put("password","required|regex:^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$|confirmed");
        myMap.put("password_confirmation", "required");
        return myMap;
    }

    @Override
    protected Map<String, String> setMesages() {
        Map<String, String> innerMap = new HashMap<>();
        innerMap.put("name.required","The name field is required");
        
        innerMap.put("email.required", "The address field is required");
        innerMap.put("email.regex","The Email field must be in the correct format");
        innerMap.put("email.unique","The Email already exists!Please try again");
        
        innerMap.put("username.required", "The Username field is required");
        innerMap.put("username.regex","<html>The Username fields must be greater than 8 characters and less<br> than 30 characters and have no special characters<html>");
        innerMap.put("username.unique","The Username already exists! Please try again");
        
        innerMap.put("password.required", "The Password field is required");
        innerMap.put("password.regex", "<html>The password Minimum eight characters, <br>at least one uppercase character, one lowercase character, <br> one number and one special character</html>");
        
        innerMap.put("password_confirmation.confirmed","The Password authentication is not correct" );
        
        return innerMap;
    }
    
}
