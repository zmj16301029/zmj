package com.example.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class AdminActivity extends AppCompatActivity
{
    private List<News> newsList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);
        initnews();
        ListView listView = (ListView) findViewById(R.id.newsList1);
        NewsAdapter adapter = new NewsAdapter(AdminActivity.this, R.layout.newsui, newsList);
        listView.setAdapter(adapter);
        Button button1 = (Button)findViewById(R.id.signButton2);//学员签到
        button1.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent intent1 = new Intent(AdminActivity.this,Absent.class);
                startActivity(intent1);
            }
        });

        Button button2 = (Button)findViewById(R.id.stuinfoButton2);//学员信息
        button2.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent intent2 = new Intent(AdminActivity.this,Stu_infoActivity.class);
                startActivity(intent2);
            }
        });

        Button button3 = (Button)findViewById(R.id.coach_Button2);//教练信息
        button3.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent intent3 = new Intent(AdminActivity.this,Stu_infoActivity.class);
                startActivity(intent3);
            }
        });

        Button button4 = (Button)findViewById(R.id.courseButton2);//课程管理
        button4.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent intent4 = new Intent(AdminActivity.this,Adm_courseActivity.class);
                startActivity(intent4);
            }
        });

        Button button6 = (Button)findViewById(R.id.adm_myButton);//我的
        button6.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent intent3 = new Intent(AdminActivity.this,ChangeInfoActivity.class);
                intent3.putExtra("usetype","管理员");
                startActivity(intent3);
            }
        });
    }

    public void initnews()
    {
        News news1 = new News("震惊！！！外国男子因突然健身差点丧命!",R.drawable.new1);
        newsList.add(news1);
        News news2 = new News("3个月20多家健身房关门，传统健身房“倒闭潮”来了？",R.drawable.new2);
        newsList.add(news2);
        News new3 = new News("过度健身也是病！会对身体造成的5大伤害",R.drawable.new3);
        newsList.add(new3);
        News new4 = new News("男子花1.5万健身减肥差点送命!",R.drawable.new4);
        newsList.add(new4);
        News new5 = new News("健身猝死事件频发，我们还要健身吗？",R.drawable.new5);
        newsList.add(new5);
    }
}
