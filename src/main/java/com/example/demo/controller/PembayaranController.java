package com.example.demo.controller;

import com.example.demo.model.Pembayaran;
import com.example.demo.model.Sampah;
import com.example.demo.model.Transaksi;
import com.example.demo.model.Warga;
import com.example.demo.service.PembayaranService;
import com.example.demo.service.SampahService;
import com.example.demo.service.TransaksiService;
import com.example.demo.service.WargaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@Controller
@RequestMapping("/admin/pembayaran")
public class PembayaranController {

    @Autowired
    private PembayaranService pembayaranService;

    @Autowired
    private TransaksiService transaksiService;

    @Autowired
    private SampahService sampahService;

    @Autowired
    private WargaService wargaService;

    @GetMapping
    public String index(Model model) {
        model.addAttribute("pembayaranList", pembayaranService.getAll());
        model.addAttribute("sampahList", sampahService.getAll());
        model.addAttribute("wargaList", wargaService.getAll());
        return "admin/pembayaran";
    }

    @PostMapping("/simpan")
    public String simpan(
            @RequestParam("wargaId") Long wargaId,
            @RequestParam("tanggal") String tanggal,
            @RequestParam("sampahId") Long sampahId,
            @RequestParam("berat") Double berat,
            @RequestParam("jumlahBayar") Double jumlahBayar,
            @RequestParam("metodeBayar") String metodeBayar) {

        // Buat transaksi otomatis
        Transaksi transaksi = new Transaksi();
        Warga warga = new Warga();
        warga.setIdWarga(wargaId);
        transaksi.setWarga(warga);
        transaksi.setTanggal(LocalDate.parse(tanggal));
        Transaksi savedTransaksi = transaksiService.save(transaksi);

        // Simpan pembayaran
        Pembayaran pembayaran = new Pembayaran();
        pembayaran.setTransaksi(savedTransaksi);

        Sampah sampah = new Sampah();
        sampah.setIdSampah(sampahId);
        pembayaran.setSampah(sampah);

        pembayaran.setBerat(berat);
        pembayaran.setJumlahBayar(jumlahBayar);
        pembayaran.setMetodeBayar(metodeBayar);

        pembayaranService.save(pembayaran);
        return "redirect:/admin/pembayaran";
    }

    @GetMapping("/hapus/{id}")
    public String hapus(@PathVariable Long id) {
        pembayaranService.delete(id);
        return "redirect:/admin/pembayaran";
    }
}
