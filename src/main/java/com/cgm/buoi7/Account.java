/*
*  created date: May 17, 2022
*  author: cgm
*/
package com.cgm.buoi7;

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

    public Account(String username, Integer password, String email, boolean loggedIn) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.loggedIn = loggedIn;
    }

    //check login
    public boolean checkLoggedIn(){
        return loggedIn;
    }

    public void login(String username, Integer password){
        //to do
    }

    public void logout(){
        this.loggedIn = false;
        this.username = null;
        this.password = null;
        this.email = null;
        System.out.println("[LOGGED_OUT] You have been logged out");

    }


    //hanh vi cuar object
    public static void createAccount(String username, Integer password, String email){
        //so do tuan tu - sequence
        //check valid username, email =>??? class method : accountValid
        boolean valid;
        valid = accountValid(username, email);

        if(!valid){
            ///
        }else{
            //tao tai khoan => CSDL
        }

    }

    public static boolean accountValid(String username, String email){
        int index = 0;
        boolean valid = true;
        //check username = mr teo
        index = accounts.search("un", username);

        if(index != -1){
            valid = false;
        }

        index = accounts.search("email", email);
        if(index != - 1){
            valid = false;
        }
        return valid;
    }

    

    


    
}
