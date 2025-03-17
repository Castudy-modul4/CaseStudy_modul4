package org.example.casestudymodule4_quanlycanhochungcu.repository;

import org.example.casestudymodule4_quanlycanhochungcu.entity.TinhTrangCanHo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TinhTrangCanHoRepository extends JpaRepository<TinhTrangCanHo, Integer> {
    List<TinhTrangCanHo> findAll();
}
