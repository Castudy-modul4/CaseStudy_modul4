package org.example.casestudymodule4_quanlycanhochungcu.service;

import org.example.casestudymodule4_quanlycanhochungcu.entity.CanHo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ICanHoService extends IService<CanHo> {
  List<CanHo> getAllDTO();
  Page<CanHo> findALl(Pageable pageable);
  Page<CanHo> findAllByMaCanHo(Integer maCanHo, Pageable pageable);
  Page<CanHo> findAllByLoaiCanHo(Integer maLoaiCanHo, Pageable pageable);
  Page<CanHo> findAllByTinhTrangCanHo1(Integer maTinhTrangCanHo, Pageable pageable);
  Page<CanHo> findAllByTinhTrangCoSoVatChat(Integer maTinhTrangCoSoVatChat, Pageable pageable);
  Page<CanHo> findAllByTinhTrangCoSoVatChatAndLoaiCanHo(Integer maTinhTrangCoSoVatChat, Integer maLoaiCanHo, Pageable pageable);
  Page<CanHo> findAllByTinhTrangCanHoAndLoaiCanHo1(Integer maTinhTrangCanHo, Integer maLoaiCanHo, Pageable pageable);
  Page<CanHo> findAllByTinhTrangCanHoAndLoaiCanHoAndTinhTrangCoSoVatChat1(Integer maTinhTrangCanHo, Integer maLoaiCanHo, Integer maTinhTrangCoSoVatChat, Pageable pageable);
  Page<CanHo> getAll(Pageable pageable);
  List<CanHo> getAllDeleted();
  Page<CanHo> findAllDeleted(Pageable pageable);
  void restore(int maCanHo);
}

