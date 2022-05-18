/*
*  created date: May 17, 2022
*  author: cgm
*/
package com.cgm.buoi7;

import java.util.Scanner;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

public class BootStrap {
    public static void main(String[] args) throws InterruptedException {
        Scanner inpuScanner  = new Scanner(System.in);
        Account accObject = new Account();
        UITerminal uiTerminal = new UITerminal(accObject);

        System.out.println("Welcome to the Cinema Reservation System!!\n (To exit type 'exit') \n");

        while(true){
            Thread.sleep(5000);
            uiTerminal.displayOptions();
            System.out.println(uiTerminal.getPrompt());
            //chon
            //command
            String rep = inpuScanner.nextLine();

            //LI
           String cmd =  uiTerminal.handleCommands(rep);

            if(cmd != null && !cmd.equals("Unkown command.")){
                System.out.println(cmd);
                uiTerminal.handleInputs();
            }
            //inpuScanner.nextLine();

           
           
           
            

        }
    }
    
}
