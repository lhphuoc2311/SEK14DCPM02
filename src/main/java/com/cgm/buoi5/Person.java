/*
*  created date: Apr 26, 2022
*  author: cgm
*/
package com.cgm.buoi5;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.JsonArray;

public class Person {

    private String name;
    private List<Car> lCars =new ArrayList<>();//xe
    /**
     * @param name
     * @param listCar
     */
    public Person(String name, List<Car> lCars) {
        this.name = name;
        this.lCars = lCars;
    }

    


    
}
