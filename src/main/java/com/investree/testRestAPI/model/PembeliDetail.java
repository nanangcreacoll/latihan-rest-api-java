package com.investree.testRestAPI.model;

import jakarta.persistence.*;
import lombok.Getter;

import java.io.Serializable;

@Getter @Entity @Table(name = "pembelidetail")
public class PembeliDetail implements Serializable {
    @Id @Column(name = "id") @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "status", nullable = false, length = 45)
    private String status;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_pembeli", referencedColumnName = "id")
    private Pembeli pembeli;
}
