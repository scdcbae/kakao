package com.hanbit2007.kakao.presentation.message;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Vibrator;
import android.preference.PreferenceManager;
import android.telephony.SmsManager;
import android.webkit.JavascriptInterface;
import android.widget.Toast;

/**
 * Created by hb2007 on 2017-01-21.
 */

public class javascriptInterface {
    Context context;

    public javascriptInterface(Context context) {
        this.context = context;
    }
    @JavascriptInterface
    public void showToast(String message){
        Toast.makeText(context, message, Toast.LENGTH_LONG).show();
    }
    @JavascriptInterface
    public void savePreferences(String key, String value){
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor editor = sp.edit();
        editor.putString(key, value);
        editor.commit();
    }
    @JavascriptInterface
    public void Vibrate(long milliseconds){
        Vibrator v = (Vibrator) context.getSystemService(Context.VIBRATOR_SERVICE);
        v.vibrate(milliseconds);
    }
    @JavascriptInterface
    public void sendSMS(String phone, String message){
        SmsManager sms = SmsManager.getDefault();
        sms.sendTextMessage(phone, null, message, null, null);
    }
}
