package service;

import model.Book;

import java.util.List;

public interface Interface<T> {
    List<T> findAll();
    T findById(int id);
    List<T> findByName(String name);
    List<T> findListById(int id);
    void save(T t);
    void edit(int id,T t);
    void delete(int id);
}
