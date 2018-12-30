package com.example.myapplication;

import android.Manifest;
import android.content.Context;
import android.content.res.Resources;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import database.MyDatabase;

public class CallActivity extends AppCompatActivity
{
    private MyDatabase dbHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_call);

        ActivityCompat.requestPermissions(CallActivity.this, new String[]{Manifest.permission.SEND_SMS}, 1);
        initCoach();
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.coachView);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        CoachAdapter adapter = new CoachAdapter(coachList, CallActivity.this);
        recyclerView.setAdapter(adapter);
    }

    List<PrivateCoach> coachList = new ArrayList<>();

    public void initCoach()
    {
        Uri uri = Uri.parse("content://com.example.myapplication.database.provider/private_coach");
        Cursor cursor = getContentResolver().query(uri, null, null, null, null);
        if(cursor.moveToFirst())
        {
            do
            {
                String name = cursor.getString(cursor.getColumnIndex("name"));
                String des = cursor.getString(cursor.getColumnIndex("des"));
                String res = cursor.getString(cursor.getColumnIndex("res"));
                String str[] = res.split("\\.");
                Context ctx=getBaseContext();
                int resId = getResources().getIdentifier(str[2], "drawable", ctx.getPackageName());
                coachList.add(new PrivateCoach(name, des, resId));//¸ÄÎªcoachList.add(new PrivateCoach(name, des, count, resId));
            }
            while (cursor.moveToNext());
        }
        cursor.close();
    }

    private Context mContext = CallActivity.this;
}
