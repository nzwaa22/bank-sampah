package com.example.demo.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PembayaranTest {

    @Test
    void testSetDanGetBerat() {
        Pembayaran pembayaran = new Pembayaran();
        pembayaran.setBerat(3.0);
        assertEquals(3.0, pembayaran.getBerat());
    }

    @Test
    void testSetDanGetMetodeBayar() {
        Pembayaran pembayaran = new Pembayaran();
        pembayaran.setMetodeBayar("Tunai");
        assertEquals("Tunai", pembayaran.getMetodeBayar());
    }

    @Test
    void testHitungJumlahBayar() {
        // Simulasi hitung jumlah bayar = berat x harga per kg
        double berat = 3.0;
        double hargaPerKg = 1500.0;
        double expected = berat * hargaPerKg;

        Pembayaran pembayaran = new Pembayaran();
        pembayaran.setBerat(berat);
        pembayaran.setJumlahBayar(expected);

        assertEquals(4500.0, pembayaran.getJumlahBayar());
    }

    @Test
    void testRelasiTransaksi() {
        Transaksi transaksi = new Transaksi();
        transaksi.setIdTransaksi(1L);

        Pembayaran pembayaran = new Pembayaran();
        pembayaran.setTransaksi(transaksi);

        assertEquals(1L, pembayaran.getTransaksi().getIdTransaksi());
    }

    @Test
    void testMetodeBayarTransfer() {
        Pembayaran pembayaran = new Pembayaran();
        pembayaran.setMetodeBayar("Transfer");
        assertEquals("Transfer", pembayaran.getMetodeBayar());
    }

    @Test
    void testPembayaranTidakNull() {
        Pembayaran pembayaran = new Pembayaran();
        assertNotNull(pembayaran);
    }
}
