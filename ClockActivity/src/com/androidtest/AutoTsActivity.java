package com.androidtest;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.TextView;

public class AutoTsActivity extends Activity {
	/** Called when the activity isfirst created. */
	/* ����Ҫʹ�õ������ */
	private final String[] normalString = new String[] { "Android",
			"Android Blog", "Android Market", "Android SDK", "Android AVD",
			"BlackBerry", "BlackBerry JDE", "Symbian", "Symbian Carbide",
			"Java 2ME", "Java FX", "Java 2EE", "Java 2SE", "Mobile",
			"Motorola", "Nokia", "Sun", "Nokia Symbian", "Nokia forum",
			"WindowsMobile", "Broncho", "Windows XP", "Google",
			"Google Android ", "Google�����", "IBM", "MicroSoft", "Java", "C++",
			"C", "C#", "J#", "VB" };
	@SuppressWarnings("unused")
	private TextView show;
	private AutoCompleteTextView autoTextView;
	private Button clean;
	private ArrayAdapter<String> arrayAdapter;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		/* װ����������main.xml */
		setContentView(R.layout.autots);
		/* ��XML�л�ȡUIԪ�ض��� */
		show = (TextView) findViewById(R.id.TextView_InputShow);
		autoTextView = (AutoCompleteTextView) findViewById(R.id.AutoCompleteTextView_input);
		clean = (Button) findViewById(R.id.Button_clean);
		/* ʵ��һ�������������������Զ�������������Զ�װ������� */
		arrayAdapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_dropdown_item_1line, normalString);
		/* ���Զ���������������������� */
		autoTextView.setAdapter(arrayAdapter);
		/* ����հ�ť��ӵ���¼���������� */
		clean.setOnClickListener(new Button.OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				/* ��� */
				autoTextView.setText("");
			}
		});
	}
}