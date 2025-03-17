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
import java.util.Optional;

@Controller
@RequestMapping("/khach-hang")
public class KhachHangController {

    @Autowired
    private IKhachHangService khachHangService;

    // 1. Lấy danh sách khách hàng
    @GetMapping("/list")
    public String getAll(Model model, @RequestParam(value = "name", defaultValue = "") String tenKhachHang) {
        List<KhachHang> khachHangs = khachHangService.findByName(tenKhachHang);
        model.addAttribute("khachHangs", khachHangs);
        model.addAttribute("tenKhachHang", tenKhachHang);
        return "khachHang/list";
    }

    // 2. Xóa khách hàng
    @GetMapping("/delete/{id}")
    public String deleteKhachHang(@PathVariable("id") Integer id, RedirectAttributes redirectAttributes) {
        khachHangService.remove(id);
        redirectAttributes.addFlashAttribute("message", "Xóa khách hàng thành công!");
        return "redirect:/khach-hang/list";
    }

    // 3. Hiển thị form thêm mới khách hàng
    @GetMapping("/create")
    public String showCreateForm(Model model) {
        model.addAttribute("khachHang", new KhachHang());
        return "khachHang/create";
    }

    // 4. Xử lý thêm mới khách hàng
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
        return "redirect:/khach-hang/list";
    }

    // 5. Hiển thị form cập nhật khách hàng
    @GetMapping("/update/{id}")
    public String showUpdateForm(@PathVariable("id") Integer id, Model model) {
        KhachHang khachHang = khachHangService.findById(id);
        if (khachHang == null) {
            return "redirect:/khach-hang/list";
        }
        model.addAttribute("khachHang", khachHang);
        return "khachHang/update";
    }

    // 6. Xử lý cập nhật khách hàng
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
        return "redirect:/khach-hang/list";
    }
}
