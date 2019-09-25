package com.example.test.langpush.util;

import android.annotation.TargetApi;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.graphics.Color;
import android.os.Build;

public class PushChannelAndroid8 {

    //设置通知通道
    public static void notifyChannel(Context context, String channelId, String channelName) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            int importance = NotificationManager.IMPORTANCE_HIGH;
            createNotificationChannel(context,channelId, channelName, importance);
        }
    }
    @TargetApi(Build.VERSION_CODES.O)
    private static void createNotificationChannel(Context context,String channelId,String channelName, int importance) {
        NotificationManager notificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        NotificationChannel channel = notificationManager.getNotificationChannel(channelId);
        if(channel == null){
            channel = new NotificationChannel(channelId, channelName, importance);
            channel.setShowBadge(true);//显示红点提示
            channel.setDescription(channelName);
            channel.enableLights(true);
            channel.enableVibration(true);
            channel.setShowBadge(true);
            channel.setLightColor(Color.GREEN);
            notificationManager.createNotificationChannel(channel);
        }
    }
}
