package com.zup.cartao.cartao;

import com.zup.cartao.proposta.Proposta;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = "restricoes",url = "${url.restricoes}")
public interface CartaoClient {

    @RequestMapping(method = RequestMethod.POST)
    ResponseEntity<CartaoResponse> solicitacoes(Proposta proposta);

}


