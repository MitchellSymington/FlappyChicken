package com.example.admin.flappychicken.elements;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Rect;

import com.example.admin.flappychicken.R;
import com.example.admin.flappychicken.graphic.Tela;

/**
 * Created by admin on 18/11/17.
 */

public class Tap {
    private final Tela tela;
    private final Bitmap tap;

    public Tap (Tela tela, Context context){
        this.tela = tela;
        Bitmap bp = BitmapFactory.decodeResource(context.getResources(), R.drawable.tap);
        this.tap = Bitmap.createScaledBitmap(bp, 300, 300, false);
    }

    public Tap desenhaNo (Canvas canvas){
        canvas.drawBitmap(tap, centralizaTao(), tela.getAltura() / 2, null);
        return null;
    }

    private int centralizaTao() {
        int centroHorizontal = tela.getLargura() / 3;
        return centroHorizontal;
    }

}
