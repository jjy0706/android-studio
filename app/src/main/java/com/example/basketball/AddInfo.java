package com.example.basketball;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class AddInfo extends AppCompatActivity {

    Button sec,back;
    EditText infoposi,infoarea,infoage,infohei;
    Helper helper;
    String id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.addinfo);

        helper = new Helper(this);
        sec = findViewById(R.id.finish);
        back = findViewById(R.id.infoback);

        infoage = findViewById(R.id.age);
        infoarea = findViewById(R.id.address);
        infohei = findViewById(R.id.height);
        infoposi = findViewById(R.id.posi);



        sec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Bundle bundle = getIntent().getExtras();

                id = bundle.getString("id");

                Log.d(getClass().getName(),"에드인포에서 받는"+id);
                String age = infoage.getText().toString();
                String hei = infohei.getText().toString();
                String area = infoarea.getText().toString();
                String posi = infoposi.getText().toString();

                if(id != null){

                    if(helper.BoardInfo(id,posi,hei,age,area)){

                        Toast.makeText(getApplicationContext(),"게시물등록완료",Toast.LENGTH_SHORT).show();

                        Intent intent = new Intent(getApplicationContext(),BoardPage.class);

                        intent.putExtra("id",id);

                        startActivity(intent);
                    }else {
                        Toast.makeText(getApplicationContext(),"게시물등록실패",Toast.LENGTH_SHORT).show();
                    }
                }


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
