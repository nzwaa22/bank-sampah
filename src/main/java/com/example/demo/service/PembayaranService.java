package com.example.demo.service;

import com.example.demo.model.Pembayaran;
import com.example.demo.repository.PembayaranRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PembayaranService {

    @Autowired
    private PembayaranRepository repo;

    public List<Pembayaran> getAll() { return repo.findAll(); }
    public Optional<Pembayaran> getById(Long id) { return repo.findById(id); }
    public Pembayaran save(Pembayaran p) { return repo.save(p); }
    public void delete(Long id) { repo.deleteById(id); }
}
