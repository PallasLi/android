package com.androidtest;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.ProgressDialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;

public class DialogActivity extends Activity {
	private Button button1;
	private Button button2;
	private Button button3;
	private Button button4;
	private Button button5;
	private Button button6;
	private TextView tvDate;
	private ProgressDialog mProgressDialog;
	private int mSingleChoiceID = -1;
	private final ArrayList<Integer> MultiChoiceID = new ArrayList<Integer>();
	private EditText e1;
	private final Calendar c = Calendar.getInstance();

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.dialog);
		button1 = (Button) findViewById(R.id.button1);
		button1.setOnClickListener(new AlertOnclick());
		button2 = (Button) findViewById(R.id.button2);
		button2.setOnClickListener(new AlertListOnclick());
		button3 = (Button) findViewById(R.id.button3);
		button3.setOnClickListener(new AlertListWithButtonOnclick());
		button4 = (Button) findViewById(R.id.button4);
		button4.setOnClickListener(new ProgressOnclick());
		button5 = (Button) findViewById(R.id.button5);
		button5.setOnClickListener(new AlertMultiplyListWithButtonOnclick());
		button6 = (Button) findViewById(R.id.button6);
		button6.setOnClickListener(new DiyOnclick());
		tvDate = (TextView) findViewById(R.id.tvDate);
		tvDate.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				show(arg0);

			}
		});
		e1 = (EditText) findViewById(R.id.c1_time);
		e1.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				c.setTimeInMillis(System.currentTimeMillis());
				int mHour = c.get(Calendar.HOUR_OF_DAY);
				int mMinute = c.get(Calendar.MINUTE);
				new TimePickerDialog(DialogActivity.this,
						new TimePickerDialog.OnTimeSetListener() {

							@Override
							public void onTimeSet(TimePicker view,
									int hourOfDay, int minute) {
								c.setTimeInMillis(System.currentTimeMillis());
								c.set(Calendar.HOUR_OF_DAY, hourOfDay);
								c.set(Calendar.MINUTE, minute);
								c.set(Calendar.SECOND, 0); // 设为 0
								c.set(Calendar.MILLISECOND, 0); // 设为 0
								SimpleDateFormat simpleDateFormat = new SimpleDateFormat(
										"yyyy-MM-dd hh:mm");
								e1.setText(simpleDateFormat.format(cal
										.getTime()));

							}
						}, mHour, mMinute, true).show();
			}
		});
	}

	class AlertOnclick implements OnClickListener {

		@Override
		public void onClick(View arg0) {
			AlertDialog.Builder builder = new AlertDialog.Builder(
					DialogActivity.this);
			builder.setTitle("你确定要离开吗？");
			builder.setPositiveButton("确定",
					new DialogInterface.OnClickListener() {
						@Override
						public void onClick(DialogInterface dialog,
								int whichButton) {
							// 这里添加点击确定后的逻辑
							showDialog("你选择了确定");
						}
					});
			builder.setNegativeButton("取消",
					new DialogInterface.OnClickListener() {
						@Override
						public void onClick(DialogInterface dialog,
								int whichButton) {
							// 这里添加点击确定后的逻辑
							showDialog("你选择了取消");
						}
					});
			builder.setNeutralButton("Neutral",
					new DialogInterface.OnClickListener() {
						@Override
						public void onClick(DialogInterface dialog,
								int whichButton) {
							// 这里添加点击确定后的逻辑
							showDialog("你选择了Neutral");
						}
					});
			builder.create().show();

		}
	}

	class AlertListOnclick implements OnClickListener {

		@Override
		public void onClick(View arg0) {
			final String[] mItems = { "item0", "item1", "itme2", "item3",
					"itme4", "item5", "item6" };

			AlertDialog.Builder builder = new AlertDialog.Builder(
					DialogActivity.this);
			builder.setTitle("列表选择框");
			builder.setItems(mItems, new DialogInterface.OnClickListener() {
				@Override
				public void onClick(DialogInterface dialog, int which) {
					// 点击后弹出窗口选择了第几项
					showDialog("你选择的id为" + which + " , " + mItems[which]);
				}
			});
			builder.create().show();
		}
	}

	class AlertListWithButtonOnclick implements OnClickListener {

		@Override
		public void onClick(View arg0) {
			final String[] mItems = { "item0", "item1", "itme2", "item3",
					"itme4", "item5", "item6" };

			AlertDialog.Builder builder = new AlertDialog.Builder(
					DialogActivity.this);
			builder.setTitle("单项选择");
			mSingleChoiceID = -1;
			builder.setSingleChoiceItems(mItems, 0,
					new DialogInterface.OnClickListener() {
						@Override
						public void onClick(DialogInterface dialog,
								int whichButton) {
							mSingleChoiceID = whichButton;
							showDialog("你选择的id为" + whichButton + " , "
									+ mItems[whichButton]);
						}
					});
			builder.setPositiveButton("确定",
					new DialogInterface.OnClickListener() {
						@Override
						public void onClick(DialogInterface dialog,
								int whichButton) {
							if (mSingleChoiceID > 0) {
								showDialog("你选择的是" + mSingleChoiceID);
							}
						}
					});
			builder.setNegativeButton("取消",
					new DialogInterface.OnClickListener() {
						@Override
						public void onClick(DialogInterface dialog,
								int whichButton) {

						}
					});
			builder.create().show();
		}
	}

	class AlertMultiplyListWithButtonOnclick implements OnClickListener {

		@Override
		public void onClick(View arg0) {

			final String[] mItems = { "item0", "item1", "itme2", "item3",
					"itme4", "item5", "item6" };
			AlertDialog.Builder builder = new AlertDialog.Builder(
					DialogActivity.this);

			MultiChoiceID.clear();
			builder.setTitle("多项选择");
			builder.setMultiChoiceItems(mItems, new boolean[] { false, false,
					false, false, false, false, false },
					new DialogInterface.OnMultiChoiceClickListener() {
						@Override
						public void onClick(DialogInterface dialog,
								int whichButton, boolean isChecked) {
							if (isChecked) {
								MultiChoiceID.add(whichButton);
								showDialog("你选择的id为" + whichButton + " , "
										+ mItems[whichButton]);
							} else {
								MultiChoiceID.remove(whichButton);
							}

						}
					});
			builder.setPositiveButton("确定",
					new DialogInterface.OnClickListener() {
						@Override
						public void onClick(DialogInterface dialog,
								int whichButton) {
							String str = "";
							int size = MultiChoiceID.size();
							for (int i = 0; i < size; i++) {
								str += mItems[MultiChoiceID.get(i)] + ", ";
							}
							showDialog("你选择的是" + str);
						}
					});
			builder.setNegativeButton("取消",
					new DialogInterface.OnClickListener() {
						@Override
						public void onClick(DialogInterface dialog,
								int whichButton) {

						}
					});
			builder.create().show();
		}
	}

	class ProgressOnclick extends Thread implements OnClickListener {

		@Override
		public void onClick(View arg0) {
			// mProgressDialog = new ProgressDialog(DialogActivity.this);
			// mProgressDialog.setTitle("读取ing");
			// mProgressDialog.setMessage("正在读取中请稍候");
			// mProgressDialog.setIndeterminate(true);
			// mProgressDialog.setCancelable(true);
			// mProgressDialog.show();
			mProgressDialog = new ProgressDialog(DialogActivity.this);
			mProgressDialog.setTitle("进度条窗口");
			mProgressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
			mProgressDialog.setMax(100);
			mProgressDialog.setButton("确定",
					new DialogInterface.OnClickListener() {
						@Override
						public void onClick(DialogInterface dialog,
								int whichButton) {
							// 这里添加点击后的逻辑
						}
					});
			mProgressDialog.setButton2("取消",
					new DialogInterface.OnClickListener() {
						@Override
						public void onClick(DialogInterface dialog,
								int whichButton) {
							// 这里添加点击后的逻辑
						}
					});
			mProgressDialog.show();
			new Thread(this).start();

		}

		@Override
		public void run() {
			int Progress = 0;
			while (Progress < 100) {
				try {
					Thread.sleep(100);
					Progress++;
					mProgressDialog.incrementProgressBy(1);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}

		}
	}

	class DiyOnclick implements OnClickListener {

		@Override
		public void onClick(View arg0) {
			AlertDialog.Builder builder = new AlertDialog.Builder(
					DialogActivity.this);
			LayoutInflater factory = LayoutInflater.from(DialogActivity.this);
			final View textEntryView = factory.inflate(R.layout.clock, null);
			builder.setTitle("自定义输入框");
			builder.setView(textEntryView);
			builder.setPositiveButton("确定",
					new DialogInterface.OnClickListener() {
						@Override
						public void onClick(DialogInterface dialog,
								int whichButton) {

						}
					});
			builder.setNegativeButton("取消",
					new DialogInterface.OnClickListener() {
						@Override
						public void onClick(DialogInterface dialog,
								int whichButton) {

						}
					});
			builder.create().show();
		}
	}

	private final Calendar cal = Calendar.getInstance();
	private final DatePickerDialog.OnDateSetListener listener = new DatePickerDialog.OnDateSetListener() {

		@Override
		public void onDateSet(DatePicker view, int year, int monthOfYear,
				int dayOfMonth) {
			cal.set(Calendar.YEAR, year);
			cal.set(Calendar.MONTH, monthOfYear);
			cal.set(Calendar.DAY_OF_MONTH, dayOfMonth);
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat(
					"yyyy-MM-dd");
			tvDate.setText(simpleDateFormat.format(cal.getTime()));
		}
	};

	public void show(View v) {
		new DatePickerDialog(DialogActivity.this, listener,
				cal.get(Calendar.YEAR), cal.get(Calendar.MONTH),
				cal.get(Calendar.DAY_OF_MONTH)).show();
	}

	private void showDialog(String str) {
		new AlertDialog.Builder(DialogActivity.this).setMessage(str).show();
	}
}