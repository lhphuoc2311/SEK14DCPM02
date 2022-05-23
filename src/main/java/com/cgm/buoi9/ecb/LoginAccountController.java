/*
*  created date: May 23, 2022
*  author: cgm
*/
package com.cgm.buoi9.ecb;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

public class LoginAccountController {

    // login
    private Account account;
    /**
     * @param account
     */
    public LoginAccountController(Account account) {
        this.account = account;
    }

    public void login(String username, Integer password) {

        JsonArray tempMemory = Account.getAccounts().getAll();

        int index = -1;
        index = Account.getAccounts().search("un", username);

        // 1. already logined ==> username == object.username
        // logedIn = true
        if (username.equals(this.account.getUsername())) {
            System.out.println("[ALREADY LOGGED IN] You have already logged in.");

            // 2. dang nhap nhieu tai khoan=> username nhap vao != objcAccount.username
        } else if (this.account.getUsername() != null && !this.account.getUsername().equals(username)) {
            System.out.println("[INVALID MULTIPLE LOGINS] You need  to logout first to try another login.");
            // 4. dang nhap binh thuong|
        } else if (index != -1) {// accountObject => un =null, ps = null, email = null; loggedIn = false
            JsonObject jsonObject = tempMemory.get(index).getAsJsonObject();
            int passwordAcc = jsonObject.get("ps").getAsInt();
            if (passwordAcc == password) {
                String email = jsonObject.get("email").getAsString();
                // update value data to account
                this.account.setAccount(username, password, email);
                System.out.println("[LOGGED IN] You are logged in.");

            } else {
                System.out.println("[WRONG PASSWORD] The password  you enterd is incorrect!!!");
            }

        } else {
            System.out.println("[NOT REGISTERD] You have to  register first.!!! ");
        }

        // else
        // 3. chua dang ky
    }
    // logout

    public void logout(){
        this.account.logout();
    }

}
