/*
*  created date: May 23, 2022
*  author: cgm
*/
package com.cgm.buoi9.ecb;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.cgm.buoi8.Actions;

public class LoginAccountUI {
    private static Scanner scanner = new Scanner(System.in);

    private LoginAccountController loginAccountController;
    private Actions command;

    

    /**
     * @param loginAccountController
     * @param command
     */
    public LoginAccountUI(LoginAccountController loginAccountController) {
        this.loginAccountController = loginAccountController;
        this.command = null;
    }

    public String handleCommands(String rep) {
        String cmd = rep.toUpperCase();
        this.command = Actions.valueOf(cmd);
        if (this.command.equals(Actions.LO)) {
            return "Logging out ...";
        } else if (this.command.equals(Actions.LI)) {
            return "Enter a username, a password";
        } else {
            return "Unkown command.";
        }
    }

    public void handleInputs() {
    if (this.command.equals(Actions.LI)) {
            // ???code?
           List<Object> list =  loginInputs();// Implementations
           this.loginAccountController.login(list.get(0).toString(), (int)list.get(1));//Controller
        }else if(this.command.equals(Actions.LO)){
            this.loginAccountController.logout();//Controller
        }
    }


    private List<Object> loginInputs() {
        List<Object> list = new ArrayList<>();
        System.out.print("USERNAME: ");
        String username = scanner.nextLine();
        System.out.print("PASSWORD: ");
        Integer password = scanner.nextInt();scanner.nextLine();
        list.add(username);
        list.add(password);
        return list;
    }

}
