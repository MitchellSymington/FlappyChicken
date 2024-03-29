package com.example.admin.flappychicken.engine;

import android.content.Context;
import android.media.AudioManager;
import android.media.SoundPool;

import com.example.admin.flappychicken.R;

/**
 * Created by admin on 10/12/2017.
 */

public class Som {
    private final SoundPool soundPool;
    public static int PULO;
    public static int COLISAO;
    public static int PONTUACAO;

    public Som (Context context){
        soundPool = new SoundPool(3, AudioManager.STREAM_MUSIC, 0);
        PULO = soundPool.load(context, R.raw.pulo, 1);
        COLISAO = soundPool.load(context, R.raw.colisao, 1);
        PONTUACAO = soundPool.load(context, R.raw.pontos, 1);
    }

    public void toca(int som){
        soundPool.play(som, 1, 1, 1, 0, 1);
    }

}
