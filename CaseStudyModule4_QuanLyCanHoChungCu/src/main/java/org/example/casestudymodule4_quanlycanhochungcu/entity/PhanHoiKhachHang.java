package org.example.casestudymodule4_quanlycanhochungcu.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class PhanHoiKhachHang {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int maPhanHoi;

    @Column(nullable = false, length = 500)
    private String noiDungPhanHoi;

    @Temporal(TemporalType.TIMESTAMP)
    private Date ngayGuiPhanHoi;

    @ManyToOne
    @JoinColumn(name = "ma_can_ho", nullable = false)
    private CanHo canHo;

    @ManyToOne
    @JoinColumn(name = "ma_khach_hang", nullable = false)
    private KhachHang khachHang;

    @Column(nullable = false, length = 50)
    private String trangThaiPhanHoi;

    @Column(length = 100)
    private String loaiPhanHoi;

    @ManyToOne
    @JoinColumn(name = "ma_nhan_vien_xu_ly")
    private NhanVien nhanVienXuLy;

    @Temporal(TemporalType.TIMESTAMP)
    private Date ngayXuLy;

    @Column(length = 500)
    private String ghiChuXuLy;
}
