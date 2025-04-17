package interfaces;

import models.Dragon;

import java.util.LinkedList;

public interface Collectionable<T> {
    public void remove(T dragon);
    public void printInfo();
    public void print();
    public void clear();
    public void put(T element);
    public T search(int id);
    public LinkedList<T> getCollection();
    public void setCollection(LinkedList<T> dragons);
}
