package dev.shumittaher.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

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
        updateGameStat(gameStatus);

        for (int z =0; z<9; z++ ){

            buttons[z].setOnClickListener(this);

        }

    }

    public void updateGameStat(int gameStatus) {

        if (gameStatus == 1) {
            showStat.setText("Player One to Move");
        }

        if (gameStatus == 2) {
            showStat.setText("Player two to Move");
        }

    }


    @Override
    public void onClick(View v) {

        Button button = (Button)v;

        int x = button.getResources().getResourceEntryName(button.getId()).charAt(1) - 48;
        int y = button.getResources().getResourceEntryName(button.getId()).charAt(3) - 48;

        switch (x) {

            case 1:
                new Players(gameStatus).x1++;

            case 2:
                new Players(gameStatus).x2++;

            case 3:
                new Players(gameStatus).x3++;

        };


        Log.i("status","_" + x);

        Log.i("status","_" + new Players(gameStatus).x1);

    }
}