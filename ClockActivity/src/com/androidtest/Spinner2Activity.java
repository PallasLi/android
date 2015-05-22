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
	/* ��������ʹ�õĶ��� */
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
		/* ����������ʾ����Ϊmain.xml */
		setContentView(R.layout.spinner2);
		/* findViewByID()��ȡXML�е�UIԪ�� */
		show_yourChoice_TextView = (TextView) findViewById(R.id.TextView_Show_yourChoice);
		input_City_EditText = (EditText) findViewById(R.id.EditView_Input);
		Add_Button = (Button) findViewById(R.id.Button_ADD);
		Del_Button = (Button) findViewById(R.id.Button_DEL);
		city_Spinner = (Spinner) findViewById(R.id.Spinner_Slecte);
		/* ��ʼ���ַ������� */
		cities = new String[] { "Android", "BlackBerry", "J2ME", "Symbian",
				"Broncho", "LinuxMobile", "Palm", "WindwosMobile" };
		/* ��ʼ��Listʵ��ArrayList�Ķ��� */
		cityList = new ArrayList<String>();
		/* ���������ַ���������ӵ�ArrayList�� */
		for (int i = 0; i < cities.length; i++) {
			cityList.add(cities[i]);
		}
		/* ����Ӧ��ʹ��List<> ,���ʹ��String[]������ */
		/* ��ʼ�������˵������������� */
		arrayAdapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_spinner_item, cityList);
		/* ���������˵���ʾ���ݵķ�� */
		arrayAdapter
				.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		/* �������˵������������������ */
		city_Spinner.setAdapter(arrayAdapter);
		/* Ĭ������ʱ�ı�������ʾ */
		show_yourChoice_TextView.setText(arrayAdapter.getItem(0));
		/* Ĭ������ʱ�����˵���һ�ѡ�� */
		city_Spinner.setSelection(0);
		/* Ϊ��ť��ӵ���¼������� */
		Add_Button.setOnClickListener(this);
		Del_Button.setOnClickListener(this);
		/* Ϊ�����˵����ѡ��ѡ���¼������� */
		city_Spinner.setOnItemSelectedListener(this);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		/* ����ť�����в�ͬ���� */
		case R.id.Button_ADD:
			/* ��ʾToast��ʾ */
			Toast.makeText(this, "���", Toast.LENGTH_SHORT).show();
			/* ���������еĽ�Ҫ��ӵ��ַ��� */
			addString = input_City_EditText.getText().toString();
			/* �������Ƚ��Ƿ�������˵��������ظ� */
			for (int i = 0; i < arrayAdapter.getCount(); i++) {
				if (addString.equals(arrayAdapter.getItemId(i))) {
					return;
					/* �ظ��ˣ������� */
				}
			}
			/* �������ַ�����Ϊ"" */
			if (!addString.equals("")) {
				/* ��ӽ��������� */
				arrayAdapter.add(addString);
				/* ��ȡ�ո���ӽ����ַ���λ�� */
				int post = arrayAdapter.getPosition(addString);
				/* ���øո���ӽ��������˵����ݱ�ѡ�� */
				city_Spinner.setSelection(post);
				/* �������� */
				input_City_EditText.setText("");
			}
			break;
		case R.id.Button_DEL:
			if (city_Spinner.getSelectedItem() != null) {
				/* ɾ��mySpinner��ֵ */
				arrayAdapter.remove(city_Spinner.getSelectedItem().toString());
				/* ��myEditText��� */
				input_City_EditText.setText("");
				if (arrayAdapter.getCount() == 0) {
					/* ��myTextView��� */
					Toast.makeText(this, "ɾ����", Toast.LENGTH_SHORT).show();
					show_yourChoice_TextView.setText("");
				}
			}
			break;
		default:
			break;
		}
	}

	/* �����˵�ѡ�ѡ���¼����� */
	@Override
	public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2,
			long arg3) {
		// TODO Auto-generated method stub
		show_yourChoice_TextView.setText(arrayAdapter.getItem(arg2));
	}

	/* δ��ѡ���¼����� */
	@Override
	public void onNothingSelected(AdapterView<?> arg0) {
		// TODO Auto-generated method stub
	}

	/* ���Menu�˵������˳����� */
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// TODO Auto-generated method stub
		menu.add("Exit");
		return super.onCreateOptionsMenu(menu);
	}

	/* Menu�˵��˳� */
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		finish();
		return super.onOptionsItemSelected(item);
	}
}