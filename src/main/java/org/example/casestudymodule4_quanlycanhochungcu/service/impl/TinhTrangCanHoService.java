package org.example.casestudymodule4_quanlycanhochungcu.service.impl;

import org.example.casestudymodule4_quanlycanhochungcu.entity.TinhTrangCanHo;
import org.example.casestudymodule4_quanlycanhochungcu.repository.ITinhTrangCoSoRepo;
import org.example.casestudymodule4_quanlycanhochungcu.repository.TinhTrangCanHoRepository;
import org.example.casestudymodule4_quanlycanhochungcu.service.ITinhTrangCanHoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TinhTrangCanHoService implements ITinhTrangCanHoService {
    @Autowired
    TinhTrangCanHoRepository tinhTrangCoSoRepo;
    @Override
    public List<TinhTrangCanHo> getAll() {
        return tinhTrangCoSoRepo.findAll();
    }

    @Override
    public TinhTrangCanHo getById(int id) {
        return null;
    }

    @Override
    public void add(TinhTrangCanHo tinhTrangCanHo) {

    }

    @Override
    public void update(int id, TinhTrangCanHo tinhTrangCanHo) {

    }

    @Override
    public void delete(int id) {

    }

    @Override
    public List<TinhTrangCanHo> findByMaCanHo(Integer maCanHo) {
        return List.of();
    }
}
