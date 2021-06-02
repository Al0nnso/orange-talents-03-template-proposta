package com.zup.cartao.restricao;

import com.zup.cartao.proposta.Proposta;

public class Restricao {

    private String documento;
    private String nome;
    private Long idProposta;


    public Restricao(Proposta proposta) {
        this.documento = proposta.getDocumento();
        this.nome = proposta.getNome();
        this.idProposta = proposta.getId();
    }

    public String getDocumento() {
        return this.documento;
    }

    public String getNome() {
        return this.nome;
    }

    public Long getIdProposta() {
        return this.idProposta;
    }
    
}
