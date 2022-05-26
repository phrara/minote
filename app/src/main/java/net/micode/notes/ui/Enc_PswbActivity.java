package net.micode.notes.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import net.micode.notes.R;

public class Enc_PswbActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.enc_verify);

        Button bt_sub=findViewById(R.id.bt_sub);
        bt_sub.getBackground().setAlpha(70);


        EditText et_psw= (EditText) findViewById(R.id.et_psw);
            et_psw.setInputType(129);//输入口令时不可见

        bt_sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String str_psw = et_psw.getText().toString().trim();
                if(str_psw.length()==0){
                    Toast.makeText(Enc_PswbActivity.this, "密码不能为空", Toast.LENGTH_SHORT).show();
                }else {
                    if("123456".equals(str_psw)){
                        startActivity(new Intent(Enc_PswbActivity.this, Enc_MainActivity.class));

                    }else {
                        Toast.makeText(Enc_PswbActivity.this, "密码错误", Toast.LENGTH_SHORT).show();

                    }
                }
            }
        });
    }
}