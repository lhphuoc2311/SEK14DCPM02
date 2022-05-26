/*
*  created date: May 26, 2022
*  author: cgm
*/
package com.cgm.buoi5;

import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

public class PersonListCarTestDrive {
    public static void main(String[] args) {



        // List<String> teoCars = new ArrayList<>();
        // teoCars.add("100");
        // teoCars.add("101");

        List<Car> lCars = new ArrayList<>();
        lCars.add(new Car("100", 2000, "model1"));
        lCars.add(new Car("102", 2001, "model2"));

        Person person = new Person("Teo", lCars);


        JsonObject seat1 = new JsonObject();
        seat1.addProperty("1", 0);
        JsonObject seat2 = new JsonObject();
        seat2.addProperty("2", 1);


        JsonArray seats = new JsonArray();
        seats.add(seat1);
        seats.add(seat2);

        JsonObject hall = new JsonObject();
        hall.addProperty("hallno", 1);
        hall.add("seats", seats);


        Gson gson =new Gson();
        try(FileWriter writer = new FileWriter("halls.json")){
            gson.toJson(hall, writer);
        }catch(Exception e){
            e.printStackTrace();
        }


    }
    
}
