package com.marceloserpa;


public class Main {
    static void main() {
        var myHashMap = new MyHashMap();
        myHashMap.put(1, 100);
        myHashMap.put(20, 5);
        myHashMap.put(21, 5);
        myHashMap.put(31, 6);
        myHashMap.put(41, 7);
        myHashMap.put(4, 19);

        System.out.println("====");
        System.out.println(myHashMap.get(1));
        System.out.println(myHashMap.get(20));
        System.out.println(myHashMap.get(21));
        System.out.println(myHashMap.get(31));
        System.out.println(myHashMap.get(41));
        System.out.println(myHashMap.get(51));
        System.out.println(myHashMap.get(4));
    }
}
