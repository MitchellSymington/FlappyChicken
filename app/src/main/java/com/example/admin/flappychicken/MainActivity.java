package com.example.admin.flappychicken;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.FrameLayout;

import com.example.admin.flappychicken.engine.Game;

public class MainActivity extends AppCompatActivity {

    private Game game;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        novoJogo();
    }

    @Override
    protected void onPause() {
        super.onPause();
        game.pause();
    }

    @Override
    protected void onResume() {
        super.onResume();
        game.inicia();
        new Thread(game).start();
    }

    protected  void novoJogo(){
        FrameLayout container = (FrameLayout) findViewById(R.id.container);
        game = new Game(this);
        container.addView(game);
    }
}
