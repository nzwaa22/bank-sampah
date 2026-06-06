package com.example.demo.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class WargaTest {

    @Test
    void testSetDanGetNama() {
        Warga warga = new Warga();
        warga.setNama("Budi");
        assertEquals("Budi", warga.getNama());
    }

    @Test
    void testSetDanGetAlamat() {
        Warga warga = new Warga();
        warga.setAlamat("Bandung");
        assertEquals("Bandung", warga.getAlamat());
    }

    @Test
    void testSetDanGetNoHp() {
        Warga warga = new Warga();
        warga.setNoHp("081234567890");
        assertEquals("081234567890", warga.getNoHp());
    }

    @Test
    void testIdWarga() {
        Warga warga = new Warga();
        warga.setIdWarga(1L);
        assertEquals(1L, warga.getIdWarga());
    }

    @Test
    void testWargaTidakNull() {
        Warga warga = new Warga();
        assertNotNull(warga);
    }
}
