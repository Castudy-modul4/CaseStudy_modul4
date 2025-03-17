    package org.example.casestudymodule4_quanlycanhochungcu.controller;

    import org.example.casestudymodule4_quanlycanhochungcu.entity.LoaiCanHo;
    import org.example.casestudymodule4_quanlycanhochungcu.repository.ILoaiCanHoRepository;
    import org.example.casestudymodule4_quanlycanhochungcu.service.ILoaiCanHoService;
    import org.example.casestudymodule4_quanlycanhochungcu.service.LoaiCanHoService;
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.stereotype.Controller;
    import org.springframework.ui.Model;
    import org.springframework.validation.BindingResult;
    import org.springframework.validation.annotation.Validated;
    import org.springframework.web.bind.annotation.*;
    import org.springframework.web.servlet.mvc.support.RedirectAttributes;

    import java.util.List;

    @Controller

    @RequestMapping("/loaiCanHo")
    public class LoaiCanHoController {

        @Autowired
        private ILoaiCanHoService loaiCanHoService;

        @GetMapping("/list")
        public String showListLoaiCanHo(Model model,
                                        @RequestParam(value = "name" , defaultValue = "") String tenLoaiCanHo) {
            List<LoaiCanHo> loaiCanHos =loaiCanHoService.findByName(tenLoaiCanHo);
            model.addAttribute("loaiCanHos", loaiCanHos);
            model.addAttribute("tenLoaiCanHo", tenLoaiCanHo);
            return "loaiCanHo/list";
        }

        @GetMapping("/delete/{id}")
        public String deleteLoaiCanHo(@PathVariable ("id")Integer id,
                                      RedirectAttributes redirectAttributes) {
            loaiCanHoService.remove(id);
            redirectAttributes.addFlashAttribute("message","xóa sản phẩm thành công !");
            return "redirect:/loaiCanHo/list";
        }

        @GetMapping("/create")
        public String showCreateLoaiCanHo(Model model) {
            model.addAttribute("loaiCanHo", new LoaiCanHo());
            return "loaiCanHo/create";
        }

        @PostMapping("/create")
        public String createLoaiCanHo(@Validated @ModelAttribute("loaiCanHo") LoaiCanHo loaiCanHo,
                                      BindingResult bindingResult,
                                      Model model,
                                      RedirectAttributes redirectAttributes) {
            if (bindingResult.hasErrors()) {
                model.addAttribute("loaiCanHo", loaiCanHo);
                return "loaiCanHo/create";
            }
            loaiCanHoService.save(loaiCanHo);
            redirectAttributes.addFlashAttribute("message","thêm mới loại căn h thành công !");
            return "redirect:/loaiCanHo/list";
        }

        @GetMapping("/update/{id}")
        public String showUpdateLoaiCanHo(@PathVariable("id") Integer id, Model model) {
            LoaiCanHo loaiCanHo = loaiCanHoService.findById(id);
            if (loaiCanHo == null) {
                return "redirect:/loaiCanHo/list";
            }
            model.addAttribute("loaiCanHo", loaiCanHo);
            return "loaiCanHo/update";
        }

        @PostMapping("/update/{id}")
        public String updateLoaiCanHo(@Validated @ModelAttribute("loaiCanHo") LoaiCanHo loaiCanHo,
                                      @PathVariable("id") Integer id,
                                      BindingResult bindingResult,
                                      RedirectAttributes redirectAttributes) {
            if (bindingResult.hasErrors()) {
                return "loaiCanHo/update";
            }
            loaiCanHoService.update(id,loaiCanHo);
            redirectAttributes.addFlashAttribute("message", "Cập nhật loại căn hộ thành công!");
            return "redirect:/loaiCanHo/list";
        }

    }
