package org.example.casestudymodule4_quanlycanhochungcu.service;

import java.util.List;

public interface IServiceTin<T> {
    List<T> getAll();

    void save(T s);

    void update(int id, T s);

    void remove(int id);

    T findById(int id);

    List<T> findByName(String name);
}
