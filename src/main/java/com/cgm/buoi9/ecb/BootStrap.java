/*
*  created date: May 17, 2022
*  author: cgm
*/
package com.cgm.buoi9.ecb;

import java.util.Scanner;

import com.cgm.buoi8.Actions;

public class BootStrap {
    public static void main(String[] args) throws InterruptedException {
        Scanner inpuScanner = new Scanner(System.in);
        Account account = new Account();
        NewAccountController newAccountController = new NewAccountController(account);
        NewAccountUI newAccountUI = new NewAccountUI(newAccountController);

        LoginAccountController loginAccountController = new LoginAccountController(account);
        LoginAccountUI loginAccountUI = new LoginAccountUI(loginAccountController);

        System.out.println("Welcome to the Cinema Reservation System!!\n (To exit type 'exit') \n");

        while (true) {
            Thread.sleep(5000);
            displayOptions(newAccountController);
            String prompt = getPrompt(newAccountController);
            System.out.print(prompt);
            // chon
            // command
            String rep = inpuScanner.nextLine();

            // LI
            String resCMD;
            if (rep.toUpperCase().equals(Actions.CA.toString())) {
                resCMD = newAccountUI.handleCommands(rep);
                System.out.println(resCMD);

                if (resCMD != null && !resCMD.equals("Unkown command.")) {
                    newAccountUI.handleInputs();
                }
            } else if (rep.toUpperCase().equals(Actions.LI.toString())
                    || rep.toUpperCase().equals(Actions.LO.toString())) {

                resCMD = loginAccountUI.handleCommands(rep);

                if (resCMD != null && !resCMD.equals("Unkown command.")) {
                    loginAccountUI.handleInputs();
                }
            }
            // String cmd = uiTerminal.handleCommands(rep);

            // if (cmd != null && !cmd.equals("Unkown command.")) {
            // System.out.println(cmd);
            // uiTerminal.handleInputs();
            // }
            // inpuScanner.nextLine();

        }

    }

    public static void displayOptions(NewAccountController newAccountController) {
        System.out.println("~~~~~~~~~~~~~~~~~~~~CRS MENU~~~~~~~~~~~~~~~~~~~");
        // check
        String str = "";
        if (!newAccountController.getAccount().checkLoggedIn()) {

            str = "Enter one of the commands in the    brackets:\n" +
                    "[CA] Create Account\n" +
                    "[LI] Login";
            System.out.println(str);
        } else {

            System.out.println("Enter on of the commands in      brackets:\n " +
                    "[LO] Logout");
        }
    }

    public static String getPrompt(NewAccountController newAccountController){

        if(!newAccountController.getAccount().checkLoggedIn()){
            return "";
        }

        //String str  = "LOGGED IN AS # " + account.getUsername();

        return "LOGGED IN AS # " + newAccountController.getAccount().getUsername();

    }

}
