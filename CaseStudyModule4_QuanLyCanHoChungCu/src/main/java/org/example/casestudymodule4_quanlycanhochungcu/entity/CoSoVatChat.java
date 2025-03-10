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
public class CoSoVatChat {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int maCoSoVatChat;
    private String tenCoSoVatChat;
    @ManyToOne
    @JoinColumn(name = "tinh_trang_co_so_vat_chat_ma_tinh_trang_co_so_vat_chat")
    private TinhTrangCoSoVatChat tinhTrangCoSoVatChat;
    private Date ngayBaoTriCuoi;
    private String ghiChuBaoTriCuoi;


}
