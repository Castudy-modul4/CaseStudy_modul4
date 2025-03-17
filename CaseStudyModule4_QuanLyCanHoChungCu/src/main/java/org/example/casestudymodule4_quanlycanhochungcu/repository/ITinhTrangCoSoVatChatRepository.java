package org.example.casestudymodule4_quanlycanhochungcu.repository;

import org.example.casestudymodule4_quanlycanhochungcu.entity.TinhTrangCoSoVatChat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ITinhTrangCoSoVatChatRepository extends JpaRepository<TinhTrangCoSoVatChat, Integer> {
    List<TinhTrangCoSoVatChat> findByTenTinhTrangCoSoVatChatContainingIgnoreCase(String name);
}
