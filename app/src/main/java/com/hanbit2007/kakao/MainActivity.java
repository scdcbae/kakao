package com.hanbit2007.kakao;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.hanbit2007.kakao.presentation.member.LoginActivity;
import com.hanbit2007.kakao.presentation.member.RegistActivity;
import com.hanbit2007.kakao.util.BackPressCloseHandler;

public class MainActivity extends AppCompatActivity  implements View.OnClickListener{

    //Button btJoin, btLogin;
    Button regist_btn, menu_login, menu_help;
    LinearLayout help_center;
    TextView menu_home;
    View mCustomView;
    private BackPressCloseHandler backPressCloseHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        menu_home = (TextView) findViewById(R.id.menu_home);
        android.support.v7.app.ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayShowCustomEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(false);
        actionBar.setDisplayShowTitleEnabled(false);
        actionBar.setDisplayShowHomeEnabled(false);
        mCustomView = LayoutInflater.from(MainActivity.this).inflate(R.layout.main_custombar, null);
        actionBar.setCustomView(mCustomView);
        setContentView(R.layout.activity_main);
        init();
/*
        btJoin = (Button) findViewById(R.id.btJoin);
        btLogin = (Button) findViewById(R.id.btLogin);

        btJoin.setOnClickListener(this);
        btLogin.setOnClickListener(this);
*/
    }

    private void init() {
        regist_btn = (Button) findViewById(R.id.regist_btn);
        //help_center = (LinearLayout) findViewById(R.id.help_center);
        menu_login = (Button) mCustomView.findViewById(R.id.menu_login);
        menu_help = (Button) mCustomView.findViewById(R.id.menu_help);
        regist_btn.setOnClickListener(this);
        //help_center.setOnClickListener(this);
        menu_login.setOnClickListener(this);
        menu_help.setOnClickListener(this);
        backPressCloseHandler = new BackPressCloseHandler(this);
    }

    @Override
    public void onClick(View v){
        switch(v.getId()){
            case R.id.btJoin:
//                Toast.makeText(MainActivity.this, "Click Join", Toast.LENGTH_LONG).show();
                this.startActivity(new Intent(MainActivity.this, RegistActivity.class));
                break;
            case R.id.menu_help:
                startActivity(new Intent(MainActivity.this, null/*HelpActivity.class*/));
                break;
            case R.id.menu_login:
                this.startActivity(new Intent(MainActivity.this, LoginActivity.class));
                break;
/*
            case R.id.btLogin:
                Toast.makeText(MainActivity.this, "Click Login", Toast.LENGTH_LONG).show();
                this.startActivity(new Intent(MainActivity.this, LoginActivity.class));
                break;
*/
        }
    }

    @Override
    public void onBackPressed(){
        backPressCloseHandler.onBackPressed();
    }
}

