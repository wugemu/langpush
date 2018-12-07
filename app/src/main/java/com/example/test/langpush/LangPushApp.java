package com.example.test.langpush;

import android.app.Application;
import android.content.Context;

import com.example.test.langpush.util.PushUtil;
import com.xiaomi.mipush.sdk.MiPushClient;

//需要打开应用推送权限
public class LangPushApp extends Application {
    //华为推送初始化 key在AndroidManifest.xml
    //小米推送参数配置
    public static final String XIAOMI_APP_ID = "2882303761517901111";
    public static final String XIAOMI_APP_KEY = "5521790093123";
    //魅族推送参数配置
    public static final String MEIZU_APP_ID = "117123";
    public static final String MEIZU_APP_KEY = "929c20e1813f42a7af29c490c1338123";
    //OPPO推送参数配置
    public static final String OPPO_APP_AppKey = "e4b873800e744cae9e685a2f552e1112";
    public static final String OPPO_APP_AppSecret = "69a42a0800444e2c81404e127e9d5341";

    @Override
    public void onCreate() {
        super.onCreate();
        //推送初始化
        PushUtil.initPush(this);
    }

    //小米注册
    public static void reInitXiaoMiPush(Context ctx) {
        MiPushClient.registerPush(ctx.getApplicationContext(), XIAOMI_APP_ID, XIAOMI_APP_KEY);
    }

    //魅族注册
    public static void reInitMeiZuPush(Context ctx) {
        com.meizu.cloud.pushsdk.PushManager.register(ctx, MEIZU_APP_ID, MEIZU_APP_KEY);
    }

    //OPPO注册
    public static void reInitOppoPush(Context ctx){
        com.coloros.mcssdk.PushManager.getInstance().register(ctx,OPPO_APP_AppKey,OPPO_APP_AppSecret,new OPPOPushCallback());
    }
}
