package com.example.test.langpush;

import android.content.Context;
import android.util.Log;

import com.coloros.mcssdk.PushService;
import com.coloros.mcssdk.mode.AppMessage;
import com.coloros.mcssdk.mode.CommandMessage;
import com.coloros.mcssdk.mode.SptDataMessage;

public class OPPOPushRevicer extends PushService {
    @Override
    public void processMessage(Context context, AppMessage appMessage) {
        super.processMessage(context, appMessage);
    }

    @Override
    public void processMessage(Context context, SptDataMessage sptDataMessage) {
        super.processMessage(context, sptDataMessage);
    }

    @Override
    public void processMessage(Context context, CommandMessage commandMessage) {
        Log.e("0.0","OPPO推送消息："+commandMessage.toString());
        super.processMessage(context, commandMessage);
    }
}
