package com.investree.testRestAPI.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "pembeli")
public class Pembeli {
    @Id @Column(name = "id") @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nama", nullable = false, length = 45)
    private Long name;

    @Column(name = "hp", length = 15)
    private Long hp;

    @Column(name = "jk", length = 15)
    private Long jk;

    @Column(name = "alamat", columnDefinition = "TEXT")
    private Long alamat;
}
