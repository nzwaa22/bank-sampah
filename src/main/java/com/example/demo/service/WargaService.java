package com.example.demo.service;

import com.example.demo.model.Warga;
import com.example.demo.repository.WargaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WargaService {

    @Autowired
    private WargaRepository wargaRepository;

    public List<Warga> getAll() { 
        return wargaRepository.findAll(); 
    }

    public Optional<Warga> getById(Long id) { 
        return wargaRepository.findById(id); 
    }

    public Warga save(Warga warga) { 
        return wargaRepository.save(warga); 
    }

    public void delete(Long id) { 
        wargaRepository.deleteById(id); 
    }
}