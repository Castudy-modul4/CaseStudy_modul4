package org.example.casestudymodule4_quanlycanhochungcu.repository;

import org.example.casestudymodule4_quanlycanhochungcu.entity.TinhTrangCoSoVatChat;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ITinhTrangCoSoRepo extends JpaRepository<TinhTrangCoSoVatChat, Integer> {
    List<TinhTrangCoSoVatChat> findAll();
}
