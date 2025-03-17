package org.example.casestudymodule4_quanlycanhochungcu.service;

import org.example.casestudymodule4_quanlycanhochungcu.entity.TaiKhoan;

import java.util.List;
import java.util.Optional;

public interface IServiceHieu<T> {
    List<T> findAll();
    Optional<T> findById(Long id);
    TaiKhoan save(T t);
    void deleteById(Long id);

}
