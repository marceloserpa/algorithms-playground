package com.marceloserpa;

import java.util.NoSuchElementException;

public class MyHashMap {

    public static final int CAPACITY = 10;
    private Entry[] table;

    private static class Entry {
        int key;
        int value;
        Entry next;

        public Entry(int key, int value, Entry next){
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }

    public MyHashMap() {
        this.table = new Entry[CAPACITY];
    }

    public void put(int key, int value){
        int index = hash(key);
        if(table[index] != null) {
            System.out.printf("Key=%d Collision Detected!!!!%n\n", key);

            Entry entry = table[index];
            if(entry.key == key) {
                System.out.println("Already exists: updating value for key = " + key);
                entry.value = value;
                return;
            }
            while(entry.next != null) {
                if(entry.key == key) {
                    System.out.println("Already exists: updating value for key = " + key);
                    entry.value = value;
                    return;
                }
                entry = entry.next;
            }
            if(entry.key == key) {
                System.out.println("Already exists: updating value for key = " + key);
                entry.value = value;
                return;
            }
            entry.next = new Entry(key,value, null);
        }else{
            table[index] = new Entry(key, value, null);
        }

    }

    public int get(int key){
        int index = hash(key);
        Entry entry = table[index];

        if(entry == null) return 0;

        if(entry.key == key) {
            return entry.value;
        }
        while(entry.next != null) {
            entry = entry.next;
            if(entry.key == key){
                break;
            }
        }

        if(entry.key != key) {
            return 0;
        }
        return entry.value;
    }

    public void remove(int key) {
        int index = hash(key);

        if(table[index] ==null) {
            throw new NoSuchElementException("Key="+key+" was not found");
        }

        Entry entry = table[index];

        // focusing in the first element
        if(entry.key == key && entry.next == null) {
            table[index] = null;
            return;
        }

        if(entry.key == key){
            table[index] = entry.next;
            return;
        }

        //moving to next (LL nav)
        while(entry.next != null && entry.next.key != key){
            entry = entry.next;
        }

        if(entry.next == null) {
            throw new NoSuchElementException("Key="+key+" was not found");
        }

        entry.next = entry.next.next;
    }

    private int hash(int key){
        int hash = Math.abs(key) % CAPACITY;
        System.out.printf("key=%d Hash=%d\n", key, hash);
        return hash;
    }

}
