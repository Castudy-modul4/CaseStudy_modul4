package org.example.casestudymodule4_quanlycanhochungcu.Service.impl;

import org.example.casestudymodule4_quanlycanhochungcu.Repository.TaiKhoanRepository;
import org.example.casestudymodule4_quanlycanhochungcu.Service.ITaiKhoanService;
import org.example.casestudymodule4_quanlycanhochungcu.entity.TaiKhoan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class TaiKhoanService implements ITaiKhoanService{
    @Autowired
    private TaiKhoanRepository taiKhoanRepository;


    @Override
    public List<TaiKhoan> findAll() {
        return taiKhoanRepository.findAll();
    }

    @Override
    public Optional<TaiKhoan> findById(Long id) {
        return taiKhoanRepository.findById(id);
    }

    @Override
    public TaiKhoan save(TaiKhoan taiKhoan) {
        return taiKhoanRepository.save(taiKhoan);
    }

    @Override
    public void deleteById(Long id) {
        taiKhoanRepository.deleteById(id);
    }
}
