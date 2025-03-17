package org.example.casestudymodule4_quanlycanhochungcu.service;

import org.example.casestudymodule4_quanlycanhochungcu.entity.KhachHang;
import org.springframework.stereotype.Service;

@Service
public interface IKhachHangService extends IServiceTin<KhachHang>{
    void addCanHoToKhachHang(int khachHangId, int canHoId);
}
