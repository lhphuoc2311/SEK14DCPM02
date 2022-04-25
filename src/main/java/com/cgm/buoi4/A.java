/*
*  created date: Apr 25, 2022
*  author: cgm
*/
package com.cgm.buoi4;

public class A {

    //attribute: B
    private B refObject;//biến đối tượng - biến class: static

    public A(){
        refObject = new B();
    }

    public A(B b){
        this.refObject = b;
    }


    /**
     * @param refObject the refObject to set
     */
    public void setRefObject(B refObject) {
        this.refObject = refObject;
    }

    
}
