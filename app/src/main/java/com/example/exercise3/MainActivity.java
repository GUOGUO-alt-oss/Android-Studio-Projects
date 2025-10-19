package com.example.exercise3;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    // 跳转到任务一
    public void openTask1(View view) {
        Intent intent = new Intent(this, Task1Activity.class);
        startActivity(intent);
    }

    // 跳转到任务二
    public void openTask2(View view) {
        Intent intent = new Intent(this, Task2Activity.class);
        startActivity(intent);
    }

    // 跳转到任务三
    public void openTask3(View view) {
        Intent intent = new Intent(this, Task3Activity.class);
        startActivity(intent);
    }

    // 跳转到任务四
    public void openTask4(View view) {
        Intent intent = new Intent(this, Task4Activity.class);
        startActivity(intent);
    }
}
