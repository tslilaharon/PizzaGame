package com.example.apppizzagame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private int[] buttons = {0, R.id.ib1, R.id.ib2, R.id.ib3, R.id.ib4, R.id.ib5, R.id.ib6, R.id.ib7, R.id.ib8, R.id.ib9};
    TextView tvTittle;
    TextView tvCounterE;
    TextView tvCounterP;
    TextView tvEnum;
    TextView tvPnum;
    public int counterpizza = 0;
    public int counternopizza=0;
    public ImageButton btn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvTittle = (TextView) findViewById(R.id.tvTittle);
        tvPnum = (TextView) findViewById(R.id.tvPnum);
        tvEnum = (TextView) findViewById(R.id.tvEnum);
        tvCounterE = (TextView) findViewById(R.id.tvCounterE);
        tvCounterP = (TextView) findViewById(R.id.tvCounterP);

        for (int i = 1; i <= 9; i++) {
            ImageButton btn = (ImageButton)findViewById(buttons[i]);
            btn.setOnClickListener(this);
        }
    }

    @Override
    public void onClick(View v) {
        for (int i=1 ; i <= 9 ; i++) {
            if (v.getId() == buttons[i]) {
                int r =handleButton(i);    // i is the button number
                if(r == 0)
                {
                    counterpizza++;
                    String number1 = String.valueOf(counterpizza);
                    tvPnum.setText(number1);
                    for (int j = 1 ; j<=9 ; j++ )
                    {
                        btn = (ImageButton)findViewById(buttons[j]);
                        btn.setImageResource(R.drawable.tray);

                    }
                    btn = (ImageButton)findViewById(buttons[i]);
                    btn.setImageResource(R.drawable.pizza);
                }
                if(r == 1)
                {

                    counternopizza++;
                    String number = String.valueOf(counternopizza);
                    tvEnum.setText(number);
                    ImageButton btn = (ImageButton)findViewById(buttons[i]);
                    for (int j = 1 ; j<=9 ; j++ )
                    {
                        btn = (ImageButton)findViewById(buttons[j]);
                        btn.setImageResource(R.drawable.tray);
                    }

                }
            }
        }
        if(counternopizza == 100)
        {
            counterpizza=0;
            counternopizza=0;
            Intent intent = new Intent(this,MainActivity3.class);
            startActivity(intent);
        }
        if(counterpizza == 10)
        {
            counternopizza=0;
            counterpizza=0;

            Intent intent = new Intent(this,MainActivity2.class);
            startActivity(intent);
        }
    }

    private int handleButton(int i) {
        int YNpizza = Random1(i);

        return YNpizza;

    }

    public int Random1 (int i)
    {
        int seed;

        Random rnd = new Random();
        seed = rnd.nextInt(9);
        if(seed == i)
        {
            return 0;
        }
        else
        {
            return 1;

        }
    }

}