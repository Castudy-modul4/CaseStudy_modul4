package org.example.casestudymodule4_quanlycanhochungcu.service.impl;

import jakarta.persistence.EntityNotFoundException;
import org.example.casestudymodule4_quanlycanhochungcu.entity.CanHo;
import org.example.casestudymodule4_quanlycanhochungcu.repository.ICanHoRepository;
import org.example.casestudymodule4_quanlycanhochungcu.repository.IKhachHangRepository;
import org.example.casestudymodule4_quanlycanhochungcu.repository.IPhanHoiKhachHangRepository;
import org.example.casestudymodule4_quanlycanhochungcu.service.ICanHoService;
import org.example.casestudymodule4_quanlycanhochungcu.service.IPhanHoiKhachHangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class CanHoService implements ICanHoService {
@Autowired
private ICanHoRepository repository;
@Autowired
private IPhanHoiKhachHangRepository phanHoiKhachHangService;
@Autowired
private IKhachHangRepository khachHangService;
    @Override
    public List<CanHo> getAll() {
        List<CanHo> list = repository.findAll();
        return list;
    }

    @Override
    public CanHo getById(int id) {
        return null;
    }

    @Override
    public void add(CanHo canHo) {
        if (repository.existsById(canHo.getMaCanHo())) {
            throw new IllegalArgumentException("Mã căn hộ đã tồn tại.");
        }
        canHo.setVersion(0);
        repository.save(canHo);
    }

    @Override
    public void update(int id, CanHo updatedCanHo) {
        CanHo existingCanHo = repository.findById(id).orElseThrow(() ->
                new EntityNotFoundException("Không tìm thấy căn hộ với ID: " + id)
        );

        existingCanHo.setLoaiCanHo(updatedCanHo.getLoaiCanHo());
        existingCanHo.setTinhTrangCoSoVatChat(updatedCanHo.getTinhTrangCoSoVatChat());
        existingCanHo.setThoiGianThue(updatedCanHo.getThoiGianThue());
        existingCanHo.setNgayBatDauThue(updatedCanHo.getNgayBatDauThue());

        repository.save(existingCanHo);
    }


    @Override
    @Transactional
    public void delete(int maCanHo) {
        phanHoiKhachHangService.deleteByCanHo_MaCanHo(maCanHo);
        khachHangService.deleteByCanHo_MaCanHo(maCanHo);
       repository.deleteById(maCanHo);
    }
    @Override
    public List<CanHo> findByMaCanHo(Integer maCanHoId) {
        return repository.findAllByMaCanHo(maCanHoId);
    }

    @Override
    public List<CanHo> getAllDTO() {
        return null;
    }

    @Override
    public Page<CanHo> findALl(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public Page<CanHo> findAllByMaCanHo(Integer maCanHo, Pageable pageable) {
        return repository.findAllByMaCanHo(maCanHo, pageable);
    }

    @Override
    public Page<CanHo> findAllByTinhTrangCoSoVatChat(Integer maTinhTrangCoSoVatChat, Pageable pageable) {
        return repository.findAllByTinhTrangCoSoVatChat_MaTinhTrangCoSoVatChat(maTinhTrangCoSoVatChat, pageable);
    }

    @Override
    public Page<CanHo> findAllByLoaiCanHo(Integer maLoaiCanHo, Pageable pageable) {
        return repository.findAllByLoaiCanHo_MaLoaiCanHo(maLoaiCanHo, pageable);
    }

    @Override
    public Page<CanHo> findAllByTinhTrangCoSoVatChatAndLoaiCanHo(Integer maTinhTrangCoSoVatChat, Integer maLoaiCanHo, Pageable pageable) {
        return repository.findAllByTinhTrangCoSoVatChat_MaTinhTrangCoSoVatChatAndLoaiCanHo_MaLoaiCanHo(maTinhTrangCoSoVatChat, maLoaiCanHo, pageable);
    }

    @Override
    public Page<CanHo> getAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public Page<CanHo> findAllByTinhTrangCanHo1(Integer maTinhTrangCanHo, Pageable pageable) {
        return repository.findAllByTinhTrangCanHo_MaTinhTrangCanHo(maTinhTrangCanHo, pageable);
    }

    @Override
    public Page<CanHo> findAllByTinhTrangCanHoAndLoaiCanHo1(Integer maTinhTrangCanHo, Integer maLoaiCanHo, Pageable pageable) {
        return repository.findAllByTinhTrangCanHo_MaTinhTrangCanHoAndLoaiCanHo_MaLoaiCanHo(maTinhTrangCanHo, maLoaiCanHo, pageable);
    }

    @Override
    public Page<CanHo> findAllByTinhTrangCanHoAndLoaiCanHoAndTinhTrangCoSoVatChat1(Integer maTinhTrangCanHo, Integer maLoaiCanHo, Integer maTinhTrangCoSoVatChat, Pageable pageable) {
        return repository.findAllByTinhTrangCanHo_MaTinhTrangCanHoAndLoaiCanHo_MaLoaiCanHoAndTinhTrangCoSoVatChat_MaTinhTrangCoSoVatChat(maTinhTrangCanHo, maLoaiCanHo, maLoaiCanHo, pageable);
    }
}
