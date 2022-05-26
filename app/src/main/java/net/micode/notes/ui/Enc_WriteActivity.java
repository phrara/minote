package net.micode.notes.ui;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import net.micode.notes.R;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Enc_WriteActivity extends Activity implements View.OnClickListener {

    private EditText mEtnot;
    /**
     * 写入
     */
    private Button mBtwrite;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.enc_write);
        initView();
    }

    private void initView() {
        mEtnot = (EditText) findViewById(R.id.etnot);

        mBtwrite = (Button) findViewById(R.id.btwrite);
        mBtwrite.getBackground().setAlpha(70);
        mBtwrite.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.btwrite:
                writeNot();
                break;
        }
    }

    private void writeNot() {
        if(mEtnot.getText().toString().trim().isEmpty()){
            Toast.makeText(this, "日记内容不能为空", Toast.LENGTH_SHORT).show();
            return;
        }
        Enc_Notepadinfo notepadinfo=new Enc_Notepadinfo();
        notepadinfo.setContent(mEtnot.getText().toString().trim());

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");// HH:mm:ss
        //获取当前时间
        Date date = new Date(System.currentTimeMillis());
        notepadinfo.setTime(simpleDateFormat.format(date));
       DbHelper.getInstance(this).saveLamp(notepadinfo);
        Toast.makeText(this, "写入成功", Toast.LENGTH_SHORT).show();
        finish();
    }
}