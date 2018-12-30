package com.example.myapplication;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by 16301029 on 2018/10/1.
 */

public class CourseAdapter extends RecyclerView.Adapter<CourseAdapter.ViewHolder>
{
    private List<Course> courseList;

    static class ViewHolder extends RecyclerView.ViewHolder
    {
        ImageView courseImage;
        TextView courseName;

        public ViewHolder(View view)
        {
            super(view);
            courseImage = (ImageView) view.findViewById(R.id.course_image);
            courseName = (TextView) view.findViewById(R.id.course_name);
        }
    }

    public CourseAdapter(List<Course> courseList)
    {
        this.courseList = courseList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.course,parent,false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

   @Override
    public void onBindViewHolder(ViewHolder holder, int position)
    {
        Course course = courseList.get(position);
        holder.courseName.setText(course.getCourseName());
        holder.courseImage.setImageResource(course.getCourseImage());
    }

    @Override
    public int getItemCount()
    {
        return courseList.size();
    }
}
