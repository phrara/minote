package net.micode.notes.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import net.micode.notes.R;
import net.micode.notes.tool.PwPropertiesUtils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

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
                    //从配置文件中拿取密码的hash值
                    String psw = PwPropertiesUtils.getProperties(getApplicationContext()).getProperty("cyp_password");
                    //将用户输入的值hash后进行比较
                    String input_pwMD5= stringMD5(stringMD5(str_psw));
                    //System.out.println(str_psw);
                    if(psw.equals(input_pwMD5)){
                        startActivity(new Intent(Enc_PswbActivity.this, Enc_MainActivity.class));

                    }else {
                        Toast.makeText(Enc_PswbActivity.this, "密码错误", Toast.LENGTH_SHORT).show();

                    }
                }
            }
        });
    }

    public static String stringMD5(String input) {

        try {
//            拿到一个MD5转换器（如果想要SHA1参数换成”SHA1”）
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
//            输入的字符串转换成字节数组
            byte[] inputByteArray = input.getBytes();
//            inputByteArray是输入字符串转换得到的字节数组
            messageDigest.update(inputByteArray);
//            转换并返回结果，也是字节数组，包含16个元素
            byte[] resultByteArray = messageDigest.digest();
//            字符数组转换成字符串返回
            return byteArrayToHex(resultByteArray);
        } catch (NoSuchAlgorithmException e) {
            return null;
        }
    }

    //    将字节数组换成成16进制的字符串
    public static String byteArrayToHex(byte[] byteArray) {

//        首先初始化一个字符数组，用来存放每个16进制字符
        char[] hexDigits = {'0','1','2','3','4','5','6','7','8','9', 'A','B','C','D','E','F' };

//        new一个字符数组，这个就是用来组成结果字符串的（解释一下：一个byte是八位二进制，也就是2位十六进制字符（2的8次方等于16的2次方））
        char[] resultCharArray =new char[byteArray.length * 2];

//        遍历字节数组，通过位运算（位运算效率高），转换成字符放到字符数组中去
        int index = 0;

        for (byte b : byteArray) {
            resultCharArray[index++] = hexDigits[b>>> 4 & 0xf];
            resultCharArray[index++] = hexDigits[b& 0xf];
        }

//        字符数组组合成字符串返回
        return new String(resultCharArray);
    }
}