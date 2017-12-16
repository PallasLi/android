package com.pallasli.officeautomation.bpm;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.pallasli.officeautomation.R;
import com.pallasli.officeautomation.hr.AskForLeaveActivity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MyTodoListActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bpm_my_todo_list);
        myTodoList = (ListView) findViewById(R.id.bpm_my_todo_list);//得到ListView对象的引用 /*为ListView设置Adapter来绑定数据*/
//        myTodoList.setAdapter(new ArrayAdapter<String>(this,
//                android.R.layout.simple_list_item_1, strs));
        SimpleAdapter adapter = new SimpleAdapter(this, getData(), R.layout.activity_bpm_my_todo_list_row,
                new String[]{"title", "info", "img"},
                new int[]{R.id.title, R.id.info, R.id.img});
        myTodoList.setAdapter(adapter);
        myTodoList.setItemsCanFocus(true);
        myTodoList.setOnItemClickListener(new ListView.OnItemClickListener(){

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent it= new Intent();
                it.setClass(MyTodoListActivity.this,AuditActivity.class);
                startActivity(it);
            }
        });
    }

    ListView myTodoList;
    private List<Map<String, Object>> getData() {
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("title", "G1");
        map.put("info", "google 1");
//        map.put("img", R.drawable.i1);
        list.add(map);

        map = new HashMap<String, Object>();
        map.put("title", "G2");
        map.put("info", "google 2");
//        map.put("img", R.drawable.i2);
        list.add(map);

        map = new HashMap<String, Object>();
        map.put("title", "G3");
        map.put("info", "google 3");
//        map.put("img", R.drawable.i3);
        list.add(map);

        return list;
    }
}
