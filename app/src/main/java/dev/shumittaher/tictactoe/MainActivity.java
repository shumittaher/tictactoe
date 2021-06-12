package dev.shumittaher.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView showStat;
    Button [] buttons = new Button [9];
    int z=0;
    Players player1 = new Players(1);
    Players player2 = new Players(2);
    Players activePlayer;

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
        activePlayer = player1;
        updateGameStat();



        for (int z =0; z<9; z++ ){

            buttons[z].setOnClickListener(this);

        }

    }

    private void changeGameStat() {

        if (activePlayer == player2) {
            activePlayer = player1;
            updateGameStat();
        }

        if (activePlayer == player1) {
            activePlayer = player2;
            updateGameStat();        }

    }

    public void updateGameStat() {

        if (activePlayer == player1) {
            showStat.setText("Player One to Move");
        }

        if (activePlayer == player2) {
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
                activePlayer.x1++;
                if (y==1) {activePlayer.z1++;}
                if (y==3) {activePlayer.z2++;}

            case 2:
                activePlayer.x2++;
                if (y==2) {
                    activePlayer.z1++;
                    activePlayer.z2++;
                }

            case 3:
                activePlayer.x3++;
                if (y==3) {activePlayer.z1++;}
                if (y==1) {activePlayer.z2++;}

        };
        switch (y) {

            case 1:
                activePlayer.y1++;

            case 2:
                activePlayer.y2++;

            case 3:
                activePlayer.y3++;

        };

        winConditionChecker();
        changeGameStat();



    }

    private void winConditionChecker() {

        if (activePlayer.x1 == 3) {

        }

    }


}