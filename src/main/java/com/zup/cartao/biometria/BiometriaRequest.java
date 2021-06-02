package com.zup.cartao.biometria;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class BiometriaRequest {

    @NotBlank @NotNull
    private String biometria;

    @Deprecated
    public BiometriaRequest() {
    }

    public BiometriaRequest(String biometria) {
        this.biometria = biometria;
    }

    public String getBiometria() {
        return this.biometria;
    }

    public void setBiometria(String biometria) {
        this.biometria = biometria;
    }

    public Biometria toModel() {
        return new Biometria(biometria);
    }

}
