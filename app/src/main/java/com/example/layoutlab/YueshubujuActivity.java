package com.example.layoutlab;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class YueshubujuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yueshubuju_layout);

        // 示例：演示约束布局特性
        Toast.makeText(this, "这是约束布局示例", Toast.LENGTH_SHORT).show();
    }

    // 可选：添加返回键处理
    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}