package com.phjt.autopackage;

import android.app.Application;
import android.util.Log;

import com.meituan.android.walle.WalleChannelReader;
import com.umeng.commonsdk.UMConfigure;

/**
 * @author: anjun
 * date:2020/7/29 15:24
 * company: 普华集团
 * description:
 */
 public class App extends Application {

    public static String channelName;

    @Override
    public void onCreate() {
        super.onCreate();
        // 获取渠道- 添加到友盟统计
        channelName = WalleChannelReader.getChannel(getApplicationContext());
        Log.i("channel-->", "" + "*****************************" + channelName);
        UMConfigure.init(this, "5f212307b4b08b653e8f50de", channelName, UMConfigure.DEVICE_TYPE_PHONE, null);
    }
}
