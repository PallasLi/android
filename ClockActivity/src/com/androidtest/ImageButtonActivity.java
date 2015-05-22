package com.androidtest;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class ImageButtonActivity extends Activity {
	/** Called when the activity isfirst created. */
	/* ����ImageButton */
	private ImageButton back_Imagebutton, photo_Imagebutton;
	private boolean Tag = true;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.imagebutton);
		/* ��XML�л�ȡ�ؼ����� */
		back_Imagebutton = (ImageButton) findViewById(R.id.myImageButton_Back);
		photo_Imagebutton = (ImageButton) findViewById(R.id.myImageButton_Photo);
		// ����Ĭ�ϵı���ͼƬ
		back_Imagebutton.setBackgroundResource(R.drawable.ic_launcher);
		photo_Imagebutton.setBackgroundResource(R.drawable.ic_launcher);
		// ��ImageButton�����¼�������
		photo_Imagebutton.setOnClickListener(new ImageButton.OnClickListener() {
			@Override
			public void onClick(View v) {
				System.out.println("**************888");
				// TODO Auto-generated method stub
				Tag = !Tag;// ���ı���ͼƬ
				if (Tag) {
					System.out.println("**************888");
					back_Imagebutton
							.setBackgroundResource(R.drawable.ic_launcher);
				} else {
					back_Imagebutton
							.setBackgroundResource(R.drawable.ic_launcher);
				}
			}
		});
	}
}