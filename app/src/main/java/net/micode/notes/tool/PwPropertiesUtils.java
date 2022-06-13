package net.micode.notes.tool;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.util.Log;

import java.io.IOException;
import java.io.InputStream;

import java.util.Properties;

/**
 * 配置文件读取类
 */
public class PwPropertiesUtils {

    //1、配置文件的位置在assets资源目录下
    private final static String m_strPath = "password.properties";
    private static final String TAG = "sad";
    //2、配置文件的位置在源代码根目录(src下)
    //private final static String m_strPath = "/global.properties";

    public static Properties getProperties(Context c){
        // 读取参数配置

        Properties props = new Properties();

        try {

            props.load(c.getApplicationContext().getAssets().open(m_strPath));
            Log.d(TAG, "getProperties: 111111111111111");
        } catch (IOException e) {

            AlertDialog.Builder dialog = new AlertDialog.Builder(c);

            dialog.setTitle("错误");

            dialog.setMessage("读取配置文件失败");

            dialog.setCancelable(false);

            dialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {

                @Override

                public void onClick(DialogInterface dialogInterface, int i) {


                }

            });

            dialog.show();
        }

        return props;
    }

}
