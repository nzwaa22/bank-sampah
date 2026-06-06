package com.example.demo.controller;

import com.example.demo.model.KategoriSampah;
import com.example.demo.service.KategoriSampahService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin/kategori")
public class KategoriSampahController {

    @Autowired
    private KategoriSampahService kategoriSampahService;

    @GetMapping
    public String index(Model model) {
        model.addAttribute("kategoriList", kategoriSampahService.getAll());
        return "admin/kategori";
    }

    @PostMapping("/simpan")
    public String simpan(@ModelAttribute KategoriSampah kategori) {
        kategoriSampahService.save(kategori);
        return "redirect:/admin/kategori";
    }

    @GetMapping("/hapus/{id}")
    public String hapus(@PathVariable Long id) {
        kategoriSampahService.delete(id);
        return "redirect:/admin/kategori";
    }
}