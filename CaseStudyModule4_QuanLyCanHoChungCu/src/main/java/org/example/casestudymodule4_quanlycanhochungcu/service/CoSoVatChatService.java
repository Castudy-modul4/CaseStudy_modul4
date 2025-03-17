package org.example.casestudymodule4_quanlycanhochungcu.service;

import org.example.casestudymodule4_quanlycanhochungcu.entity.CoSoVatChat;
import org.example.casestudymodule4_quanlycanhochungcu.repository.ICoSoVatChatRepositoty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CoSoVatChatService implements ICoSoVatChatService {

    @Autowired
    private ICoSoVatChatRepositoty coSoVatChatRepository;

    @Override
    public List<CoSoVatChat> getAll() {
        return coSoVatChatRepository.findAll();
    }

    @Override
    public void save(CoSoVatChat coSoVatChat) {
        coSoVatChatRepository.save(coSoVatChat);
    }

    @Override
    public void update(int id, CoSoVatChat coSoVatChat) {
        Optional<CoSoVatChat> existing = coSoVatChatRepository.findById(id);
        if (existing.isPresent()) {
            coSoVatChat.setMaCoSoVatChat(id);
            coSoVatChatRepository.save(coSoVatChat);
        }
    }

    @Override
    public void remove(int id) {
        coSoVatChatRepository.deleteById(id);
    }

    @Override
    public CoSoVatChat findById(int id) {
        return coSoVatChatRepository.findById(id).orElse(null);
    }

    @Override
    public List<CoSoVatChat> findByName(String name) {
        return coSoVatChatRepository.findByTenCoSoVatChatContainingIgnoreCase(name);
    }
}