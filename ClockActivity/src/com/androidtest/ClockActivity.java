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
	/* 定义要使用的类对象 */
	private TextView showTime;// 显示进程时钟的TextView
	AnalogClock myClock;// 模拟时钟
	DigitalClock myDigClock;// 数字时钟
	private final int msg_Key = 0x1234;// 发送的消息内容
	public Handler myHandler;// 发送、处理消息的类
	public Calendar myCalendar;// 日历类
	private int my_Hour, my_Minute, my_Second;// 时、分、秒
	private Thread myT;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		/* 导入主屏布局main.xml */
		setContentView(R.layout.clock);
		/* 从XML中获取模拟时钟UI对象 */
		myClock = (AnalogClock) findViewById(R.id.Clock);
		/* 从XML中获取数字时钟UI对象 */
		myDigClock = (DigitalClock) findViewById(R.id.DigitalClock01);
		/* 从XML中获取TextView UI对象 */
		showTime = (TextView) findViewById(R.id.TextView_showTime);
		/* 通过Handler来接收进程所传递的信息并更新TextView */
		myHandler = new Handler() {
			@Override
			public void handleMessage(Message msg) {
				/* 这里是处理信息的方法 */
				// TODO Auto-generated method stub
				super.handleMessage(msg);
				switch (msg.what) {
				case msg_Key:
					/* 在这处理要TextView对象Show时间的事件 */
					showTime.setText(my_Hour + " :" + my_Minute + " :"
							+ my_Second);
					break;
				default:
					break;
				}
			}
		};
		/* 通过进程来持续取得系统时间 */
		myT = new Thread(this);
		myT.start();
	}

	/* 实现一个Runable接口，实例化一个进程对象，用来持续取得系统时间 */
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			do {
				/* 取得系统时间 */
				long Time = System.currentTimeMillis();
				myCalendar = Calendar.getInstance();
				myCalendar.setTimeInMillis(Time);
				my_Hour = myCalendar.get(Calendar.HOUR);
				my_Minute = myCalendar.get(Calendar.MINUTE);
				my_Second = myCalendar.get(Calendar.SECOND);
				/* 让进程休息一秒 */
				Thread.sleep(1000);
				/* 重要关键程序:取得时间后发出信息给Handler */
				Message msg = new Message();
				msg.what = msg_Key;
				myHandler.sendMessage(msg);
				/* 重要关键程序:取得时间后发出信息给Handler */
			} while (myT.interrupted() == false);
			/* 当系统发出中断信息时停止本循环 */
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}