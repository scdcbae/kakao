package com.hanbit2007.kakao.presentation.member;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.hanbit2007.kakao.R;

public class ListActivity extends AppCompatActivity implements View.OnClickListener{

    Button btDetail,btFind;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        btDetail = (Button) findViewById(R.id.btDetail);
        btFind = (Button) findViewById(R.id.btFind);

        btDetail.setOnClickListener(this);
        btFind.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()) {
            case R.id.btDetail:
                Log.d(">>>>>>>","11111");
                Toast.makeText(ListActivity.this, "Detail Complete", Toast.LENGTH_LONG).show();
                Log.d(">>>>>>>","222222");
                this.startActivity(new Intent(ListActivity.this, DetailActivity.class));
                Log.d(">>>>>>>","33333");
                break;
            case R.id.btFind:
                Toast.makeText(ListActivity.this, "Search Complete", Toast.LENGTH_LONG).show();
                this.startActivity(new Intent(ListActivity.this, SearchActivity.class));
                break;
        }
    }
}
