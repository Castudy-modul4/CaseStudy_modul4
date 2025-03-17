package org.example.casestudymodule4_quanlycanhochungcu.service;

import java.util.List;

public interface IService<T> {
List<T> getAll();
T getById(int id);
void add(T t);
void update(int id,T t);
void delete(int id);
List<T> findByMaCanHo(Integer maCanHo);
}
