package com.hbdworld.ashello;

import android.database.DataSetObserver;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ListViewActivity extends AppCompatActivity {


    private ListView listView = null;
    private String[] strs = new String[]{"123", "456", "789"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);

        //--
        listView = (ListView)this.findViewById(R.id.listView);
        ListAdapter listAdapter = new ArrayAdapter<String>(this,R.layout.lv_simple_item,strs);
        listView.setAdapter(listAdapter);

    }
}
