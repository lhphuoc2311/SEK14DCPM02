/*
*  created date: May 17, 2022
*  author: cgm
*/
package com.cgm.buoi7;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.JsonArray;

public class Account {

    private static StoredFiles accounts = new StoredFiles("accounts.json");

    private String username;
    private Integer password;
    private String email;
    private boolean loggedIn;

    /**
     * 
     */
    public Account() {
        this.username = null;
        this.loggedIn = false;
        this.password = null;
        this.email = null;

    }

    /**
     * @param username
     * @param password
     * @param email
     * @param loggedIn
     */

    public Account(String username, Integer password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
        //this.loggedIn = loggedIn;
    }

    // check login
    public boolean checkLoggedIn() {
        return loggedIn;
    }

    public void login(String username, Integer password) {
        // to do
    }

    public void logout() {
        this.loggedIn = false;
        this.username = null;
        this.password = null;
        this.email = null;
        System.out.println("[LOGGED_OUT] You have been logged out");

    }

    // hanh vi cuar object
    public static void createAccount(String username, Integer password, String email) {
        // so do tuan tu - sequence
        // check valid username, email =>??? class method : accountValid
        List<Object> listCheck;
        listCheck = accountValid(username, email);

        if(!(boolean)listCheck.get(0)){
            System.out.println(listCheck.get(1));
        }else{
            //them account moi vao CSDL
            accounts.update(username, password, email);//memory
            accounts.write();
            System.out.println(listCheck.get(1));
        }


        // if(!valid){
        // /
        // }else{
        // tao tai khoan => CSDL
        // }

    }

    public static List<Object> accountValid(String username, String email) {
        List<Object> list = new ArrayList<>();
        int index = 0;
        // Boolean valid = true;
        // check username = mr teo
        index = accounts.search("un", username);

        if (index != -1) {
            // valid = false;
            list.add(false);// 0
            list.add("[USERNAME EXISTS] An user with that username already exists.");// 1
            return list;
        }

        index = accounts.search("email", email);
        if (index != -1) {
            // valid = false;
            list.add(false);
            list.add("[EMAIL EXISTS] A mail with that email already exists.");
            return list;
        }

        if (index == -1) {
            // valid
            list.add(true);
            list.add("[ACCOUNT_CREATED] An account has been created.");
        }
        return list;
    }

    /**
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @return the password
     */
    public Integer getPassword() {
        return password;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

}
