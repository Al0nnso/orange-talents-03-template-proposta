package com.zup.cartao.cartao;


import javax.persistence.*;
import javax.validation.constraints.NotBlank;

import org.hibernate.annotations.GenericGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
public class Cartao {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private String id;
    @Column(nullable = false)
    private String idCartao;
    private BloqueioCartao bloqueio;

    public Cartao() {
    }

    public Cartao(String idCartao) {

        this.idCartao = idCartao;
        //this.bloqueioCartao = new BloqueioCartao(CartaoBloqueado.NÃO);
    }


    public String getId() {
        return id;
    }

    public String getIdCartao() {
        return idCartao;
    }

    public BloqueioCartao getBloqueio() {
        return this.bloqueio;
    }

}
