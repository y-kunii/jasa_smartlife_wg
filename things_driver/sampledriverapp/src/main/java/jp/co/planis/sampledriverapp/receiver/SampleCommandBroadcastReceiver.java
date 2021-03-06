package jp.co.planis.sampledriverapp.receiver;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.support.v4.content.WakefulBroadcastReceiver;

import jp.co.planis.sampledriverapp.service.SampleGatewayToDriverIntentService;

/**
 * ゲートウェイからのコマンドを受信するレシーバのサンプル
 * Created by y_akimoto on 2016/09/21.
 */
public class SampleCommandBroadcastReceiver extends WakefulBroadcastReceiver{
    @Override
    public void onReceive(Context context, Intent intent) {
        // 受け取ったIntentの処理をIntentServiceで行う
        ComponentName componentName = new ComponentName(context.getPackageName(), SampleGatewayToDriverIntentService.class.getName());

        // サービスの起動。処理中スリープを制御
        startWakefulService(context, (intent.setComponent(componentName)));
        setResultCode(Activity.RESULT_OK);
    }
}
