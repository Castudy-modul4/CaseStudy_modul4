package org.example.casestudymodule4_quanlycanhochungcu.repository;

import org.example.casestudymodule4_quanlycanhochungcu.entity.KhachHang;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IKhachHangRepository extends JpaRepository<KhachHang, Integer> {
    List<KhachHang> findByTenKhachHangContaining(String name);
}
