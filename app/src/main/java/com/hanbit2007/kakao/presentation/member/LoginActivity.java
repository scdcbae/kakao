package com.hanbit2007.kakao.presentation.member;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.hanbit2007.kakao.MainActivity;
import com.hanbit2007.kakao.R;
import com.hanbit2007.kakao.domain.MemberBean;
import com.hanbit2007.kakao.service.MemberService;
import com.hanbit2007.kakao.service.MemberServiceImpl;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener{

    EditText etLoginId, etLoginPass;
    Button btLogin_login, btLogin_cancel;
    String sLoginId, sLoginPass;
    MemberService service;
    MemberBean member;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etLoginId = (EditText) findViewById(R.id.etLoginid);
        etLoginPass = (EditText) findViewById(R.id.etLoginpass);
        btLogin_login = (Button) findViewById(R.id.btLogin_login);
        btLogin_cancel = (Button) findViewById(R.id.btLogin_cancel);

        btLogin_login.setOnClickListener(this);
        btLogin_cancel.setOnClickListener(this);

        service = new MemberServiceImpl(this.getApplicationContext());
        member = new MemberBean();
    }

    @Override
    public void onClick(View v) {
        sLoginId = String.valueOf(etLoginId.getText());
        sLoginPass = String.valueOf(etLoginPass.getText());
        Log.d("넘어온 ID:" , sLoginId);
        Log.d("넘어온 PASS:", sLoginPass);
        member.setId(sLoginId);
        member.setPw(sLoginPass);

        switch(v.getId()){
            case R.id.btLogin_login:
                boolean flag = service.login(member);
                if(flag){
                    Toast.makeText(LoginActivity.this, "Login Complete", Toast.LENGTH_LONG).show();
                    this.startActivity(new Intent(LoginActivity.this, ListActivity.class));
                }else{
                    Toast.makeText(LoginActivity.this, "Login Fail", Toast.LENGTH_LONG).show();
                }
                break;
            case R.id.btLogin_cancel:
                this.startActivity(new Intent(LoginActivity.this, MainActivity.class));
                break;
        }

    }
}
