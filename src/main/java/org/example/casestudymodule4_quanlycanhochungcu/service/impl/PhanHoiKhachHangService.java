package org.example.casestudymodule4_quanlycanhochungcu.service.impl;

import org.example.casestudymodule4_quanlycanhochungcu.entity.PhanHoiKhachHang;
import org.example.casestudymodule4_quanlycanhochungcu.service.ICanHoService;
import org.example.casestudymodule4_quanlycanhochungcu.service.IPhanHoiKhachHangService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class PhanHoiKhachHangService implements IPhanHoiKhachHangService {
    @Autowired
    private IPhanHoiKhachHangService phanHoiKhachHangService;
    @Override
    public List<PhanHoiKhachHang> getAll() {
        return List.of();
    }

    @Override
    public PhanHoiKhachHang getById(int id) {
        return null;
    }

    @Override
    public void add(PhanHoiKhachHang phanHoiKhachHang) {

    }

    @Override
    public void update(int id, PhanHoiKhachHang phanHoiKhachHang) {

    }

    @Override
    public void delete(int id) {
        phanHoiKhachHangService.delete(id);
    }

    @Override
    public List<PhanHoiKhachHang> findByMaCanHo(Integer maCanHo) {
        return List.of();
    }
}
