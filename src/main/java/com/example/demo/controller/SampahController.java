package com.example.demo.controller;

import com.example.demo.model.Sampah;
import com.example.demo.service.KategoriSampahService;
import com.example.demo.service.SampahService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin/sampah")
public class SampahController {

    @Autowired
    private SampahService sampahService;

    @Autowired
    private KategoriSampahService kategoriSampahService;

    @GetMapping
    public String index(Model model) {
        model.addAttribute("sampahList", sampahService.getAll());
        model.addAttribute("kategoriList", kategoriSampahService.getAll());
        return "admin/sampah";
    }

    @PostMapping("/simpan")
    public String simpan(@ModelAttribute Sampah sampah) {
        sampahService.save(sampah);
        return "redirect:/admin/sampah";
    }

    @GetMapping("/hapus/{id}")
    public String hapus(@PathVariable Long id) {
        sampahService.delete(id);
        return "redirect:/admin/sampah";
    }
}