package com.zup.cartao.proposta;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import javax.validation.Valid;

import com.zup.cartao.error.ErrorMessage;
import com.zup.cartao.restricao.Restricao;
import com.zup.cartao.restricao.RestricaoClient;
import com.zup.cartao.restricao.RestricaoResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;


@RestController
@RequestMapping("/propostas")
public class PropostaController {
	
	private PropostaRepository repository;
	
	@Autowired
	private RestricaoClient restricaoClient;

	public PropostaController(PropostaRepository repository) {
		this.repository = repository;
	}

	@PostMapping
	@Transactional
	public ResponseEntity<?> criaNovaProposta(@RequestBody @Valid CriaNovaPropostaRequest request, UriComponentsBuilder uriBuilder) throws Exception{
		Proposta proposta = request.toModel();

		if(repository.existsByDocumento(proposta.getDocumento())){
			return ResponseEntity.unprocessableEntity().build();
		}

		Restricao restricao = new Restricao(proposta);
		ResponseEntity<RestricaoResponse> restricaoResponse = restricaoClient.solicitacoes(restricao);
		System.out.println(restricaoResponse.getBody());

		repository.save(proposta);

		return ResponseEntity.created(uriBuilder.path("/propostas/{id}").build(proposta.getId())).build();
	}
	
	
}
