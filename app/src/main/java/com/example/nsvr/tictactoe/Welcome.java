package com.example.nsvr.tictactoe;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Welcome extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.welcome);

        final EditText pX = (EditText) findViewById(R.id.pX);
        final EditText pO = (EditText) findViewById(R.id.pO);

        Button playB = (Button) findViewById(R.id.playB);

        playB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String PlayerX = "" + pX.getText().toString();
                String PlayerO = "" + pO.getText().toString();

                Intent intent = new Intent(Welcome.this, Game.class);

                intent.putExtra("PlayerX", PlayerX);
                intent.putExtra("PlayerO", PlayerO);

                startActivity(intent);

            }
        });
    }
}