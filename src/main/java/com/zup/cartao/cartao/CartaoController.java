package com.zup.cartao.cartao;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;

import com.zup.cartao.cartao.CartaoRepository;
import com.zup.cartao.error.ErrorMessage;

@RestController
@RequestMapping("/api/cartoes")
public class CartaoController {

    private CartaoRepository cartaoRespository;

    public CartaoController(CartaoRepository cartaoRespository){
        this.cartaoRespository = cartaoRespository;
    }

    @PostMapping("/bloqueio/{id}")
    @Transactional
    public ResponseEntity<?> bloquear(@PathVariable("id") String id, HttpServletRequest request){
        Optional<Cartao> cartao = cartaoRespository.findById(id);

        if(cartao.isPresent()){
            if(cartao.get().getBloqueio().getBloqueio()==Bloqueio.SIM){
                ErrorMessage error = new ErrorMessage("Error","O cartão já está bloqueado");
                return ResponseEntity.unprocessableEntity().body(error);
            }
            BloqueioCartao bloqueio = new BloqueioCartao(Bloqueio.SIM);
            bloqueio.setId(request.getRemoteAddr());
            bloqueio.setUserAgent(request.getHeader("User-Agent"));
        }
        //ErrorMessage error = new ErrorMessage("Error","O cartão não existe");
        return ResponseEntity.notFound().build();
    }


}