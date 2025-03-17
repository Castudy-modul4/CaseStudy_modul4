package org.example.casestudymodule4_quanlycanhochungcu.controller;

import jakarta.validation.Valid;
import org.example.casestudymodule4_quanlycanhochungcu.service.ITaiKhoanService;
import org.example.casestudymodule4_quanlycanhochungcu.entity.TaiKhoan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/taikhoan")
public class TaiKhoanController {

    @Autowired
    private ITaiKhoanService taiKhoanService;


    @GetMapping("/list")
    public String listTaiKhoan(Model model) {
        List<TaiKhoan> danhSachTaiKhoan = taiKhoanService.findAll();
        model.addAttribute("taiKhoans", danhSachTaiKhoan);
        return "account/list";
    }

    @GetMapping("/create")
    public String showCreateForm(Model model) {
        model.addAttribute("taiKhoan", new TaiKhoan());
        return "account/create";
    }

    @PostMapping("/create")
    public String createTaiKhoan(@Valid @ModelAttribute("taiKhoan") TaiKhoan taiKhoan,
                                 BindingResult bindingResult,
                                 RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            return "account/create";
        }
        taiKhoanService.save(taiKhoan);
        redirectAttributes.addFlashAttribute("message", "Tạo tài khoản thành công!");
        return "redirect:/taikhoan/list";
    }
    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model, RedirectAttributes redirectAttributes) {
        Optional<TaiKhoan> optionalTaiKhoan = taiKhoanService.findById(id);
        if (optionalTaiKhoan.isEmpty()) {
            redirectAttributes.addFlashAttribute("error", "Không tìm thấy tài khoản!");
            return "redirect:/taikhoan/list";
        }
        model.addAttribute("taiKhoan", optionalTaiKhoan.get());
        return "account/edit";
    }

    // 5️⃣ Xử lý cập nhật tài khoản
    @PostMapping("/edit/{id}")
    public String updateTaiKhoan(@PathVariable Long id,
                                 @Valid @ModelAttribute("taiKhoan") TaiKhoan taiKhoan,
                                 BindingResult bindingResult,
                                 RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            return "account/edit";
        }

        Optional<TaiKhoan> existingTaiKhoan = taiKhoanService.findById(id);
        if (existingTaiKhoan.isPresent()) {
            TaiKhoan updatedTaiKhoan = existingTaiKhoan.get();
            updatedTaiKhoan.setUsername(taiKhoan.getUsername());
            if (!taiKhoan.getPassword().isEmpty()) {
                updatedTaiKhoan.setPassword(taiKhoan.getPassword());
            }
            updatedTaiKhoan.setRole(taiKhoan.getRole());

            taiKhoanService.save(updatedTaiKhoan);
            redirectAttributes.addFlashAttribute("message", "Cập nhật tài khoản thành công!");
        } else {
            redirectAttributes.addFlashAttribute("error", "Không tìm thấy tài khoản!");
        }
        return "redirect:/taikhoan/list";
    }



    @GetMapping("/delete/{id}")
    public String deleteTaiKhoan(@PathVariable Long id, RedirectAttributes redirectAttributes) {
        taiKhoanService.deleteById(id);
        redirectAttributes.addFlashAttribute("message", "Xóa tài khoản thành công!");
        return "redirect:/taikhoan/list";
    }
}