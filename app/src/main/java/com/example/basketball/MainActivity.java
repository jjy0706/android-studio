package com.example.basketball;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText etid,etpw;
    Button login,join,search,drop1;
    String ad,p;
    Helper helper;

    @Override
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);

        setContentView(R.layout.activity_main);

        etid = (EditText)findViewById(R.id.ID);
        etpw = (EditText)findViewById(R.id.PW);

        login = findViewById(R.id.Login);
        join = (Button)findViewById(R.id.join);
        search = (Button)findViewById(R.id.search);


        helper = new Helper(this);


       join.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               Intent intent = new Intent(MainActivity.this,Joinpage.class);

               startActivity(intent);
           }
       });
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                ad = etid.getText().toString();
                p = etpw.getText().toString();

                Log.d(getClass().getName(),"온클릭해서들어가는값"+ad+","+p);

                try{

                    if (helper.loginidCheck(ad).equals("")){

                        Toast.makeText(getApplicationContext(),"id또는pw가 틀렸습니다",Toast.LENGTH_LONG).show();

                    }else {

                        Toast.makeText(getApplicationContext(),"로그인완료",Toast.LENGTH_LONG).show();

                        Bundle bundle1 = new Bundle();

                        bundle1.putString("id", ad);

                        Intent intent = new Intent(MainActivity.this, BoardPage.class);

                        intent.putExtras(bundle1);


                        startActivity(intent);
                    }

                }catch (Exception e){
                    Toast.makeText(getApplicationContext(),"id또는pw가 틀렸습니다",Toast.LENGTH_LONG).show();
                }

            }
        });
    }
}