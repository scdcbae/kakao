package com.hanbit2007.kakao.presentation.member;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.hanbit2007.kakao.R;
import com.hanbit2007.kakao.domain.MemberBean;
import com.hanbit2007.kakao.service.MemberService;
import com.hanbit2007.kakao.service.MemberServiceImpl;
import com.hanbit2007.kakao.util.MemberAdapter;

import java.util.ArrayList;

public class ListActivity extends AppCompatActivity implements View.OnClickListener{
    MemberService service;
    ListView lv_member_list;
    final String[] arr = new String[1];

//    Button btDetail,btFind;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        service = new MemberServiceImpl(this.getApplicationContext());
        lv_member_list = (ListView) findViewById(R.id.lv_member_list);
        ArrayList<MemberBean> list = service.list();
        Log.d("Service ?óê?Ñú Î¶¨ÌÑ¥?ïú ?ç∞?ù¥?Ñ∞ Í∞??àò: ",String.valueOf(list.size()));
        lv_member_list.setAdapter(new MemberAdapter(list, this));
        lv_member_list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View v, int i, long l) {
                Object o = lv_member_list.getItemAtPosition(i);
                MemberBean member = (MemberBean) o;
                Toast.makeText(ListActivity.this, "?Ñ†?Éù?ïú ?ù¥Î¶? "+member.getName(),
                    Toast.LENGTH_LONG).show();
                Intent intent = new Intent(ListActivity.this, DetailActivity.class);
                intent.putExtra("id", member.getId());
                startActivity(intent);
            }
        });

        lv_member_list.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View v, int i, long l) {
                Object o = lv_member_list.getItemAtPosition(i);
                MemberBean member = (MemberBean) o;
                arr[0] = member.getId();
                new AlertDialog.Builder(ListActivity.this)
                    .setTitle("?Ç≠?†ú ?")
                    .setMessage("?†ïÎßêÎ°ú ?Ç≠?†ú?ïò?ãúÍ≤†Ïäµ?ãàÍπ??")
                    .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            service.unregist(arr[0]);
                        }
                    })
                    .setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    }).show();

                return true;
            }
        });
/*
        btDetail = (Button) findViewById(R.id.btDetail);
        btFind = (Button) findViewById(btFind);

        btDetail.setOnClickListener(this);
        btFind.setOnClickListener(this);
*/
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()) {
/*
            case R.id.btDetail:
                Log.d(">>>>>>>","11111");
                Toast.makeText(ListActivity.this, "Detail Complete", Toast.LENGTH_LONG).show();
                Log.d(">>>>>>>","222222");
                this.startActivity(new Intent(ListActivity.this, DetailActivity.class));
                Log.d(">>>>>>>","33333");
                break;
            case btFind:
                Toast.makeText(ListActivity.this, "Search Complete", Toast.LENGTH_LONG).show();
                this.startActivity(new Intent(ListActivity.this, SearchActivity.class));
                break;
*/
        }
    }
}
