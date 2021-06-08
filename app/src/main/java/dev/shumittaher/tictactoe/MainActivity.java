package dev.shumittaher.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private int gameStatus, playerOneScore, playerTwoScore;
    TextView showStat;
    Button [] buttons = new Button [9];
    int z=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        for (int x=1; x <= 3; x++ ) {

            for (int y=1; y <= 3; y++ ){

                String buttonTag = "r" + x + "c" + y;
                int resourceID  = getResources().getIdentifier(buttonTag,"id", getPackageName());
                buttons[z] = (Button) findViewById(resourceID);
                z++;

            }

        }

        showStat = findViewById(R.id.tvGameStat);
        gameStatus = 1 ;
        runGame();

        for (int z =0; z<9; z++ ){

            buttons[z].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.i("clicked", "button is clicked");
                }
            });



        }


    }

    public void runGame() {

        if (gameStatus == 1) {
            showStat.setText("Player One to Move");
            moveDetector();
        }

        if (gameStatus == 2) {
            showStat.setText("Player two to Move");
            moveDetector();
        }

    }

    public void moveDetector() {



        }
    }