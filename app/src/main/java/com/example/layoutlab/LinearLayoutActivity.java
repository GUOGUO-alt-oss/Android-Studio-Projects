package com.example.layoutlab;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class LinearLayoutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_linear_layout);

        // 移除对 backButton 的引用
        // 可以使用设备的返回键返回上一个活动

        // 示例：演示线性布局特性
        Toast.makeText(this, "这是线性布局示例", Toast.LENGTH_SHORT).show();
    }

    // 可选：添加返回键处理
    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}