/*package com.example.basketball;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class BoardAdapter extends BaseAdapter {

    Context context;
    BoardData data [];

    BoardAdapter(Context context, BoardData [] data){
        this.context = context;
        this.data = data;

    }


    @Override
    public int getCount() {
        return data.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        if(view == null){
            LayoutInflater inflater = LayoutInflater.from(context);
            view = inflater.inflate(R.layout.userlist,viewGroup,false);
        }
        TextView name = (TextView)view.findViewById(R.id.boardname);
        TextView area = (TextView)view.findViewById(R.id.boardaddress);
        TextView age = (TextView)view.findViewById(R.id.boardage);
        TextView posi = (TextView)view.findViewById(R.id.boardposi);

        String a = String.valueOf(data[i].age);

        name.setText("닉네임:"+data[i].name);
        area.setText("지역:"+data[i].area);
        age.setText("나이:"+a);
        posi.setText("포지션"+data[i].posi);

        return view;
    }

}*/
