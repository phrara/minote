package net.micode.notes.ui;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import net.micode.notes.R;

import java.util.ArrayList;

public class MainActivity extends Activity implements View.OnClickListener {

    /**
     * 写日记
     */
    private Button mBtwrite;
    /**
     * 查看日记
     */
    private Button mBtread;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //初始化界面
        initView();

}


    private void initView() {
        mBtwrite = (Button) findViewById(R.id.btwrite);
        mBtwrite.setOnClickListener(this);
        mBtread = (Button) findViewById(R.id.btread);
        mBtread.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.btwrite:
                startActivity(new Intent(MainActivity.this,WriteActivity.class));

                break;
            case R.id.btread:
                startActivity(new Intent(MainActivity.this,ReadActivity.class));

                break;
        }
    }
}