package com.investree.testRestAPI.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Setter @Getter @Entity @Table(name = "transaksi")
public class Transaksi extends AuditDate implements Serializable {
    @Id @Column(name = "id") @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne @JoinColumn(name = "barang_id")
    Barang barang;

    @ManyToOne @JoinColumn(name = "pembeli_id")
    Pembeli pembeli;
}
