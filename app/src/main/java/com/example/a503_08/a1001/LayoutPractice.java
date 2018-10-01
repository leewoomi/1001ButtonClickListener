package com.example.a503_08.a1001;

import android.content.DialogInterface;
import android.media.MediaPlayer;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Vibrator;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

public class LayoutPractice extends AppCompatActivity {

    private Button blue, green, red;
    private LinearLayout pageblue, pagegreen, pagered;


    Button btnvibrate, btnsystemsound, btnusersound;
    Button btntoast;

    Button btnbasicalert;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layout_practice);

        //layout에 만든 뷰 찾아오기
        blue = (Button)findViewById(R.id.blue);
        green = (Button)findViewById(R.id.green);
        red= (Button)findViewById(R.id.red);

        pageblue = (LinearLayout)findViewById(R.id.pageblue);
        pagegreen = (LinearLayout)findViewById(R.id.pagegreen);
        pagered=(LinearLayout)findViewById(R.id.pagered);


        btnvibrate = (Button)findViewById(R.id.btnvibrate);
        btnsystemsound = (Button)findViewById(R.id.btnsystemsound);
        btnusersound = (Button)findViewById(R.id.btnusersound);


        btntoast=(Button)findViewById(R.id.btntoast);

        btnbasicalert = (Button)findViewById(R.id.btnbasicalert);


        //blue를 클릭했을 때 처리
        blue.setOnClickListener(new Button.OnClickListener(){

            @Override
            public void onClick(View v) {
                pageblue.setVisibility(View.VISIBLE);
                pagegreen.setVisibility(View.INVISIBLE);
                pagered.setVisibility(View.INVISIBLE);
            }
        });



        //green을 클릭했을 때 처리
        green.setOnClickListener(new Button.OnClickListener(){

            @Override
            public void onClick(View v) {
                pageblue.setVisibility(View.INVISIBLE);
                pagegreen.setVisibility(View.VISIBLE);
                pagered.setVisibility(View.INVISIBLE);
            }
        });


        //red를 클릭했을 때 처리
        red.setOnClickListener(new Button.OnClickListener(){

            @Override
            public void onClick(View v) {
                pageblue.setVisibility(View.INVISIBLE);
                pagegreen.setVisibility(View.INVISIBLE);
                pagered.setVisibility(View.VISIBLE);
            }

        });



        //btnvibrate 클릭 - 진동
        btnvibrate.setOnClickListener(new Button.OnClickListener(){

            @Override
            public void onClick(View v) {
                //진동 만들기 - 1초동안 진동

                Vibrator vib = (Vibrator)getSystemService(VIBRATOR_SERVICE);
                vib.vibrate(1000);
            }
        });


        //btnsystemsound 클릭 - 시스템 사운드
        btnsystemsound.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View v) {
                Uri systemsound = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
                Ringtone ringtone = RingtoneManager.getRingtone(getApplicationContext(),systemsound);
                ringtone.play();
            }
        });


        //btnusersound 클릭 - 사용자 효과음
        btnusersound.setOnClickListener(new Button.OnClickListener(){

            @Override
            public void onClick(View v) {
              MediaPlayer player = MediaPlayer.create(LayoutPractice.this, R.raw.cannonsound);
                player.start();
            }
        });



        btntoast.setOnClickListener(new Button.OnClickListener(){

            @Override
            public void onClick(View v) {
                Toast.makeText(LayoutPractice.this,"토스트 출력", Toast.LENGTH_LONG).show();
            }
        });


        //btnbasicalert 클릭

        btnbasicalert.setOnClickListener(new View.OnClickListener(){


            @Override
            public void onClick(View v) {
                new AlertDialog.Builder(LayoutPractice.this).setMessage("기본 대화상자").setTitle("대화상자").setIcon(R.drawable.icon).setPositiveButton("긍정",new DialogInterface.OnClickListener(){

                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(LayoutPractice.this,"긍정을 눌렀습니다.", Toast.LENGTH_LONG).show();
                    }
                }).setNegativeButton("부정", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        MediaPlayer player = MediaPlayer.create(LayoutPractice.this, R.raw.windsound);
                        player.start();
                    }
                }).setNeutralButton("중립", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Vibrator vib = (Vibrator)getSystemService(VIBRATOR_SERVICE);
                        vib.vibrate(1000);
                    }
                }).setCancelable(false).show();
            }
        });

    }
}
