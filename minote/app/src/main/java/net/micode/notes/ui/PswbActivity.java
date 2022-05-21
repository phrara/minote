package net.micode.notes.ui;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import net.micode.notes.R;

public class PswbActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pswb);
        Button bt_sub=findViewById(R.id.bt_sub);
        EditText et_psw=findViewById(R.id.et_psw);
        bt_sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String str_psw = et_psw.getText().toString().trim();
                if(str_psw.length()==0){
                    Toast.makeText(PswbActivity.this, "密码不能为空", Toast.LENGTH_SHORT).show();
                }else {
                    if("123456".equals(str_psw)){
                        startActivity(new Intent(PswbActivity.this,MainActivity.class));

                    }else {
                        Toast.makeText(PswbActivity.this, "密码错误", Toast.LENGTH_SHORT).show();

                    }
                }
            }
        });
    }
}