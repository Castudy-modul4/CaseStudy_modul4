package org.example.casestudymodule4_quanlycanhochungcu.service.impl;

import org.example.casestudymodule4_quanlycanhochungcu.entity.TinhTrangCanHo;
import org.example.casestudymodule4_quanlycanhochungcu.entity.TinhTrangCoSoVatChat;
import org.example.casestudymodule4_quanlycanhochungcu.repository.ITinhTrangCoSoRepo;
import org.example.casestudymodule4_quanlycanhochungcu.service.ITinhTrangCoSoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TinhTrangCoSoService implements ITinhTrangCoSoService {
@Autowired
ITinhTrangCoSoRepo repo;
    @Override
    public List<TinhTrangCoSoVatChat> getAll() {
        return repo.findAll();
    }

    @Override
    public TinhTrangCoSoVatChat getById(int id) {
        return null;
    }

    @Override
    public void add(TinhTrangCoSoVatChat tinhTrangCoSoVatChat) {

    }

    @Override
    public void update(int id, TinhTrangCoSoVatChat tinhTrangCoSoVatChat) {

    }

    @Override
    public void delete(int id) {

    }

    @Override
    public List<TinhTrangCoSoVatChat> findByMaCanHo(Integer maCanHo) {
        return List.of();
    }

    @Override
    public TinhTrangCoSoVatChat findTinhTrangCoSoVatChatById(int id) {
        return repo.findById(id).orElse(null);
    }
}
