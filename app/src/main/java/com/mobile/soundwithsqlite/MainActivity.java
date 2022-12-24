package com.mobile.soundwithsqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import java.util.StringTokenizer;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    Button btn_sound1, btn_sound2, btn_sound3, btn_sound4;
    Button btn_sound5, btn_sound6, btn_sound7, btn_sound8;
    Button btn_dec, btn_decPlay;
    Button btn_save, btn_select;
    EditText et_date, et_num;
    TextView viewResult;
    // DBHelper
    DBHelper dbHelper;
    TimerTask timerTask1, timerTask2, timerTask3, timerTask4;
    TimerTask timerTask5, timerTask6, timerTask7, timerTask8;
    Timer timer = new Timer();;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // 디자인 매핑
        setContentView(R.layout.activity_main);

        // Control 매핑
        btn_sound1 = (Button) findViewById(R.id.btn_sound1);
        btn_sound2 = (Button) findViewById(R.id.btn_sound2);
        btn_sound3 = (Button) findViewById(R.id.btn_sound3);
        btn_sound4 = (Button) findViewById(R.id.btn_sound4);
        btn_sound5 = (Button) findViewById(R.id.btn_sound5);
        btn_sound6 = (Button) findViewById(R.id.btn_sound6);
        btn_sound7 = (Button) findViewById(R.id.btn_sound7);
        btn_sound8 = (Button) findViewById(R.id.btn_sound8);
        btn_save = (Button) findViewById(R.id.btn_save);
        btn_select = (Button) findViewById(R.id.btn_select);
        et_date = (EditText) findViewById(R.id.et_date);
        et_num = (EditText) findViewById(R.id.et_num);
        viewResult = (TextView) findViewById(R.id.ViewResult);
        btn_dec = (Button) findViewById(R.id.btn_dec);
        btn_decPlay = (Button) findViewById(R.id.btn_decPlay);

        // 버튼 클릭 이벤트 정의
        btn_save.setOnClickListener(this);
        btn_select.setOnClickListener(this);
        btn_dec.setOnClickListener(this);

        dbHelper = new DBHelper(MainActivity.this, 1);

        MediaPlayer mediaPlayer1 = MediaPlayer.create(this, R.raw.sound1);
        MediaPlayer mediaPlayer2 = MediaPlayer.create(this, R.raw.sound2);
        MediaPlayer mediaPlayer3 = MediaPlayer.create(this, R.raw.sound3);
        MediaPlayer mediaPlayer4 = MediaPlayer.create(this, R.raw.sound4);
        MediaPlayer mediaPlayer5 = MediaPlayer.create(this, R.raw.sound5);
        MediaPlayer mediaPlayer6 = MediaPlayer.create(this, R.raw.sound6);
        MediaPlayer mediaPlayer7 = MediaPlayer.create(this, R.raw.sound7);
        MediaPlayer mediaPlayer8 = MediaPlayer.create(this, R.raw.sound8);

        btn_sound1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayer1.start();
            }
        });
        btn_sound2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayer2.start();
            }
        });
        btn_sound3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayer3.start();
            }
        });
        btn_sound4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayer4.start();
            }
        });
        btn_sound5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayer5.start();
            }
        });
        btn_sound6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayer6.start();
            }
        });
        btn_sound7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayer7.start();
            }
        });
        btn_sound8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayer8.start();
            }
        });

        btn_decPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                timerTask1 = new TimerTask() {
                    @Override
                    public void run() {
                        mediaPlayer1.start();
                    }
                };
                timerTask2 = new TimerTask() {
                    @Override
                    public void run() {
                        mediaPlayer2.start();
                    }
                };
                timerTask3 = new TimerTask() {
                    @Override
                    public void run() {
                        mediaPlayer3.start();
                    }
                };
                timerTask4 = new TimerTask() {
                    @Override
                    public void run() {
                        mediaPlayer4.start();
                    }
                };
                timerTask5 = new TimerTask() {
                    @Override
                    public void run() {
                        mediaPlayer5.start();
                    }
                };
                timerTask6 = new TimerTask() {
                    @Override
                    public void run() {
                        mediaPlayer6.start();
                    }
                };
                timerTask7 = new TimerTask() {
                    @Override
                    public void run() {
                        mediaPlayer7.start();
                    }
                };
                timerTask8 = new TimerTask() {
                    @Override
                    public void run() {
                        mediaPlayer8.start();
                    }
                };

                String decNum = (String) dbHelper.getResultDec();
                String[] array = decNum.split("-");
                for(int i=0; i<array.length; i++){
                    if (array[i].equals("1")){
                        timer.schedule(timerTask1,3000);
                        /*mediaPlayer1.start(); */}
                    else if (array[i].equals("2")){
                        timer.schedule(timerTask2,3000);
                        /*mediaPlayer2.start();*/ }
                    else if (array[i].equals("3")){
                        timer.schedule(timerTask3,3000);
                        /*mediaPlayer3.start();*/ }
                    else if (array[i].equals("4")){
                        timer.schedule(timerTask4,3000);
                        /*mediaPlayer4.start();*/ }
                    else if (array[i].equals("5")){
                        timer.schedule(timerTask5,3000);
                        /*mediaPlayer5.start();*/ }
                    else if (array[i].equals("6")){
                        timer.schedule(timerTask6,3000);
                        /*mediaPlayer6.start();*/ }
                    else if (array[i].equals("7")){
                        timer.schedule(timerTask7,3000);
                        /*mediaPlayer7.start();*/ }
                    else {
                        timer.schedule(timerTask8,3000);
                        /*mediaPlayer8.start();*/ }
                }
            }

        });

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_save:
                dbHelper.insert(Integer.parseInt(et_date.getText().toString()), Integer.parseInt(et_num.getText().toString()));
                break;
            case R.id.btn_select:
                viewResult.setText(dbHelper.getResult());
                break;
            case R.id.btn_dec:
                viewResult.setText(dbHelper.getResultDec());
                break;
        }
    }

}