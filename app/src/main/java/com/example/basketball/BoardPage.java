package com.example.basketball;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DigitalClock;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;


public class BoardPage extends AppCompatActivity {

    Button addinfo;
    ListView list;
    ArrayAdapter adapter;
    Helper helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.boardpage);


        helper = new Helper(this);

        ArrayList<String> arrayList = new ArrayList<>();

        list = (ListView)findViewById(R.id.listview);

        addinfo = (Button) findViewById(R.id.addinfo);

        adapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,arrayList);

        list.setAdapter(adapter);

        addinfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Bundle bundle1 = getIntent().getExtras();

                String id = bundle1.getString("id");

                bundle1.putString("id",id);

                Intent intent = new Intent(getApplicationContext(), AddInfo.class);

                Log.d(getClass().getName(),"보더에서 에드클릭스"+id);

                intent.putExtras(bundle1);

                startActivity(intent);

            }
        });

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                String item = (String)adapterView.getItemAtPosition(i);

                String [] strarr = item.split("\\:");

                String name = strarr[1].trim();

                Bundle bundle = new Bundle();

                bundle.putString("name",name);

                Log.d(getClass().getName(),"보더에서 리스트뷰클릭"+name);

                Intent intent = new Intent(getApplicationContext(), DitailPage.class);

                intent.putExtras(bundle);

                startActivity(intent);
            }
        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater menuInflater  = getMenuInflater();

        menuInflater.inflate(R.menu.menu,menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()) {

            case R.id.gomypage:

                Toast.makeText(getApplicationContext(),"마이페이지",Toast.LENGTH_SHORT).show();

                Bundle bundle = getIntent().getExtras();

                String id = bundle.getString("id");

                bundle.putString("id",id);

                Intent intent = new Intent(getApplicationContext(),MyPage.class);

                intent.putExtras(bundle);

                startActivity(intent);

                break;
            case R.id.out:
                Intent intent1 = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent1);
                break;

        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onResume() {

        super.onResume();
        adapter.clear();
        adapter.addAll(helper.Board());
        //adapter.notifyDataSetChanged();

    }
}