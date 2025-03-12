package org.example.casestudymodule4_quanlycanhochungcu.Service;

import org.example.casestudymodule4_quanlycanhochungcu.entity.TaiKhoan;

import java.util.List;
import java.util.Optional;


public interface IService<T> {
    List<TaiKhoan> findAll();
    Optional<TaiKhoan> findById(Long id);
    TaiKhoan save(TaiKhoan taiKhoan);
    void deleteById(Long id);
}
