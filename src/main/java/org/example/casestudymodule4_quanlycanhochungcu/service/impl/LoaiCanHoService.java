package org.example.casestudymodule4_quanlycanhochungcu.service.impl;

import org.example.casestudymodule4_quanlycanhochungcu.entity.LoaiCanHo;
import org.example.casestudymodule4_quanlycanhochungcu.entity.TinhTrangCanHo;
import org.example.casestudymodule4_quanlycanhochungcu.repository.ILoaiCanHoRepo;
import org.example.casestudymodule4_quanlycanhochungcu.service.ILoaiCanHoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoaiCanHoService implements ILoaiCanHoService {
    @Autowired
    ILoaiCanHoRepo repo;

    @Override
    public List<LoaiCanHo> getAll() {
        return repo.findAll();
    }

    @Override
    public LoaiCanHo getById(int id) {
        return null;
    }

    @Override
    public void add(LoaiCanHo loaiCanHo) {

    }

    @Override
    public void update(int id, LoaiCanHo loaiCanHo) {

    }

    @Override
    public void delete(int id) {

    }

    @Override
    public List<LoaiCanHo> findByMaCanHo(Integer maCanHo) {
        return List.of();
    }

    @Override
    public LoaiCanHo findLoaiCanHoById(int id) {
        return repo.findById(id).orElse(null);
    }
}
