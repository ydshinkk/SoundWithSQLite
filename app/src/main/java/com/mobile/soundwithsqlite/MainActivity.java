package com.mobile.soundwithsqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.json.JSONArray;

import java.util.ArrayList;
import java.util.StringTokenizer;

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
        btn_decPlay.setOnClickListener(this);

        dbHelper = new DBHelper(MainActivity.this, 1);

        MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.sound1);

        btn_sound1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayer.start();
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
            case R.id.btn_decPlay:

                String DecNum = dbHelper.getResultDec();




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