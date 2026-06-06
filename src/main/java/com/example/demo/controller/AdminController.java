package com.example.demo.controller;

import com.example.demo.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private WargaService wargaService;

    @Autowired
    private TransaksiService transaksiService;

    @Autowired
    private SampahService sampahService;

    @Autowired
    private PembayaranService pembayaranService;

    @GetMapping("/dashboard")
    public String dashboard(Model model) {
        model.addAttribute("totalWarga", wargaService.getAll().size());
        model.addAttribute("totalTransaksi", transaksiService.getAll().size());
        model.addAttribute("totalSampah", sampahService.getAll().size());
        model.addAttribute("totalPembayaran", pembayaranService.getAll().size());
        return "admin/dashboard";
    }
}
