package net.micode.notes.ui;

import android.app.Activity;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.text.Spanned;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import net.micode.notes.R;

import org.commonmark.node.Node;
import org.commonmark.parser.Parser;
import org.commonmark.renderer.html.HtmlRenderer;

public class MarkDownActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mark_down);

        System.out.println("ssss");

        // 获取mdStr
        Bundle bundle = getIntent().getExtras();
        String mdStr = bundle.getString("mdStr");

        // 将markdown解析为html
        Parser parser = Parser.builder().build();
        Node document = parser.parse(mdStr);
        HtmlRenderer hr = HtmlRenderer.builder().build();
        String string  = hr.render(document);
        Spanned res = Html.fromHtml(string);

        // 渲染
        EditText mdView = findViewById(R.id.md_view);
        mdView.setText(res);

        // 返回按钮
        Button backBtn = findViewById(R.id.BackBtn);
        backBtn.setTextColor(Color.YELLOW);
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}