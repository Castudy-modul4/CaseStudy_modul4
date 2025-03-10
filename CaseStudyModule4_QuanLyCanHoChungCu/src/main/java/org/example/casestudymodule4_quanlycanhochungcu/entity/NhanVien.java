package org.example.casestudymodule4_quanlycanhochungcu.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class NhanVien {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int maNhanVien;
    private String tenNhanVien;
    private String CCCD;
    private String mail;
    private String sdt;
    @ManyToOne
    @JoinColumn(name = "chuc_vu_ma_chuc_vu")
    private ChucVu chucVu;
    private double luong;
}
