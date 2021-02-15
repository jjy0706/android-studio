package com.example.basketball;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Joinpage extends AppCompatActivity {

    Button loginback,comple;
    EditText id,pw,nn,ph,rw;
    Helper helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.joinpage);

        loginback = (Button)findViewById(R.id.Loginback);
        comple = (Button)findViewById(R.id.finish);
        helper = new Helper(this);

        id = (EditText)findViewById(R.id.JoinId);
        pw = (EditText)findViewById(R.id.JoinPW);
        nn = (EditText)findViewById(R.id.JoinNickName);
        ph = (EditText)findViewById(R.id.JoinPH);
        rw = (EditText)findViewById(R.id.JoinPW1);


        loginback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getApplicationContext(),MainActivity.class);

                startActivity(intent);
            }
        });

        comple.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String cid = id.getText().toString();
                String cpw = pw.getText().toString();
                String cnn = nn.getText().toString();
                String cph = ph.getText().toString();
                String pw2 = rw.getText().toString();

                if(cid.equals("") == true && cid.length() >=7){
                    Toast.makeText(getApplicationContext(),"id칸에 빈곳이 있거나 범위를 초과했습니다.",Toast.LENGTH_SHORT).show();

                }else if(!cpw.equals(pw2)){
                    Toast.makeText(getApplicationContext(),"비밀번호를 재확인해주세요",Toast.LENGTH_SHORT).show();
                }
                else if(cpw.equals("") == true && cpw.length() >=15){
                    Toast.makeText(getApplicationContext(),"pw칸에 빈곳이 있거나 범위를 초과했습니다.",Toast.LENGTH_SHORT).show();
                }
                else if(cnn.equals("") == true && cnn.length() >= 7){
                    Toast.makeText(getApplicationContext(),"닉네임칸에 빈곳이 있거나 범위를 초과했습니다.",Toast.LENGTH_SHORT).show();
                }
                else if(cpw.equals("") == true && cpw.length() > 11){
                    Toast.makeText(getApplicationContext(),"ph칸에 빈곳이 있거나 범위를 초과했습니다.",Toast.LENGTH_SHORT).show();
                }else{
                    if(helper.insert(cid,cpw,cnn,cph) == true){
                        Toast.makeText(getApplicationContext(),"가입완료",Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                        startActivity(intent);

                    }else {
                        Toast.makeText(getApplicationContext(),"이미 있는id입니다",Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}
