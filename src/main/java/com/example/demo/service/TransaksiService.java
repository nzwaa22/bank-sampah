package com.example.demo.service;

import com.example.demo.model.Transaksi;
import com.example.demo.repository.TransaksiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TransaksiService {

    @Autowired
    private TransaksiRepository repo;

    public List<Transaksi> getAll() { return repo.findAll(); }
    public Optional<Transaksi> getById(Long id) { return repo.findById(id); }
    public Transaksi save(Transaksi t) { return repo.save(t); }
    public void delete(Long id) { repo.deleteById(id); }
}
