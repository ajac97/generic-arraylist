package edu.touro.cs;

import  org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MyLinkedListTest {

    private MyLinkedList<String> mll = new MyLinkedList();
    private MyLinkedList<String> abList = new MyLinkedList();

    MyLinkedListTest()
    {
        abList.add("A");abList.add("B");
    }
    @org.junit.jupiter.api.Test
    void size() {
    }

    @org.junit.jupiter.api.Test
    void isEmpty() {
    }

    @org.junit.jupiter.api.Test
    void containsTrue() {
        
        mll.add("A");
        assertEquals(true, mll.contains("A"));
    }

    @org.junit.jupiter.api.Test
    void containsFalse() {
        assertEquals(false, mll.contains("A"));
    }

    @org.junit.jupiter.api.Test
    void add1() {
       this.mll.add("A");
       assertEquals(1, mll.size());
    }


    @org.junit.jupiter.api.Test
    void get() {

        assertEquals("A", abList.get(0));
        assertEquals("B", abList.get(1));
    }

    @org.junit.jupiter.api.Test
    void set() {
        String oldVal = abList.set(0, "Q");
        assertEquals("Q", abList.get(0));
        assertEquals("B", abList.get(1));
        assertEquals("A", oldVal);
    }

    @org.junit.jupiter.api.Test
    void remove() {
        String oldVal =  abList.remove(0);
        assertEquals("A", oldVal);
        assertEquals("B", abList.get(0));
    }


    @org.junit.jupiter.api.Test
    void remove2() {
        abList.add("C");

        String oldVal =  abList.remove(1);
        assertEquals("B", oldVal);
        assertEquals("C", abList.get(1));
    }

    @org.junit.jupiter.api.Test
    void toArray() { // sharing private issue test
        mll.add("A");
        Object [] backDoor = mll.toArray();
        backDoor[0] = "HAHHA";

        assertEquals("A", mll.get(0));
    }

    @org.junit.jupiter.api.Test
    void iteration() {
        this.mll.add("A");
        this.mll.add("Q");

        String concat = "";
        for (String s : mll) {
            concat += s;
        }
        assertEquals("AQ", concat);
        ArrayList<String> al = new ArrayList<String>();

        boolean ret = mll.addAll( al);
    }

    @org.junit.jupiter.api.Test
    void generic() {
        MyGenericArrayList<String> mll = new MyGenericArrayList();

    }
}