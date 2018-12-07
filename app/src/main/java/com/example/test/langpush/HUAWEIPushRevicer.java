package com.example.test.langpush;

import android.app.NotificationManager;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.huawei.hms.support.api.push.PushReceiver;

import java.lang.reflect.Type;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

//华为推送接收service
public class HUAWEIPushRevicer extends PushReceiver {
    @Override
    public void onToken(Context context, String token, Bundle extras) {
        Log.d("0.0","token:"+token);
    }
    @Override
    public boolean onPushMsg(Context context, byte[] msg, Bundle bundle) {
        try {
            //CP可以自己解析消息内容，然后做相应的处理
            String content = new String(msg, "UTF-8");
            Log.i("0.0", "收到PUSH透传消息,消息内容为:" + content);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public void onEvent(Context context, Event event, Bundle extras) {
        if (Event.NOTIFICATION_OPENED.equals(event) || Event.NOTIFICATION_CLICK_BTN.equals(event)) {
            int notifyId = extras.getInt(BOUND_KEY.pushNotifyId, 0);
            Log.i("0.0", "收到通知栏消息点击事件,notifyId:" + notifyId);
            if (0 != notifyId) {
                NotificationManager manager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
                manager.cancel(notifyId);
            }
        }
        try {
            String message =  extras.getString(BOUND_KEY.pushMsgKey);
            if (message!=null&&message.length()>0){
                if(message.startsWith("[")){
                    message=message.substring(1);
                }
                if(message.endsWith("]")){
                    message=message.substring(0,message.length()-1);
                }
                Type type=new TypeToken<Map<String,Object>>(){}.getType();

                Gson gson= new Gson();
                Map<String,Object> map=gson.fromJson(message, type);
                String gotype=(String)map.get("gotype");
                Log.e("0.0",gotype);
            }

        }catch (Exception e){
            Log.e("0.0",e.getMessage());
        }
        super.onEvent(context, event, extras);
    }
}
