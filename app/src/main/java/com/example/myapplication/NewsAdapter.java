package com.example.myapplication;

import android.content.Context;
import android.support.annotation.NonNull;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by 16301029 on 2018/9/24.
 */

public class NewsAdapter extends ArrayAdapter<News>
{
    private int resourceId;
    public NewsAdapter(Context context, int textViewResoyrceId, List<News> objects)
    {
        super(context, textViewResoyrceId, objects);
        resourceId  = textViewResoyrceId;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        News news = getItem(position);
        View view = LayoutInflater.from(getContext()).inflate(resourceId, parent, false);
        ImageView newsImage = (ImageView) view.findViewById(R.id.image);
        TextView textView = (TextView) view.findViewById(R.id.title);
        newsImage.setImageResource(news.getImageId());
        textView.setText(news.getTitle());
        return view;
    }
}
