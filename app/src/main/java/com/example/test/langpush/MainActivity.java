package com.example.test.langpush;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.test.langpush.util.PushUtil;
import com.example.test.langpush.util.SystemUtil;
import com.huawei.android.hms.agent.HMSAgent;
import com.huawei.android.hms.agent.common.handler.ConnectHandler;
import com.huawei.android.hms.agent.push.handler.GetTokenHandler;
import com.huawei.hms.support.api.push.TokenResult;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //华为机型推送链接
        PushUtil.HuaWeiConnect(MainActivity.this);

        //通知跳转
        Intent intent = getIntent();
        if (intent != null) {
            Uri uri = intent.getData();
            if (uri != null) {
                String dataString = intent.getDataString();
                Log.d("0.0",dataString);
                intent=new Intent(MainActivity.this,Main2Activity.class);
                startActivity(intent);
            }
        }
    }
}
