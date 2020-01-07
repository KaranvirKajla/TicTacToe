package com.example.tictactoe;

import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.logging.XMLFormatter;

public class MainActivity extends AppCompatActivity {
    //ImageView imageView;
    ConstraintLayout constraintLayout;
    boolean gameActive = true;

    // 0-X
    //1-O
    int activePlayer=0;
    int[] gameState ={2,2,2,2,2,2,2,2,2};
    //State meanings
//    0 - X
//    1-O
//    2 - NULL
    int [][ ] winPositions={{0,1,2},{3,4,5},{6,7,8},{0,3,6},
            {1,4,7},{2,5,8},{0,4,8},{2,4,6}};
    public void playerTap(View view){

        int i;
        for(i=0;i<gameState.length;i++){
            if(gameState[i]==2){break;}
        }
        if(i==gameState.length){
            for(i=0;i<gameState.length;i++){
               gameState[i]=2;
            }

            ((ImageView )findViewById(R.id.imageView0)).setImageResource(0);
            ((ImageView )findViewById(R.id.imageView1)).setImageResource(0);
            ((ImageView )findViewById(R.id.imageView2)).setImageResource(0);
            ((ImageView )findViewById(R.id.imageView3)).setImageResource(0);
            ((ImageView )findViewById(R.id.imageView5)).setImageResource(0);
            ((ImageView )findViewById(R.id.imageView4)).setImageResource(0);
            ((ImageView )findViewById(R.id.imageView6)).setImageResource(0);
            ((ImageView )findViewById(R.id.imageView7)).setImageResource(0);
            ((ImageView )findViewById(R.id.imageView8)).setImageResource(0);

        }
        ImageView img = (ImageView) view;
        int tappedImage = Integer.parseInt(img.getTag().toString());
        if(!gameActive){gameReset(view);}
        if(gameState[tappedImage]==2 && gameActive){
            gameState[tappedImage]=activePlayer;
            img.setTranslationY(-1000f);
            if(activePlayer==0){
                img.setImageResource(R.drawable.x2);
                activePlayer=1;
                TextView status = findViewById(R.id.status);
                status.setText("O's Turn");
            }else{
                img.setImageResource(R.drawable.o2);
                activePlayer=0;
                TextView status = findViewById(R.id.status);
                status.setText("X's Turn");
            }
            img.animate().translationYBy(1000f).setDuration(300);
        }
        //Check if any player has won
        for(int[] winPosition : winPositions){
            if(gameState[winPosition[0]]==gameState[winPosition[1]]
                    && gameState[winPosition[1]]==gameState[winPosition[2]]&&gameState[winPosition[2]]!=2){
                String winnerStr;
                gameActive=false;
                if(gameState[winPosition[0]]==0){
                    winnerStr = "X has won";
                }
                else{
                    winnerStr="O has won";
                }
                TextView status = findViewById(R.id.status);
                status.setText(winnerStr);

            }
        }

    }
    public  void gameReset(View view){


        gameActive=true;
        activePlayer=0;
        for(int i=0;i<gameState.length;i++){
            gameState[i]=2;
        }
        ((ImageView )findViewById(R.id.imageView0)).setImageResource(0);
        ((ImageView )findViewById(R.id.imageView1)).setImageResource(0);
        ((ImageView )findViewById(R.id.imageView2)).setImageResource(0);
        ((ImageView )findViewById(R.id.imageView3)).setImageResource(0);
        ((ImageView )findViewById(R.id.imageView4)).setImageResource(0);
        ((ImageView )findViewById(R.id.imageView5)).setImageResource(0);
        ((ImageView )findViewById(R.id.imageView6)).setImageResource(0);
        ((ImageView )findViewById(R.id.imageView7)).setImageResource(0);
        ((ImageView )findViewById(R.id.imageView8)).setImageResource(0);




    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
