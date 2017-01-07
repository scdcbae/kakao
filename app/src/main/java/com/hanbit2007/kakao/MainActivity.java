package com.hanbit2007.kakao;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.hanbit2007.kakao.presentation.member.LoginActivity;
import com.hanbit2007.kakao.presentation.member.RegistActivity;

public class MainActivity extends AppCompatActivity  implements View.OnClickListener{

    Button btJoin, btLogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btJoin = (Button) findViewById(R.id.btJoin);
        btLogin = (Button) findViewById(R.id.btLogin);

        btJoin.setOnClickListener(this);
        btLogin.setOnClickListener(this);
    }

    @Override
    public void onClick(View v){
        switch(v.getId()){
            case R.id.btJoin:
                Toast.makeText(MainActivity.this, "Click Join", Toast.LENGTH_LONG).show();
                this.startActivity(new Intent(MainActivity.this, RegistActivity.class));
                break;
            case R.id.btLogin:
                Toast.makeText(MainActivity.this, "Click Login", Toast.LENGTH_LONG).show();
                this.startActivity(new Intent(MainActivity.this, LoginActivity.class));
                break;
        }
    }
}