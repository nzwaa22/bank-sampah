package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "pembayaran")
public class Pembayaran {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPembayaran;

    @ManyToOne
    @JoinColumn(name = "id_transaksi")
    private Transaksi transaksi;

    @ManyToOne
    @JoinColumn(name = "id_sampah")
    private Sampah sampah;

    private Double berat;
    private Double jumlahBayar;
    private String metodeBayar;

    public Long getIdPembayaran() { return idPembayaran; }
    public void setIdPembayaran(Long idPembayaran) { this.idPembayaran = idPembayaran; }

    public Transaksi getTransaksi() { return transaksi; }
    public void setTransaksi(Transaksi transaksi) { this.transaksi = transaksi; }

    public Sampah getSampah() { return sampah; }
    public void setSampah(Sampah sampah) { this.sampah = sampah; }

    public Double getBerat() { return berat; }
    public void setBerat(Double berat) { this.berat = berat; }

    public Double getJumlahBayar() { return jumlahBayar; }
    public void setJumlahBayar(Double jumlahBayar) { this.jumlahBayar = jumlahBayar; }

    public String getMetodeBayar() { return metodeBayar; }
    public void setMetodeBayar(String metodeBayar) { this.metodeBayar = metodeBayar; }
}
