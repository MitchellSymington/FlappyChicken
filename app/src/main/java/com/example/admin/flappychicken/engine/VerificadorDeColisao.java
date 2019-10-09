package com.example.admin.flappychicken.engine;

import com.example.admin.flappychicken.elements.Canos;
import com.example.admin.flappychicken.elements.Passaro;

/**
 * Created by admin on 28/10/17.
 */

class VerificadorDeColisao {
    private final Passaro passaro;
    private final Canos canos;

    public VerificadorDeColisao(Passaro passaro, Canos canos) {
        this.passaro = passaro;
        this.canos = canos;
    }

    public boolean temColisao() {
        return canos.temColisaoCom(passaro);
    }
}
