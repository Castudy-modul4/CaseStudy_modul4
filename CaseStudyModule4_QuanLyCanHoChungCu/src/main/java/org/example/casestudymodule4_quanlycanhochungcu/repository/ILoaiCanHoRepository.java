package org.example.casestudymodule4_quanlycanhochungcu.repository;

import org.example.casestudymodule4_quanlycanhochungcu.entity.LoaiCanHo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ILoaiCanHoRepository extends JpaRepository<LoaiCanHo, Integer> {

    List<LoaiCanHo> findByTenLoaiCanHoContainingIgnoreCase(String name);
}
