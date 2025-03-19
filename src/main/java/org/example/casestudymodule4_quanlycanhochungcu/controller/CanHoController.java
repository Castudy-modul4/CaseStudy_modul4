    package org.example.casestudymodule4_quanlycanhochungcu.controller;

    import jakarta.persistence.EntityNotFoundException;
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
    import org.springframework.data.domain.Pageable;
    import org.springframework.data.web.PageableDefault;
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
                               @RequestParam(value = "tinhTrangCanHo", required = false) Integer maTinhTrangCanHo,
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
                canHos = canHoService.findALl(pageable); // Lấy danh sách căn hộ đang hoạt động
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

        @PostMapping("/delete/{id}")
        public String xoaCanHo(@PathVariable int id, RedirectAttributes redirectAttributes) {
            try {
                canHoService.delete(id);
                redirectAttributes.addFlashAttribute("message", "Xóa căn hộ thành công!");
            } catch (EntityNotFoundException e) {
                redirectAttributes.addFlashAttribute("error", "Không tìm thấy căn hộ hoặc căn hộ đã bị xóa.");
            }
            return "redirect:/CanHo/list";
        }
        @GetMapping("/deletedList")
        public String hienThiDanhSachCanHoDaXoa(
                @PageableDefault(size = 5) Pageable pageable,
                Model model
        ) {
            Page<CanHo> canHoPage = canHoService.findAllDeleted(pageable);
            model.addAttribute("canHoPage", canHoPage);
            return "deletedList";
        }
        @PostMapping("/restore/{id}")
        public String khoiPhucCanHo(@PathVariable int id, RedirectAttributes redirectAttributes) {
            try {
                canHoService.restore(id);
                redirectAttributes.addFlashAttribute("message", "Khôi phục căn hộ thành công!");
            } catch (EntityNotFoundException e) {
                redirectAttributes.addFlashAttribute("error", "Không tìm thấy căn hộ đã bị xóa.");
            }
            return "redirect:/CanHo/deletedList";
        }

        @GetMapping("/edit/{id}")
        public String showEditForm(@PathVariable("id") int maCanHo, Model model, RedirectAttributes redirectAttributes) {
            try {
                CanHo canHo = canHoService.getById(maCanHo);
                if (canHo.isDeleted())
                    throw new EntityNotFoundException("Can not edit deleted can ho");
                model.addAttribute("canHo", canHo);
                model.addAttribute("loaiCanHos", loaiCanHoService.getAll());
                model.addAttribute("tinhTrangCoSoVatChats", tinhTrangCoSoService.getAll());
                model.addAttribute("tinhTrangCanHos", tinhTrangCanHoService.getAll());
                return "edit";
            } catch (EntityNotFoundException e) {
                redirectAttributes.addFlashAttribute("error", e.getMessage());
                return "redirect:/CanHo/list";
            }
        }
        @PostMapping("/update/{id}")
        public String capNhatCanHo(@PathVariable("id") int maCanHo, @ModelAttribute("canHo") CanHo canHo, RedirectAttributes redirectAttributes) {
            try {
                canHoService.update(maCanHo, canHo);
                redirectAttributes.addFlashAttribute("message", "Cập nhật căn hộ thành công.");
            } catch (EntityNotFoundException e) {
                redirectAttributes.addFlashAttribute("error", e.getMessage());
                return "redirect:/CanHo/list";
            }
            return "redirect:/CanHo/list";
        }
    }
