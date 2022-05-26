package net.micode.notes.ui;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
;

import net.micode.notes.R;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class Enc_ReviseActivity extends Activity {

    EditText et_r;//revise文本框
    TextView tv_id;
     Button bt_u;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.edit_layout);

         et_r=findViewById(R.id.et_r);
         tv_id=findViewById(R.id.tv_id);

         bt_u=findViewById(R.id.bt_u);
         bt_u.getBackground().setAlpha(70);
         tv_id.setText("id:  "+getIntent().getStringExtra("id"));
        et_r.setText(getIntent().getStringExtra("content"));
        bt_u.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(et_r.getText().toString().trim().length()==0){
                    Toast.makeText(Enc_ReviseActivity.this, "内容不能为空", Toast.LENGTH_SHORT).show();
                return;
                }
                Enc_Notepadinfo notepadinfo =new Enc_Notepadinfo();
                notepadinfo.setId(getIntent().getStringExtra("id"));
                notepadinfo.setContent(et_r.getText().toString().trim());
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss E");// HH:mm:ss
                simpleDateFormat.setTimeZone(TimeZone.getTimeZone("Asia/Shanghai"));//设置时区
                //获取当前时间
                Date date = new Date(System.currentTimeMillis());
                notepadinfo.setTime(simpleDateFormat.format(date));
                DbHelper.getInstance(Enc_ReviseActivity.this).updataItem(notepadinfo);
                Toast.makeText(Enc_ReviseActivity.this, "成功", Toast.LENGTH_SHORT).show();
               finish();
            }
        });

    }






}
