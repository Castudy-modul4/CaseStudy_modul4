package org.example.casestudymodule4_quanlycanhochungcu.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

    @Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class KhachHang {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int maKhachHang;

    private String tenKhachHang;
    private String CCCD;
    private String mail;
    private String sdt;

    @ManyToMany
    @JoinTable(
            name = "khach_hang_can_ho",
            joinColumns = @JoinColumn(name = "ma_khach_hang"),
            inverseJoinColumns = @JoinColumn(name = "ma_can_ho")
    )
    private Set<CanHo> canHo;
}
