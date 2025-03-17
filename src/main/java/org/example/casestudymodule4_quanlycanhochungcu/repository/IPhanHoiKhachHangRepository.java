package org.example.casestudymodule4_quanlycanhochungcu.repository;

import org.example.casestudymodule4_quanlycanhochungcu.entity.PhanHoiKhachHang;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPhanHoiKhachHangRepository extends JpaRepository<PhanHoiKhachHang, Integer> {
    void deleteByCanHo_MaCanHo(Integer maCanHo);
}
