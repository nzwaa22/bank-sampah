package com.example.demo.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "warga")
public class Warga {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idWarga;

    private String nama;
    private String alamat;
    private String noHp;

    @OneToMany(mappedBy = "warga")
    private List<Transaksi> transaksiList;

    public Long getIdWarga() { return idWarga; }
    public void setIdWarga(Long idWarga) { this.idWarga = idWarga; }

    public String getNama() { return nama; }
    public void setNama(String nama) { this.nama = nama; }

    public String getAlamat() { return alamat; }
    public void setAlamat(String alamat) { this.alamat = alamat; }

    public String getNoHp() { return noHp; }
    public void setNoHp(String noHp) { this.noHp = noHp; }

    public List<Transaksi> getTransaksiList() { return transaksiList; }
    public void setTransaksiList(List<Transaksi> transaksiList) { this.transaksiList = transaksiList; }
}
