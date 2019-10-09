package com.example.admin.flappychicken;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.admin.flappychicken.elements.Pontuacao;

public class GameOverActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_over);
        TextView score = (TextView) findViewById(R.id.tv_score);
        Intent intent = getIntent();

        int pontos = (int) intent.getSerializableExtra("pontos");
        score.setText("SCORE:" + pontos);

        Button bt_game_over = (Button)findViewById(R.id.game_over_button);
        bt_game_over.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentJogarDeNovo = new Intent(GameOverActivity.this,MainActivity.class);
                startActivity(intentJogarDeNovo);
            }
        });
    }


}
