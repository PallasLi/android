package com.pallasli.officeautomation.bpm;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.pallasli.officeautomation.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MyDraftListActivity  extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bpm_my_draft_list);

        myDraftList = (ListView) findViewById(R.id.bpm_my_draft_list);//得到ListView对象的引用 /*为ListView设置Adapter来绑定数据*/

        SimpleAdapter adapter = new SimpleAdapter(this, getData(), R.layout.activity_bpm_my_draft_list_row,
                new String[]{"title", "info", "img"},
                new int[]{R.id.title, R.id.info, R.id.img});
        myDraftList.setAdapter(adapter);
    }

    ListView myDraftList;
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
