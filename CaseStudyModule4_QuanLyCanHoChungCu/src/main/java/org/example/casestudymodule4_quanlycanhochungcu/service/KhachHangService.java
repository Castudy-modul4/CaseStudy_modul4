package org.example.casestudymodule4_quanlycanhochungcu.service;

import org.example.casestudymodule4_quanlycanhochungcu.entity.CanHo;
import org.example.casestudymodule4_quanlycanhochungcu.entity.KhachHang;
import org.example.casestudymodule4_quanlycanhochungcu.repository.ICanHoRepository;
import org.example.casestudymodule4_quanlycanhochungcu.repository.IKhachHangRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class KhachHangService implements IKhachHangService {

    @Autowired
    private IKhachHangRepository khachHangRepository;

    @Autowired
    private ICanHoRepository canHoRepository;

    @Override
    public List<KhachHang> getAll() {
        return khachHangRepository.findAll();
    }

    @Override
    public void save(KhachHang khachHang) {
        khachHangRepository.save(khachHang);
    }

    @Override
    public void update(int id, KhachHang khachHang) {
        Optional<KhachHang> existingKhachHang = khachHangRepository.findById(id);
        if (existingKhachHang.isPresent()) {
            KhachHang kh = existingKhachHang.get();
            kh.setTenKhachHang(khachHang.getTenKhachHang());
            kh.setCCCD(khachHang.getCCCD());
            kh.setMail(khachHang.getMail());
            kh.setSdt(khachHang.getSdt());
            khachHangRepository.save(kh);
        }
    }

    @Override
    public void remove(int id) {
        khachHangRepository.deleteById(id);
    }

    @Override
    public KhachHang findById(int id) {
        return khachHangRepository.findById(id).orElse(null);
    }

    @Override
    public List<KhachHang> findByName(String name) {
        return khachHangRepository.findByTenKhachHangContaining(name);
    }

    @Override
    public void addCanHoToKhachHang(int khachHangId, int canHoId) {
        Optional<KhachHang> khachHangOpt = khachHangRepository.findById(khachHangId);
        Optional<CanHo> canHoOpt = canHoRepository.findById(canHoId);

        if (khachHangOpt.isPresent() && canHoOpt.isPresent()) {
            KhachHang khachHang = khachHangOpt.get();
            CanHo canHo = canHoOpt.get();

            Set<CanHo> danhSachCanHo = khachHang.getCanHo();
            danhSachCanHo.add(canHo);
            khachHang.setCanHo(danhSachCanHo);

            khachHangRepository.save(khachHang);
        }
    }
}
