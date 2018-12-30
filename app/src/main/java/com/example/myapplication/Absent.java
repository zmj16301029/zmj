package com.example.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

public class Absent extends AppCompatActivity
{
    private String[] data ={ "小明","小红","小韩","小李","小梅","小胡","小帅","杨幂"};
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_absent);
        ListView list_ab = (ListView) findViewById(R.id.list_ab);
        list_ab.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_list_item_checked,data));
        list_ab.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
        Button button = (Button)findViewById(R.id.commitButton);
        button.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Toast.makeText(Absent.this, "提交成功", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
