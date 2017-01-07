package com.hanbit2007.kakao.presentation.message;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.hanbit2007.kakao.R;
import com.hanbit2007.kakao.service.MessageService;
import com.hanbit2007.kakao.service.MessageServiceImpl;

public class WriteMsgActivity extends AppCompatActivity implements View.OnClickListener{

    MessageService service;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_write_msg);

        service = new MessageServiceImpl(this.getApplicationContext());
    }

    @Override
    public void onClick(View v) {

    }
}
