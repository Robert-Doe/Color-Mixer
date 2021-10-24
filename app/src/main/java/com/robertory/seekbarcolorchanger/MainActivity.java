package com.robertory.seekbarcolorchanger;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    SeekBar sbRed,sbBlue,sbGreen;
    View viewColorBoard;
    int mBlueColor=128;
    int mGreenColor=128;
    int mRedColor=128;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sbRed=(SeekBar)findViewById(R.id.sbRed);

        sbBlue=(SeekBar)findViewById(R.id.sbBlue);

        sbGreen=(SeekBar)findViewById(R.id.sbGreen);
        viewColorBoard=findViewById(R.id.viewColorBoard);
        displayColour();

        sbRed.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress,
                                          boolean fromUser) {
                //Toast.makeText(getApplicationContext(),"seekbar progress: "+progress, Toast.LENGTH_SHORT).show();
                mRedColor=progress;
              //  viewColorBoard.setBackgroundColor(Color.rgb(mRedColor,mGreenColor,mBlueColor));
                displayColour();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                //Toast.makeText(getApplicationContext(),"seekbar touch started!", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                //.makeText(getApplicationContext(),"seekbar touch stopped!", Toast.LENGTH_SHORT).show();
            }
        });

        sbGreen.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress,
                                          boolean fromUser) {
                // Toast.makeText(getApplicationContext(),"seekbar progress: "+progress, Toast.LENGTH_SHORT).show();
                mGreenColor = progress;
                displayColour();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                //Toast.makeText(getApplicationContext(),"seekbar touch started!", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
               // Toast.makeText(getApplicationContext(),"seekbar touch stopped!", Toast.LENGTH_SHORT).show();
            }
        });

        sbBlue.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress,
                                          boolean fromUser) {
                mBlueColor=progress;
                displayColour();
                //viewColorBoard.setBackgroundColor(Color.rgb(mRedColor,mGreenColor,mBlueColor));
                //Toast.makeText(getApplicationContext(),"seekbar progress: "+progress, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
               // Toast.makeText(getApplicationContext(),"seekbar touch started!", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
               // Toast.makeText(getApplicationContext(),"seekbar touch stopped!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    void displayColour()
    {
        viewColorBoard.setBackgroundColor(Color.rgb(mRedColor,mGreenColor,mBlueColor));
        TextView tvColorCode=findViewById(R.id.textView);
        tvColorCode.setText(String.format("#%s%s%s",hex(mRedColor),hex(mGreenColor),hex(mBlueColor)));
    }

    String hex(int colour)
    {
       return String.format("%c%c",hexIndexer(colour/16),hexIndexer(colour%16));
    }

    char hexIndexer(int value)
    {
        switch (value)
        {
            case 10:
                return 'a';
            case 11:
                return 'b';
            case 12:
                return 'c';
            case 13:
                return 'd';
            case 14:
                return 'e';
            case 15:
                return 'f';
                default: return (char)(value%16+48);
        }
    }


}