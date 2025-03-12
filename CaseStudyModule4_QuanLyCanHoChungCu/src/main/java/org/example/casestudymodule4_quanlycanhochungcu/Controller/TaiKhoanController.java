package org.example.casestudymodule4_quanlycanhochungcu.Controller;

import org.example.casestudymodule4_quanlycanhochungcu.Service.ITaiKhoanService;
import org.example.casestudymodule4_quanlycanhochungcu.entity.TaiKhoan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


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

    @GetMapping("/delete/{id}")
    public String deleteTaiKhoan(@PathVariable Long id) {
        taiKhoanService.deleteById(id);
        return "redirect:/taikhoan";
    }
}