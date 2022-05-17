/*
*  created date: May 17, 2022
*  author: cgm
*/
package com.cgm.buoi7;

public class AccountTestDrive {
    public static void main(String[] args) {
        //Account account = new Account();
        boolean test = Account.accountValid("mrteo", "mrteo@gmail.com");

        if(!test){
            System.out.println("[USERNAME EXISTS or EMAIL] A User with that username or email already exists." );

        }else{
            System.out.println("[ACCOUNT_CREATED] An account has been createa.");
        }

    }
    
}
