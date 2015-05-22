package com.androidtest;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.BatteryManager;
import android.os.Bundle;
import android.widget.TextView;

/**
 * Android开发者可以利用BroadcastReceiver机制，获取电池电量变化的ACTION_BATTERY_CHANGED
 * intent，进而获取当前android设备的电池状态。 具体操作步骤：
 * 1.创建一个监听ACTION_BATTERY_CHANGED事件的intentFilter。
 * 2.创建一个BroadcastReceiver对象，该对象可以接收broadcast intent。
 * 3.注册BroadcastReceiver对象来监听ACTION_BATTERY_CHANGED事件。
 * 4.在BroadcastReceiver对象中，重写onReceive方法，在onReceive方法的传入参数intent里获取需要的电池状态信息。
 * 5.在生命周期结束时，取消step4中的注册。
 **/
public class BatteryMonitorActivity extends Activity {

	private TextView batterLevel;
	private BroadcastReceiver batteryLevelRcvr;
	private IntentFilter batteryLevelFilter;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		batterLevel = (TextView) findViewById(R.id.batteryLevel);
		monitorBatteryState();
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
		unregisterReceiver(batteryLevelRcvr);
	}

	private void monitorBatteryState() {
		batteryLevelRcvr = new BroadcastReceiver() {

			@Override
			public void onReceive(Context context, Intent intent) {
				StringBuilder sb = new StringBuilder();
				int rawlevel = intent.getIntExtra("level", -1);
				int scale = intent.getIntExtra("scale", -1);
				int status = intent.getIntExtra("status", -1);
				int health = intent.getIntExtra("health", -1);
				int level = -1; // percentage, or -1 for unknown
				if (rawlevel >= 0 && scale > 0) {
					level = (rawlevel * 100) / scale;
				}
				sb.append("The phone");
				if (BatteryManager.BATTERY_HEALTH_OVERHEAT == health) {
					sb.append("'s battery feels very hot!");
				} else {
					switch (status) {
					case BatteryManager.BATTERY_STATUS_UNKNOWN:
						sb.append("no battery.");
						break;
					case BatteryManager.BATTERY_STATUS_CHARGING:
						sb.append("'s battery");
						if (level <= 33)
							sb.append(" is charging, battery level is low"
									+ "[" + level + "]");
						else if (level <= 84)
							sb.append(" is charging." + "[" + level + "]");
						else
							sb.append(" will be fully charged.");
						break;
					case BatteryManager.BATTERY_STATUS_DISCHARGING:
					case BatteryManager.BATTERY_STATUS_NOT_CHARGING:
						if (level == 0)
							sb.append(" needs charging right away.");
						else if (level > 0 && level <= 33)
							sb.append(" is about ready to be recharged, battery level is low"
									+ "[" + level + "]");
						else
							sb.append("'s battery level is" + "[" + level + "]");
						break;
					case BatteryManager.BATTERY_STATUS_FULL:
						sb.append(" is fully charged.");
						break;
					default:
						sb.append("'s battery is indescribable!");
						break;
					}
				}
				sb.append(' ');
				batterLevel.setText(sb.toString());
			}
		};
		batteryLevelFilter = new IntentFilter(Intent.ACTION_BATTERY_CHANGED);
		registerReceiver(batteryLevelRcvr, batteryLevelFilter);
	}
}
