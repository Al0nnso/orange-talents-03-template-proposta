package com.zup.cartao.restricao;

public class RestricaoResponse {

    private String documento;
    private String nome;
    private Situacao resultadoSolicitacao;
    private Long idProposta;


    public RestricaoResponse(String documento, String nome, Situacao resultadoSolicitacao, Long idProposta) {
        this.documento = documento;
        this.nome = nome;
        this.resultadoSolicitacao = resultadoSolicitacao;
        this.idProposta = idProposta;
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
