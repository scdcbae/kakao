package com.hanbit2007.kakao.presentation.member;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.hanbit2007.kakao.R;
import com.hanbit2007.kakao.domain.MemberBean;
import com.hanbit2007.kakao.presentation.message.WriteMsgActivity;
import com.hanbit2007.kakao.service.MemberService;
import com.hanbit2007.kakao.service.MemberServiceImpl;
import com.hanbit2007.kakao.util.Phone;

public class DetailActivity extends AppCompatActivity implements View.OnClickListener{

    TextView tvID, tvPass, tvName, tvTel, tvAddr;
    Button btCall, btMap, btMessage, btUpdate, btDelete, btList;
    ImageView Iv_Photo;
    Phone phone;

    /*
    private int[]photos={
            R.drawable.cupcake,
            R.drawable.donut,
            R.drawable.eclair,
            R.drawable.froyo,
            R.drawable.gingerbread,
            R.drawable.honeycomb,
            R.drawable.icecream,
            R.drawable.jellybean,
            R.drawable.kitkat,
            R.drawable.lollipop
    };
*/

    MemberService service;
    MemberBean member;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        service = new MemberServiceImpl(this.getApplicationContext());
        Intent intent = this. getIntent();
        String id = intent.getExtras().getString("id");
        member = service.searchById(id);
        phone = new Phone(this, this);

//        member = service.searchById("hong");
        tvID = (TextView) findViewById(R.id.tvID);
        tvPass = (TextView) findViewById(R.id.tvPass);
        tvName = (TextView) findViewById(R.id.tvName);
        tvTel = (TextView) findViewById(R.id.tvTel);
        tvAddr = (TextView) findViewById(R.id.tvAddr);
        Iv_Photo = (ImageView) findViewById(R.id.Iv_Photo);
        tvID.setText(member.getId());
        tvPass.setText(member.getPw());
        tvName.setText(member.getName());
        tvTel.setText(member.getPhone());
        tvAddr.setText(member.getAddr());
        //Iv_Photo.setImageResource(R.drawable.cupcake); //????????????????

//        int foo = getResources().getIdentifier(this.getPackageName() + ":drawable/" + "donut", null, null);
//int foo = getResources().getIdentifier(this.getPackageName() + ":drawable/" + member.getPhoto(), null, null);
        Log.d("DB 프로필 이미지: ", member.getPhoto());
//        String PhotoName = member.getPhoto().substring(member.getPhoto().length()-4, member.getPhoto().length());
//        int foo = getResources().getIdentifier(this.getPackageName() + ":drawable/" + PhotoName, null, null);
        int foo = getResources().getIdentifier(this.getPackageName() + ":drawable/" + member.getPhoto(), null, null);
        Iv_Photo.setImageDrawable(getResources().getDrawable(foo, getApplicationContext().getTheme()));

        btCall = (Button) findViewById(R.id.btCall);
        btMap = (Button) findViewById(R.id.btMap);
        btMessage = (Button) findViewById(R.id.btMessage);
        btUpdate = (Button) findViewById(R.id.btUpdate);
        btDelete = (Button) findViewById(R.id.btDelete);
        btList = (Button) findViewById(R.id.btList);

        btCall.setOnClickListener(this);
        btMap.setOnClickListener(this);
        btMessage.setOnClickListener(this);
        btUpdate.setOnClickListener(this);
        btDelete.setOnClickListener(this);
        btList.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.btCall:
                Log.d("전화번호:", member.getPhone());
                phone.dial(member.getPhone());
                break;
            case R.id.btMap:
                //활성화 시 엄청 느려짐.
                Intent intent_map = new Intent(DetailActivity.this, MapsActivity.class);
                //위도 경도 값을 넘겨주어야 함. site => http://mygeoposition.com/
                member.setAddr("37.5597680,126.9423080");
                intent_map.putExtra("position", member.getAddr());
                startActivity(intent_map);
                break;
            case R.id.btMessage:
                //웹뷰가 되어야 가능.
                Intent intent_msg = new Intent(DetailActivity.this, WriteMsgActivity.class);
                intent_msg.putExtra("phone", member.getPhone());
                startActivity(intent_msg);
                break;
            case R.id.btUpdate:
                Intent intent = new Intent(DetailActivity.this, ModifyActivity.class);
                intent.putExtra("id", member.getId());
                startActivity(intent);
//                this.startActivity(new Intent(DetailActivity.this, ModifyActivity.class));
                break;
            case R.id.btDelete:
                service.unregist(member.getId());
                this.startActivity(new Intent(DetailActivity.this, ListActivity.class));
                break;
            case R.id.btList:
                this.startActivity(new Intent(DetailActivity.this, ListActivity.class));
                break;
        }
    }
}
