package org.example.casestudymodule4_quanlycanhochungcu.service;

import org.example.casestudymodule4_quanlycanhochungcu.entity.LoaiCanHo;
import org.example.casestudymodule4_quanlycanhochungcu.repository.ILoaiCanHoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class LoaiCanHoService implements ILoaiCanHoService{
    @Autowired
    private ILoaiCanHoRepository loaiCanHoRepository;
    @Override
    public List<LoaiCanHo> getAll() {
        return loaiCanHoRepository.findAll();
    }

    @Override
    public void save(LoaiCanHo s) {
        loaiCanHoRepository.save(s);
    }

    @Override
    public void update(int id, LoaiCanHo s) {
        if (loaiCanHoRepository.existsById(id)) {
            s.setMaLoaiCanHo(id);
            loaiCanHoRepository.save(s);
        }
    }


    @Override
    public void remove(int id) {
        loaiCanHoRepository.deleteById(id);
    }

    @Override
    public LoaiCanHo findById(int id) {
        return loaiCanHoRepository.findById(id).orElse(null);
    }

    @Override
    public List<LoaiCanHo> findByName(String name) {
        return loaiCanHoRepository.findByTenLoaiCanHoContainingIgnoreCase(name);
    }
}
