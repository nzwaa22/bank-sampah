package com.example.demo.model;

import jakarta.persistence.*;
import java.util.List;

@Entity                              // ← tambah ini
@Table(name = "kategori_sampah")
public class KategoriSampah {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idKategori;

    private String namaKategori;

    @OneToMany(mappedBy = "kategoriSampah")
    private List<Sampah> sampahList;

    public Long getIdKategori() { return idKategori; }
    public void setIdKategori(Long idKategori) { this.idKategori = idKategori; }

    public String getNamaKategori() { return namaKategori; }
    public void setNamaKategori(String namaKategori) { this.namaKategori = namaKategori; }

    public List<Sampah> getSampahList() { return sampahList; }
    public void setSampahList(List<Sampah> sampahList) { this.sampahList = sampahList; }
}