package net.micode.notes.ui;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import net.micode.notes.R;

import java.util.ArrayList;
import java.util.HashMap;

public class Enc_ReadAdapter extends BaseAdapter {

   private Context context;
    private ArrayList<HashMap<String, Object>> list;
    public Enc_ReadAdapter(Context context, ArrayList<HashMap<String, Object>> list){
        this.context = context;
        this.list=list;
    }

    @Override
    public int getCount() {

        return list.size();
    }

    @Override
    public Object getItem(int i) {

        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(final int p, View convertView , ViewGroup viewGroup) {
        ViewHolder viewHolder;
        if (convertView == null){
            viewHolder = new ViewHolder();

            // inflate出子项布局，实例化其中的图片控件和文本控件
            convertView = LayoutInflater.from(context).inflate(R.layout.enc_listview_item,viewGroup,false);

            viewHolder.tvname = (TextView) convertView.findViewById(R.id.tvcontent);
            viewHolder.tvtime = (TextView) convertView.findViewById(R.id.tvtime);
            viewHolder.bt_d = (Button) convertView.findViewById(R.id.bt_d);

            viewHolder.bt_u = (Button) convertView.findViewById(R.id.bt_u);

            convertView.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder) convertView.getTag();
        }
        // 绑定数据
        viewHolder.tvname.setText("内容："+list.get(p).get("content").toString());
        viewHolder.tvtime.setText(""+list.get(p).get("time").toString());
        viewHolder.bt_d.getBackground().setAlpha(70);
        viewHolder.bt_d.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new AlertDialog.Builder(context)
                        //图标
                        //标题
                        .setTitle("提示")
                        //不可点击外部区域取消对话框
                        .setCancelable(false)
                        //内容
                        .setMessage("确定删除？")
                        //第一个参数选项，第二个参数为该选项的点击事件
                        .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                              DbHelper.getInstance(context).deletItem(list.get(p).get("id").toString());
                                Toast.makeText(context, "成功", Toast.LENGTH_SHORT).show();
                                list.clear();
                                ArrayList<HashMap<String, Object>> list1= DbHelper.getInstance(context).getLampList();
                                 list=list1;
                                 notifyDataSetChanged();
                            }
                        })
                        //第一个参数选项，第二个参数为该选项的点击事件
                        .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                            }
                        })
                        //展示
                        .show();

            }
        });
        viewHolder.bt_u.getBackground().setAlpha(70);
        viewHolder.bt_u.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(context, Enc_ReviseActivity.class);
                intent.putExtra("id",list.get(p).get("id").toString());
                intent.putExtra("content",list.get(p).get("content").toString());
                context.startActivity(intent);
            }
        });
        return convertView;
    }

    // 内部类
    class ViewHolder{
        TextView tvname;
        TextView tvtime;
        Button bt_d;
        Button bt_u;
    }

}
