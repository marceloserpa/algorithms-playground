package com.marceloserpa;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyHashMapTest {

    @Test
    void put() {
        var myHashMap = new MyHashMap();
        myHashMap.put(1, 100);
        myHashMap.put(20, 5);
        myHashMap.put(31, 6);
        myHashMap.put(41, 7);
        myHashMap.put(4, 19);

        assertEquals(100, myHashMap.get(1));
        assertEquals(5, myHashMap.get(20));
        assertEquals(6, myHashMap.get(31));
        assertEquals(7, myHashMap.get(41));
        assertEquals(19, myHashMap.get(4));
    }

    @Test
    void put2() {
        var myHashMap = new MyHashMap();
        myHashMap.put(20, 5);
        myHashMap.put(20, 6);

        assertEquals(6, myHashMap.get(20));
    }

    @Test
    void put3() {
        var myHashMap = new MyHashMap();
        myHashMap.put(21, 5);
        myHashMap.put(31, 6);
        myHashMap.put(41, 6);
        myHashMap.put(51, 6);
        myHashMap.put(51, 888);

        assertEquals(888, myHashMap.get(51));
    }

    @Test
    void remove() {
        var myHashMap = new MyHashMap();
        myHashMap.put(1, 100);
        myHashMap.remove(1);

        assertEquals(0, myHashMap.get(1));
    }

    @Test
    void removeFromSecondBucketPosition() {
        var myHashMap = new MyHashMap();
        myHashMap.put(1, 100);
        myHashMap.put(11, 56);
        myHashMap.remove(11);

        assertEquals(0, myHashMap.get(11));
    }


    @Test
    void removeFromMiddleBucketPosition() {
        var myHashMap = new MyHashMap();
        myHashMap.put(1, 1);
        myHashMap.put(11, 2);
        myHashMap.put(21, 3);
        myHashMap.put(31, 4);

        myHashMap.remove(21);

        assertEquals(2, myHashMap.get(11));
        assertEquals(4, myHashMap.get(31));
    }

}