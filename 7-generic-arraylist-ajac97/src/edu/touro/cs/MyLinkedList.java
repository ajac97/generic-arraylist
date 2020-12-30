package edu.touro.cs;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

//public                        // U RO A R
//protected
//package private -  default
//private

class Node<T>
{
    T data;
    Node<T> prev, next;

    public Node(){}
    public Node(T t, Node<T> prev, Node<T> next) {
        data= t;
        this.prev = prev;
        this.next = next;
    }
}

public class MyLinkedList<T> implements List<T> {
    private Node<T> head, tail;
    private int size;

    public MyLinkedList()
    {
        head = tail = new Node<>();
    }
    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override //TODO
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public Iterator<T> iterator() {
        return new MyLinkedListIterator();
    }

    private class MyLinkedListIterator implements Iterator<T>{//TODO

        private Node<T> prevPtr = head;

        @Override
        public boolean hasNext() {
            return prevPtr.next != null;
        }

        @Override
        public T next() { // returns next data elt, and updates the ptr
            return null;
        }

        public void remove(){  //TODO

        }
    }
    @Override//TODO
    public Object[] toArray() {
        return new Object[0];
    }

    @Override//TODO
    public <T1> T1[] toArray(T1[] a) {
        return null;
    }

    @Override//TODO
    public boolean add(T t /* implicitly passes the this reference*/) {
        Node<T> newNode = new Node<>(t, tail, null);

        tail.next = newNode; // old last node point to new Node
        tail = newNode; // or tail = newNode // tail point to new Node

        size++;
        return true;
    }

    @Override//TODO
    public boolean remove(Object o) {
        return false;
    }

    @Override//TODO
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override//TODO
    public boolean addAll(Collection<? extends T> c) {
        return false;
    }

    @Override//TODO
    public boolean addAll(int index, Collection<? extends T> c) {
        return false;
    }

    @Override//TODO
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override//TODO
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override//TODO
    public void clear() {
        head = tail = null; // disconnected nodes will be garbage collected
        size = 0;
    }
// remove
// static inner class
// iterator

    @Override//TODO
    public T get(int index) {
        // size check

        Node<T> currentNode = head;
        for (int counter = 0; counter <= index; currentNode = currentNode.next, counter++ )
            ; // BLANK
        return currentNode.data;
    }

    @Override//TODO
    public T set(int index, T element) {
        return null;
    }

    @Override//TODO
    public void add(int index, T element) {

    }

    @Override//TODO
    public T remove(int index) {
        // index bounds check >=0 and < size

        Node<T> previousNode = head;
        for (int counter = 0; counter < index; previousNode = previousNode.next, counter++)
            ; // BLANK
        T oldValue = previousNode.next.data;
        previousNode.next = previousNode.next.next;
        if (index == size-1)
        {
            tail = tail.prev;
        }
        size--;
        return oldValue;

    }

    @Override //TODO
    public int indexOf(Object o) {
        return 0;
    }

    @Override//TODO
    public int lastIndexOf(Object o) {
        return 0;
    }

    @Override
    public ListIterator<T> listIterator() {
        return null;
    }

    @Override
    public ListIterator<T> listIterator(int index) {
        return null;
    }

    @Override
    public List<T> subList(int fromIndex, int toIndex) {
        return null;
    }
}
