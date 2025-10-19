package com.example.exercise3;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Task1Activity extends AppCompatActivity {

    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task1);

        listView = findViewById(R.id.list_view);

        // 数据准备
        List<Map<String, Object>> data = new ArrayList<>();
        String[] titles = {"Lion", "Tiger", "Monkey", "Dog", "Cat", "Elephant"};
        int[] icons = {
                R.drawable.lion,
                R.drawable.tiger,
                R.drawable.monkey,
                R.drawable.dog,
                R.drawable.cat,
                R.drawable.elephant
        };

        for (int i = 0; i < titles.length; i++) {
            Map<String, Object> item = new HashMap<>();
            item.put("title", titles[i]);
            item.put("icon", icons[i]);
            data.add(item);
        }

        SimpleAdapter adapter = new SimpleAdapter(this, data,
                R.layout.list_item,  // 使用你之前创建的 list_item.xml
                new String[]{"icon", "title"},
                new int[]{R.id.iv_icon, R.id.tv_title});

        listView.setAdapter(adapter);

        // 点击事件
        listView.setOnItemClickListener((parent, view, position, id) -> {
            String title = (String) data.get(position).get("title");

            // Toast 提示
            Toast.makeText(this, "选中：" + title, Toast.LENGTH_SHORT).show();

            // 发送通知
            sendNotification(title);
        });
    }

    private void sendNotification(String title) {
        NotificationManager nm = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel channel = new NotificationChannel(
                    "TASK1_CHANNEL", "任务一通知", NotificationManager.IMPORTANCE_DEFAULT);
            nm.createNotificationChannel(channel);
        }

        NotificationCompat.Builder builder = new NotificationCompat.Builder(this, "TASK1_CHANNEL")
                .setSmallIcon(R.mipmap.ic_launcher)
                .setContentTitle(title)
                .setContentText("你点击了列表项：" + title)
                .setAutoCancel(true);

        nm.notify((int) System.currentTimeMillis(), builder.build());
    }
}