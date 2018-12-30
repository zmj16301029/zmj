package com.example.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class Adm_courseActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adm_course);
        initcrouse();
        ListView listView = (ListView)findViewById(R.id.bookList);
        BookAdapter bookAdapter = new BookAdapter(Adm_courseActivity.this,R.layout.courseitem,courseList);
        listView.setAdapter(bookAdapter);
        Button button = (Button)findViewById(R.id.creat_course);
        button.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {

            }
        });
    }

    private List<Course2> courseList = new ArrayList<>();

    public void initcrouse()
    {
        Course2 course1 = new Course2("马甲线养成",R.drawable.course1,"锻炼腹肌，适合初学者,效果显著，一分钟消耗33千卡能量");
        courseList.add(course1);
        Course2 course2 = new Course2("驼背改善",R.drawable.course2,"矫正脊椎，适合成年人");
        courseList.add(course2);
        Course2 course3 = new Course2("胸肌入门",R.drawable.course3,"锻炼胸肌，适合男性");
        courseList.add(course3);
        Course2 course4 = new Course2("手臂练习",R.drawable.course4,"针对女性的手臂练习");
        courseList.add(course4);
        Course2 course5 = new Course2("跑步训练",R.drawable.course5,"有氧慢跑训练");
        courseList.add(course5);
    }
}
