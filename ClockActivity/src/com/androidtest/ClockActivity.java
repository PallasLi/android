package com.androidtest;

import java.util.Calendar;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.AnalogClock;
import android.widget.DigitalClock;
import android.widget.TextView;

public class ClockActivity extends Activity implements Runnable {
	/* ����Ҫʹ�õ������ */
	private TextView showTime;// ��ʾ����ʱ�ӵ�TextView
	AnalogClock myClock;// ģ��ʱ��
	DigitalClock myDigClock;// ����ʱ��
	private final int msg_Key = 0x1234;// ���͵���Ϣ����
	public Handler myHandler;// ���͡�������Ϣ����
	public Calendar myCalendar;// ������
	private int my_Hour, my_Minute, my_Second;// ʱ���֡���
	private Thread myT;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		/* ������������main.xml */
		setContentView(R.layout.clock);
		/* ��XML�л�ȡģ��ʱ��UI���� */
		myClock = (AnalogClock) findViewById(R.id.Clock);
		/* ��XML�л�ȡ����ʱ��UI���� */
		myDigClock = (DigitalClock) findViewById(R.id.DigitalClock01);
		/* ��XML�л�ȡTextView UI���� */
		showTime = (TextView) findViewById(R.id.TextView_showTime);
		/* ͨ��Handler�����ս��������ݵ���Ϣ������TextView */
		myHandler = new Handler() {
			@Override
			public void handleMessage(Message msg) {
				/* �����Ǵ�����Ϣ�ķ��� */
				// TODO Auto-generated method stub
				super.handleMessage(msg);
				switch (msg.what) {
				case msg_Key:
					/* ���⴦��ҪTextView����Showʱ����¼� */
					showTime.setText(my_Hour + " :" + my_Minute + " :"
							+ my_Second);
					break;
				default:
					break;
				}
			}
		};
		/* ͨ������������ȡ��ϵͳʱ�� */
		myT = new Thread(this);
		myT.start();
	}

	/* ʵ��һ��Runable�ӿڣ�ʵ����һ�����̶�����������ȡ��ϵͳʱ�� */
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			do {
				/* ȡ��ϵͳʱ�� */
				long Time = System.currentTimeMillis();
				myCalendar = Calendar.getInstance();
				myCalendar.setTimeInMillis(Time);
				my_Hour = myCalendar.get(Calendar.HOUR);
				my_Minute = myCalendar.get(Calendar.MINUTE);
				my_Second = myCalendar.get(Calendar.SECOND);
				/* �ý�����Ϣһ�� */
				Thread.sleep(1000);
				/* ��Ҫ�ؼ�����:ȡ��ʱ��󷢳���Ϣ��Handler */
				Message msg = new Message();
				msg.what = msg_Key;
				myHandler.sendMessage(msg);
				/* ��Ҫ�ؼ�����:ȡ��ʱ��󷢳���Ϣ��Handler */
			} while (myT.interrupted() == false);
			/* ��ϵͳ�����ж���Ϣʱֹͣ��ѭ�� */
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}