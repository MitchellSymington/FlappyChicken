package com.example.admin.flappychicken.elements;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;

import com.example.admin.flappychicken.R;
import com.example.admin.flappychicken.engine.Som;
import com.example.admin.flappychicken.graphic.Cores;
import com.example.admin.flappychicken.graphic.Tela;

/**
 * Created by admin on 20/10/17.
 */

public class Passaro {

    private static final Paint vermelho = Cores.getCorDoPassaro();

    public static final int X = 180;//dobro do raio
    public static final int RAIO = 90;
    private final Bitmap passaro;
    private final Som som;
    private Tela tela;


    private int altura;

    public Passaro (Tela tela, Context context,Som som){
        this.som = som;
        this.tela = tela;
        this.altura = 100;
        Bitmap bp = BitmapFactory.decodeResource(context.getResources(), R.drawable.passaro);
        this.passaro = Bitmap.createScaledBitmap(bp, RAIO*2, RAIO*2 , false);
    }

    public void cai () {

        boolean chegouNoChao = altura + RAIO > tela.getAltura();
        if(!chegouNoChao) {
            this.altura += 13;
        }

    }

    public void pula (){
        if (altura > RAIO){
            som.toca(Som.PULO);
            this.altura -= 200;
        }
    }

    public void desenhaNo (Canvas canvas){
        canvas.drawBitmap(passaro, X-RAIO, altura-RAIO, null);
    }

    public int getAltura() {
        return this.altura;
    }
}
