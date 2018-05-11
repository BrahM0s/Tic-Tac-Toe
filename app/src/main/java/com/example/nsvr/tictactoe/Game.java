package com.example.nsvr.tictactoe;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Game extends AppCompatActivity implements View.OnClickListener{

    boolean playerX = true;
    int turnCount = 0;
    Button b00;
    Button b01;
    Button b02;
    Button b10;
    Button b11;
    Button b12;
    Button b20;
    Button b21;
    Button b22;
    Button resetB;
    int[][] position = new int[3][3];
    TextView display;
    String plX, plO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        Intent intent = getIntent();

        plX = intent.getStringExtra("PlayerX");
        plO = intent.getStringExtra("PlayerO");

        b00 = (Button) findViewById(R.id.b00);
        b01 = (Button) findViewById(R.id.b01);
        b02 = (Button) findViewById(R.id.b02);
        b10 = (Button) findViewById(R.id.b10);
        b11 = (Button) findViewById(R.id.b11);
        b12 = (Button) findViewById(R.id.b12);
        b20 = (Button) findViewById(R.id.b20);
        b21 = (Button) findViewById(R.id.b21);
        b22 = (Button) findViewById(R.id.b22);

        resetB = (Button) findViewById(R.id.resetB);
        display = (TextView) findViewById(R.id.display);

        b00.setOnClickListener(this);
        b01.setOnClickListener(this);
        b02.setOnClickListener(this);
        b10.setOnClickListener(this);
        b11.setOnClickListener(this);
        b12.setOnClickListener(this);
        b20.setOnClickListener(this);
        b21.setOnClickListener(this);
        b22.setOnClickListener(this);

        resetB.setOnClickListener(this);

        initializeGame();
    }

    @Override
    public void onClick(View view){
        boolean resetGame = false;
        switch(view.getId()){
            case R.id.b00:
                if(playerX){
                    b00.setText("X");
                    position[0][0]=1;
                } else{
                    b00.setText("O");
                    position[0][0]=0;
                }
                b00.setEnabled(false);
                break;
            case R.id.b01:
                if(playerX){
                    b01.setText("X");
                    position[0][1]=1;
                } else{
                    b01.setText("O");
                    position[0][1]=0;
                }
                b01.setEnabled(false);
                break;
            case R.id.b02:
                if(playerX){
                    b02.setText("X");
                    position[0][2]=1;
                } else{
                    b02.setText("O");
                    position[0][2]=0;
                }
                b02.setEnabled(false);
                break;
            case R.id.b10:
                if(playerX){
                    b10.setText("X");
                    position[1][0]=1;
                } else{
                    b10.setText("O");
                    position[1][0]=0;
                }
                b10.setEnabled(false);
                break;
            case R.id.b11:
                if(playerX){
                    b11.setText("X");
                    position[1][1]=1;
                } else{
                    b11.setText("O");
                    position[1][1]=0;
                }
                b11.setEnabled(false);
                break;
            case R.id.b12:
                if(playerX){
                    b12.setText("X");
                    position[1][2]=1;
                } else{
                    b12.setText("O");
                    position[1][2]=0;
                }
                b12.setEnabled(false);
                break;
            case R.id.b20:
                if(playerX){
                    b20.setText("X");
                    position[2][0]=1;
                } else{
                    b20.setText("O");
                    position[2][0]=0;
                }
                b20.setEnabled(false);
                break;
            case R.id.b21:
                if(playerX){
                    b21.setText("X");
                    position[2][1]=1;
                } else{
                    b21.setText("O");
                    position[2][1]=0;
                }
                b21.setEnabled(false);
                break;
            case R.id.b22:
                if(playerX){
                    b22.setText("X");
                    position[2][2]=1;
                } else{
                    b22.setText("O");
                    position[2][2]=0;
                }
                b22.setEnabled(false);
                break;
            case R.id.resetB:
                resetGame=true;
                break;

                default:
                    break;
        }

        if(resetGame){
            resetBoard();
        } else{
            turnCount++;
            playerX=!playerX;

            if(playerX){

                setInfo(plX + "'s Turn!");
            } else{
                setInfo(plO + "'s Turn!");
            }
            if(turnCount==9){
                gameResult("Draw!");
            }

            checkWinner();
        }
    }
    private void checkWinner(){

        for(int i=0;i<3;i++){
            if(position[i][0]==position[i][1] && position[i][0]==position[i][2]){
                if(position[i][0]==1)
                    gameResult(plX + " Wins!");
                else if(position[i][0]==0)
                    gameResult(plO + " Wins!");
            }
        }
        for(int i=0;i<3;i++){
            if(position[0][i]==position[1][i] && position[0][i]==position[2][i]){
                if(position[0][i]==1)
                    gameResult(plX + " Wins!");
                else if(position[0][i]==0)
                    gameResult(plO + " Wins!");
            }
        }
        if(position[0][0]==position[1][1] && position[0][0]==position[2][2]){
            if(position[0][0]==1)
                gameResult(plX + " Wins!");
            else if(position[0][0]==0)
                gameResult(plO +" Wins!");
        }
        if(position[0][2]==position[1][1] && position[0][2]==position[2][0]){
            if(position[0][2]==1)
                gameResult(plX + " Wins!");
            else if(position[0][2]==0)
                gameResult(plO + " Wins!");
        }
    }

    private void enableAll(boolean value){

        b00.setEnabled(value);
        b01.setEnabled(value);
        b02.setEnabled(value);

        b10.setEnabled(value);
        b11.setEnabled(value);
        b12.setEnabled(value);

        b20.setEnabled(value);
        b21.setEnabled(value);
        b22.setEnabled(value);
    }
    private void gameResult(String winner){

        setInfo(winner);
        enableAll(false);
    }
    private void resetBoard(){

        b00.setText("");
        b01.setText("");
        b02.setText("");

        b10.setText("");
        b11.setText("");
        b12.setText("");

        b20.setText("");
        b21.setText("");
        b22.setText("");

        enableAll(true);

        playerX = true;
        turnCount = 0;

        initializeGame();

        setInfo("New Game\n" + plX + "'s Turn!");

        Toast.makeText(this,"Board Reset", Toast.LENGTH_SHORT).show();
    }

    private void setInfo(String text){
        display.setText(text);
    }

    private void initializeGame(){
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                position[i][j] = -1;
            }
        }
        setInfo(plX + "'s Turn!");
    }
}
