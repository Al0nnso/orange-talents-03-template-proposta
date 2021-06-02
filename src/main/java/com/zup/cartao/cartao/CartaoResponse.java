package com.zup.cartao.cartao;

public class CartaoResponse {
    private String id;

    @Deprecated
    public CartaoResponse() {
    }

    public CartaoResponse(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }
}