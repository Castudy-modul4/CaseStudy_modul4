package org.example.casestudymodule4_quanlycanhochungcu.service;

import org.example.casestudymodule4_quanlycanhochungcu.entity.LoaiCanHo;
import org.example.casestudymodule4_quanlycanhochungcu.entity.TinhTrangCanHo;

import java.util.List;

public interface ILoaiCanHoService extends IService<LoaiCanHo> {
    LoaiCanHo findLoaiCanHoById(int id);
}
