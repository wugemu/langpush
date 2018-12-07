package com.example.test.langpush.util;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.os.Process;
import android.util.Log;

import com.coloros.mcssdk.PushManager;
import com.example.test.langpush.LangPushApp;
import com.huawei.android.hms.agent.HMSAgent;
import com.huawei.android.hms.agent.common.handler.ConnectHandler;
import com.huawei.android.hms.agent.push.handler.GetPushStateHandler;
import com.huawei.android.hms.agent.push.handler.GetTokenHandler;
import com.meizu.cloud.pushsdk.util.MzSystemUtils;
import com.xiaomi.channel.commonutils.logger.LoggerInterface;
import com.xiaomi.mipush.sdk.Logger;

import java.util.List;

public class PushUtil {
    public static void initPush(Application context){
        //华为推送初始化 key在AndroidManifest.xml
        if(SystemUtil.isHuawei()) {
            HMSAgent.init(context);
        }

        //小米推送初始化
        if(SystemUtil.isXiaomi()) {
            if (shouldInit(context)) {
                LangPushApp.reInitXiaoMiPush(context);
            }
            //小米推送日志
            LoggerInterface newLogger = new LoggerInterface() {
                @Override
                public void setTag(String tag) {
                    // ignore
                }

                @Override
                public void log(String content, Throwable t) {
                    Log.d("0.0", content, t);
                }

                @Override
                public void log(String content) {
                    Log.d("0.0", content);
                }
            };
            Logger.setLogger(context, newLogger);
        }

        //魅族推送初始化
        if(MzSystemUtils.isBrandMeizu(context)){
            //支持华为推送
            LangPushApp.reInitMeiZuPush(context);
        }

        //OPPO推送初始化
        if(PushManager.isSupportPush(context)){
            //支持OPPO推送
            LangPushApp.reInitOppoPush(context);
        }

        //个推推送

    }

    public static void HuaWeiConnect(Activity activity){
        if(SystemUtil.isHuawei()) {
            //链接华为推送服务
            HMSAgent.connect(activity, new ConnectHandler() {
                @Override
                public void onConnect(int rst) {
                }
            });
            //获取华为推送token
            HMSAgent.Push.getToken(new GetTokenHandler() {
                @Override
                public void onResult(int rst) {
                }
            });
            //获取华为推送状态
            HMSAgent.Push.getPushState(new GetPushStateHandler() {
                @Override
                public void onResult(int rst) {
                }
            });
        }
    }

    //因为推送服务XMPushService在AndroidManifest.xml中设置为运行在另外一个进程，这导致本Application会被实例化两次，所以我们需要让应用的主进程初始化。
    private static boolean shouldInit(Application context) {
        ActivityManager am = ((ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE));
        List<ActivityManager.RunningAppProcessInfo> processInfos = am.getRunningAppProcesses();
        String mainProcessName = context.getPackageName();
        int myPid = Process.myPid();
        for (ActivityManager.RunningAppProcessInfo info : processInfos) {
            if (info.pid == myPid && mainProcessName.equals(info.processName)) {
                return true;
            }
        }
        return false;
    }
}
