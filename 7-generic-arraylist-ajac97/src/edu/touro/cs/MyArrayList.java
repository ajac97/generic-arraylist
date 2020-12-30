package edu.touro.cs;

import java.util.*;

// Reuse existing code wherever efficient
public class MyArrayList implements List<String> {
    public MyArrayList(){
        this(10);
    }

    public MyArrayList(int initialCapacity)
    {
        backingStore = new String[initialCapacity];
        // 100 lines
    }
    // OOP : Reuse code (as long as its efficient)
    //     : Encapsulation: hide implementation/ private fields
    private String[] backingStore;
    private int insertionPoint = 0;

    @Override
    public int size() {
        return insertionPoint;
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public boolean contains(Object o) {
        for (int i = 0; i < size(); i++) {
            if (o == null && backingStore[i] == null ||
                    o != null && o.equals(backingStore[i]))
                return true;
        }
        return false;
    }

    public class MyArrayListIterator implements Iterator<String> { // INNER CLASS
        // a class declared within another class
        // access memebrs of the enclosing OUTER class
        private int beforeIndex = 0; // field = instance variable

        @Override
        public boolean hasNext() {
            return beforeIndex < size();
        }

        @Override
        public String next() {
            String s =  MyArrayList.this.backingStore[beforeIndex];
            ++beforeIndex;
            return s;
            //
            //  return backingStore[beforeIndex++];
        }
    }

    //  | A | B | C |
    @Override
    public Iterator<String> iterator() {
        return new MyArrayListIterator();
    }

    @Override
    public Object[] toArray() { // TODO
        return backingStore; // never share your privates
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return null;
    }

    @Override // avg speed complxity
    public boolean add(String s) { // adds to tail of list. Avg efficiency is amortized constant time
        if (insertionPoint >= backingStore.length) {
            growBackingStore(); // O(n) - linear time
        }
        backingStore[insertionPoint++] = s; // O(1) - constant time
        return true;
    }

    private void growBackingStore() // new array will be twice size old array
    {
        String[] newBackingStore = new String[backingStore.length * 2 + 1];
        System.arraycopy(backingStore, 0, newBackingStore, 0, backingStore.length);
        backingStore = newBackingStore;
    }

    @Override
    public boolean remove(Object o) {// TODO
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) { // TODO
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends String> c) {// TODO
        if (c == null)
            throw new NullPointerException("Collection may not be null");
        if (c.isEmpty())
            return false;
        // if size doesnt fit into current capacity,
        // increase size of backing store and copy elts from collection into backingStore
        for (String s: c) {
            add(s); // may involve multiple grow() operations
        }
        return true;
    }

    @Override // TODO
    public boolean addAll(int index, Collection<? extends String> c) {
        nullCheck(c, "Collection c");
        return false;
    }

    private void nullCheck(Object o, String msg) {
        if (o == null)
            throw new NullPointerException(msg + " may not be null");
    }

    @Override // TODO
    public boolean removeAll(Collection<?> c) {
        return false;
    }
    // A B C D E F removeALL(D A) => B C E F
    // LOOK UP API long documentation

    @Override // TODO
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {
        insertionPoint = 0;

        for (int i=0;i<size();i++)
            backingStore[i]=null; // important to set to null
        // OR
        backingStore = new String[10];
    }

    @Override
    public String get(int index) {
        // TODO exception details
        if (index >= size())
            throw new IndexOutOfBoundsException(String.format("details of exception"));
        return backingStore[index];
    }

    @Override
    public String set(int index, String element) {// TODO
        return null;
    } // TODO

    @Override
    public void add(int index, String element) {// may require up to n shifts O(n) worst case

    }



    @Override
    public String remove(int index) {
        return null;
    } // TODO

    @Override
    public int indexOf(Object o) { // TODO
        return 0;
    } // TODO

    @Override
    public int lastIndexOf(Object o) { // TODO
        return 0;
    } // TODO

    @Override
    public ListIterator<String> listIterator() {
        return null;
    }

    @Override
    public ListIterator<String> listIterator(int index) {
        return null;
    }

    @Override
    public List<String> subList(int fromIndex, int toIndex) {
        return null;
    }


}
