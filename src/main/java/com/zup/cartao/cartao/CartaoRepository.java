package com.zup.cartao.cartao;

import org.springframework.stereotype.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface CartaoRepository extends JpaRepository<Cartao,Long>{
    Optional<Cartao> findById(String id);
}