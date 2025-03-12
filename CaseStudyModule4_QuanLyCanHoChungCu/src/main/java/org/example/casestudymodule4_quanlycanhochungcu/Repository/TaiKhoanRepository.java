package org.example.casestudymodule4_quanlycanhochungcu.Repository;



import org.example.casestudymodule4_quanlycanhochungcu.entity.TaiKhoan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TaiKhoanRepository extends JpaRepository<TaiKhoan, Long> {
    Optional<TaiKhoan> findByUsername(String username);
}
