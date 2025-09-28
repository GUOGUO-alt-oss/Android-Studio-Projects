package com.example.layoutlab;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    private int jumpCount = 0; // 用于跟踪点击次数

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    // 按钮点击事件处理
    public void onJumpButtonClick(View view) {
        jumpCount++;
        Intent intent;
        switch (jumpCount % 4) { // 根据点击次数循环跳转
            case 1:
                intent = new Intent(this, LinearLayoutActivity.class);
                break;
            case 2:
                intent = new Intent(this, TableLayoutActivity.class);
                break;
            case 3:
                intent = new Intent(this, JisuanjiActivity.class);
                break;
            case 0: // 当 jumpCount 为 4 的倍数时，跳转到第四个活动
                intent = new Intent(this, YueshubujuActivity.class);
                break;
            default:
                intent = new Intent(this, LinearLayoutActivity.class);
        }
        startActivity(intent);
    }
}