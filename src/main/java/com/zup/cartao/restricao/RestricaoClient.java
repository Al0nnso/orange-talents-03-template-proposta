package com.zup.cartao.restricao;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = "restricoes",url = "${url.restricoes}")
public interface RestricaoClient {

    @RequestMapping(method = RequestMethod.POST)
    ResponseEntity<RestricaoResponse> solicitacoes(Restricao restricao);

}


