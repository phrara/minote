package net.micode.notes.ui;


import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

import net.micode.notes.R;

import java.util.ArrayList;
import java.util.HashMap;

public class Enc_ReadActivity extends Activity {

    private ListView lvread;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.enc_read);
        initView();

    }

    @Override
    protected void onResume() {
        super.onResume();
        initdata();
    }

    private void initView() {// 初始化一个列表，这个元件能够自适应元素内容多少。
        lvread = (ListView) findViewById(R.id.lvread);
    }

    private void initdata() {
        ArrayList<HashMap<String, Object>> list= DbHelper.getInstance(this).getLampList();
        Enc_ReadAdapter readAdapter =new Enc_ReadAdapter(this,list);

        lvread.setAdapter(readAdapter);//令列表装载这个内容组件
    }



}