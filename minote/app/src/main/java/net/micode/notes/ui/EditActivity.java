package net.micode.notes.ui;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.icu.util.LocaleData;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
;

import net.micode.notes.R;

import java.text.SimpleDateFormat;
import java.util.Date;

public class EditActivity extends Activity {

    EditText et_c;
    TextView tv_id;
     Button bt_u;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.edit_layout);

         et_c=findViewById(R.id.et_c);
         tv_id=findViewById(R.id.tv_id);
         bt_u=findViewById(R.id.bt_u);
         tv_id.setText("id:  "+getIntent().getStringExtra("id"));
        et_c.setText(getIntent().getStringExtra("content"));
        bt_u.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(et_c.getText().toString().trim().length()==0){
                    Toast.makeText(EditActivity.this, "内容不能为空", Toast.LENGTH_SHORT).show();
                return;
                }
                Notepadinfo notepadinfo =new Notepadinfo();
                notepadinfo.setId(getIntent().getStringExtra("id"));
                notepadinfo.setContent(et_c.getText().toString().trim());
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");// HH:mm:ss
                //获取当前时间
                Date date = new Date(System.currentTimeMillis());
                notepadinfo.setTime(simpleDateFormat.format(date));
                DbHelper.getInstance(EditActivity.this).updataItem(notepadinfo);
                Toast.makeText(EditActivity.this, "成功", Toast.LENGTH_SHORT).show();
               finish();
            }
        });

    }






}
