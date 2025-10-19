package com.example.exercise3;

import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class Task3Activity extends AppCompatActivity {

    private TextView textTest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task3);
        textTest = findViewById(R.id.text_test);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.menu_normal) {
            Toast.makeText(this, "点击了普通菜单项", Toast.LENGTH_SHORT).show();
            return true;
        } else if (id == R.id.font_small) {
            textTest.setTextSize(10);
            item.setChecked(true);
            return true;
        } else if (id == R.id.font_medium) {
            textTest.setTextSize(16);
            item.setChecked(true);
            return true;
        } else if (id == R.id.font_large) {
            textTest.setTextSize(20);
            item.setChecked(true);
            return true;
        } else if (id == R.id.color_red) {
            textTest.setTextColor(Color.RED);
            item.setChecked(true);
            return true;
        } else if (id == R.id.color_black) {
            textTest.setTextColor(Color.BLACK);
            item.setChecked(true);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}