package ru.itis;

public interface List extends Collection {
    Object get(int index);
    void addToBegin(Object object);
}