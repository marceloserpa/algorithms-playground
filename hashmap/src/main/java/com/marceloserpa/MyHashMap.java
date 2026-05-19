package com.marceloserpa;

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
        }
        table[index] = new Entry(key, value, null);
    }

    public int get(int key){
        int index = hash(key);
        Entry entry = table[index];
        return entry.value;
    }

    public void remove(int key) {
        int index = hash(key);
        table[index] = null;
    }

    private int hash(int key){
        int hash = Math.abs(key) % CAPACITY;
        System.out.printf("key=%d Hash=%d\n", key, hash);
        return hash;
    }



}
