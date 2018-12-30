package com.example.myapplication;

/**
 * Created by Administrator on 2018/10/1.
 */

public class Course
{
    private String courseName;
    private int courseImage;

    public Course(String name, int imageId)
    {
        this.courseName = name;
        this.courseImage = imageId;
    }

    public String getCourseName()
    {
        return courseName;
    }

    public int getCourseImage()
    {
        return courseImage;
    }
}
