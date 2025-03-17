package org.example.casestudymodule4_quanlycanhochungcu.controller;

import org.example.casestudymodule4_quanlycanhochungcu.entity.CanHo;
import org.example.casestudymodule4_quanlycanhochungcu.entity.LoaiCanHo;
import org.example.casestudymodule4_quanlycanhochungcu.entity.TinhTrangCanHo;
import org.example.casestudymodule4_quanlycanhochungcu.entity.TinhTrangCoSoVatChat;
import org.example.casestudymodule4_quanlycanhochungcu.service.ICanHoService;
import org.example.casestudymodule4_quanlycanhochungcu.service.ILoaiCanHoService;
import org.example.casestudymodule4_quanlycanhochungcu.service.ITinhTrangCoSoService;
import org.example.casestudymodule4_quanlycanhochungcu.service.impl.CanHoService;
import org.example.casestudymodule4_quanlycanhochungcu.service.impl.TinhTrangCanHoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/CanHo")
public class CanHoController {

    @Autowired
    private ICanHoService canHoService;
    @Autowired
    private ILoaiCanHoService loaiCanHoService;
    @Autowired
    private ITinhTrangCoSoService tinhTrangCoSoService;
    @Autowired
    private TinhTrangCanHoService tinhTrangCanHoService;

    @GetMapping("/list")

    public String showList(Model model,
                           @RequestParam(value="tinhTrangCanHo",required = false) Integer maTinhTrangCanHo,

                           @RequestParam(value = "name", required = false) Integer maCanHo,

                           @RequestParam(value = "loaiCanHo", required = false) Integer loaiCanHo,

                           @RequestParam(value = "tinhTrangCoSoVatChat", required = false) Integer maTinhTrangCoSoVatChat,

                           @RequestParam(name = "page", defaultValue = "0") int page) {
        Page<CanHo> canHos;
        PageRequest pageable = PageRequest.of(page, 5);
        if (maCanHo != null) {
            canHos = canHoService.findAllByMaCanHo(maCanHo, pageable);
        } else if (loaiCanHo != null && maTinhTrangCoSoVatChat != null) {
            canHos = canHoService.findAllByTinhTrangCoSoVatChatAndLoaiCanHo(maTinhTrangCoSoVatChat, loaiCanHo, pageable);
        } else if (loaiCanHo != null) {
            canHos = canHoService.findAllByLoaiCanHo(loaiCanHo, pageable);
        } else if (maTinhTrangCoSoVatChat != null) {
            canHos = canHoService.findAllByTinhTrangCoSoVatChat(maTinhTrangCoSoVatChat, pageable);
        } else if (maTinhTrangCanHo != null) {
            canHos = canHoService.findAllByTinhTrangCanHo1(maTinhTrangCanHo, pageable);
        } else if (maTinhTrangCanHo != null && loaiCanHo != null) {
            canHos = canHoService.findAllByTinhTrangCanHoAndLoaiCanHo1(maTinhTrangCanHo, loaiCanHo, pageable);
        } else if (maTinhTrangCanHo != null && loaiCanHo != null && maTinhTrangCoSoVatChat != null) {
            canHos = canHoService.findAllByTinhTrangCanHoAndLoaiCanHoAndTinhTrangCoSoVatChat1(maTinhTrangCanHo, loaiCanHo, maTinhTrangCoSoVatChat, pageable);
        } else {
            canHos=canHoService.findALl(pageable);
        }


        model.addAttribute("canHos", canHos);
        model.addAttribute("loaiCanHos", loaiCanHoService.getAll());
        model.addAttribute("tinhTrangCoSoVatChats", tinhTrangCoSoService.getAll());
        model.addAttribute("tinhTrangCanHos", tinhTrangCanHoService.getAll());
        model.addAttribute("name", maCanHo);
        model.addAttribute("loaiCanHo", loaiCanHo);
        model.addAttribute("tinhTrangCoSoVatChat", maTinhTrangCoSoVatChat);
        model.addAttribute("tinhTrangCanHo", maTinhTrangCanHo);
        return "list";
    }
    @GetMapping("/create")
    public String showCreate(Model model) {
         model.addAttribute("CanHo", new CanHo());
         model.addAttribute("loaiCanHos",loaiCanHoService.getAll());
         model.addAttribute("tinhTrangCoSo",tinhTrangCoSoService.getAll());
         return "create";
    }
    @PostMapping("/create")
    public String createCanHo(@ModelAttribute CanHo canHo,
                              @RequestParam("tinhTrangCoSoVatChat") Integer tinhTrangCoSoVatChatId,
                              Model model) {
        try {
            TinhTrangCoSoVatChat tinhTrangCoSoVatChat = tinhTrangCoSoService.findTinhTrangCoSoVatChatById(tinhTrangCoSoVatChatId);
            canHo.setTinhTrangCoSoVatChat(tinhTrangCoSoVatChat);
            canHoService.add(canHo);
            return "redirect:/CanHo/list";
        } catch (IllegalArgumentException e) {
            model.addAttribute("error", e.getMessage());
            model.addAttribute("CanHo", canHo);
            model.addAttribute("loaiCanHos", loaiCanHoService.getAll());
            model.addAttribute("tinhTrangCoSo", tinhTrangCoSoService.getAll());
            return "create";
        }
    }
    @GetMapping("/{maCanHo}/delete")
    public String deleteStudent(@PathVariable("maCanHo")int maCanHo,
                                RedirectAttributes redirectAttributes) {
        canHoService.delete(maCanHo);
        redirectAttributes.addFlashAttribute("message", "Xóa thành công");
        return "redirect:/CanHo/list";
    }
}