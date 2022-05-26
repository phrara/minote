package net.micode.notes.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import net.micode.notes.R;

public class Enc_MainActivity extends Activity implements View.OnClickListener {

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
        setContentView(R.layout.enc_main);
        //初始化界面
        initView();

}


    private void initView() {
        mBtwrite = (Button) findViewById(R.id.btwrite);
        mBtwrite.setOnClickListener(this);
        mBtwrite.getBackground().setAlpha(70);
        mBtread = (Button) findViewById(R.id.btread);
        mBtread.setOnClickListener(this);
        mBtread.getBackground().setAlpha(70);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.btwrite:
                startActivity(new Intent(Enc_MainActivity.this, Enc_WriteActivity.class));

                break;
            case R.id.btread:
                startActivity(new Intent(Enc_MainActivity.this, Enc_ReadActivity.class));

                break;
        }
    }
}