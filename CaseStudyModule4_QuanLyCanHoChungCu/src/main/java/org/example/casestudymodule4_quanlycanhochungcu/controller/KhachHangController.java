package org.example.casestudymodule4_quanlycanhochungcu.controller;

import org.example.casestudymodule4_quanlycanhochungcu.entity.KhachHang;
import org.example.casestudymodule4_quanlycanhochungcu.service.IKhachHangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/khachHang")
public class KhachHangController {

    @Autowired
    private IKhachHangService khachHangService;

    @GetMapping("/list")
    public String getAll(Model model, @RequestParam(value = "name", defaultValue = "") String tenKhachHang) {
        List<KhachHang> khachHangs = khachHangService.findByName(tenKhachHang);
        model.addAttribute("khachHangs", khachHangs);
        model.addAttribute("tenKhachHang", tenKhachHang);
        return "/khachHang/list";
    }

    @GetMapping("/delete/{id}")
    public String deleteKhachHang(@PathVariable("id") Integer id, RedirectAttributes redirectAttributes) {
        khachHangService.remove(id);
        redirectAttributes.addFlashAttribute("message", "Xóa khách hàng thành công!");
        return "redirect:/khachHang/list";
    }

    @GetMapping("/create")
    public String showCreateForm(Model model) {
        model.addAttribute("khachHang", new KhachHang());
        return "khachHang/create";
    }

    @PostMapping("/create")
    public String createKhachHang(@Validated @ModelAttribute("khachHang") KhachHang khachHang,
                                  BindingResult bindingResult,
                                  RedirectAttributes redirectAttributes,
                                  Model model) {
        if (bindingResult.hasErrors()) {
            return "khachHang/create";
        }

        khachHangService.save(khachHang);
        redirectAttributes.addFlashAttribute("message", "Thêm mới khách hàng thành công!");
        return "redirect:/khachHang/list";
    }

    @GetMapping("/update/{id}")
    public String showUpdateForm(@PathVariable("id") Integer id, Model model) {
        KhachHang khachHang = khachHangService.findById(id);
        if (khachHang == null) {
            return "redirect:/khach-hang/list";
        }
        model.addAttribute("khachHang", khachHang);
        return "khachHang/update";
    }

    @PostMapping("/update/{id}")
    public String updateKhachHang(@Validated @ModelAttribute("khachHang") KhachHang khachHang,
                                  BindingResult bindingResult,
                                  @PathVariable("id") Integer id,
                                  RedirectAttributes redirectAttributes,
                                  Model model) {
        if (bindingResult.hasErrors()) {
            return "khachHang/update";
        }

        khachHangService.update(id, khachHang);
        redirectAttributes.addFlashAttribute("message", "Cập nhật khách hàng thành công!");
        return "redirect:/khachHang/list";
    }
}
