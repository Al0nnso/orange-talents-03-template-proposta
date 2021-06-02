package com.zup.cartao.biometria;

import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.CreationTimestamp;

@Entity
public class Biometria {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String biometria;
    @CreationTimestamp
    private LocalDateTime criadoEm=LocalDateTime.now();

    @Deprecated
    public Biometria() {
    }

    public Biometria(String biometria) {
        this.biometria = biometria;
    }

    public Long getId() {
        return id;
    }

    public String getBiometria() {
        return biometria;
    }

    public LocalDateTime getCriadoEm() {
        return criadoEm;
    }

}