package com.example.demo.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SampahTest {

    @Test
    void testSetDanGetBerat() {
        Sampah sampah = new Sampah();
        sampah.setBerat(2.5);
        assertEquals(2.5, sampah.getBerat());
    }

    @Test
    void testSetDanGetHargaPerKg() {
        Sampah sampah = new Sampah();
        sampah.setHargaPerKg(1500.0);
        assertEquals(1500.0, sampah.getHargaPerKg());
    }

    @Test
    void testSetDanGetIdSampah() {
        Sampah sampah = new Sampah();
        sampah.setIdSampah(1L);
        assertEquals(1L, sampah.getIdSampah());
    }

    @Test
    void testRelasiKategori() {
        KategoriSampah kategori = new KategoriSampah();
        kategori.setNamaKategori("Organik");

        Sampah sampah = new Sampah();
        sampah.setKategoriSampah(kategori);

        assertEquals("Organik", sampah.getKategoriSampah().getNamaKategori());
    }

    @Test
    void testSampahTidakNull() {
        Sampah sampah = new Sampah();
        assertNotNull(sampah);
    }
}
