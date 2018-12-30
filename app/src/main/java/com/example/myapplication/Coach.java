package com.example.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import java.util.ArrayList;
import java.util.List;

public class Coach extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coach);
        initcrouse();
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.teachRecycler);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        CourseAdapter adapter = new CourseAdapter(courseList);
        recyclerView.setAdapter(adapter);

        Button button1 = (Button)findViewById(R.id.signButton);//学员签到
        button1.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent intent1 = new Intent(Coach.this,Absent.class);
                startActivity(intent1);
            }
        });

        Button button2 = (Button)findViewById(R.id.stuinfoButton);
        button2.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent intent2 = new Intent(Coach.this,Stu_infoActivity.class);
                startActivity(intent2);
            }
        });

        Button button3 = (Button)findViewById(R.id.coach_Button);
        button3.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent intent3 = new Intent(Coach.this,ChangeInfoActivity.class);
                intent3.putExtra("usetype","教练");
                startActivity(intent3);
            }
        });

        Button button4 = (Button)findViewById(R.id.courseButton1);
        button4.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent intent4  = new Intent(Coach.this,ManaCourse.class);
                startActivity(intent4);
            }
        });

        Button button_add = (Button)findViewById(R.id.addCourseButton);
        button_add.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent intent5 = new Intent(Coach.this,Add_course.class);
                startActivity(intent5);
            }
        });
    }

    List<Course> courseList = new ArrayList<>();
    public void initcrouse()
    {
        Course course1 = new Course("马甲线养成",R.drawable.course1);
        courseList.add(course1);
        Course course2 = new Course("驼背改善",R.drawable.course2);
        courseList.add(course2);
        Course course3 = new Course("胸肌入门",R.drawable.course3);
        courseList.add(course3);
    }
}
