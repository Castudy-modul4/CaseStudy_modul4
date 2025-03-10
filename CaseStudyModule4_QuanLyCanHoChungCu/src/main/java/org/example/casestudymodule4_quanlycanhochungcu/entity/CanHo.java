package org.example.casestudymodule4_quanlycanhochungcu.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CanHo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int maCanHo;

    @ManyToOne
    @JoinColumn(name = "loai_can_ho_ma_loai_can_ho")
    private LoaiCanHo loaiCanHo;

    @ManyToOne
    @JoinColumn(name = "tinh_trang_can_ho_ma_tinh_trang_can_ho")
    private TinhTrangCanHo tinhTrangCanHo;

    private String thoiGianThue;
    private Date ngayBatDauThue;


    @ManyToMany(mappedBy = "canHo")
    private Set<KhachHang> khachHangs;

    @OneToMany(mappedBy = "canHo", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PhanHoiKhachHang> danhSachPhanHoi;
}
