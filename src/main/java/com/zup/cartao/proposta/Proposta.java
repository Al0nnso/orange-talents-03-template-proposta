package com.zup.cartao.proposta;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.zup.cartao.restricao.Restricao;

@Entity
public class Proposta {

    // Seta e retorna automaticamente a variavel ( getter e setter )
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
    @JsonProperty @Column(nullable = false, unique = true)
    private String documento;
    @JsonProperty @Column(nullable = false)
    private String email;
    @JsonProperty
    private String nome;
    @JsonProperty
    private String endereco;
    @JsonProperty
    private Double salario;
    
    @Deprecated
    Proposta(){
    }
    

    public Proposta(String documento,String email,String nome,String endereco, Double salario){
        this.documento=documento;
		this.endereco = endereco;
		this.email=email;
		this.nome=nome;
		this.salario=salario;
    }


	public Long getId() {
		return this.id;
	}

    public void setId(Long id) {
        this.id = id;
    }

    public String getDocumento() {
        return this.documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return this.endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public Double getSalario() {
        return this.salario;
    }

    public void setSalario(Double salario) {
        this.salario = salario;
    }


}
