package com.example.layoutlab;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class TableLayoutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_table_layout);

        // 示例：演示表格布局特性
        Toast.makeText(this, "这是表格布局示例", Toast.LENGTH_SHORT).show();
    }

    // 可选：添加返回键处理
    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}