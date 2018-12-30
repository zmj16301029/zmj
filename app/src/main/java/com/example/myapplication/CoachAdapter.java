package com.example.myapplication;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Administrator on 2018/11/30.
 */

public class CoachAdapter extends RecyclerView.Adapter<CoachAdapter.ViewHolder>
{
    private List<PrivateCoach> coachList;
    private Context mcontext;

    static class ViewHolder extends RecyclerView.ViewHolder
    {
        ImageView coachImage;
        TextView coachName;
        TextView coachTel;

        public ViewHolder(View view)
        {
            super(view);
            coachImage = (ImageView) view.findViewById(R.id.course_image);
            coachName = (TextView) view.findViewById(R.id.course_name);
            coachTel = (TextView) view.findViewById(R.id.course_info);
        }
    }

    public CoachAdapter(List<PrivateCoach> coachList, Context c)
    {
        this.coachList = coachList;
        this.mcontext = c;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.courseitem,parent,false);
        final ViewHolder holder = new ViewHolder(view);

        //为列表电话号添加事件响应
        holder.coachTel.setOnLongClickListener(new View.OnLongClickListener()
        {
            @Override
            public boolean onLongClick(View v)
            {
                int position = holder.getAdapterPosition();
                PrivateCoach pcoach = coachList.get(position);
                Intent intent = new Intent(Intent.ACTION_SENDTO);
                intent.setData(Uri.parse("smsto:" + pcoach.getDescription()));
                if(ContextCompat.checkSelfPermission(mcontext, Manifest.permission.SEND_SMS) != PackageManager.PERMISSION_GRANTED)
                {
                    System.out.println("没有权限");
                }
                mcontext.startActivity(intent);
                return true;
            }
        });
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position)
    {
        PrivateCoach coach = coachList.get(position);
        holder.coachName.setText(coach.getName());
        holder.coachImage.setImageResource(coach.getCoachImage());
        holder.coachTel.setText(coach.getDescription());
    }

    @Override
    public int getItemCount()
    {
        return coachList.size();
    }
}
