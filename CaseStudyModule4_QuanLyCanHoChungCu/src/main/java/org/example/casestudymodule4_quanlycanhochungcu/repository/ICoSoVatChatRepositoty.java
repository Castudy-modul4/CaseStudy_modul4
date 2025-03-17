package org.example.casestudymodule4_quanlycanhochungcu.repository;

import org.example.casestudymodule4_quanlycanhochungcu.entity.CoSoVatChat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ICoSoVatChatRepositoty extends JpaRepository<CoSoVatChat, Integer> {
    List<CoSoVatChat> findByTenCoSoVatChatContainingIgnoreCase(String name);
}
