package com.example.admin.flappychicken.elements;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;

import com.example.admin.flappychicken.engine.Som;
import com.example.admin.flappychicken.graphic.Cores;

import java.io.Serializable;

/**
 * Created by admin on 28/10/17.
 */

public class Pontuacao implements Serializable {

    private static final Paint BRANCO = Cores.getCorDaPontuacao();
    private final Som som;
    private int pontos = 0;

    public Pontuacao(Som som){
        this.som = som;
    }

    public void aumenta() {
        pontos++;
        som.toca(Som.PONTUACAO);
    }

    public int getPontos() {return pontos; }

    public void desenhaNo(Canvas canvas) {
        canvas.drawText(String.valueOf(pontos), 500, 200, BRANCO);
    }

}
