package com.zup.cartao;

import java.math.BigDecimal;
import java.net.http.HttpHeaders;

import javax.persistence.EntityManager;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureDataJpa;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
//import com.zup.cartao.proposta.CriaNovaPropostaRequest;

@SpringBootTest
@AutoConfigureMockMvc // Para testes de mock
@AutoConfigureDataJpa // Para testes de jpa
class PropostasControllerTest {
    
    // MockMvc ( faz requisição para o controller )
    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper jsonMapper;
    
    @MockBean
    EntityManager entityManager;

    @Test
    void criaNovaProposta() throws Exception{
        // Cria objecto para representar json que será mandado
        //mockMvc.perform(MockMvcRequestBuilders.post("/propostas").content(json(new CriaNovaPropostaRequest("34242343","aloo@gmail.com","alonso","onde?", BigDecimal.valueOf(1000d))))
       // 		.contentType(APPLICATION_JSON))
        //		.andExpect(ResponseEntity.status().isCreated());
    }

    //String json(CriaNovaPropostaRequest request) throws JsonProcessingException{
    //    return jsonMapper.writeValueAsString(request);
    //}
}
