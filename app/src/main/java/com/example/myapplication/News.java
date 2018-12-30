package com.example.myapplication;

/**
 * Created by 16301029 on 2018/9/24.
 */

public class News
{
    private String title;
    private int imageId;
    public News(String title, int imageId)
    {
        this.title = title;
        this.imageId = imageId;
    }

    public String getTitle()
    {
        return title;
    }

    public int getImageId()
    {
        return imageId;
    }
}
