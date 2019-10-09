package com.example.admin.flappychicken.engine;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;

import com.example.admin.flappychicken.GameOverActivity;
import com.example.admin.flappychicken.elements.Canos;
import com.example.admin.flappychicken.elements.GameOver;
import com.example.admin.flappychicken.elements.Passaro;
import com.example.admin.flappychicken.R;
import com.example.admin.flappychicken.elements.Pontuacao;
import com.example.admin.flappychicken.elements.Tap;
import com.example.admin.flappychicken.graphic.Tela;

/**
 * Created by admin on 19/10/17.
 */

public class Game extends SurfaceView implements Runnable, View.OnTouchListener {

    private final Som som;
    private boolean isRunning = false;
    private boolean isOver = true;
    private final SurfaceHolder holder = getHolder();
    private Passaro passaro;
    private Canos canos;
    private Bitmap backGround;
    private Tela tela;
    private Context context;
    private Pontuacao pontuacao;
    private Tap tap;

    public Game(Context context) {
        super(context);
        //tela = new Tela(context);
        this.context = context;
        som = new Som(context);
        novoGame(context);
        //inicializaElementos();
        setOnTouchListener(this);
    }

    public void novoGame (Context context){
        tela = new Tela(context);
        inicializaElementos();
    }

    @Override
    public void run() {

        while(isRunning) {
            if(!holder.getSurface().isValid()) continue;
            Canvas canvas = holder.lockCanvas();
            canvas.drawBitmap(backGround, 0, 0, null);
            passaro.desenhaNo(canvas);

            canos.desenhaNo(canvas);
            pontuacao.desenhaNo(canvas);

            if (!isOver){
                passaro.cai();
                canos.move(tela);
            }
            else {
                tap.desenhaNo(canvas);
            }

            if(new VerificadorDeColisao(passaro, canos).temColisao()) {
                Intent intent = new Intent(context,GameOverActivity.class);
                som.toca(Som.COLISAO);
                int pontos = pontuacao.getPontos();
                intent.putExtra("pontos",pontos);
                context.startActivity(intent);
                new GameOver(tela).desenhaNo(canvas);
                isRunning = false;
                isOver = true;
            }

            holder.unlockCanvasAndPost(canvas);
        }
    }

    public void inicializaElementos(){
        tap = new Tap(tela,context);
        pontuacao = new Pontuacao(som);
        passaro = new Passaro(tela, context,som);
        this.canos = new Canos(tela,pontuacao, context);
        Bitmap back = BitmapFactory.decodeResource(getResources(), R.drawable.background);
        backGround = Bitmap.createScaledBitmap(back,back.getWidth(), tela.getAltura(),false);
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        if (isRunning) isOver = false;
        passaro.pula();
        return false;
    }

    public void pause() {
        isRunning = false;
    }

    public void inicia() { isRunning = true; }
}
