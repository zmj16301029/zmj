package com.example.myapplication;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class ManaCourse extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book);
        initcrouse();
        ListView listView = (ListView)findViewById(R.id.bookList);
        BookAdapter bookAdapter = new BookAdapter(ManaCourse.this,R.layout.course,courseList);
        listView.setAdapter(bookAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
            {
                Course2 course = courseList.get(position);
                createDia(course.getCourseName(),course);
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
    public void createDia(String name, final Course2 course)
    {
        final String title = name;
        AlertDialog dialog = new AlertDialog.Builder(this)
                .setTitle(title)
                .setMessage("确定删除" + title + "课程吗？")
                .setNegativeButton("取消", new DialogInterface.OnClickListener()
                {
                    @Override
                    public void onClick(DialogInterface dialog, int which)
                    {
                        dialog.dismiss();
                    }
                })
                .setPositiveButton("删除", new DialogInterface.OnClickListener()
                {
                    @Override
                    public void onClick(DialogInterface dialog, int which)
                    {
                        //courseList.remove(course);
                        dialog.dismiss();
                    }
                }).create();
        dialog.show();
    }
}
