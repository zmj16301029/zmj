package com.example.myapplication;

/**
 * Created by Administrator on 2018/10/9.
 */

public class Course2
{
    private String courseName;
    private int courseImage;
    private String courseInfo;

    public Course2(String name, int imageId, String courseInfo)
    {
        this.courseName = name;
        this.courseImage = imageId;
        this.courseInfo = courseInfo;
    }

    public String getCourseName()
    {
        return courseName;
    }

    public int getCourseImage()
    {
        return courseImage;
    }

    public  String getCourseInfo()
    {
        return courseInfo;
    }
}
