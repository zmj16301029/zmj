package com.example.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.ToggleButton;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.lang.String;

import connect.ConnectHttp;

import com.tencent.tauth.Tencent;
import com.tencent.connect.share.QQShare;
import com.tencent.connect.share.QzoneShare;
import com.tencent.connect.UserInfo;
import com.tencent.tauth.IUiListener;
import com.tencent.connect.auth.QQToken;
import com.tencent.connect.common.Constants;
import com.tencent.tauth.UiError;
import org.json.JSONObject;
import org.json.JSONException;


public class MainActivity extends AppCompatActivity
{

    //tencent sdk源码
    private Tencent mTencent;
    private IUiListener loginListener;

    private IUiListener userInfoListener;
    private String scope;
    private UserInfo userInfo;
    private final String APP_ID = "101532799";

    public void qqShare(View v) {
        final Bundle params = new Bundle();
        params.putInt(QQShare.SHARE_TO_QQ_KEY_TYPE, QQShare.SHARE_TO_QQ_TYPE_DEFAULT);//分享的类型
        params.putString(QQShare.SHARE_TO_QQ_TITLE, "测试");//分享标题
        params.putString(QQShare.SHARE_TO_QQ_SUMMARY,"测试");//要分享的内容摘要
        params.putString(QQShare.SHARE_TO_QQ_TARGET_URL,"https://github.com/huyangya/learngit");//内容地址
        params.putString(QQShare.SHARE_TO_QQ_IMAGE_URL,"http://pic.nen.com.cn/500/15/73/81/15738128_667009.jpg");//分享的图片URL
        params.putString(QQShare.SHARE_TO_QQ_APP_NAME, "测试");//应用名称
        mTencent.shareToQQ(MainActivity.this, params, new ShareUiListener());
    }


    private class BaseUiListener implements IUiListener {
        @Override
        public void onComplete(Object response) {
            if (null == response) {
                Toast.makeText(MainActivity.this, "登录失败",Toast.LENGTH_LONG).show();
                return;
            }
            JSONObject jsonResponse = (JSONObject) response;
            if (null != jsonResponse && jsonResponse.length() == 0) {
                Toast.makeText(MainActivity.this, "登录失败",Toast.LENGTH_LONG).show();
                return;
            }
            Toast.makeText(MainActivity.this, "登录成功",Toast.LENGTH_LONG).show();
            doComplete((JSONObject)response);
        }

        protected void doComplete(JSONObject values) {

        }
        @Override
        public void onError(UiError e) {
            //登录错误
        }

        @Override
        public void onCancel() {
            // 运行完成
        }
    }



    /**
     * 分享到QQ空间
     * @param v
     */
    public void qqQzoneShare(View v) {
        int QzoneType = QzoneShare.SHARE_TO_QZONE_TYPE_NO_TYPE;
        Bundle params = new Bundle();
        params.putInt(QzoneShare.SHARE_TO_QZONE_KEY_TYPE, QzoneType);
        params.putString(QzoneShare.SHARE_TO_QQ_TITLE, "测试");//分享标题
        params.putString(QzoneShare.SHARE_TO_QQ_SUMMARY, "测试");//分享的内容摘要
        params.putString(QzoneShare.SHARE_TO_QQ_TARGET_URL, "https://github.com/huyangya/learngit");//分享的链接
        //分享的图片, 以ArrayList<String>的类型传入，以便支持多张图片（注：图片最多支持9张图片，多余的图片会被丢弃）
        ArrayList<String> imageUrls = new ArrayList<String>();
        imageUrls.add("http://pic.nen.com.cn/500/15/73/81/15738128_667009.jpg");//添加一个图片地址
        params.putStringArrayList(QzoneShare.SHARE_TO_QQ_IMAGE_URL, imageUrls);//分享的图片URL
        mTencent.shareToQzone(MainActivity.this, params, new ShareUiListener());
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        final EditText acc = (EditText) findViewById(R.id.acc);//账户
        final EditText passWord = (EditText) findViewById(R.id.pass);//密码
        mTencent = Tencent.createInstance(APP_ID, MainActivity.this);
        scope = "all";
        loginListener = new BaseUiListener() {
            @Override
            protected void doComplete(JSONObject values) {//得到用户的ID  和签名等信息  用来得到用户信息
                Log.i("lkei",values.toString());
                System.out.println("(((((((((((((((((((");
                Intent intent = new Intent(MainActivity.this,FirstActivity.class);
                startActivity(intent);
            }
        };


        Button button1 = (Button)findViewById(R.id.button1);//登陆

        button1.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent intent;
                intent = new Intent("com.app.first");
                startActivity(intent);
                //联网登陆
                new Thread()
                {
                    @Override
                    public void run()
                    {
                        String response = doPost("login").trim();
                        Intent intent;
                        switch (response)
                        {
                            case "1":
                                intent = new Intent("com.app.first");
                                startActivity(intent);
                                break;
                            case "2":
                                intent = new Intent(MainActivity.this,Coach.class);
                                startActivity(intent);
                                break;
                            case "3":
                                intent = new Intent(MainActivity.this,AdminActivity.class);
                                startActivity(intent);
                                break;
                            case "NO":
                                showRes();
                                break;
                            default:
                                System.out.println("default");
                                break;
                        }
                    }
                }.start();
            }
        });

        ToggleButton toggleButton = (ToggleButton)findViewById(R.id.toggleButton);
        toggleButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
        {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked)
            {
                if(isChecked)//不可见
                {
                    passWord.setInputType(InputType.TYPE_CLASS_TEXT|InputType.TYPE_TEXT_VARIATION_PASSWORD);
                }
                else
                {
                    passWord.setInputType(InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
                }
            }
        });

        Button button2 = (Button)findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                new Thread()
                {
                    @Override
                    public void run()
                    {
                        if(doPost("register").trim().equals("YES"))
                        {
                            Intent intent = new Intent("com.app.first");
                            startActivity(intent);
                        }
                        else
                        {
                            showRes();
                        }
                    }
                }.start();
            }
        });

        Button buttonqq1 = (Button)findViewById(R.id.buttonqq1);
        buttonqq1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (!mTencent.isSessionValid()) {
                    mTencent.login(MainActivity.this, "all", loginListener);


                }

            }
        });
    }

    //销毁QQ登录
    @Override
    protected void onDestroy() {
        if (mTencent != null) {
            mTencent.logout(MainActivity.this);
        }
        super.onDestroy();
    }


    private class ShareUiListener implements IUiListener {

        @Override
        public void onComplete(Object response) {
            //分享成功

        }

        @Override
        public void onError(UiError uiError) {
            //分享失败

        }

        @Override
        public void onCancel() {
            //分享取消

        }
    }



    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == Constants.REQUEST_LOGIN ||
                requestCode == Constants.REQUEST_APPBAR) {
            Tencent.onActivityResultData(requestCode,resultCode,data,loginListener);
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    public String doPost(String type)
    {
        final EditText acc = (EditText)findViewById(R.id.acc);//账号编辑域
        final EditText passWord = (EditText)findViewById(R.id.pass);//密码编辑域
        String account = acc.getText().toString().trim();
        String pass = passWord.getText().toString().trim();
        String result = " ";
        String data = "req=" + type + "&acc=" + account + "&password=" + pass;//要post的数据
        //建立连接
        ConnectHttp con = new ConnectHttp("POST");
        con.connect();
        HttpURLConnection connection = con.getConnection();
        connection.setRequestProperty("Content-Type","application/x-www-form-urlencoded");
        connection.setRequestProperty("Content-Length", data.length() + "");
        //得到返回值
        try
        {
            connection.getOutputStream().write(data.getBytes());//post数据
            System.out.println(data);
            int code = connection.getResponseCode();
            if (code == 200)
            {
                InputStream is = connection.getInputStream();
                ByteArrayOutputStream bos = new ByteArrayOutputStream();
                byte[] buffer = new byte[1024];
                int len = -1;
                while ((len = is.read(buffer)) != -1)
                {
                    bos.write(buffer, 0, len);
                }
                result = new String(bos.toByteArray());
                is.close();
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        System.out.println(result);
        return result;
    }

    private void showRes()
    {
        runOnUiThread(new Runnable()
        {
            @Override
            public void run()
            {
                Toast.makeText(MainActivity.this,"失败",Toast.LENGTH_SHORT).show();
            }
        });
    }

}
