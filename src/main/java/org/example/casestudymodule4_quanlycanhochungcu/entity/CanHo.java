package org.example.casestudymodule4_quanlycanhochungcu.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    private Integer maCanHo;

    @ManyToOne
    @JoinColumn(name = "loai_can_ho_ma_loai_can_ho")
    @NotNull
    private LoaiCanHo loaiCanHo;

    @ManyToOne
    @JoinColumn(name = "tinh_trang_can_ho_ma_tinh_trang_can_ho")
    @NotNull
    private TinhTrangCanHo tinhTrangCanHo;

    private String thoiGianThue;

    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date ngayBatDauThue;

    @ManyToMany(mappedBy = "canHo")
    private Set<KhachHang> khachHangs;

    @OneToMany(mappedBy = "canHo", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PhanHoiKhachHang> danhSachPhanHoi;

    @ManyToOne
    @JoinColumn(name = "tinhTrangCoSoVatChat_id")
    @NotNull
    private TinhTrangCoSoVatChat tinhTrangCoSoVatChat;
    private boolean isDeleted;
}