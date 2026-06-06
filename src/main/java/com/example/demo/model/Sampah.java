package com.example.demo.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "sampah")
public class Sampah {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idSampah;

    @ManyToOne
    @JoinColumn(name = "id_kategori")
    private KategoriSampah kategoriSampah;

    private Double berat;
    private Double hargaPerKg;

    @OneToMany(mappedBy = "sampah")
    private List<Pembayaran> pembayaranList;

    public Long getIdSampah() { return idSampah; }
    public void setIdSampah(Long idSampah) { this.idSampah = idSampah; }

    public KategoriSampah getKategoriSampah() { return kategoriSampah; }
    public void setKategoriSampah(KategoriSampah kategoriSampah) { this.kategoriSampah = kategoriSampah; }

    public Double getBerat() { return berat; }
    public void setBerat(Double berat) { this.berat = berat; }

    public Double getHargaPerKg() { return hargaPerKg; }
    public void setHargaPerKg(Double hargaPerKg) { this.hargaPerKg = hargaPerKg; }

    public List<Pembayaran> getPembayaranList() { return pembayaranList; }
    public void setPembayaranList(List<Pembayaran> pembayaranList) { this.pembayaranList = pembayaranList; }
}
