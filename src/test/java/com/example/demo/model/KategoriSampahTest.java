package com.example.demo.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class KategoriSampahTest {

    @Test
    void testSetDanGetNamaKategori() {
        KategoriSampah kategori = new KategoriSampah();
        kategori.setNamaKategori("Organik");
        assertEquals("Organik", kategori.getNamaKategori());
    }

    @Test
    void testSetDanGetIdKategori() {
        KategoriSampah kategori = new KategoriSampah();
        kategori.setIdKategori(1L);
        assertEquals(1L, kategori.getIdKategori());
    }

    @Test
    void testKategoriAnorganik() {
        KategoriSampah kategori = new KategoriSampah();
        kategori.setNamaKategori("Anorganik");
        assertEquals("Anorganik", kategori.getNamaKategori());
    }

    @Test
    void testKategoriB3() {
        KategoriSampah kategori = new KategoriSampah();
        kategori.setNamaKategori("B3");
        assertEquals("B3", kategori.getNamaKategori());
    }

    @Test
    void testKategoriTidakNull() {
        KategoriSampah kategori = new KategoriSampah();
        assertNotNull(kategori);
    }
}
