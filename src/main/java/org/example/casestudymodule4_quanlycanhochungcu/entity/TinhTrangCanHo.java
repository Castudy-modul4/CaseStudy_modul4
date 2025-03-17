package org.example.casestudymodule4_quanlycanhochungcu.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class TinhTrangCanHo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int maTinhTrangCanHo;
    private String tenTinhTrangCanHo;
}
