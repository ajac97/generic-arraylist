package edu.touro.cs;

import java.util.*;


// generics - create flexible data structures for many types that are TYPE SAFE
public class MyGenericArrayList<T> implements List<T> // T is called a type parameter... a placeholder,
        // for the type argument specified when instantiate a MyGenericArrayList<String>
        // String is the type argument
{
    private T[] backingStore;
    private int insertionPoint = 0;

    public MyGenericArrayList() {
        this(10);
    }

    public MyGenericArrayList(int initialCapacity) {
        backingStore = (T[]) new Object[initialCapacity];
    }

    @Override
    public int size() {
        return insertionPoint;
    }

    public void ensureCapacity(int minCapacity) {
        if (backingStore.length < minCapacity) {
            T[] newBackingStore = (T[]) new Object[minCapacity];
            System.arraycopy(backingStore, 0, newBackingStore, 0, size());
            backingStore = newBackingStore;
        }
    }

    private void checkBoundaries(int index) {
        if (index >= size() || index < 0) {
            throw new IndexOutOfBoundsException("The index provided is out of the bounds of the ArrayList");
        }
    }

    private void checkNull(Collection<?> c) {
        for (Object o : c) {
            if (o == null) {
                throw new NullPointerException("The values in the collection cannot be null");
            }
        }
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

    @Override
    public Iterator<T> iterator() {
        return null;
    }

    private class MyGenericArrayListIterator implements Iterator<T> {
        int current = -1;
        boolean nextWasCalled, removeWasCalled;

        @Override
        public boolean hasNext() {
            return current + 1 < size();
        }

        @Override
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException("There is no next element in this ArrayList");
            }
            nextWasCalled = true;
            removeWasCalled = false;
            return (T) backingStore[++current];
        }

        @Override
        public void remove() {
            if (!nextWasCalled) {
                throw new IllegalStateException("Cannot call remove unless next called first");
            }
            if (removeWasCalled) {
                throw new IllegalStateException("Cannot call remove twice unless next was called first");
            }
            removeWasCalled = true;
            MyGenericArrayList.this.remove(current--);
        }
    }

    @Override
    public Object[] toArray() {
        T[] temp = (T[]) new Object[size()];
        if (size() == 0) {
            return temp;
        }
        System.arraycopy(backingStore, 0, temp, 0, size());
        return temp;
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return null;
    }

    @Override
    public boolean add(T t) {
        if (insertionPoint >= backingStore.length) {
            growBackingStore();
        }
        backingStore[insertionPoint] = t;
        insertionPoint++;
        return true;
    }

    private void growBackingStore() // new array will be twice size old array
    {
        T[] newBackingStore = (T[]) new Object[backingStore.length * 2 + 1];
        System.arraycopy(backingStore, 0, newBackingStore, 0, backingStore.length);
        backingStore = newBackingStore;
    }

    @Override
    public boolean remove(Object o) {
        for (int i = 0; i < size(); i++) {
            if (backingStore[i].equals(o)) {
                System.arraycopy(backingStore, i + 1, backingStore, i, (size() - 1) - i);
                insertionPoint--;
                return true;
            }
        }
        return false;
    }


    @Override
    public boolean containsAll(Collection<?> c) {
        checkNull(c);
        if (c.isEmpty()) {
            return true;
        }
        for (Object o : c) {
            if (!contains(o)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        if (c.isEmpty()) {
            return false;
        }
        checkNull(c);
        ensureCapacity(size() + c.size());
        T[] temp = (T[]) new Object[size() + c.size()];
        Object[] cToArr = c.toArray();
        System.arraycopy(backingStore, 0, temp, 0, size());
        System.arraycopy(cToArr, 0, temp, size(), c.size());
        System.arraycopy(temp, 0, backingStore, 0, temp.length);
        insertionPoint += c.size();
        return true;

    }

    @Override
    public boolean addAll(int index, Collection<? extends T> c) {
        checkBoundaries(index);
        checkNull(c);
        if (c.isEmpty()) {
            return false;
        }
        ensureCapacity(backingStore.length + c.size());
        T[] temp = (T[]) new Object[size() + c.size()];
        Object[] cToArr = c.toArray();
        System.arraycopy(backingStore, 0, temp, 0, index);
        System.arraycopy(cToArr, 0, temp, index, c.size());
        if (size() >= index) {
            System.arraycopy(backingStore, index, temp, index + c.size(), size() - index);
        }
        System.arraycopy(temp, 0, backingStore, 0, temp.length);
        insertionPoint += c.size();
        return true;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        checkNull(c);
        boolean modified = false;
        if (c.isEmpty()) {
            return false;
        }
        for (Object o : c) {
            for (int i = 0; i < backingStore.length; i++) {
                if (o.equals(backingStore[i])) {
                    remove(i--);
                    modified = true;
                }
            }
        }
        return modified;
    }

    @Override
    public boolean retainAll(Collection<?> collection) {
        checkNull(collection);
        if (collection.isEmpty()) {
            return false;
        }
        boolean modified = false;
        for (int i = 0; i < size(); i++) {
            if (!collection.contains(backingStore[i])) {
                remove(i--);
                modified = true;
            }
        }
        return modified;
    }

    @Override
    public void clear() {
        backingStore = (T[]) new Object[10];
        insertionPoint = 0;
    }

    @Override
    public T get(int index) {
        checkBoundaries(index);
        return backingStore[index];
    }

    @Override
    public T set(int index, T element) {
        checkBoundaries(index);
        T previous = backingStore[index];
        backingStore[index] = element;
        return previous;
    }


    @Override
    public void add(int index, T element) {
        checkBoundaries(index);
        if (insertionPoint >= backingStore.length) {
            growBackingStore();
        }
        T[] temp = (T[]) new Object[size() + 1];
        System.arraycopy(backingStore, 0, temp, 0, index);
        temp[index] = element;
        if (size() > index) {
            System.arraycopy(backingStore, index, temp, index + 1, 2);
        }
        System.arraycopy(temp, 0, backingStore, 0, temp.length);
        insertionPoint++;
    }

    @Override
    public T remove(int index) {
        checkBoundaries(index);
        T previous = backingStore[index];
        System.arraycopy(backingStore, index + 1, backingStore, index, (size() - 1) - index);
        insertionPoint--;
        return previous;
    }

    @Override
    public int indexOf(Object o) {
        for (int i = 0; i < size(); i++) {
            if (backingStore[i].equals(o)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        for (int i = size() - 1; i >= 0; i--) {
            if (backingStore[i].equals(o)) {
                return i;
            }
        }
        return -1;
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
