/*
*  created date: May 17, 2022
*  author: cgm
*/
package com.cgm.buoi7;

public class StoredFilesTestDrive {
    public static void main(String[] args) {
        StoredFiles storedFiles = new StoredFiles("accounts.json");
        storedFiles.read();
        System.out.println("");
    }
    
}
