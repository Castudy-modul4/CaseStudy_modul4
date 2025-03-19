package org.example.casestudymodule4_quanlycanhochungcu.repository;

import org.example.casestudymodule4_quanlycanhochungcu.entity.PhanHoiKhachHang;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IPhanHoiKhachHangRepository extends JpaRepository<PhanHoiKhachHang, Integer> {
    void deleteByCanHo_MaCanHo(Integer maCanHo);
    List<PhanHoiKhachHang> findByCanHo_MaCanHo(Integer maCanHo);
}
