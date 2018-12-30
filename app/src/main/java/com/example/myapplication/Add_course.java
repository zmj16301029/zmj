package com.example.myapplication;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Add_course extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book);
        initcrouse();
        ListView listView = (ListView)findViewById(R.id.bookList);
        BookAdapter bookAdapter = new BookAdapter(Add_course.this,R.layout.courseitem,courseList);
        listView.setAdapter(bookAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
            {
                Course2 course = courseList.get(position);
                createDia(course.getCourseName());
            }
        });
    }

    private List<Course2> courseList = new ArrayList<>();

    public void initcrouse()
    {
        Course2 course1 = new Course2("马甲线养成",R.drawable.course1,"锻炼腹肌，适合初学者");
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

    public void createDia(String name) {
        String title = "添加" + name + "课程";
        final String course = name;
        AlertDialog dialog = new AlertDialog.Builder(this)
                .setTitle(title)
                .setNegativeButton("取消", new DialogInterface.OnClickListener()
                {
                    @Override
                    public void onClick(DialogInterface dialog, int which)
                    {
                        dialog.dismiss();
                    }
                })
                .setPositiveButton("确定", new DialogInterface.OnClickListener()
                {
                    @Override
                    public void onClick(DialogInterface dialog, int which)
                    {
                        String str = "";
                        str = "成功添加" + course + "课程";
                        Toast.makeText(Add_course.this, str, Toast.LENGTH_SHORT).show();
                        dialog.dismiss();
                    }
                }).create();
        dialog.show();
    }
}
