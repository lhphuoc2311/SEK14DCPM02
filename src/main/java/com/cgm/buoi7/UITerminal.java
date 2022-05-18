/*
*  created date: May 17, 2022
*  author: cgm
*/
package com.cgm.buoi7;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.swing.Action;

import com.cgm.buoi8.Actions;

public class UITerminal {
    private static Scanner scanner = new Scanner(System.in);
    private Account accObject;
    private String prompt;
    private Actions command;

    /**
     * @param accObject
     */
    public UITerminal(Account accObject) {
        this.accObject = accObject;
        this.prompt = null;
        this.command = null;

    }

    public void displayOptions() {
        System.out.println("~~~~~~~~~~~~~~~~~~~~CRS MENU~~~~~~~~~~~~~~~~~~~");

        // check
        if (!accObject.checkLoggedIn()) {
            this.prompt = "Enter one of the commands in the brackets:\n" +
                    "[CA] Create Account\n" +
                    "[LI] Login";
        } else {
            this.prompt = "LOGGED IN AS # " + accObject.getUsername();
            System.out.println("Enter on of the commands in brackets:\n " +
                    "[LO] Logout");
        }

    }

    /**
     * @return the prompt
     */
    public String getPrompt() {
        return prompt;
    }

    public void handleInputs() {
        if (this.command.equals(Actions.CA)) {
            Account account = createAccountInputs();
            Account.createAccount(account.getUsername(), account.getPassword(), account.getEmail());

        } else if (this.command.equals(Actions.LI)) {
            // ???code?
           List<Object> list =  loginInputs();// Implementations
           accObject.login(list.get(0).toString(), (int)list.get(1));

        }else if(this.command.equals(Actions.LO)){
            accObject.logout();
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

    // CA LI LO li
    public String handleCommands(String rep) {
        String cmd = rep.toUpperCase();
        this.command = Actions.valueOf(cmd);

        if (this.command.equals(Actions.CA)) {
            return "Enter a username, a password, a email";
        } else if (this.command.equals(Actions.LO)) {
            return "Logging out ...";
        } else if (this.command.equals(Actions.LI)) {
            return "Enter a username, a password";
        } else {
            return "Unkown command.";
        }

    }

}
