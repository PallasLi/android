package com.androidtest;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.MultiAutoCompleteTextView;

public class AutoTsDxActivity extends Activity {
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
	private Button clean;
	private MultiAutoCompleteTextView myAutoCompleteTextView;
	private ArrayAdapter<String> adapter;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		/* װ����������main.xml */
		setContentView(R.layout.autotsdx);
		/* ��findViewById()��XML�л�ȡUIԪ�ض��� */
		myAutoCompleteTextView = (MultiAutoCompleteTextView) findViewById(R.id.MultiAutoCompleteTextView);
		clean = (Button) findViewById(R.id.Button_clean);
		/* new ArrayAdapter���󲢽�normalString�ַ������鴫�� */
		/* ʵ��һ�������������������Զ�������������Զ�װ������� */
		adapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_dropdown_item_1line, normalString);
		/* ��ArrayAdapter���AutoCompleteTextView������ */
		/* ���Զ���������������������� */
		myAutoCompleteTextView.setAdapter(adapter);
		/* ����Tokenizer��ȷ���û������ı�����ط�Χ */
		myAutoCompleteTextView
				.setTokenizer(new MultiAutoCompleteTextView.CommaTokenizer());
		/* ����հ�ť��ӵ���¼���������� */
		clean.setOnClickListener(new Button.OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				/* ��� */
				myAutoCompleteTextView.setText("");
			}
		});
	}
}