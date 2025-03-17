package org.example.casestudymodule4_quanlycanhochungcu.dto;

import org.example.casestudymodule4_quanlycanhochungcu.entity.LoaiCanHo;
import org.example.casestudymodule4_quanlycanhochungcu.entity.PhanHoiKhachHang;
import org.example.casestudymodule4_quanlycanhochungcu.entity.TinhTrangCanHo;

import java.util.Date;
import java.util.List;

public class CanHoDTO {
    private int maCanHo;
    private LoaiCanHo loaiCanHo;
    private TinhTrangCanHo tinhTrangCanHo;
    private String thoiGianThue;
    private Date ngayBatDauThue;
    private List<PhanHoiKhachHang> danhSachPhanHoi;
  public CanHoDTO() {

  }

    public int getMaCanHo() {
        return maCanHo;
    }

    public void setMaCanHo(int maCanHo) {
        this.maCanHo = maCanHo;
    }

    public LoaiCanHo getLoaiCanHo() {
        return loaiCanHo;
    }

    public void setLoaiCanHo(LoaiCanHo loaiCanHo) {
        this.loaiCanHo = loaiCanHo;
    }

    public TinhTrangCanHo getTinhTrangCanHo() {
        return tinhTrangCanHo;
    }

    public void setTinhTrangCanHo(TinhTrangCanHo tinhTrangCanHo) {
        this.tinhTrangCanHo = tinhTrangCanHo;
    }

    public String getThoiGianThue() {
        return thoiGianThue;
    }

    public void setThoiGianThue(String thoiGianThue) {
        this.thoiGianThue = thoiGianThue;
    }

    public Date getNgayBatDauThue() {
        return ngayBatDauThue;
    }

    public void setNgayBatDauThue(Date ngayBatDauThue) {
        this.ngayBatDauThue = ngayBatDauThue;
    }

    public List<PhanHoiKhachHang> getDanhSachPhanHoi() {
        return danhSachPhanHoi;
    }

    public void setDanhSachPhanHoi(List<PhanHoiKhachHang> danhSachPhanHoi) {
        this.danhSachPhanHoi = danhSachPhanHoi;
    }
}
