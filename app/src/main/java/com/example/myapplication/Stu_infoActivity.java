package com.example.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;

public class Stu_infoActivity extends AppCompatActivity
{

    private String[] data ={ "小明","小红","小韩","小李","小梅","零超","杨超越","杨幂"};
    private String[] text ={ "男 20","女 28","男 23","男 21","女 19","女 20","男 18","女 30"};

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stu_info);
        ListView list =(ListView) findViewById(R.id.stu_list);
        ArrayList<HashMap<String,String>> mylist = new ArrayList<HashMap<String,String>>();
        for(int i=0;i<8;i++)
        {
            HashMap<String,String> map=new HashMap<String,String>();
            map.put("ItemName",data[i]);
            map.put("ItemText",text[i]);
            mylist.add(map);
        }
        SimpleAdapter mSchedule = new SimpleAdapter(this,mylist,R.layout.stu_item, new String[]{"ItemName","ItemText"}, new int[]{R.id.ItemName,R.id.ItemText});
        list.setAdapter(mSchedule);
    }
}
