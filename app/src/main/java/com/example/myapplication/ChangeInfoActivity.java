package com.example.myapplication;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class ChangeInfoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_info);
        TextView textView = (TextView) findViewById(R.id.useType);
        String useType = getIntent().getStringExtra("usetype");
        textView.setText("用户类型：" + useType);
        Button button1 = (Button)findViewById(R.id.namebutton);
        button1.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                createDia("用户名", R.id.name);
            }
        });
        Button button2 = (Button)findViewById(R.id.sexbutton);
        button2.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                createDia("性别", R.id.sex);
            }
        });

        Button button3 = (Button) findViewById(R.id.agebutton);
        button3.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                createDia("年龄", R.id.age);
            }
        });
    }
    public void createDia(String type, int res)
    {
        View view = getLayoutInflater().inflate(R.layout.dialog,null);
        final EditText editText = (EditText) view.findViewById(R.id.dia_edit);
        final String info_type = type;
        final int info_res = res;
        String title = "修改" + type;
        AlertDialog dialog = new AlertDialog.Builder(this)
                .setTitle(title)
                .setView(view)
                .setNegativeButton("取消",new DialogInterface.OnClickListener()
                {
                    @Override
                    public void onClick(DialogInterface dialog, int which)
                    {
                        dialog.dismiss();
                    }
                })
                .setPositiveButton("确定", new DialogInterface.OnClickListener()
                {
                    @Override
                    public void onClick(DialogInterface dialog, int which)
                    {
                        String name = editText.getText().toString();
                        TextView tv = (TextView)findViewById(info_res);
                        tv.setText(info_type + ":" + name);
                        Toast.makeText(ChangeInfoActivity.this, "修改成功", Toast.LENGTH_SHORT).show();
                        dialog.dismiss();
                    }
                }).create();
        dialog.show();
    }
}
