package org.example.casestudymodule4_quanlycanhochungcu.repository;



import org.example.casestudymodule4_quanlycanhochungcu.entity.TaiKhoan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface TaiKhoanRepository extends JpaRepository<TaiKhoan, Long> {
    boolean existsByUsername(String username);
}
