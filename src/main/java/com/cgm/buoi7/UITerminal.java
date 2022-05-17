/*
*  created date: May 17, 2022
*  author: cgm
*/
package com.cgm.buoi7;

import java.util.Scanner;

public class UITerminal {
    private Account accObject;
    private String prompt;
    private String command;
    /**
     * @param accObject
     */
    public UITerminal(Account accObject) {
        this.accObject = accObject;
        this.prompt = null;
        this.command = null;

    }

    public void displayOptions(){
        System.out.println("~~~~~~~~~~~~~~~~~~~~CRS MENU~~~~~~~~~~~~~~~~~~~");

        //check
        if(!accObject.checkLoggedIn()){
            this.prompt = "Enter one of the commands in the brackets:\n" +
            "[CA] Create Account\n" +
            "[LI] Login";
        }else{
            this.prompt = "LOGGED IN AS # " + accObject.getUsername();
            System.out.println("Enter on of the commands in brackets:\n "+
             "[LO] Logout" );
        }

    }

    /**
     * @return the prompt
     */
    public String getPrompt() {
        return prompt;
    }


    public void handleInputs(){
        if(this.command.equals("CA")){
            Account account = createAccountInputs();
            Account.createAccount(account.getUsername(), account.getPassword(), account.getEmail());

        }else if(this.command.equals("LI")){

        }
    }

    public static Account createAccountInputs(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("USERNAME: ");
        String username = scanner.nextLine();
        System.out.print("PASSWORD: ");
        Integer password = scanner.nextInt();
        scanner.nextLine();
        System.out.print("EMAIL: ");
        String email = scanner.nextLine();
        return new Account(username, password, email);

    }

    //CA LI LO li
    public String handleCommands(String rep){
        String cmd = rep.toUpperCase();
        this.command = cmd;

        if(this.command.equals("CA")){
            return "Enter a username, a password, a email";
        }else if(this.command.equals("LO")){
            return "Logging out ...";
        }else if(this.command.equals("LI")){
            return "Enter a username, a password";
        }else{
            return "Unkown command.";
        }

    }

    
    
}
