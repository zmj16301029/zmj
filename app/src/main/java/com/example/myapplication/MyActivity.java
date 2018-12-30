package com.example.myapplication;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.lang.reflect.Array;

public class MyActivity extends AppCompatActivity
{

    private String[] data = {"个人信息", "修改密码" ,"修改目标步数"};
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);
        final ListView listView = (ListView) findViewById(R.id.myList);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(MyActivity.this,android.R.layout.simple_list_item_1,data);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
            {
                switch (position)
                {
                    case 0://修改个人信息
                        Intent intent0 = new Intent(MyActivity.this,ChangeInfoActivity.class);
                        intent0.putExtra("usetype","会员");
                        startActivity(intent0);
                        break;
                    case 1://修改密码
                        Intent intent1 = new Intent(MyActivity.this,changemimaActivity.class);
                        startActivity(intent1);
                        break;
                    case 2://修改目标步数
                        createDia();
                        break;
                }
            }
        });
    }

    public void createDia()
    {
        View view = getLayoutInflater().inflate(R.layout.dialog,null);
        AlertDialog dialog = new AlertDialog.Builder(this)
                .setTitle("修改目标步数")
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
                        EditText editText = (EditText) findViewById(R.id.dia_edit);
                        //String num = editText.getText().toString();
                        Toast.makeText(MyActivity.this, "修改成功", Toast.LENGTH_SHORT).show();
                        dialog.dismiss();
                    }
                }).create();
        dialog.show();
    }

}
