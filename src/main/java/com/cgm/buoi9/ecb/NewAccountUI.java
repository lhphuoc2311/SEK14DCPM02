/*
*  created date: May 23, 2022
*  author: cgm
*/
package com.cgm.buoi9.ecb;

import java.util.Scanner;

import com.cgm.buoi8.Actions;

public class NewAccountUI {
    private static Scanner scanner = new Scanner(System.in);
    private Actions command;
    private NewAccountController newAccountController;

    

    /**
     * @param command
     * @param newAccountController
     */
    public NewAccountUI( NewAccountController newAccountController) {
        this.command = null;
        this.newAccountController = newAccountController;
    }

    // CA LI LO li
    public String handleCommands(String rep) {
        String cmd = rep.toUpperCase();
        this.command = Actions.valueOf(cmd);
        if (this.command.equals(Actions.CA)) {
            return "Enter a username, a password, a email";
        } else {
            return "Unkown command.";
        }
    }

    public void handleInputs() {
        if (this.command.equals(Actions.CA)) {
            Account account = createAccountInputs();
            newAccountController.createAccount(account.getUsername(), account.getPassword(), account.getEmail());
        }
    }

    private static Account createAccountInputs() {
        System.out.print("USERNAME: ");
        String username = scanner.nextLine();
        System.out.print("PASSWORD: ");
        Integer password = scanner.nextInt();
        scanner.nextLine();
        System.out.print("EMAIL: ");
        String email = scanner.nextLine();
        return new Account(username, password, email);
    }

}
