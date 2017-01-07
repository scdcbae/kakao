package com.hanbit2007.kakao.presentation.member;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.hanbit2007.kakao.R;

public class RegistActivity extends AppCompatActivity implements View.OnClickListener{

    Button btRegist, btJoin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regist);

        btRegist = (Button) findViewById(R.id.btRegist);
        btJoin = (Button) findViewById(R.id.btJoin);

        btRegist.setOnClickListener(this);
        btJoin.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId())
        {
            case R.id.btRegist:
                this.startActivity(new Intent(RegistActivity.this, RegistActivity.class));
                break;
            case R.id.btJoin:
                this.startActivity(new Intent(RegistActivity.this, LoginActivity.class));
                break;
        }
    }
}
