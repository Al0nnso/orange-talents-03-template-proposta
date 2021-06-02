package com.zup.cartao.cartao;


import javax.persistence.*;
import javax.validation.constraints.NotBlank;

import com.zup.cartao.biometria.Biometria;

import org.hibernate.annotations.GenericGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
public class Cartao {

    @Id
    private String id;
    @OneToOne
    private BloqueioCartao bloqueioCartao;
    @OneToOne(cascade = CascadeType.ALL)
    private Biometria biometria;

    @Deprecated
    public Cartao() {
    }

    public Cartao(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public BloqueioCartao getBloqueio() {
        return this.bloqueioCartao;
    }

    public void setBloqueio(BloqueioCartao bloqueio) {
        this.bloqueioCartao=bloqueio;
    }

    public void setBiometria(Biometria biometria) {
        this.biometria=biometria;
    }

    public Biometria getBiometria() {
        return this.biometria;
    }

}
