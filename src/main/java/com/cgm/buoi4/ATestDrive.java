/*
*  created date: Apr 25, 2022
*  author: cgm
*/
package com.cgm.buoi4;

public class ATestDrive {

    public static void main(String[] args) {

        B b = new B();

        A a = new A(b);

        a.setRefObject(b);


        //Composition
        A a2 = new A();


        
    }

    
    
    

    
}
