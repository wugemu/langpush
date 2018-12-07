package com.example.test.langpush;

import android.text.TextUtils;
import android.util.Log;

import com.coloros.mcssdk.PushManager;
import com.coloros.mcssdk.callback.PushCallback;
import com.coloros.mcssdk.mode.SubscribeResult;

import java.util.List;

public class OPPOPushCallback implements PushCallback {
    @Override
    public void onRegister(int i, String registerID) {
        Log.e("0.0","oppo推送code:"+i+" 推送registerID："+registerID);
        if(!TextUtils.isEmpty(registerID)){

        }else {
            //注册失败 重新注册
            PushManager.getInstance().getRegister();
        }
    }

    @Override
    public void onUnRegister(int i) {

    }

    @Override
    public void onGetAliases(int i, List<SubscribeResult> list) {

    }

    @Override
    public void onSetAliases(int i, List<SubscribeResult> list) {

    }

    @Override
    public void onUnsetAliases(int i, List<SubscribeResult> list) {

    }

    @Override
    public void onSetUserAccounts(int i, List<SubscribeResult> list) {

    }

    @Override
    public void onUnsetUserAccounts(int i, List<SubscribeResult> list) {

    }

    @Override
    public void onGetUserAccounts(int i, List<SubscribeResult> list) {

    }

    @Override
    public void onSetTags(int i, List<SubscribeResult> list) {

    }

    @Override
    public void onUnsetTags(int i, List<SubscribeResult> list) {

    }

    @Override
    public void onGetTags(int i, List<SubscribeResult> list) {

    }

    @Override
    public void onGetPushStatus(int i, int i1) {

    }

    @Override
    public void onSetPushTime(int i, String s) {

    }

    @Override
    public void onGetNotificationStatus(int i, int i1) {

    }
}
