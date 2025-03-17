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
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int maKhachHang;

    private String tenKhachHang;
    private String CCCD;
    private String mail;
    private String sdt;
    @ManyToMany
    @JoinTable(
            name = "canho_khachhang",
            joinColumns = @JoinColumn(name = "khach_hang_id"),
            inverseJoinColumns = @JoinColumn(name = "canho_id")
    )
    private Set<CanHo> canHo;
}
