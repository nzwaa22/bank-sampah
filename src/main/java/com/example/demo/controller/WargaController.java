package com.example.demo.controller;

import com.example.demo.model.Warga;
import com.example.demo.service.WargaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin/warga")
public class WargaController {

    @Autowired
    private WargaService wargaService;

    @GetMapping
    public String index(Model model) {
        model.addAttribute("wargaList", wargaService.getAll());
        return "admin/warga";
    }

    @PostMapping("/simpan")
    public String simpan(@ModelAttribute Warga warga) {
        wargaService.save(warga);
        return "redirect:/admin/warga";
    }

    @GetMapping("/hapus/{id}")
    public String hapus(@PathVariable Long id) {
        wargaService.delete(id);
        return "redirect:/admin/warga";
    }
}
