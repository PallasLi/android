package com.androidtest;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.MultiAutoCompleteTextView;

public class AutoTsDxActivity extends Activity {
	/** Called when the activity isfirst created. */
	/* 定义要使用的类对象 */
	private final String[] normalString = new String[] { "Android",
			"Android Blog", "Android Market", "Android SDK", "Android AVD",
			"BlackBerry", "BlackBerry JDE", "Symbian", "Symbian Carbide",
			"Java 2ME", "Java FX", "Java 2EE", "Java 2SE", "Mobile",
			"Motorola", "Nokia", "Sun", "Nokia Symbian", "Nokia forum",
			"WindowsMobile", "Broncho", "Windows XP", "Google",
			"Google Android ", "Google浏览器", "IBM", "MicroSoft", "Java", "C++",
			"C", "C#", "J#", "VB" };
	private Button clean;
	private MultiAutoCompleteTextView myAutoCompleteTextView;
	private ArrayAdapter<String> adapter;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		/* 装入主屏布局main.xml */
		setContentView(R.layout.autotsdx);
		/* 以findViewById()从XML中获取UI元素对象 */
		myAutoCompleteTextView = (MultiAutoCompleteTextView) findViewById(R.id.MultiAutoCompleteTextView);
		clean = (Button) findViewById(R.id.Button_clean);
		/* new ArrayAdapter对象并将normalString字符串数组传入 */
		/* 实现一个适配器对象，用来给自动完成输入框添加自动装入的内容 */
		adapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_dropdown_item_1line, normalString);
		/* 将ArrayAdapter添加AutoCompleteTextView对象中 */
		/* 给自动完成输入框添加内容适配器 */
		myAutoCompleteTextView.setAdapter(adapter);
		/* 设置Tokenizer来确定用户输入文本的相关范围 */
		myAutoCompleteTextView
				.setTokenizer(new MultiAutoCompleteTextView.CommaTokenizer());
		/* 给清空按钮添加点击事件处理监听器 */
		clean.setOnClickListener(new Button.OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				/* 清空 */
				myAutoCompleteTextView.setText("");
			}
		});
	}
}