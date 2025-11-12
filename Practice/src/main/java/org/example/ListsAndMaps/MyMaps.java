package org.example.ListsAndMaps;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MyMaps {
    public static void main(String[] args) {
        Map<String, Integer> pops = new HashMap<>();

        pops.put("UK", 17000000);
        pops.put("USA", 250000000);
        pops.put("CANADA", 12000000);

        //pops.remove("USA");

        System.out.println(pops);

        pops.put("CANADA", 34000000);

        System.out.println(pops.get("UK"));

        Set<String> myKeys = pops.keySet();
        Collection<Integer> popValues = pops.values();

        System.out.println(myKeys);
        System.out.println(popValues);


    }



}
