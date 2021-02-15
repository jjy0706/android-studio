package com.example.basketball;

import android.content.Intent;
import android.database.Cursor;
import android.database.CursorIndexOutOfBoundsException;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class DitailPage extends AppCompatActivity {

    Button update,back;
    TextView posi,phon,hei,skill,nickname,age,mytext;
    Helper helper;
    String p,po,he,sk,ag,na;
    Bundle bundle;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ditailpage);

        helper = new Helper(this);

        back = findViewById(R.id.boardback1);

        posi = findViewById(R.id.mypageposi1);
        phon = findViewById(R.id.mypageph1);
        hei = findViewById(R.id.mypagehei1);
        skill = findViewById(R.id.mypageskill1);
        nickname = findViewById(R.id.mypagename1);
        age = findViewById(R.id.mypageage1);
        mytext = findViewById(R.id.mypagetext1);


        bundle = getIntent().getExtras();

        String num = bundle.getString("name");

        Log.d(getClass().getName(),"마이페이지에서 받는"+num);

        if(num != ""){

                Cursor cursor = helper.getlistData(num);
                    cursor.moveToNext();
                    p = cursor.getString(0);
                    po = cursor.getString(1);
                    he = cursor.getString(2);
                    sk = cursor.getString(3);
                    ag = cursor.getString(4);
                    na = cursor.getString(5);


                Log.d(getClass().getName(),"상세페이지에서 받는 폰번호"+p);

                if (!cursor.isClosed()) {

                    cursor.close();
                }

                posi.setText(po);
                phon.setText(p);
                hei.setText(he);
                skill.setText(sk);
                age.setText(ag);
                nickname.setText(na);

        }
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent();

                startActivity(intent);

                finish();

            }
        });

    }
}
