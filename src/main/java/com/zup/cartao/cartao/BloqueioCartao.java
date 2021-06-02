package com.zup.cartao.cartao;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class BloqueioCartao {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private String id;
    private String ip;
    private String userAgent;
    @Enumerated(EnumType.STRING)
    private Bloqueio bloqueio;

    @Deprecated
    public BloqueioCartao(){
    }

    public BloqueioCartao(Bloqueio bloqueio) {
        this.bloqueio = bloqueio;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIp() {
        return this.ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getUserAgent() {
        return this.userAgent;
    }

    public void setUserAgent(String userAgent) {
        this.userAgent = userAgent;
    }

    public Bloqueio getBloqueio() {
        return this.bloqueio;
    }

    public void setBloqueio(Bloqueio bloqueio) {
        this.bloqueio = bloqueio;
    }

}
