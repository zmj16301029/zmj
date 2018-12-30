package com.example.myapplication;

/**
 * Created by Administrator on 2018/11/30.
 */

public class PrivateCoach
{
    private String name;
    private String description;
    private int coachImage;

    public PrivateCoach(String name, String description, int image)
    {
        this.coachImage = image;
        this.description = description;
        this.name = name;
    }

    public String getName()
    {
         return name;
    }

    public String getDescription()
    {
        return description;
    }

    public int getCoachImage()
    {
        return coachImage;
    }
}
