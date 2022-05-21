package net.micode.notes.ui;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ListView;

import net.micode.notes.R;

import java.util.ArrayList;
import java.util.HashMap;

public class ReadActivity extends Activity {

    private ListView lvread;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read);
        initView();

    }

    @Override
    protected void onResume() {
        super.onResume();
        initdata();
    }

    private void initView() {
        lvread = (ListView) findViewById(R.id.lvread);
    }

    private void initdata() {
        ArrayList<HashMap<String, Object>> list= DbHelper.getInstance(this).getLampList();
        ReadAdapter readAdapter =new ReadAdapter(this,list);

        lvread.setAdapter(readAdapter);
    }



}