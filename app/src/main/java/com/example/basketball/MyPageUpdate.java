package com.example.basketball;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MyPageUpdate extends AppCompatActivity {

    EditText upnickname,upage,upposi,uphei,upph,upskill,uptext;
    Helper helper;
    Button back,sec;
    String id;
    Bundle bundle;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mypageupdate);

        helper = new Helper(this);

        upage = findViewById(R.id.updateage1);
        uphei = findViewById(R.id.updatehei1);
        upnickname = findViewById(R.id.updatenickname1);
        upph = findViewById(R.id.updateph1);
        upposi = findViewById(R.id.updateposi1);
        upskill = findViewById(R.id.updateskill1);
        uptext = findViewById(R.id.updatetext);

        back = findViewById(R.id.updateback1);
        sec = findViewById(R.id.updatesec1);

        bundle = getIntent().getExtras();

        id = bundle.getString("id");

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getApplicationContext(),MyPage.class);

                startActivity(intent);

            }
        });

        sec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(getApplicationContext(),"수정완료클릭",Toast.LENGTH_SHORT).show();

                String n = upnickname.getText().toString();
                String ph = upph.getText().toString();
                String po = upposi.getText().toString();
                String ag = upage.getText().toString();
                String skill = upskill.getText().toString();
                String he = uphei.getText().toString();

                Log.d(getClass().getName(),"업데이트id값"+id);

                if(helper.Mypageupdate(id,ph,po,he,skill,ag,n) == true){

                    Toast.makeText(getApplicationContext(),"업데이트성공",Toast.LENGTH_SHORT).show();

                    Intent intent = new Intent(getApplicationContext(),MyPage.class);

                    bundle.putString("id",id);

                    intent.putExtras(bundle);

                    startActivity(intent);

                }else{
                    Toast.makeText(getApplicationContext(),"업데이트실패",Toast.LENGTH_SHORT).show();
                }

            }
        });
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
