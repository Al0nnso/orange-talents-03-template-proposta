package com.zup.cartao.proposta;

import java.util.Date;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import javax.validation.Valid;

import com.zup.cartao.cartao.Cartao;
import com.zup.cartao.cartao.CartaoClient;
import com.zup.cartao.cartao.CartaoRepository;
import com.zup.cartao.cartao.CartaoResponse;
import com.zup.cartao.error.ErrorMessage;
import com.zup.cartao.restricao.Restricao;
import com.zup.cartao.restricao.RestricaoClient;
import com.zup.cartao.restricao.RestricaoResponse;
import com.zup.cartao.restricao.Situacao;
import com.zup.cartao.restricao.SituacaoCartao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;


@RestController
@RequestMapping("/propostas")
public class PropostaController {
	
	@Autowired
	private PropostaRepository propostaRepository;
	
	@Autowired
	private RestricaoClient restricaoClient;

	@Autowired
	private CartaoClient cartaoClient;

	@PostMapping
	@Transactional
	public ResponseEntity<?> criaNovaProposta(@RequestBody @Valid CriaNovaPropostaRequest request, UriComponentsBuilder uriBuilder) throws Exception{
		Proposta proposta = request.toModel();

		if(propostaRepository.existsByDocumento(proposta.getDocumento())){
			return ResponseEntity.unprocessableEntity().build();
		}

		Restricao restricao = new Restricao(proposta);
		ResponseEntity<RestricaoResponse> restricaoResponse = restricaoClient.solicitacoes(restricao);

		proposta.setSituacao(restricaoResponse.getBody());

		if(proposta.getSituacao()==SituacaoCartao.ELEGIVEL){
			ResponseEntity<CartaoResponse> cartaoResponse = cartaoClient.cria(proposta);
			System.out.println(cartaoResponse.getStatusCode());
			if(cartaoResponse.getStatusCode() == HttpStatus.CREATED){
				proposta.criaCartao(cartaoResponse.getBody().getId());
			}
		}

		propostaRepository.save(proposta);

		return ResponseEntity.created(uriBuilder.path("/propostas/{id}").build(proposta.getId())).build();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> retornaProposta(@PathVariable Long id){
		Optional<Proposta> proposta = propostaRepository.findById(id);

		if(proposta.isPresent()){
			return ResponseEntity.ok(proposta.get());
		}

		return ResponseEntity.notFound().build();
	}

	
}
