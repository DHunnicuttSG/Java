package org.example.ListsAndMaps;

import java.util.ArrayList;
import java.util.List;

public class MyLists {
    public static void main(String[] args) {
        List<String> myStringList = new ArrayList<>();

        myStringList.add("First");
        myStringList.add("Second");
        myStringList.add("Third");
        myStringList.add("Third");

        myStringList.remove("Third");


        System.out.println(myStringList);

        for(String x : myStringList){
            System.out.println(x);
        }

        System.out.println(myStringList.size());


    }



}
