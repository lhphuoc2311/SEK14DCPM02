/*
*  created date: May 23, 2022
*  author: cgm
*/
package com.cgm.buoi9.ecb;

import java.util.ArrayList;
import java.util.List;

public class NewAccountController {
    private Account account;

    /**
     * @return the account
     */
    public Account getAccount() {
        return account;
    }

    /**
     * @param account
     */
    public NewAccountController(Account account) {
        this.account = account;
    }
    public void createAccount(String username, Integer password, String email) {
        // so do tuan tu - sequence
        // check valid username, email =>??? class method : accountValid
        List<Object> listCheck;
        
        listCheck = accountValid(username, email);
        if (!(boolean) listCheck.get(0)) {
            System.out.println(listCheck.get(1));
        } else {
            // them account moi vao CSDL
            Account.getAccounts().update(username, password, email);// memory
            Account.getAccounts().write();
            System.out.println(listCheck.get(1));
        }
        // if(!valid){
        // /
        // }else{
        // tao tai khoan => CSDL
        // }
    }
    public  List<Object> accountValid(String username, String email) {
        List<Object> list = new ArrayList<>();
        int index = 0;
        // Boolean valid = true;
        // check username = mr teo
        index = Account.getAccounts().search("un", username);
        if (index != -1) {
            // valid = false;
            list.add(false);// 0
            list.add("[USERNAME EXISTS] An user with that username already exists.");// 1
            return list;
        }
        index = Account.getAccounts().search("email", email);
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
    
}
