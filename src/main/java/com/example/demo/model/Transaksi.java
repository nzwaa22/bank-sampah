package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "transaksi")
public class Transaksi {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idTransaksi;

    @ManyToOne
    @JoinColumn(name = "id_warga")
    private Warga warga;

    private LocalDate tanggal;

    @OneToMany(mappedBy = "transaksi")
    private List<Pembayaran> pembayaranList;

    public Long getIdTransaksi() { return idTransaksi; }
    public void setIdTransaksi(Long idTransaksi) { this.idTransaksi = idTransaksi; }

    public Warga getWarga() { return warga; }
    public void setWarga(Warga warga) { this.warga = warga; }

    public LocalDate getTanggal() { return tanggal; }
    public void setTanggal(LocalDate tanggal) { this.tanggal = tanggal; }

    public List<Pembayaran> getPembayaranList() { return pembayaranList; }
    public void setPembayaranList(List<Pembayaran> pembayaranList) { this.pembayaranList = pembayaranList; }
}
