package org.example.casestudymodule4_quanlycanhochungcu.repository;

import org.example.casestudymodule4_quanlycanhochungcu.entity.LoaiCanHo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ILoaiCanHoRepo extends JpaRepository<LoaiCanHo, Integer> {
    List<LoaiCanHo> findAll();
}
