package com.example.demo.service;

import com.example.demo.model.KategoriSampah;
import com.example.demo.repository.KategoriSampahRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class KategoriSampahService {

    @Autowired
    private KategoriSampahRepository repo;

    public List<KategoriSampah> getAll() { return repo.findAll(); }
    public Optional<KategoriSampah> getById(Long id) { return repo.findById(id); }
    public KategoriSampah save(KategoriSampah k) { return repo.save(k); }
    public void delete(Long id) { repo.deleteById(id); }
}
