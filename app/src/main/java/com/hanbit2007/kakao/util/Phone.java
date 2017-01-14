package com.hanbit2007.kakao.util;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;

/**
 * Created by hb2007 on 2017-01-14.
 */

public class Phone {
    private Context context;
    private Activity activity;

    public Phone(Context context, Activity activity) {
        this.context = context;
        this.activity = activity;
    }

    public void dial(String phoneNo){
        Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+phoneNo));
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
    }

    public void directCall(String phoneNo){
        Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:"+phoneNo));
        if(ActivityCompat.checkSelfPermission(context, Mainfest.permission.CALL_PHONE)
                != PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(activity, new String[]{Mainfest.permission.CALL_PHONE},2);
            return;
        }
        intent.addFlags(intent.FLAG_ACTIVITY_NEW_TASK);
    }
}
