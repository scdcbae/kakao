package com.hanbit2007.kakao.presentation.member;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.hanbit2007.kakao.R;
import com.hanbit2007.kakao.domain.MemberBean;
import com.hanbit2007.kakao.service.MemberService;
import com.hanbit2007.kakao.service.MemberServiceImpl;

public class ModifyActivity extends AppCompatActivity implements View.OnClickListener{
    TextView tvID;
    EditText etPass, etName, etTel, etAddr, etPhoto;
    ImageView Iv_Photo;
    Button btUpdate, btCancel;
//    ImageView IvPhoto;
    MemberService service;
    MemberBean member;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modify);
        service = new MemberServiceImpl(this.getApplicationContext());
        Intent intent = this. getIntent();
        String id = intent.getExtras().getString("id");

        member = service.searchById(id);
        tvID = (TextView) findViewById(R.id.tvID);
        etPass = (EditText) findViewById(R.id.etPass);
        etName = (EditText) findViewById(R.id.etName);
        etTel = (EditText) findViewById(R.id.etTel);
        etAddr = (EditText) findViewById(R.id.etAddr);
        etPhoto = (EditText) findViewById(R.id.etPhoto);
//        Iv_Photo = (ImageView) findViewById(R.id.Iv_Photo);
        btUpdate = (Button) findViewById(R.id.btUpdate);
        btCancel = (Button) findViewById(R.id.btCancel);

  //      int foo = getResources().getIdentifier(this.getPackageName() + ":drawable/" + "donut", null, null);
    //    IvPhoto.setImageDrawable(getResources().getDrawable(foo, getApplicationContext().getTheme()));

        btUpdate.setOnClickListener(this);
        btCancel.setOnClickListener(this);

        tvID.setText(member.getId());
        etPass.setHint(member.getPw());
        etName.setHint(member.getName());
        etTel.setHint(member.getPhone());
        etAddr.setHint(member.getAddr());

    }

    @Override
    public void onClick(View v) {
        switch(v.getId()) {
            case R.id.btUpdate:
                MemberBean temp = new MemberBean();
                temp.setId(tvID.getText().toString());
                temp.setPw((etPass.getText().toString().equals(""))?member.getPw():etPass.getText().toString());
                temp.setName((etName.getText().toString().equals(""))?member.getName():etName.getText().toString());
                temp.setPhone((etTel.getText().toString().equals(""))?member.getPhone():etTel.getText().toString());
                temp.setAddr((etAddr.getText().toString().equals(""))?member.getAddr():etAddr.getText().toString());
                temp.setPhoto((etPhoto.getText().toString().equals(""))?member.getPhoto():etPhoto.getText().toString());
                service.modify(temp);
                break;
            case R.id.btCall:
                break;
        }
        Intent intent = new Intent(ModifyActivity.this, DetailActivity.class);
        intent.putExtra("id", member.getId());
        startActivity(intent);
    }
}
