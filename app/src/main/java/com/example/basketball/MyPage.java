package com.example.basketball;

import android.content.Intent;
import android.database.Cursor;
import android.database.CursorIndexOutOfBoundsException;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MyPage<OnActivityResult> extends AppCompatActivity {

    Button update,back;
    TextView posi,phon,hei,skill,nickname,age,mytext;
    Helper helper;
    String id;
    Bundle bundle;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mypage);

        helper = new Helper(this);

        update = (Button)findViewById(R.id.mypageupdate);

        back =(Button)findViewById(R.id.boardback);

        posi = findViewById(R.id.mypageposi);
        phon = findViewById(R.id.mypageph);
        hei = findViewById(R.id.mypagehei);
        skill = findViewById(R.id.mypageskill);
        nickname = findViewById(R.id.mypagename);
        age = findViewById(R.id.mypageage);
        mytext = findViewById(R.id.mypagetext);

        bundle  = getIntent().getExtras();

        id = bundle.getString("id");

                String name = "";

                Cursor cursor = helper.getData(id);

                cursor.moveToNext();

                String p = cursor.getString(cursor.getColumnIndex(helper.COLUMN_ph));
                String po = cursor.getString(cursor.getColumnIndex(helper.COLUMN_pos));
                String he = cursor.getString(cursor.getColumnIndex(helper.COLUMN_hei));
                String sk = cursor.getString(cursor.getColumnIndex(helper.COLUMN_skill));
                String ag = cursor.getString(cursor.getColumnIndex(helper.COLUMN_age));
                String na = cursor.getString(cursor.getColumnIndex(helper.COLUMN_NAME));

                if (!cursor.isClosed()){
                    cursor.close();
                }

                posi.setText(po);
                phon.setText(p);
                hei.setText(he);
                skill.setText(sk);
                age.setText(ag);
                nickname.setText(na);

        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(getApplicationContext(),"수정하기 클릭",Toast.LENGTH_SHORT).show();

                Log.d(getClass().getName(), "수정하는" + id);

                bundle.putString("id",id);

                Intent intent = new Intent(getApplicationContext(),MyPageUpdate.class);

                intent.putExtras(bundle);

                startActivity(intent);

            }
        });
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getApplicationContext(),BoardPage.class);

                intent.putExtra("id",id);

                startActivity(intent);


            }
        });
    }
}
