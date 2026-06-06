package com.example.demo.repository;

import com.example.demo.model.Warga;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WargaRepository extends JpaRepository<Warga, Long> {}