package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.model.Warga;
import com.example.demo.repository.UserRepository;
import com.example.demo.repository.WargaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class RegisterController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private WargaRepository wargaRepository;

    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @GetMapping("/register")
    public String showRegister() {
        return "register";
    }

    @PostMapping("/register")
    public String doRegister(
            @RequestParam("nama") String nama,
            @RequestParam("alamat") String alamat,
            @RequestParam("noHp") String noHp,
            @RequestParam("username") String username,
            @RequestParam("password") String password,
            Model model) {

        // Cek username sudah dipakai atau belum
        if (userRepository.findByUsername(username).isPresent()) {
            model.addAttribute("error", "Username sudah digunakan, pilih username lain!");
            return "register";
        }

        // Simpan data warga dulu
        Warga warga = new Warga();
        warga.setNama(nama);
        warga.setAlamat(alamat);
        warga.setNoHp(noHp);
        Warga savedWarga = wargaRepository.save(warga);

        // Simpan akun user
        User user = new User();
        user.setUsername(username);
        user.setPassword(passwordEncoder.encode(password));
        user.setRole("USER");
        user.setWarga(savedWarga);
        userRepository.save(user);

        return "redirect:/login?registered=true";
    }
}
