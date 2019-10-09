package com.example.admin.flappychicken.elements;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;

import com.example.admin.flappychicken.R;
import com.example.admin.flappychicken.graphic.Cores;
import com.example.admin.flappychicken.graphic.Tela;

/**
 * Created by admin on 23/10/17.
 */

public class Cano {

    private static final Paint verde = Cores.getCorDoCano();

    private static final int TAMANHO_DO_CANO = 200;
    private static final int LARGURA_DO_CANO = 200;
    private final Bitmap canoInferior;
    private final Bitmap canoSuperior;
    private int alturaDoCanoInferior;
    private int alturaDoCanoSuperior;
    private Tela tela;
    private int posicao;

    public Cano(Tela tela, int posicao, Context context){
        this.tela = tela;
        this.posicao = posicao;
        this.alturaDoCanoInferior = tela.getAltura() - TAMANHO_DO_CANO - valorAleatorio();
        this.alturaDoCanoSuperior = 0 + TAMANHO_DO_CANO + valorAleatorio();
        Bitmap bp = BitmapFactory.decodeResource(context.getResources(), R.drawable.cano);
        this.canoInferior = Bitmap.createScaledBitmap(bp,LARGURA_DO_CANO,alturaDoCanoInferior,false);
        this.canoSuperior = Bitmap.createScaledBitmap(bp, LARGURA_DO_CANO, this.alturaDoCanoSuperior, false);

    }

    private int valorAleatorio() {
        return (int) (Math.random() * 600);
    }

    public void desenhaNo(Canvas canvas) {
        desenhaCanoSuperior(canvas);
        desenhaCanoInferior(canvas);
    }

    private void desenhaCanoInferior(Canvas canvas) {
        canvas.drawBitmap(canoInferior,posicao,alturaDoCanoInferior,null);
    }

    private void desenhaCanoSuperior(Canvas canvas) {
        canvas.drawRect(posicao, alturaDoCanoInferior, posicao + LARGURA_DO_CANO,tela.getAltura(), verde);
        canvas.drawBitmap(canoSuperior, posicao, 0, null);

    }

    public void move() {
        posicao -= 6;
    }

    public boolean saiuDaTela() {
        return posicao + LARGURA_DO_CANO < 0;
    }

    public int getPosicao() {
        return posicao;
    }

    public boolean temColisaoHorizontalCom(Passaro passaro) {
        return this.posicao - passaro.X < passaro.RAIO;
    }

    public boolean temColisaoVerticalCom(Passaro passaro) {
        return passaro.getAltura() - passaro.RAIO < this.alturaDoCanoSuperior
                || passaro.getAltura() + passaro.RAIO > this.alturaDoCanoInferior;

    }
}
