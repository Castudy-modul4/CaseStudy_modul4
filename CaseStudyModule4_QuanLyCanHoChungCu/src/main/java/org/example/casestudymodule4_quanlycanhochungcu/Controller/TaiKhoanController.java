package org.example.casestudymodule4_quanlycanhochungcu.Controller;

import jakarta.validation.Valid;
import org.example.casestudymodule4_quanlycanhochungcu.Service.ITaiKhoanService;
import org.example.casestudymodule4_quanlycanhochungcu.entity.TaiKhoan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import java.util.List;

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

    @GetMapping("/delete/{id}")
    public String deleteTaiKhoan(@PathVariable Long id, RedirectAttributes redirectAttributes) {
        taiKhoanService.deleteById(id);
        redirectAttributes.addFlashAttribute("message", "Xóa tài khoản thành công!");
        return "redirect:/taikhoan/list";
    }
}