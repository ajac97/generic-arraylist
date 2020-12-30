package edu.touro.cs;

import java.util.ArrayList;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class MyArrayListTest {
    MyGenericArrayList<String> mal = new MyGenericArrayList();
    ArrayList<String> temp = new ArrayList<>();

    @org.junit.jupiter.api.Test
    void removeAll() {
        mal.add("A");
        mal.add("B");
        mal.add("C");
        mal.add("D");
        mal.add("B");
        mal.add("E");
        temp.add("A");
        temp.add("B");
        mal.removeAll(temp);
        assertEquals(mal.size(), 3);
    }

    @org.junit.jupiter.api.Test
    void retainAll() {
        mal.add("A");
        mal.add("B");
        mal.add("C");
        mal.add("D");
        mal.add("E");
        mal.add("E");
        temp.add("A");
        temp.add("B");
        mal.retainAll(temp);
        assertEquals(mal.size(), 2);
        assertEquals(mal.get(0), "A");
        assertEquals(mal.get(1), "B");
    }

    @org.junit.jupiter.api.Test
    void addAll() {
        mal.add("A");
        mal.add("B");
        mal.add("C");
        temp.add("1");
        temp.add("2");
        mal.addAll(temp);
        assertEquals(mal.size(), 5);
        mal.add("Place");
        assertEquals(mal.get(0), "A");
        assertEquals(mal.get(1), "B");
        assertEquals(mal.get(2), "C");
        assertEquals(mal.get(3), "1");
        assertEquals(mal.get(4), "2");
        assertEquals(mal.get(5), "Place");
        assertEquals(mal.size(), 6);
    }


    @org.junit.jupiter.api.Test
    void addAllIndex() {
        mal.add("A");
        mal.add("B");
        mal.add("C");
        mal.add("D");
        mal.add("E");
        temp.add("1");
        temp.add("2");
        mal.addAll(2, temp);
        System.out.println(Arrays.toString(mal.toArray()));
        assertEquals(mal.get(0), "A");
        assertEquals(mal.get(1), "B");
        assertEquals(mal.get(2), "1");
        assertEquals(mal.get(3), "2");
        assertEquals(mal.get(4), "C");
        assertEquals(mal.get(5), "D");
        assertEquals(mal.get(6), "E");
        assertEquals(mal.size(), 7);
    }

    @org.junit.jupiter.api.Test
    void containsAll() {
        mal.add("A");
        mal.add("B");
        mal.add("C");
        mal.add("D");
        mal.add("E");
        temp.add("B");
        temp.add("D");
        assertTrue(mal.containsAll(temp));
    }

    @org.junit.jupiter.api.Test
    void size() {
    }

    @org.junit.jupiter.api.Test
    void isEmpty() {
    }

    @org.junit.jupiter.api.Test
    void containsTrue() {
        MyArrayList mal = new MyArrayList();
        mal.add("A");
        assertTrue(mal.contains("A"));
    }

    @org.junit.jupiter.api.Test
    void containsFalse() {
        mal.add("B");
        assertFalse(mal.contains("A"));
    }

    @org.junit.jupiter.api.Test
    void add() {
        mal.add("A");
        assertEquals(1, mal.size());
    }

    @org.junit.jupiter.api.Test
    void toArray2() { // sharing private issue test
        mal.add("A");
        Object[] backDoor = mal.toArray();
        backDoor[0] = "HAHHA";

        assertEquals("A", mal.get(0));
    }

    @org.junit.jupiter.api.Test
    void containsTrue2() {
        MyArrayList mal = new MyArrayList();
        mal.add("A");
        assertEquals(true, mal.contains("A"));
    }

    @org.junit.jupiter.api.Test
    void containsFalse2() {
        MyArrayList mal = new MyArrayList();
        assertEquals(false, mal.contains("A"));
    }

    @org.junit.jupiter.api.Test
    void add2() {
        MyArrayList mal = new MyArrayList();
        mal.add("A");
        assertEquals(1, mal.size());
    }

    @org.junit.jupiter.api.Test
    void toArray() {
        MyArrayList mal = new MyArrayList();
        mal.add("A");
        mal.add("B");
        mal.add("C");
        Object[] arr = mal.toArray();
        assertEquals("B", arr[1]);
    }

    @org.junit.jupiter.api.Test
    void addAtTest() {
        mal.add("A");
        mal.add("B");
        mal.add("C");
        mal.add("D");
        mal.add("E");
        mal.add("1");
        mal.add("2");
        mal.add("3");
        mal.add("4");
        mal.add("5");
        mal.add("6");
        mal.add("8");

        mal.add(5, "F");// method being tested
        assertEquals("1", mal.get(6));
    }

    @org.junit.jupiter.api.Test
    void removeTest() {
        mal.add("A");
        mal.add("B");
        mal.add("C");
        mal.remove("B");
        assertEquals("C", mal.get(1));
    }

    @org.junit.jupiter.api.Test
    void clearTest() {
        mal.add("A");
        mal.add("B");
        mal.add("C");
        mal.clear();
        assertEquals(0, mal.size());
    }

    @org.junit.jupiter.api.Test
    void indexOfTest() {
        mal.add("A");
        mal.add("B");
        mal.add("C");
        assertEquals(1, mal.indexOf("B"));
    }

    @org.junit.jupiter.api.Test
    void lastIndexTest() {
        mal.add("A");
        mal.add("B");
        mal.add("C");
        mal.add("B");
        mal.add("A");
        assertEquals(3, mal.lastIndexOf("B"));
    }

    @org.junit.jupiter.api.Test
    void getTest() {
        mal.add("A");
        mal.add("B");
        mal.add("C");
        mal.add("B");
        mal.add("A");
        assertEquals("B", mal.get(3));
    }

    @org.junit.jupiter.api.Test
    void setTest() {
        mal.add("A");
        mal.add("B");
        mal.add("C");
        mal.add("B");
        mal.add("A");
        mal.set(3, "C");
        assertEquals("C", mal.get(3));
    }

}

