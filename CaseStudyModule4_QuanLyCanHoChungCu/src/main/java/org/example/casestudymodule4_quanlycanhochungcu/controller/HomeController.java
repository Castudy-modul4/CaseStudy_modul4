package org.example.casestudymodule4_quanlycanhochungcu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping("/") // Khi truy cập trang chủ, sẽ hiển thị home.html
    public String home() {
        return "home"; // Trả về file home.html trong thư mục templates
    }
}
