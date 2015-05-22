package com.androidtest;

import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

public class SpinnerActivity extends Activity {
	/** Called when the activity isfirst created. */
	private static final String[] countriesStr = { "北京市", "上海市", "天津市", "重庆市" };
	private TextView myTextView;
	private Spinner mySpinner;
	private ArrayAdapter<String> adapter;
	Animation myAnimation;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		/* 载入main.xml Layout */
		setContentView(R.layout.spinner);
		/* 以findViewById()取得对象 */
		myTextView = (TextView) findViewById(R.id.TextView_Show);
		mySpinner = (Spinner) findViewById(R.id.spinner_City);
		/* 取得Animation定义在res/anim目录下 */
		myAnimation = AnimationUtils.loadAnimation(this, R.anim.my_anim);
		adapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_spinner_item, countriesStr);
		/* myspinner_dropdown为自定义下拉菜单样式定义在res/layout目录下 */
		adapter.setDropDownViewResource(R.layout.myspinner_dropdown);
		/* 将ArrayAdapter添加Spinner对象中 */
		mySpinner.setAdapter(adapter);
		/* 下拉菜单弹出的内容选项被选中事件处理 */
		mySpinner
				.setOnItemSelectedListener(new Spinner.OnItemSelectedListener() {
					@Override
					public void onItemSelected(AdapterView<?> arg0, View arg1,
							int arg2, long arg3) {
						// TODO Auto-generated method stub
						/* 将所选mySpinner的值带入myTextView中 */
						myTextView.setText("您选择的是：" + countriesStr[arg2]);
						/* 将mySpinner显示 */
						arg0.setVisibility(View.VISIBLE);
					}

					@Override
					public void onNothingSelected(AdapterView<?> arg0) {
						// TODO Auto-generated method stub
						myTextView.setText("NONE");
					}
				});
		/* 下拉菜单弹出的内容选项触屏事件处理 */
		mySpinner.setOnTouchListener(new Spinner.OnTouchListener() {
			@Override
			public boolean onTouch(View v, MotionEvent event) {
				// TODO Auto-generated method stub
				/* 将mySpinner运行Animation */
				v.startAnimation(myAnimation);
				/* 将mySpinner隐藏 */
				v.setVisibility(View.INVISIBLE);
				return false;
			}
		});
		/* 下拉菜单弹出的内容选项焦点改变事件处理 */
		mySpinner.setOnFocusChangeListener(new Spinner.OnFocusChangeListener() {
			@Override
			public void onFocusChange(View v, boolean hasFocus) {
				// TODO Auto-generated method stub
			}
		});
	}
}
