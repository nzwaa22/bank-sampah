package com.example.demo.service;

import com.example.demo.model.Sampah;
import com.example.demo.repository.SampahRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SampahService {

    @Autowired
    private SampahRepository repo;

    public List<Sampah> getAll() { return repo.findAll(); }
    public Optional<Sampah> getById(Long id) { return repo.findById(id); }
    public Sampah save(Sampah s) { return repo.save(s); }
    public void delete(Long id) { repo.deleteById(id); }
}
