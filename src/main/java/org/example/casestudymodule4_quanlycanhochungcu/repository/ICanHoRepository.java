 package org.example.casestudymodule4_quanlycanhochungcu.repository;

 import org.example.casestudymodule4_quanlycanhochungcu.entity.CanHo;
 import org.example.casestudymodule4_quanlycanhochungcu.entity.TinhTrangCoSoVatChat;
 import org.springframework.data.domain.Page;
 import org.springframework.data.domain.PageRequest;
 import org.springframework.data.domain.Pageable;
 import org.springframework.data.jpa.repository.JpaRepository;

 import java.util.List;

 public interface ICanHoRepository extends JpaRepository<CanHo, Integer>{
  List<CanHo> findAllByMaCanHo(Integer maCanHo);
  Page<CanHo> findAllByMaCanHo(Integer maCanHo, Pageable pageable);
  Page<CanHo> findAll(Pageable pageable);
  Page<CanHo> findAllByTinhTrangCoSoVatChat_MaTinhTrangCoSoVatChat(Integer maTinhTrangCoSoVatChat, Pageable pageable);
  Page<CanHo> findAllByLoaiCanHo_MaLoaiCanHo(Integer maLoaiCanHo, Pageable pageable);
  Page<CanHo> findAllByTinhTrangCoSoVatChat_MaTinhTrangCoSoVatChatAndLoaiCanHo_MaLoaiCanHo(Integer maTinhTrangCoSoVatChat, Integer maLoaiCanHo, Pageable pageable);
  Page<CanHo> findAllByTinhTrangCanHo_MaTinhTrangCanHo(Integer maTinhTrangCanHo, Pageable pageable);
  Page<CanHo> findAllByTinhTrangCanHo_MaTinhTrangCanHoAndLoaiCanHo_MaLoaiCanHo(Integer maTinhTrangCanHo, Integer maLoaiCanHo, Pageable pageable);
  Page<CanHo> findAllByTinhTrangCanHo_MaTinhTrangCanHoAndLoaiCanHo_MaLoaiCanHoAndTinhTrangCoSoVatChat_MaTinhTrangCoSoVatChat(Integer maTinhTrangCanHo, Integer maLoaiCanHo, Integer maTinhTrangCoSoVatChat, Pageable pageable);
 }
