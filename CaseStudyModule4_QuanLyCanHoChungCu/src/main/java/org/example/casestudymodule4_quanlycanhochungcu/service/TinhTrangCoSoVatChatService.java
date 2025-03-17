package org.example.casestudymodule4_quanlycanhochungcu.service;

import org.example.casestudymodule4_quanlycanhochungcu.entity.TinhTrangCoSoVatChat;
import org.example.casestudymodule4_quanlycanhochungcu.repository.ITinhTrangCoSoVatChatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TinhTrangCoSoVatChatService implements ITinhTrangCoSoVatChatService {

    @Autowired
    private ITinhTrangCoSoVatChatRepository tinhTrangRepository;

    @Override
    public List<TinhTrangCoSoVatChat> getAll() {
        return tinhTrangRepository.findAll();
    }

    @Override
    public void save(TinhTrangCoSoVatChat tinhTrang) {
        tinhTrangRepository.save(tinhTrang);
    }

    @Override
    public void update(int id, TinhTrangCoSoVatChat tinhTrang) {
        Optional<TinhTrangCoSoVatChat> existing = tinhTrangRepository.findById(id);
        if (existing.isPresent()) {
            tinhTrang.setMaTinhTrangCoSoVatChat(id);
            tinhTrangRepository.save(tinhTrang);
        }
    }

    @Override
    public void remove(int id) {
        tinhTrangRepository.deleteById(id);
    }

    @Override
    public TinhTrangCoSoVatChat findById(int id) {
        return tinhTrangRepository.findById(id).orElse(null);
    }

    @Override
    public List<TinhTrangCoSoVatChat> findByName(String name) {
        return tinhTrangRepository.findByTenTinhTrangCoSoVatChatContainingIgnoreCase(name);
    }
}
