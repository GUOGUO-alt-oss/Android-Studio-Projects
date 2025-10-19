package com.example.exercise3;

import android.graphics.Color;
import android.os.Bundle;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Task4Activity extends AppCompatActivity {

    private ListView listView;
    private List<Map<String, Object>> data;
    private SimpleAdapter adapter;
    private View selectedItemView;
    private int selectedPosition = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task4);

        listView = findViewById(R.id.list_view);
        data = new ArrayList<>();

        String[] titles = {"条目1", "条目2", "条目3", "条目4", "条目5"};
        int[] icons = {
                R.drawable.ic_launcher_background,
                R.drawable.ic_launcher_background,
                R.drawable.ic_launcher_background,
                R.drawable.ic_launcher_background,
                R.drawable.ic_launcher_background
        };

        for (int i = 0; i < titles.length; i++) {
            Map<String, Object> item = new HashMap<>();
            item.put("icon", icons[i]);
            item.put("title", titles[i]);
            data.add(item);
        }

        adapter = new SimpleAdapter(this, data,
                R.layout.list_item,
                new String[]{"icon", "title"},
                new int[]{R.id.iv_icon, R.id.tv_title});

        listView.setAdapter(adapter);

        // 长按进入 ActionMode
        listView.setOnItemLongClickListener((parent, view, position, id) -> {
            selectedPosition = position;
            selectedItemView = view;
            view.setBackgroundColor(Color.LTGRAY);
            startActionMode(actionModeCallback);
            return true;
        });
    }

    private ActionMode.Callback actionModeCallback = new ActionMode.Callback() {
        @Override
        public boolean onCreateActionMode(ActionMode mode, Menu menu) {
            getMenuInflater().inflate(R.menu.context_menu, menu);
            mode.setTitle("选择操作");
            return true;
        }

        @Override
        public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
            return false;
        }

        @Override
        public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
            if (item.getItemId() == R.id.action_delete) {
                data.remove(selectedPosition);
                adapter.notifyDataSetChanged();
                mode.finish();
                return true;
            } else if (item.getItemId() == R.id.action_share) {
                Toast.makeText(Task4Activity.this,
                        "分享：" + data.get(selectedPosition).get("title"),
                        Toast.LENGTH_SHORT).show();
                mode.finish();
                return true;
            }
            return false;
        }

        @Override
        public void onDestroyActionMode(ActionMode mode) {
            if (selectedItemView != null) {
                selectedItemView.setBackgroundColor(Color.TRANSPARENT);
            }
            selectedPosition = -1;
            selectedItemView = null;
        }
    };
}