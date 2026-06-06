package com.example.demo.model;

import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.*;

public class TransaksiTest {

    @Test
    void testSetDanGetTanggal() {
        Transaksi transaksi = new Transaksi();
        LocalDate today = LocalDate.now();
        transaksi.setTanggal(today);
        assertEquals(today, transaksi.getTanggal());
    }

    @Test
    void testSetDanGetIdTransaksi() {
        Transaksi transaksi = new Transaksi();
        transaksi.setIdTransaksi(1L);
        assertEquals(1L, transaksi.getIdTransaksi());
    }

    @Test
    void testRelasiWarga() {
        Warga warga = new Warga();
        warga.setNama("Disa");

        Transaksi transaksi = new Transaksi();
        transaksi.setWarga(warga);

        assertEquals("Disa", transaksi.getWarga().getNama());
    }

    @Test
    void testTransaksiTidakNull() {
        Transaksi transaksi = new Transaksi();
        assertNotNull(transaksi);
    }
}
