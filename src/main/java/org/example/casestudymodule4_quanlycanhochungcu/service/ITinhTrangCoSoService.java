package org.example.casestudymodule4_quanlycanhochungcu.service;

import org.example.casestudymodule4_quanlycanhochungcu.entity.TinhTrangCanHo;
import org.example.casestudymodule4_quanlycanhochungcu.entity.TinhTrangCoSoVatChat;

import java.util.List;

public interface ITinhTrangCoSoService extends IService<TinhTrangCoSoVatChat> {
  TinhTrangCoSoVatChat findTinhTrangCoSoVatChatById(int id);
}
