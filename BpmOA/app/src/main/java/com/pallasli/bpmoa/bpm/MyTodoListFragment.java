package com.pallasli.bpmoa.bpm;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import com.pallasli.bpmoa.HomeFragmentUtils;
import com.pallasli.bpmoa.R;
import com.pallasli.bpmoa.bpm.dummy.MyDoneListContent;
import com.pallasli.bpmoa.bpm.dummy.MyDoneListContent.DummyItem;
import com.pallasli.bpmoa.bpm.dummy.MyTodoListContent;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * A fragment representing a list of Items.
 * <p/>
 * Activities containing this fragment MUST implement the {@link OnListFragmentInteractionListener}
 * interface.
 */
public class MyTodoListFragment extends Fragment {

    // TODO: Customize parameter argument names
    private static final String ARG_COLUMN_COUNT = "column-count";
    // TODO: Customize parameters
    private int mColumnCount = 1;
    private OnListFragmentInteractionListener mListener;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public MyTodoListFragment() {
    }

    // TODO: Customize parameter initialization
    @SuppressWarnings("unused")
    public static MyTodoListFragment newInstance(int columnCount) {
        MyTodoListFragment fragment = new MyTodoListFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_COLUMN_COUNT, columnCount);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            mColumnCount = getArguments().getInt(ARG_COLUMN_COUNT);
        }
        AsyncTask<String, Void, String> asyncTask = new AsyncTask<String, Void, String>() {
            @Override
            protected String doInBackground(String... params) {
                try

                {
                    //访问百度的html文件的源码
                    InputStream is = new URL("http://www.baidu.com").openStream();
                    //读取数据的包装流
                    BufferedReader br = new BufferedReader(new InputStreamReader(is));
                    //str用于读取一行数据
                    String str = null;
                    //StringBuffer用于存储所欲数据
                    StringBuffer sb = new StringBuffer();
                    while ((str = br.readLine()) != null) {
                        sb.append(str);
                    }
                    System.out.println(sb.toString());
                } catch (
                        MalformedURLException e
                        )

                {
                    e.printStackTrace();
                } catch (
                        IOException e
                        )

                {
                    e.printStackTrace();
                }
                return null;
            }
        };
        asyncTask.execute();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_bpm_my_todo_list, container, false);


        myTodoList = (ListView) view.findViewById(R.id.bpm_my_todo_list);//得到ListView对象的引用 /*为ListView设置Adapter来绑定数据*/
        //        myTodoList.setAdapter(new ArrayAdapter<String>(this,
//                android.R.layout.simple_list_item_1, strs));
        SimpleAdapter adapter = new SimpleAdapter(getActivity(), getData(), R.layout.fragment_bpm_my_todo_list_row,
                new String[]{"title", "info", "img"},
                new int[]{R.id.title, R.id.info, R.id.user_photo});
        myTodoList.setAdapter(adapter);
        myTodoList.setItemsCanFocus(true);
        myTodoList.setOnItemClickListener(new ListView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                HomeFragmentUtils.openBpmAuditragment(getActivity());
            }
        });

        return view;
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

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnListFragmentInteractionListener) {
            mListener = (OnListFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnListFragmentInteractionListener");
        }
    }

    public void onListItemClick(ListView parent, View v,
                                int position, long id) {
        Log.d(getClass().getName(), "onListItemClick");
        MyTodoListContent item;
        HomeFragmentUtils.openBpmAuditragment(getActivity());
        Toast.makeText(getActivity(),
                "You have selected " + MyDoneListContent.ITEMS.get(position),
                Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnListFragmentInteractionListener {
        // TODO: Update argument type and name
        void onListFragmentInteraction(DummyItem item);
    }
}
