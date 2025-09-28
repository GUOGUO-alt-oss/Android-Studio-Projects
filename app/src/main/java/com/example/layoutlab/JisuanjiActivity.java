package com.example.layoutlab;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class JisuanjiActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jisuanji_layout);

        // 示例：简单计算器功能提示
        Toast.makeText(this, "这是计算器功能示例", Toast.LENGTH_SHORT).show();
    }

    // 可选：添加返回键处理
    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}