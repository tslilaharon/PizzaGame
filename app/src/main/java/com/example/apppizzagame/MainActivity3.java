package com.example.apppizzagame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity3 extends AppCompatActivity implements View.OnClickListener {
    ImageView ivlose;
    TextView tvlose;
    Button btnStart1;
    MediaPlayer mp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        ivlose = (ImageView)findViewById(R.id.ivlose);
        tvlose = (TextView)findViewById(R.id.tvlose);
        mp = MediaPlayer.create(this,R.raw.lose);
        mp.start();
        btnStart1 = (Button)findViewById(R.id.btnStart1);
        btnStart1.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnStart1:
                Intent intent=new Intent(this, MainActivity.class);
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
