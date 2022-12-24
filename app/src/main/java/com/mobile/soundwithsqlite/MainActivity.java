package com.mobile.soundwithsqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.provider.SyncStateContract;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.json.JSONArray;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
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

    StringTokenizer st;
    StringBuilder sb;
    String[] printSound;

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
                String decNum = (String) dbHelper.getResultDec();
                String[] array = decNum.split("-");
                for(int i=0; i<array.length; i++){
                    viewResult.setText(array[i]);
                    /*private Handler handler = new Handler();*/
                    new Timer().schedule(new TimerTask() {
                        public void run() {
                            // UI 및 로직
                        }
                    }, 1000); // 1초후 실행

                    if (array[i].equals("1")){ mediaPlayer1.start(); }
                    else if (array[i].equals("2")){ mediaPlayer2.start(); }
                    else if (array[i].equals("3")){ mediaPlayer3.start(); }
                    else if (array[i].equals("4")){ mediaPlayer4.start(); }
                    else if (array[i].equals("5")){ mediaPlayer5.start(); }
                    else if (array[i].equals("6")){ mediaPlayer6.start(); }
                    else if (array[i].equals("7")){ mediaPlayer7.start(); }
                    else { mediaPlayer8.start(); }
                }

                /*String[] array = decNum.split("-");
                ArrayList<String> arrData = new ArrayList<String>();
                Collections.addAll(arrData, array);
                for(int i=0;i<arrData.size();i++) {
                    viewResult.setText(arrData.indexOf(i));
                    if(arrData.get(0).equals(1)){
                        mediaPlayer1.start();
                    }
                    else if(array[i].equals(2)){
                        mediaPlayer2.start();
                    }
                    else if(array[i].equals(3)){
                        mediaPlayer3.start();
                    }
                    else if(array[i].equals(4)){
                        mediaPlayer4.start();
                    }
                    else if(array[i].equals(5)){
                        mediaPlayer5.start();
                    }
                    else if(array[i].equals(6)){
                        mediaPlayer6.start();
                    }
                    else if(array[i].equals(7)){
                        mediaPlayer7.start();
                    }
                    else
                        mediaPlayer8.start();*/
                /*}*/
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
            /*case R.id.btn_decPlay:

                String DecNum = dbHelper.getResultDec();*/

            /*    String DecNum = (String) dbHelper.getResultDec();

                sb = new StringBuilder();
                st = new StringTokenizer(DecNum,"-");

                printSound = new String[st.countTokens()];

                    int i = 0;

            String[] result = printSound[i];
            for (int x=0; x<result.length; x++)
                System.out.println(result[x]);

                    //뭉텅이로 붙여진 거 하나씩 떼는 반복문
                    while(st.hasMoreTokens()){
                        printSound[i] = st.nextToken();
                        String tokenI = (printSound[i]);

                        i++;

                        viewResult.setText(printSound[i]);

                        //찾는 음계가 있는지 검색하는 반복문, 인덱스를 얻었으므로 그 인덱스에 걸리는 애들만 찾으면 됨.
                        for(i=0; i<tokenI.length(); i++){
                            if(tokenI.equals(1)){
                                mediaPlayer = MediaPlayer.create(this, R.raw.sound1);
                                mediaPlayer.start();
                            }
                            else if(tokenI.equals(2)){
                                mediaPlayer = MediaPlayer.create(this, R.raw.sound2);
                                mediaPlayer.start();
                            }
                            else if(tokenI.equals(3)){
                                mediaPlayer = MediaPlayer.create(this, R.raw.sound3);
                                mediaPlayer.start();
                            }
                            else if(tokenI.equals(4)){
                                mediaPlayer = MediaPlayer.create(this, R.raw.sound4);
                                mediaPlayer.start();
                            }
                            else if(tokenI.equals(5)){
                                mediaPlayer = MediaPlayer.create(this, R.raw.sound5);
                                mediaPlayer.start();
                            }
                            else if(tokenI.equals(6)){
                                mediaPlayer = MediaPlayer.create(this, R.raw.sound6);
                                mediaPlayer.start();
                            }
                            else if(tokenI.equals(7)){
                                mediaPlayer = MediaPlayer.create(this, R.raw.sound7);
                                mediaPlayer.start();
                            }
                            else
                                mediaPlayer = MediaPlayer.create(this, R.raw.sound8);
                                mediaPlayer.start();
                        }

                    }
                break;*/
        }
    }

}