package org.example.casestudymodule4_quanlycanhochungcu.service;

import org.example.casestudymodule4_quanlycanhochungcu.entity.KhachHang;

import java.util.List;

public interface IKhachHangService {
    List<KhachHang> findAll();
    KhachHang findById(Long id);
    void save(KhachHang khachHang);
    void delete(Long id);
}