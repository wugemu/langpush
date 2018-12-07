package com.example.test.langpush;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;

import com.meizu.cloud.pushsdk.MzPushMessageReceiver;
import com.meizu.cloud.pushsdk.handler.MzPushMessage;
import com.meizu.cloud.pushsdk.notification.PushNotificationBuilder;
import com.meizu.cloud.pushsdk.platform.message.PushSwitchStatus;
import com.meizu.cloud.pushsdk.platform.message.RegisterStatus;
import com.meizu.cloud.pushsdk.platform.message.SubAliasStatus;
import com.meizu.cloud.pushsdk.platform.message.SubTagsStatus;
import com.meizu.cloud.pushsdk.platform.message.UnRegisterStatus;

public class MEIZUPushRevicer extends MzPushMessageReceiver {
    @Override
    @Deprecated
    public void onRegister(Context context, String pushid) {
        //调用PushManager.register(context）方法后，会在此回调注册状态
        //应用在接受返回的pushid
        Log.e("0.0","魅族onRegister");
    }

    @Override
    public void onMessage(Context context, String s) {
        //接收服务器推送的透传消息
        Log.e("0.0","魅族onMessage");
    }

    @Override
    @Deprecated
    public void onUnRegister(Context context, boolean b) {
        //调用PushManager.unRegister(context）方法后，会在此回调反注册状态
        Log.e("0.0","魅族onUnRegister");
    }

    //设置通知栏小图标
    @Override
    public void onUpdateNotificationBuilder(PushNotificationBuilder pushNotificationBuilder) {
        //重要,详情参考应用小图标自定设置
        pushNotificationBuilder.setmStatusbarIcon(R.drawable.mz_push_notification_small_icon);
        Log.e("0.0","魅族onUpdateNotificationBuilder");

    }

    @Override
    public void onPushStatus(Context context,PushSwitchStatus pushSwitchStatus) {
        //检查通知栏和透传消息开关状态回调
        Log.e("0.0","魅族onPushStatus");
    }

    @Override
    public void onRegisterStatus(Context context,RegisterStatus registerStatus) {
        //调用新版订阅PushManager.register(context,appId,appKey)回调
        Log.e("0.0","魅族onRegisterStatus");
        if(registerStatus!=null){
            String pushId=registerStatus.getPushId();
            if(!TextUtils.isEmpty(pushId)){
                Log.e("0.0","魅族pushId："+pushId);
                Log.e("0.0","魅族pushId有效时间："+registerStatus.getExpireTime());
            }
        }

    }

    @Override
    public void onUnRegisterStatus(Context context,UnRegisterStatus unRegisterStatus) {
        //新版反订阅回调
        Log.e("0.0","魅族onUnRegisterStatus");
    }

    @Override
    public void onSubTagsStatus(Context context,SubTagsStatus subTagsStatus) {
        //标签回调
        Log.e("0.0","魅族onSubTagsStatus");
    }

    @Override
    public void onSubAliasStatus(Context context,SubAliasStatus subAliasStatus) {
        //别名回调
        Log.e("0.0","魅族onSubAliasStatus");
    }
    @Override
    public void onNotificationArrived(Context context, MzPushMessage mzPushMessage) {
        //通知栏消息到达回调，flyme6基于android6.0以上不再回调
        Log.e("0.0","魅族onNotificationArrived");
    }

    @Override
    public void onNotificationClicked(Context context, MzPushMessage mzPushMessage) {
        //通知栏消息点击回调
        Log.e("0.0","魅族onNotificationClicked");
    }

    @Override
    public void onNotificationDeleted(Context context, MzPushMessage mzPushMessage) {
        //通知栏消息删除回调；flyme6基于android6.0以上不再回调
        Log.e("0.0","魅族onNotificationDeleted");
    }
}
