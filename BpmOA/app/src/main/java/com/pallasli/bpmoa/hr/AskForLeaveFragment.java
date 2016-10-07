package com.pallasli.bpmoa.hr;

import android.app.DatePickerDialog;
import android.content.Context;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.app.Fragment;
import android.os.SystemClock;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ListAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import com.pallasli.bpmoa.R;
import com.pallasli.bpmoa.model.LeaveType;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link AskForLeaveFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link AskForLeaveFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AskForLeaveFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    //表单组件
    private Spinner leaveTypeSpinner;
    private TextView startDateTextView;
    private TextView endDateTextView;
    private DatePickerDialog datePickerDialog;
    private DatePickerDialog endDatePickerDialog;
    private Calendar startDate;
    private Calendar endDate;
    private LeaveType[] leaveTypeData;

    private OnFragmentInteractionListener mListener;

    public AskForLeaveFragment() {
        // Required empty public constructor

    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment AskForLeaveFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static AskForLeaveFragment newInstance(String param1, String param2) {
        AskForLeaveFragment fragment = new AskForLeaveFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
        //在配置变化的时候将这个fragment保存下来
        setRetainInstance(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_hr_ask_for_leave, container, false);
    }

    @Override
    public void onStart() {
        super.onStart();

        //开始结束时间段
        startDateTextView = (TextView) getView().findViewById(R.id.hr_ask_for_leave_form_start_time);
        //开始结束时间段
        endDateTextView = (TextView) getView().findViewById(R.id.hr_ask_for_leave_form_end_time);
        //请假类型
        leaveTypeSpinner = (Spinner) getView().findViewById(R.id.hr_ask_for_leave_form_leave_type);

        startDateTextView.setOnTouchListener(new TextView.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent e) {
                final Calendar c = Calendar.getInstance();
                //创建DatePickerDialog对象
                if (datePickerDialog == null)
                    datePickerDialog = new DatePickerDialog(getActivity(), startDatelistener, c.get(Calendar.YEAR), c.get(Calendar.MONTH), c.get(Calendar.DAY_OF_MONTH));
                datePickerDialog.show();//显示DatePickerDialog组件
                return true;
            }
        });
        endDateTextView.setOnTouchListener(new TextView.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent e) {
                final Calendar c = Calendar.getInstance();
                //创建DatePickerDialog对象
                if (endDatePickerDialog == null)
                    endDatePickerDialog = new DatePickerDialog(getActivity(), endDatelistener, c.get(Calendar.YEAR), c.get(Calendar.MONTH), c.get(Calendar.DAY_OF_MONTH));
                endDatePickerDialog.show();//显示DatePickerDialog组件
                return true;
            }
        });


        LeaveType type1 = new LeaveType();
        type1.setCode(1);
        type1.setValue("病假");
        LeaveType type2 = new LeaveType();
        type2.setCode(2);
        type2.setValue("事假");
        LeaveType type3 = new LeaveType();
        type3.setCode(3);
        type3.setValue("其他");
        leaveTypeData = new LeaveType[]{type1, type2, type3};

        ArrayAdapter<LeaveType> leaveTypeAdapter = new ArrayAdapter<LeaveType>(getActivity(), R.layout.support_simple_spinner_dropdown_item, leaveTypeData);
        leaveTypeSpinner.setAdapter(leaveTypeAdapter);
        leaveTypeSpinner.setOnItemSelectedListener(new Spinner.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        //请假时间

    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
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
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }

    private DatePickerDialog.OnDateSetListener startDatelistener = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view, int year, int month, int day) {
            startDate = Calendar.getInstance();
            startDate.set(year, month, day);
            updateDate();
        }

        //当DatePickerDialog关闭时，更新日期显示
        private void updateDate() {
            Date date = startDate.getTime();
            SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
            String startDateStr = format1.format(date);
            //在TextView上显示日期
            startDateTextView.setText(startDateStr);
        }
    };
    private DatePickerDialog.OnDateSetListener endDatelistener = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view, int year, int month, int day) {
            endDate = Calendar.getInstance();
            endDate.set(year, month, day);
            updateDate();
        }

        //当DatePickerDialog关闭时，更新日期显示
        private void updateDate() {
            Date date = endDate.getTime();
            SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
            String startDateStr = format1.format(date);
            //在TextView上显示日期
            endDateTextView.setText(startDateStr);
        }
    };

    static interface TaskCallbacks {
        void onPreExecute();

        void onProgressUpdate(int percent);

        void onCancelled();

        void onPostExecute();
    }

    private TaskCallbacks mCallbacks;


    /**
     * 一个示例性的任务用来表示一些后台任务并且通过回调函数向Activity
     * 报告任务进度和返回结果
     * <p/>
     * 注意：我们需要在每一个方法中检查回调对象是否为null，以防它们
     * 在Activity或Fragment的onDestroy()执行后被调用。
     */
    private class DummyTask extends AsyncTask<Void, Integer, Void> {

        @Override
        protected void onPreExecute() {
            if (mCallbacks != null) {
                mCallbacks.onPreExecute();
            }
        }

        /**
         * 注意：我们不在后台线程的doInbackground方法中直接调用回调
         * 对象的方法，因为这样可能产生竞态条件
         */
        @Override
        protected Void doInBackground(Void... ignore) {
            for (int i = 0; !isCancelled() && i < 100; i++) {
                SystemClock.sleep(100);
                publishProgress(i);
            }
            return null;
        }

        @Override
        protected void onProgressUpdate(Integer... percent) {
            if (mCallbacks != null) {
                mCallbacks.onProgressUpdate(percent[0]);
            }
        }

        @Override
        protected void onCancelled() {
            if (mCallbacks != null) {
                mCallbacks.onCancelled();
            }
        }

        @Override
        protected void onPostExecute(Void ignore) {
            if (mCallbacks != null) {
                mCallbacks.onPostExecute();
            }
        }
    }

}
