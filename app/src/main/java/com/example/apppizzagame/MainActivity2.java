package com.example.apppizzagame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity implements View.OnClickListener {
    ImageView ivWin;
    TextView tvWin;
    Button btnStartW;
    MediaPlayer mp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        ivWin = (ImageView)findViewById(R.id.ivWin);
        tvWin = (TextView)findViewById(R.id.tvWin);
        mp = MediaPlayer.create(this,R.raw.win);
        mp.start();
        btnStartW = (Button)findViewById(R.id.btnStartW);
        btnStartW.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnStartW:
                Intent intent=new Intent(this,MainActivity.class);
                startActivity(intent);
                break;
        }
    }
    @Override
    protected void onStop() {
        super.onStop();
        if (mp.isPlaying()) {
            mp.stop();
        }
        mp.release();

    }


}