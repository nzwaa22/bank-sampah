package com.example.demo.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.model.KategoriSampah;
import com.example.demo.model.Pembayaran;
import com.example.demo.model.Sampah;
import com.example.demo.model.Transaksi;
import com.example.demo.model.User;
import com.example.demo.model.Warga;
import com.example.demo.repository.KategoriSampahRepository;
import com.example.demo.repository.PembayaranRepository;
import com.example.demo.repository.TransaksiRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.SampahService;
import com.example.demo.service.TransaksiService;
import com.example.demo.service.WargaService;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TransaksiRepository transaksiRepository;

    @Autowired
    private WargaService wargaService;

    @Autowired
    private SampahService sampahService;

    @Autowired
    private TransaksiService transaksiService;

    @Autowired
    private KategoriSampahRepository kategoriSampahRepository;

    @Autowired
    private PembayaranRepository pembayaranRepository;

    @GetMapping("/dashboard")
    public String dashboard(Authentication authentication, Model model) {
        // Ambil username yang sedang login
        String username = authentication.getName();

        // Cari user berdasarkan username
        User user = userRepository.findByUsername(username).orElse(null);

        if (user != null && user.getWarga() != null) {
            // Ambil semua transaksi milik warga ini
            List<Transaksi> transaksiList = transaksiRepository
                    .findByWarga_IdWarga(user.getWarga().getIdWarga());
            model.addAttribute("transaksiList", transaksiList);
            model.addAttribute("namaWarga", user.getWarga().getNama());
            model.addAttribute("warga", user.getWarga());
            model.addAttribute("sudahInputData", true);
        } else {
            model.addAttribute("transaksiList", List.of());
            model.addAttribute("namaWarga", username);
            model.addAttribute("warga", null);
            model.addAttribute("sudahInputData", false);
        }

        return "user/dashboard";
    }

    @GetMapping("/input-warga")
    public String formInputWarga(Authentication authentication, Model model) {
        String username = authentication.getName();
        User user = userRepository.findByUsername(username).orElse(null);

        // Jika user sudah punya data warga, tampilkan data yang ada
        if (user != null && user.getWarga() != null) {
            model.addAttribute("warga", user.getWarga());
            model.addAttribute("isEdit", true);
        } else {
            model.addAttribute("warga", new Warga());
            model.addAttribute("isEdit", false);
        }

        return "user/input-warga";
    }

    @PostMapping("/simpan-warga")
    public String simpanWarga(Authentication authentication, @ModelAttribute Warga warga) {
        String username = authentication.getName();
        User user = userRepository.findByUsername(username).orElse(null);

        if (user != null) {
            // Simpan atau update data warga
            Warga savedWarga = wargaService.save(warga);

            // Hubungkan user dengan warga
            user.setWarga(savedWarga);
            userRepository.save(user);
        }

        return "redirect:/user/dashboard";
    }

    @GetMapping("/input-sampah")
    public String formInputSampah(Authentication authentication, Model model) {
        String username = authentication.getName();
        User user = userRepository.findByUsername(username).orElse(null);

        // Validasi: user harus sudah input data warga terlebih dahulu
        if (user == null || user.getWarga() == null) {
            return "redirect:/user/dashboard";
        }

        // Ambil semua kategori sampah
        List<KategoriSampah> kategoriList = kategoriSampahRepository.findAll();
        model.addAttribute("kategoriList", kategoriList);
        model.addAttribute("sampah", new Sampah());

        return "user/input-sampah";
    }

    @PostMapping("/simpan-sampah")
    public String simpanSampah(Authentication authentication,
            @RequestParam Long idKategori,
            @RequestParam Double berat,
            @RequestParam LocalDate tanggal) {

        String username = authentication.getName();
        User user = userRepository.findByUsername(username).orElse(null);

        if (user != null && user.getWarga() != null) {
            // Ambil kategori sampah
            KategoriSampah kategori = kategoriSampahRepository.findById(idKategori).orElse(null);

            if (kategori != null) {
                // Simpan data sampah
                Sampah sampah = new Sampah();
                sampah.setKategoriSampah(kategori);
                sampah.setBerat(berat);
                sampah.setHargaPerKg(10000.0); // Harga default per kg
                Sampah savedSampah = sampahService.save(sampah);

                // Buat transaksi
                Transaksi transaksi = new Transaksi();
                transaksi.setWarga(user.getWarga());
                transaksi.setTanggal(tanggal);
                Transaksi savedTransaksi = transaksiService.save(transaksi);

                // Buat pembayaran
                Pembayaran pembayaran = new Pembayaran();
                pembayaran.setSampah(savedSampah);
                pembayaran.setTransaksi(savedTransaksi);
                pembayaran.setBerat(berat);
                pembayaran.setJumlahBayar(berat * 10000.0); // Total harga
                pembayaranRepository.save(pembayaran);
            }
        }

        return "redirect:/user/dashboard";
    }
}