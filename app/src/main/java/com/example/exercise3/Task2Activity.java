package com.example.exercise3;

import android.app.AlertDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Task2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task2);
    }

    public void showLoginDialog(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        View dialogView = getLayoutInflater().inflate(R.layout.dialog_login, null);
        builder.setView(dialogView);

        EditText etUser = dialogView.findViewById(R.id.et_username);
        EditText etPass = dialogView.findViewById(R.id.et_password);

        builder.setPositiveButton("登录", (dialog, which) -> {
            Toast.makeText(this, "用户：" + etUser.getText().toString(), Toast.LENGTH_SHORT).show();
        });
        builder.setNegativeButton("取消", (dialog, which) -> dialog.dismiss());

        builder.show();
    }
}