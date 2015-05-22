package com.androidtest;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class ImageViewActivity extends Activity {
	/** Called when the activity isfirst created. */
	/* ����Button��ImageView���� */
	private ImageView mImageView01;
	private ImageView mImageView02;
	private Button mButton01;
	private Button mButton02;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.imageview);
		/* ȡ��Button��ImageView���� */
		mImageView01 = (ImageView) findViewById(R.id.myImageView1);
		mImageView02 = (ImageView) findViewById(R.id.myImageView2);
		mButton01 = (Button) findViewById(R.id.myButton1);
		mButton02 = (Button) findViewById(R.id.myButton2);
		/* ����ImageView����ͼ */
		mImageView01.setImageDrawable(getResources().getDrawable(
				R.drawable.ic_launcher));
		mImageView02.setImageDrawable(getResources().getDrawable(
				R.drawable.ic_launcher));
		/* ��OnClickListener�¼������� */
		mButton01.setOnClickListener(new Button.OnClickListener() {
			@Override
			public void onClick(View v) {
				/* ��������ImageView���̻�����ͼ */
				mImageView01.setImageDrawable(getResources().getDrawable(
						R.drawable.ic_launcher));
			}
		});
		mButton02.setOnClickListener(new Button.OnClickListener() {
			@Override
			public void onClick(View v) {
				mImageView01.setImageDrawable(getResources().getDrawable(
						R.drawable.ic_launcher));
			}
		});
	}
}