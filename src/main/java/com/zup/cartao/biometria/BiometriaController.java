package com.zup.cartao.biometria;

import java.net.URI;
import java.util.Base64;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import javax.validation.Valid;

import com.zup.cartao.cartao.Cartao;
import com.zup.cartao.error.ErrorMessage;
import com.zup.cartao.proposta.PropostaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping("/biometrias")
public class BiometriaController {
    
    @Autowired
    private EntityManager entityManager;

    @PostMapping("/{id}")
    @Transactional
    public ResponseEntity<?> associaBiometria(@PathVariable String id, @RequestBody @Valid  BiometriaRequest request){
        Biometria biometria = request.toModel();
        Cartao cartao = entityManager.find(Cartao.class,id);
        if(cartao == null){
            return ResponseEntity.notFound().build();
        }else{
            try{
                Base64.getDecoder().decode(biometria.getBiometria());
            }catch(Exception e){
                ErrorMessage error = new ErrorMessage("Error","Biometria Invalida");
                return ResponseEntity.badRequest().body(error);
            }
        }

        cartao.setBiometria(biometria);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(id).toUri();
        return ResponseEntity.created(uri).body(request);

    }
}
