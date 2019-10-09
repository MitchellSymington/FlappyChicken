package com.example.admin.flappychicken;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;

public class TelaInicialActivity extends AppCompatActivity implements View.OnTouchListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_inicial);


        Button botaoStar = (Button)findViewById(R.id.tela_inicial_button);
        botaoStar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentStartJogo = new Intent(TelaInicialActivity.this,MainActivity.class);
                startActivity(intentStartJogo);
            }
        });

    }



    public void onTouch(){
        Intent intentStartJogo = new Intent(TelaInicialActivity.this,MainActivity.class);
        startActivity(intentStartJogo);
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        Intent intentStartJogo = new Intent(TelaInicialActivity.this,MainActivity.class);
        startActivity(intentStartJogo);
        return false;
    }
}
