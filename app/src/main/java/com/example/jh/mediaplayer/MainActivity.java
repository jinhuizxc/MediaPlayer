package com.example.jh.mediaplayer;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.io.IOException;

/**
 * https://lcadream.oss-cn-shanghai.aliyuncs.com/yinpin/70690899.mp3
 */
public class MainActivity extends AppCompatActivity {


    String url = "https://lcadream.oss-cn-shanghai.aliyuncs.com/yinpin/70690899.mp3";

    Button bt_play, bt_stop, bt_reset;
    MediaPlayer mediaPlayer = new MediaPlayer();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bt_play = findViewById(R.id.bt_play);
        bt_stop = findViewById(R.id.bt_stop);
        bt_reset = findViewById(R.id.bt_reset);

        bt_play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    mediaPlayer.reset();
                    mediaPlayer.setDataSource(url);
                    mediaPlayer.prepare();
                    mediaPlayer.start();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        });

        bt_stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mediaPlayer.isPlaying()) {
                    mediaPlayer.stop();
                }
            }
        });

        bt_reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mediaPlayer.isLooping()) {
                    mediaPlayer.release();
                    mediaPlayer.reset();
                }
            }
        });

    }
}
