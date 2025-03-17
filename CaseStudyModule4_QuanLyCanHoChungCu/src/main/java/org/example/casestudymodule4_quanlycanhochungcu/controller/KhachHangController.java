package org.example.casestudymodule4_quanlycanhochungcu.controller;

import org.example.casestudymodule4_quanlycanhochungcu.entity.KhachHang;
import org.example.casestudymodule4_quanlycanhochungcu.service.IKhachHangService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/khachhang")
public class KhachHangController {
    private final IKhachHangService khachHangService;

    public KhachHangController(IKhachHangService khachHangService) {
        this.khachHangService = khachHangService;
    }

    @GetMapping("/list")
    public String showKhachHangList() {
        List<KhachHang> khachHangs =  khachHangService.findAll();
        ModelAndView modelAndView = new ModelAndView("khachhang-list");
        modelAndView.addObject("khachHangs",khachHangs );

        return "khachhang-list";
    }

    @GetMapping("/edit/{id}")
    public String  showEditForm(@PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView("khachhang-form");
        modelAndView.addObject("khachHangs", khachHangService.findById(id));
        return "khachhang-list";
    }
    @PostMapping("/save")
    public String saveKhachHang(@ModelAttribute KhachHang khachHang) {
        khachHangService.save(khachHang);
        return "redirect:/khachhang-list";
    }

    @GetMapping("/delete/{id}")
    public String deleteKhachHang(@PathVariable Long id) {
        khachHangService.delete(id);
        return "redirect:/khachhang-list";
    }

}