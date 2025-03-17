package org.example.casestudymodule4_quanlycanhochungcu.controller;

import org.example.casestudymodule4_quanlycanhochungcu.entity.CoSoVatChat;
import org.example.casestudymodule4_quanlycanhochungcu.entity.TinhTrangCoSoVatChat;
import org.example.casestudymodule4_quanlycanhochungcu.service.ICoSoVatChatService;
import org.example.casestudymodule4_quanlycanhochungcu.service.ITinhTrangCoSoVatChatService;
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
@RequestMapping("/coSoVatChat")
public class CoSoVatChatController {

    @Autowired
    private ICoSoVatChatService coSoVatChatService;

    @Autowired
    private ITinhTrangCoSoVatChatService tinhTrangCoSoVatChatService;

    @GetMapping("/list")
    public String getAll(Model model, @RequestParam(value = "name", defaultValue = "") String tenCoSoVatChat) {
        List<CoSoVatChat> coSoVatChats = coSoVatChatService.findByName(tenCoSoVatChat);
        model.addAttribute("coSoVatChats", coSoVatChats);
        model.addAttribute("tenCoSoVatChat", tenCoSoVatChat);
        return "coSoVatChat/list";
    }

    @GetMapping("/delete/{id}")
    public String deleteCoSoVatChat(@PathVariable("id") Integer id, RedirectAttributes redirectAttributes) {
        coSoVatChatService.remove(id);
        redirectAttributes.addFlashAttribute("message", "Xóa cơ sở vật chất thành công!");
        return "redirect:/coSoVatChat/list";
    }

    @GetMapping("/create")
    public String showCreateForm(Model model) {
        List<TinhTrangCoSoVatChat> tinhTrangList = tinhTrangCoSoVatChatService.getAll();
        System.out.println("Danh sách tình trạng: " + tinhTrangList);

        model.addAttribute("coSoVatChat", new CoSoVatChat());
        model.addAttribute("tinhTrangList", tinhTrangList);
        return "coSoVatChat/create";
    }


    @PostMapping("/create")
    public String createCoSoVatChat(@Validated @ModelAttribute("coSoVatChat") CoSoVatChat coSoVatChat,
                                    BindingResult bindingResult,
                                    RedirectAttributes redirectAttributes,
                                    Model model) {
        System.out.println("Dữ liệu nhận được: " + coSoVatChat);

        if (bindingResult.hasErrors()) {
            System.out.println("Lỗi validate: " + bindingResult.getAllErrors());
            model.addAttribute("tinhTrangList", tinhTrangCoSoVatChatService.getAll());
            return "coSoVatChat/create";
        }

        if (Optional.ofNullable(coSoVatChat.getTinhTrangCoSoVatChat())
                .map(TinhTrangCoSoVatChat::getMaTinhTrangCoSoVatChat)
                .orElse(null) == null) {

            System.out.println("Tình trạng bị null");
            model.addAttribute("error", "Vui lòng chọn tình trạng!");
            model.addAttribute("tinhTrangList", tinhTrangCoSoVatChatService.getAll());
            return "coSoVatChat/create";
        }


        coSoVatChatService.save(coSoVatChat);
        redirectAttributes.addFlashAttribute("message", "Thêm mới thành công!");
        return "redirect:/coSoVatChat/list";
    }


    @GetMapping("/update/{id}")
    public String showUpdateForm(@PathVariable("id") Integer id, Model model) {
        CoSoVatChat coSoVatChat = coSoVatChatService.findById(id);
        if (coSoVatChat == null) {
            return "redirect:/coSoVatChat/list";
        }
        model.addAttribute("coSoVatChat", coSoVatChat);
        model.addAttribute("tinhTrangList", tinhTrangCoSoVatChatService.getAll());
        return "coSoVatChat/update";
    }

    @PostMapping("/update/{id}")
    public String updateCoSoVatChat(@Validated @ModelAttribute("coSoVatChat") CoSoVatChat coSoVatChat,
                                    BindingResult bindingResult,
                                    @PathVariable("id") Integer id,
                                    RedirectAttributes redirectAttributes,
                                    Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("tinhTrangList", tinhTrangCoSoVatChatService.getAll());
            return "coSoVatChat/update";
        }
        coSoVatChatService.update(id, coSoVatChat);
        redirectAttributes.addFlashAttribute("message", "Cập nhật cơ sở vật chất thành công!");
        return "redirect:/coSoVatChat/list";
    }
}

