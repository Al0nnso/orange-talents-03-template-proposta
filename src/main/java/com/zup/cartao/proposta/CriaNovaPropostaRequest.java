package com.zup.cartao.proposta;

import java.math.BigDecimal;
import com.fasterxml.jackson.annotation.JsonProperty;

import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

class CriaNovaPropostaRequest {

    // Seta e retorna automaticamente a variavel ( getter e setter )
    @JsonProperty @NotBlank @CPF
    private final String documento;
    @JsonProperty @NotBlank @NotNull @Email
    private final String email;
    @JsonProperty
    private final String nome;
    @JsonProperty @NotBlank @NotNull
    private final String endereco;
    @JsonProperty @NotNull @Positive
    private final Double salario;
    

    public CriaNovaPropostaRequest(String documento,String email,String nome,String endereco, Double salario){
        this.documento=documento;
		this.endereco = endereco;
		this.email=email;
		this.nome=nome;
		this.salario=salario;
    }


	public Proposta toModel() {
		Proposta proposta = new Proposta(documento,email,nome,endereco,salario);
		return proposta;
	}


}
