package org.example.casestudymodule4_quanlycanhochungcu.service.impl;

import org.example.casestudymodule4_quanlycanhochungcu.entity.PhanHoiKhachHang;
import org.example.casestudymodule4_quanlycanhochungcu.repository.IPhanHoiKhachHangRepository;
import org.example.casestudymodule4_quanlycanhochungcu.service.ICanHoService;
import org.example.casestudymodule4_quanlycanhochungcu.service.IPhanHoiKhachHangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PhanHoiKhachHangService implements IPhanHoiKhachHangService {
    @Autowired
    private IPhanHoiKhachHangRepository phanHoiKhachHangService;
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
        phanHoiKhachHangService.deleteById(id);
    }

    @Override
    public List<PhanHoiKhachHang> findByMaCanHo(Integer maCanHo) {
        return List.of();
    }
}
