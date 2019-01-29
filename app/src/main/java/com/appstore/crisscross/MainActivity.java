package com.appstore.crisscross;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int switchUser, clicked[];
    boolean win;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        switchUser = 1;
        win = false;
        clicked = new int[9];
        for(int i=0; i<6; i++)
            clicked[i] = 0;
        ((TextView)findViewById(R.id.text)).setText("Turn: Player "+switchUser);
    }

    public void onTap(View view) {
        ImageView image = (ImageView)view;
        switch (image.getId()) {
            case R.id.i00:
                if(clicked[0]==0)
                    clicked[0] = switchUser;
                else return;
                break;
            case R.id.i01:
                if(clicked[1]==0)
                    clicked[1] = switchUser;
                else return;
                break;
            case R.id.i02:
                if(clicked[2]==0)
                    clicked[2] = switchUser;
                else return;
                break;
            case R.id.i10:
                if(clicked[3]==0)
                    clicked[3] = switchUser;
                else return;
                break;
            case R.id.i11:
                if(clicked[4]==0)
                    clicked[4] = switchUser;
                else return;
                break;
            case R.id.i12:
                if(clicked[5]==0)
                    clicked[5] = switchUser;
                else return;
                break;
            case R.id.i20:
                if(clicked[6]==0)
                    clicked[6] = switchUser;
                else return;
                break;
            case R.id.i21:
                if(clicked[7]==0)
                    clicked[7] = switchUser;
                else return;
                break;
            default:
                if(clicked[8]==0)
                    clicked[8] = switchUser;
                else return;
                break;
        }
        if(switchUser==1) {
            image.setImageResource(R.drawable.blue);
        }
        else {
            image.setImageResource(R.drawable.green);
        }
        win = hasWon();
        if(win) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("Game over").setMessage("Player "+switchUser+" won").setPositiveButton("Play again", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    finish();
                    startActivity(getIntent());
                }
            }).setNegativeButton("Quit", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    finish();
                }
            });
            builder.show();
        }
        switchUser = switchUser%2 + 1;
        ((TextView)findViewById(R.id.text)).setText("Turn: Player "+switchUser);
    }

    private boolean hasWon() {
        if((clicked[0]==1 && clicked[1]==1 && clicked[2]==1) || (clicked[0]==2 && clicked[1]==2 && clicked[2]==2))
            return true;
        else if((clicked[3]==1 && clicked[4]==1 && clicked[5]==1) || (clicked[3]==2 && clicked[4]==2 && clicked[5]==2))
            return true;
        else if((clicked[6]==1 && clicked[7]==1 && clicked[8]==1) || (clicked[6]==2 && clicked[7]==2 && clicked[8]==2))
            return true;
        else if((clicked[0]==1 && clicked[3]==1 && clicked[6]==1) || (clicked[0]==2 && clicked[3]==2 && clicked[6]==2))
            return true;
        else if((clicked[1]==1 && clicked[4]==1 && clicked[7]==1) || (clicked[1]==2 && clicked[4]==2 && clicked[7]==2))
            return true;
        else if((clicked[2]==1 && clicked[5]==1 && clicked[8]==1) || (clicked[2]==2 && clicked[5]==2 && clicked[8]==2))
            return true;
        else if((clicked[0]==1 && clicked[4]==1 && clicked[8]==1) || (clicked[0]==2 && clicked[4]==2 && clicked[8]==2))
            return true;
        else if((clicked[2]==1 && clicked[4]==1 && clicked[6]==1) || (clicked[2]==2 && clicked[4]==2 && clicked[6]==2))
            return true;
        else
            return false;
    }

    public void reset(View view) {
        finish();
        startActivity(getIntent());
    }

    public void quit(View view) {
        finish();
    }
}
