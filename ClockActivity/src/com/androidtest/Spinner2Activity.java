package com.androidtest;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class Spinner2Activity extends Activity implements
		Button.OnClickListener, Spinner.OnItemSelectedListener {
	/** Called when the activity isfirst created. */
	/* 声明程序使用的对象 */
	private TextView show_yourChoice_TextView;
	private EditText input_City_EditText;
	private Button Add_Button, Del_Button;
	private Spinner city_Spinner;
	private ArrayAdapter<String> arrayAdapter;
	private String[] cities;
	private String addString;
	private List<String> cityList;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		/* 设置主屏显示布局为main.xml */
		setContentView(R.layout.spinner2);
		/* findViewByID()获取XML中的UI元素 */
		show_yourChoice_TextView = (TextView) findViewById(R.id.TextView_Show_yourChoice);
		input_City_EditText = (EditText) findViewById(R.id.EditView_Input);
		Add_Button = (Button) findViewById(R.id.Button_ADD);
		Del_Button = (Button) findViewById(R.id.Button_DEL);
		city_Spinner = (Spinner) findViewById(R.id.Spinner_Slecte);
		/* 初始化字符串数组 */
		cities = new String[] { "Android", "BlackBerry", "J2ME", "Symbian",
				"Broncho", "LinuxMobile", "Palm", "WindwosMobile" };
		/* 初始化List实例ArrayList的对象 */
		cityList = new ArrayList<String>();
		/* 遍历，把字符串数组添加到ArrayList中 */
		for (int i = 0; i < cities.length; i++) {
			cityList.add(cities[i]);
		}
		/* 这里应该使用List<> ,如果使用String[]则会出错 */
		/* 初始化下拉菜单的内容适配器 */
		arrayAdapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_spinner_item, cityList);
		/* 设置下拉菜单显示内容的风格 */
		arrayAdapter
				.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		/* 给下拉菜单对象添加内容适配器 */
		city_Spinner.setAdapter(arrayAdapter);
		/* 默认启动时文本标题显示 */
		show_yourChoice_TextView.setText(arrayAdapter.getItem(0));
		/* 默认启动时下拉菜单第一项被选中 */
		city_Spinner.setSelection(0);
		/* 为按钮添加点击事件监听器 */
		Add_Button.setOnClickListener(this);
		Del_Button.setOnClickListener(this);
		/* 为下拉菜单添加选项选中事件监听器 */
		city_Spinner.setOnItemSelectedListener(this);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		/* 区别按钮来进行不同动作 */
		case R.id.Button_ADD:
			/* 显示Toast提示 */
			Toast.makeText(this, "添加", Toast.LENGTH_SHORT).show();
			/* 获得输入框中的将要添加的字符串 */
			addString = input_City_EditText.getText().toString();
			/* 遍历，比较是否和下拉菜单中内容重复 */
			for (int i = 0; i < arrayAdapter.getCount(); i++) {
				if (addString.equals(arrayAdapter.getItemId(i))) {
					return;
					/* 重复了，则跳出 */
				}
			}
			/* 如果添加字符串不为"" */
			if (!addString.equals("")) {
				/* 添加进适配器中 */
				arrayAdapter.add(addString);
				/* 获取刚刚添加进的字符串位置 */
				int post = arrayAdapter.getPosition(addString);
				/* 设置刚刚添加进的下拉菜单内容被选中 */
				city_Spinner.setSelection(post);
				/* 清空输入框 */
				input_City_EditText.setText("");
			}
			break;
		case R.id.Button_DEL:
			if (city_Spinner.getSelectedItem() != null) {
				/* 删除mySpinner的值 */
				arrayAdapter.remove(city_Spinner.getSelectedItem().toString());
				/* 将myEditText清空 */
				input_City_EditText.setText("");
				if (arrayAdapter.getCount() == 0) {
					/* 将myTextView清空 */
					Toast.makeText(this, "删完了", Toast.LENGTH_SHORT).show();
					show_yourChoice_TextView.setText("");
				}
			}
			break;
		default:
			break;
		}
	}

	/* 下拉菜单选项被选中事件处理 */
	@Override
	public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2,
			long arg3) {
		// TODO Auto-generated method stub
		show_yourChoice_TextView.setText(arrayAdapter.getItem(arg2));
	}

	/* 未被选中事件处理 */
	@Override
	public void onNothingSelected(AdapterView<?> arg0) {
		// TODO Auto-generated method stub
	}

	/* 添加Menu菜单进行退出操作 */
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// TODO Auto-generated method stub
		menu.add("Exit");
		return super.onCreateOptionsMenu(menu);
	}

	/* Menu菜单退出 */
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		finish();
		return super.onOptionsItemSelected(item);
	}
}