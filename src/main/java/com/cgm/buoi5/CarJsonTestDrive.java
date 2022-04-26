/*
*  created date: Apr 26, 2022
*  author: cgm
*/
package com.cgm.buoi5;

import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;

public class CarJsonTestDrive {

    public static void main(String[] args) {

        Car car = new Car("100", 2022, "XXX");
        Car car2 = new Car("101", 2017, 
"yyy");

        Car car3 = new Car("102", 2018, 
"zzzz");

        List<Car> listCar = new ArrayList<>();

        listCar.add(car);
        listCar.add(car2);
        listCar.add(car3);

        //JsonArray cars = new JsonArray();
        //cars.ad
        
        Gson gson =new Gson();

        try(FileWriter writer = new FileWriter("cars.json")){
            gson.toJson(listCar, writer);
        }catch(Exception e){
            e.printStackTrace();
        }
        
        

    }
    
}
