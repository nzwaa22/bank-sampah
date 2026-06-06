package com.example.demo.controller;

import com.example.demo.model.Transaksi;
import com.example.demo.service.TransaksiService;
import com.example.demo.service.WargaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin/transaksi")
public class TransaksiController {

    @Autowired
    private TransaksiService transaksiService;

    @Autowired
    private WargaService wargaService;

    @GetMapping
    public String index(Model model) {
        model.addAttribute("transaksiList", transaksiService.getAll());
        model.addAttribute("wargaList", wargaService.getAll());
        return "admin/transaksi";
    }

    @PostMapping("/simpan")
    public String simpan(@ModelAttribute Transaksi transaksi) {
        transaksiService.save(transaksi);
        return "redirect:/admin/transaksi";
    }

    @GetMapping("/hapus/{id}")
    public String hapus(@PathVariable Long id) {
        transaksiService.delete(id);
        return "redirect:/admin/transaksi";
    }
}