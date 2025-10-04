package ar.com.itec1misiones.javatemplate.service;

import java.util.List;

public interface CRUDService <T>{
    List<T> findAll();
    T findOne(Integer id);
    void create(T t);
    void update(T t);
    void delete(T t);
}
