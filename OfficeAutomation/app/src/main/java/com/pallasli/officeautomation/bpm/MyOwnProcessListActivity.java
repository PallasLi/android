package com.pallasli.officeautomation.bpm;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import com.pallasli.officeautomation.R;
import com.pallasli.webutil.WebRequestCallback;
import com.pallasli.webutil.WebRequestUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MyOwnProcessListActivity extends Activity {

//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_bpm_my_own_process_list);
//
//        myOwnProcessList = (ListView) findViewById(R.id.bpm_my_own_process_list);//得到ListView对象的引用 /*为ListView设置Adapter来绑定数据*/
////        myTodoList.setAdapter(new ArrayAdapter<String>(this,
////                android.R.layout.simple_list_item_1, strs));
//
//        SimpleAdapter adapter = new SimpleAdapter(this, getData(), R.layout.activity_bpm_my_own_process_list_row,
//                new String[]{"title", "info", "img"},
//                new int[]{R.id.title, R.id.info, R.id.img});
//        myOwnProcessList.setAdapter(adapter);
//    }
//
//    ListView myOwnProcessList;
//    private List<Map<String, Object>> getData() {
//        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
//
//        Map<String, Object> map = new HashMap<String, Object>();
//        map.put("title", "G1");
//        map.put("info", "google 1");
////        map.put("img", R.drawable.i1);
//        list.add(map);
//
//        map = new HashMap<String, Object>();
//        map.put("title", "G2");
//        map.put("info", "google 2");
////        map.put("img", R.drawable.i2);
//        list.add(map);
//
//        map = new HashMap<String, Object>();
//        map.put("title", "G3");
//        map.put("info", "google 3");
////        map.put("img", R.drawable.i3);
//        list.add(map);
//
//        return list;
//    }

    private GridView gview;
    private List<Map<String, Object>> data_list;
    private SimpleAdapter sim_adapter;
    // 图片封装为一个数组
//    private int[] icon = { R.drawable.address_book, R.drawable.calendar,
//            R.drawable.camera, R.drawable.clock, R.drawable.games_control,
//            R.drawable.messenger, R.drawable.ringtone, R.drawable.settings,
//            R.drawable.speech_balloon, R.drawable.weather, R.drawable.world,
//            R.drawable.youtube };
    private String[] iconName = {"通讯录", "日历", "照相机", "时钟", "游戏", "短信", "铃声",
            "设置", "语音", "天气", "浏览器", "视频"};
    private Activity activity = this;

    ProgressDialog pd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bpm_my_own_process_grid);

        pd = ProgressDialog.show(activity, "请稍后。。。", "正在请求数据");

        new WebRequestUtils().openSyncRequest(MyOwnProcessListActivity.this, "http://192.168.0.109:8080/baodingOA/activityController.do?method=list",new WebRequestCallback() {
            @Override
            public void callback(String data) {
                pd.dismiss();

                Log.e(WebRequestUtils.class.getName(), data);

                //新建适配器
                String[] from = {"image", "text"};
                int[] to = {R.id.image, R.id.text};

                gview = (GridView) findViewById(R.id.gview);
                //新建List
                data_list = new ArrayList<Map<String, Object>>();
                //获取数据
                getData();
                sim_adapter = new SimpleAdapter(activity, data_list, R.layout.activity_bpm_my_own_process_grid_item, from, to);
                //配置适配器
                gview.setAdapter(sim_adapter);

                gview.setOnItemClickListener(new GridView.OnItemClickListener() {

                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        Intent it = new Intent();
                        it.setClass(MyOwnProcessListActivity.this, FormDataActivity.class);
                        startActivity(it);
                    }
                });
            }

            public List<Map<String, Object>> getData() {
                //cion和iconName的长度是相同的，这里任选其一都可以
                for (int i = 0; i < iconName.length; i++) {
                    Map<String, Object> map = new HashMap<String, Object>();
//            map.put("image", icon[i]);
                    map.put("text", iconName[i]);
                    data_list.add(map);
                }

                return data_list;
            }
        });


    }


}
