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
public class UsersRequest extends IRequest {

    @Override
    protected Map<String, String> setRules() {
        Map<String, String> rules = new HashMap();
        rules.put("id", "required|unique:users,id");
        rules.put("loginName", "required|regex:^[a-z0-9A-Z]{8,100}$|unique:users,name");
        rules.put("email", "required|regex:^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$|unique:users,email");
        rules.put("username", "required|unique:users,username");
        rules.put("password", "required|regex:^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$|confirmed");
        rules.put("password_confirmation", "required");
        return rules;
    }

    @Override
    protected Map<String, String> setMesages() {
        Map<String, String> messes = new HashMap<>();
        messes.put("loginName.required", "The name is required");
        messes.put("loginName.regex", "<html>The login name Minimum eight characters, <br> and don't have  special characters</html>");

        messes.put("email.required", "The address field is required");
        messes.put("email.regex", "The Email field must be in the correct format");
        messes.put("email.unique", "The Email already exists!Please try again");

        messes.put("username.required", "The Username field is required");

        messes.put("username.unique", "The Username already exists! Please try again");

        messes.put("password.required", "The Password field is required");
        messes.put("password.regex", "<html>The password Minimum eight characters, <br>at least one uppercase character, one lowercase character, <br> one number and one special character</html>");

        messes.put("password_confirmation.confirmed", "The Password authentication is not correct");

        return messes;
    }

}
