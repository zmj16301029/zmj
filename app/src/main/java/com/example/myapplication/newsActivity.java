package com.example.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class newsActivity extends AppCompatActivity
{

    private List<News> newsList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);
        initnews();
        ListView listView = (ListView) findViewById(R.id.listview);
        NewsAdapter adapter = new NewsAdapter(newsActivity.this, R.layout.newsui, newsList);
        listView.setAdapter(adapter);
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
