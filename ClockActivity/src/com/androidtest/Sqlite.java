package com.androidtest;

import android.app.Activity;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.ListView;

public class Sqlite extends Activity {

	// 访问登记属性android.permission.ACCESS_CHECKIN_PROPERTIES
	// ，读取或写入登记check-in数据库属性表的权限
	// 获取错略位置android.permission.ACCESS_COARSE_LOCATION，通过WiFi或移动基站的方式获取用户错略的经纬度信息，定位精度大概误差在30~1500米
	// 获取精确位置android.permission.ACCESS_FINE_LOCATION，通过GPS芯片接收卫星的定位信息，定位精度达10米以内
	// 访问定位额外命令android.permission.ACCESS_LOCATION_EXTRA_COMMANDS，允许程序访问额外的定位提供者指令
	// 获取模拟定位信息android.permission.ACCESS_MOCK_LOCATION，获取模拟定位信息，一般用于帮助开发者调试应用
	// 获取网络状态android.permission.ACCESS_NETWORK_STATE，获取网络信息状态，如当前的网络连接是否有效
	// 访问Surface Flinger
	// android.permission.ACCESS_SURFACE_FLINGER，Android平台上底层的图形显示支持，一般用于游戏或照相机预览界面和底层模式的屏幕截图
	// 获取WiFi状态android.permission.ACCESS_WIFI_STATE，获取当前WiFi接入的状态以及WLAN热点的信息
	// 账户管理android.permission.ACCOUNT_MANAGER，获取账户验证信息，主要为GMail账户信息，只有系统级进程才能访问的权限
	// 验证账户android.permission.AUTHENTICATE_ACCOUNTS，允许一个程序通过账户验证方式访问账户管理ACCOUNT_MANAGER相关信息
	// 电量统计android.permission.BATTERY_STATS，获取电池电量统计信息
	// 绑定小插件android.permission.BIND_APPWIDGET，允许一个程序告诉appWidget服务需要访问小插件的数据库，只有非常少的应用才用到此权限
	// 绑定设备管理android.permission.BIND_DEVICE_ADMIN，请求系统管理员接收者receiver，只有系统才能使用
	// 绑定输入法android.permission.BIND_INPUT_METHOD
	// ，请求InputMethodService服务，只有系统才能使用
	// 绑定RemoteViewandroid.permission.BIND_REMOTEVIEWS，必须通过RemoteViewsService服务来请求，只有系统才能用
	// 绑定壁纸android.permission.BIND_WALLPAPER，必须通过WallpaperService服务来请求，只有系统才能用
	// 使用蓝牙android.permission.BLUETOOTH，允许程序连接配对过的蓝牙设备
	// 蓝牙管理android.permission.BLUETOOTH_ADMIN，允许程序进行发现和配对新的蓝牙设备
	// 变成砖头android.permission.BRICK，能够禁用手机，非常危险，顾名思义就是让手机变成砖头
	// 应用删除时广播android.permission.BROADCAST_PACKAGE_REMOVED，当一个应用在删除时触发一个广播
	// 收到短信时广播android.permission.BROADCAST_SMS，当收到短信时触发一个广播
	// 连续广播android.permission.BROADCAST_STICKY，允许一个程序收到广播后快速收到下一个广播
	// WAP PUSH广播android.permission.BROADCAST_WAP_PUSH，WAP PUSH服务收到后触发一个广播
	// 拨打电话android.permission.CALL_PHONE，允许程序从非系统拨号器里输入电话号码
	// 通话权限android.permission.CALL_PRIVILEGED，允许程序拨打电话，替换系统的拨号器界面
	// 拍照权限android.permission.CAMERA，允许访问摄像头进行拍照
	// 改变组件状态android.permission.CHANGE_COMPONENT_ENABLED_STATE，改变组件是否启用状态
	// 改变配置android.permission.CHANGE_CONFIGURATION，允许当前应用改变配置，如定位
	// 改变网络状态android.permission.CHANGE_NETWORK_STATE，改变网络状态如是否能联网
	// 改变WiFi多播状态android.permission.CHANGE_WIFI_MULTICAST_STATE，改变WiFi多播状态
	// 改变WiFi状态android.permission.CHANGE_WIFI_STATE，改变WiFi状态
	// 清除应用缓存android.permission.CLEAR_APP_CACHE，清除应用缓存
	// 清除用户数据android.permission.CLEAR_APP_USER_DATA，清除应用的用户数据
	// 底层访问权限android.permission.CWJ_GROUP，允许CWJ账户组访问底层信息
	// 手机优化大师扩展权限android.permission.CELL_PHONE_MASTER_EX，手机优化大师扩展权限
	// 控制定位更新android.permission.CONTROL_LOCATION_UPDATES，允许获得移动网络定位信息改变
	// 删除缓存文件android.permission.DELETE_CACHE_FILES，允许应用删除缓存文件
	// 删除应用android.permission.DELETE_PACKAGES，允许程序删除应用
	// 电源管理android.permission.DEVICE_POWER，允许访问底层电源管理
	// 应用诊断android.permission.DIAGNOSTIC，允许程序到RW到诊断资源
	// 禁用键盘锁android.permission.DISABLE_KEYGUARD，允许程序禁用键盘锁
	// 转存系统信息android.permission.DUMP，允许程序获取系统dump信息从系统服务
	// 状态栏控制android.permission.EXPAND_STATUS_BAR，允许程序扩展或收缩状态栏
	// 工厂测试模式android.permission.FACTORY_TEST，允许程序运行工厂测试模式
	// 使用闪光灯android.permission.FLASHLIGHT，允许访问闪光灯
	// 强制后退android.permission.FORCE_BACK，允许程序强制使用back后退按键，无论Activity是否在顶层
	// 访问账户Gmail列表android.permission.GET_ACCOUNTS，访问GMail账户列表
	// 获取应用大小android.permission.GET_PACKAGE_SIZE，获取应用的文件大小
	// 获取任务信息android.permission.GET_TASKS，允许程序获取当前或最近运行的应用
	// 允许全局搜索android.permission.GLOBAL_SEARCH，允许程序使用全局搜索功能
	// 硬件测试android.permission.HARDWARE_TEST，访问硬件辅助设备，用于硬件测试
	// 注射事件android.permission.INJECT_EVENTS，允许访问本程序的底层事件，获取按键、轨迹球的事件流
	// 安装定位提供android.permission.INSTALL_LOCATION_PROVIDER，安装定位提供
	// 安装应用程序android.permission.INSTALL_PACKAGES，允许程序安装应用
	// 内部系统窗口android.permission.INTERNAL_SYSTEM_WINDOW，允许程序打开内部窗口，不对第三方应用程序开放此权限
	// 访问网络android.permission.INTERNET，访问网络连接，可能产生GPRS流量
	// 结束后台进程android.permission.KILL_BACKGROUND_PROCESSES，允许程序调用killBackgroundProcesses(String).方法结束后台进程
	// 管理账户android.permission.MANAGE_ACCOUNTS，允许程序管理AccountManager中的账户列表
	// 管理程序引用android.permission.MANAGE_APP_TOKENS，管理创建、摧毁、Z轴顺序，仅用于系统
	// 高级权限android.permission.MTWEAK_USER，允许mTweak用户访问高级系统权限
	// 社区权限android.permission.MTWEAK_FORUM，允许使用mTweak社区权限
	// 软格式化android.permission.MASTER_CLEAR，允许程序执行软格式化，删除系统配置信息
	// 修改声音设置android.permission.MODIFY_AUDIO_SETTINGS，修改声音设置信息
	// 修改电话状态android.permission.MODIFY_PHONE_STATE，修改电话状态，如飞行模式，但不包含替换系统拨号器界面
	// 格式化文件系统android.permission.MOUNT_FORMAT_FILESYSTEMS，格式化可移动文件系统，比如格式化清空SD卡
	// 挂载文件系统android.permission.MOUNT_UNMOUNT_FILESYSTEMS，挂载、反挂载外部文件系统
	// 允许NFC通讯android.permission.NFC，允许程序执行NFC近距离通讯操作，用于移动支持
	// 永久Activityandroid.permission.PERSISTENT_ACTIVITY，创建一个永久的Activity，该功能标记为将来将被移除
	// 处理拨出电话android.permission.PROCESS_OUTGOING_CALLS，允许程序监视，修改或放弃播出电话
	// 读取日程提醒android.permission.READ_CALENDAR，允许程序读取用户的日程信息
	// 读取联系人android.permission.READ_CONTACTS，允许应用访问联系人通讯录信息
	// 屏幕截图android.permission.READ_FRAME_BUFFER，读取帧缓存用于屏幕截图
	// 读取收藏夹和历史记录com.android.browser.permission.READ_HISTORY_BOOKMARKS，读取浏览器收藏夹和历史记录
	// 读取输入状态android.permission.READ_INPUT_STATE，读取当前键的输入状态，仅用于系统
	// 读取系统日志android.permission.READ_LOGS，读取系统底层日志
	// 读取电话状态android.permission.READ_PHONE_STATE，访问电话状态
	// 读取短信内容android.permission.READ_SMS，读取短信内容
	// 读取同步设置android.permission.READ_SYNC_SETTINGS，读取同步设置，读取Google在线同步设置
	// 读取同步状态android.permission.READ_SYNC_STATS，读取同步状态，获得Google在线同步状态
	// 重启设备android.permission.REBOOT，允许程序重新启动设备
	// 开机自动允许android.permission.RECEIVE_BOOT_COMPLETED，允许程序开机自动运行
	// 接收彩信android.permission.RECEIVE_MMS，接收彩信
	// 接收短信android.permission.RECEIVE_SMS，接收短信
	// 接收Wap Pushandroid.permission.RECEIVE_WAP_PUSH，接收WAP PUSH信息
	// 录音android.permission.RECORD_AUDIO，录制声音通过手机或耳机的麦克
	// 排序系统任务android.permission.REORDER_TASKS，重新排序系统Z轴运行中的任务
	// 结束系统任务android.permission.RESTART_PACKAGES，结束任务通过restartPackage(String)方法，该方式将在外来放弃
	// 发送短信android.permission.SEND_SMS，发送短信
	// 设置Activity观察其android.permission.SET_ACTIVITY_WATCHER，设置Activity观察器一般用于monkey测试
	// 设置闹铃提醒com.android.alarm.permission.SET_ALARM，设置闹铃提醒
	// 设置总是退出android.permission.SET_ALWAYS_FINISH，设置程序在后台是否总是退出
	// 设置动画缩放android.permission.SET_ANIMATION_SCALE，设置全局动画缩放
	// 设置调试程序android.permission.SET_DEBUG_APP，设置调试程序，一般用于开发
	// 设置屏幕方向android.permission.SET_ORIENTATION，设置屏幕方向为横屏或标准方式显示，不用于普通应用
	// 设置应用参数android.permission.SET_PREFERRED_APPLICATIONS，设置应用的参数，已不再工作具体查看addPackageToPreferred(String)
	// 介绍
	// 设置进程限制android.permission.SET_PROCESS_LIMIT，允许程序设置最大的进程数量的限制
	// 设置系统时间android.permission.SET_TIME，设置系统时间
	// 设置系统时区android.permission.SET_TIME_ZONE，设置系统时区
	// 设置桌面壁纸android.permission.SET_WALLPAPER，设置桌面壁纸
	// 设置壁纸建议android.permission.SET_WALLPAPER_HINTS，设置壁纸建议
	// 发送永久进程信号android.permission.SIGNAL_PERSISTENT_PROCESSES，发送一个永久的进程信号
	// 状态栏控制android.permission.STATUS_BAR，允许程序打开、关闭、禁用状态栏
	// 访问订阅内容android.permission.SUBSCRIBED_FEEDS_READ，访问订阅信息的数据库
	// 写入订阅内容android.permission.SUBSCRIBED_FEEDS_WRITE，写入或修改订阅内容的数据库
	// 显示系统窗口android.permission.SYSTEM_ALERT_WINDOW，显示系统窗口
	// 更新设备状态android.permission.UPDATE_DEVICE_STATS，更新设备状态
	// 使用证书android.permission.USE_CREDENTIALS，允许程序请求验证从AccountManager
	// 使用SIP视频android.permission.USE_SIP，允许程序使用SIP视频服务
	// 使用振动android.permission.VIBRATE，允许振动
	// 唤醒锁定android.permission.WAKE_LOCK，允许程序在手机屏幕关闭后后台进程仍然运行
	// 写入GPRS接入点设置android.permission.WRITE_APN_SETTINGS，写入网络GPRS接入点设置
	// 写入日程提醒android.permission.WRITE_CALENDAR，写入日程，但不可读取
	// 写入联系人android.permission.WRITE_CONTACTS，写入联系人，但不可读取
	// 写入外部存储android.permission.WRITE_EXTERNAL_STORAGE，允许程序写入外部存储，如SD卡上写文件
	// 写入Google地图数据android.permission.WRITE_GSERVICES，允许程序写入Google Map服务数据
	// 写入收藏夹和历史记录com.android.browser.permission.WRITE_HISTORY_BOOKMARKS，写入浏览器历史记录或收藏夹，但不可读取
	// 读写系统敏感设置android.permission.WRITE_SECURE_SETTINGS，允许程序读写系统安全敏感的设置项
	// 读写系统设置android.permission.WRITE_SETTINGS，允许读写系统设置项
	// 编写短信android.permission.WRITE_SMS，允许编写短信
	// 写入在线同步设置 android.permission.WRITE_SYNC_SETTINGS，写入Google在线同步设置

	// 创建数据库
	// Context.createDatabase(Stringname,intversion,int
	// mode,CursorFactoryfactory)创建一个新的数据库并
	// 返回一个SQLiteDatabase对象
	// 假如数据库不能被创建，则抛出FileNotFoundException异常
	// 新创建SQLite数据库方法
	// SQLiteDatabase mydataBase=SQLiteDatabase.create(new CursorFactory(){
	// //创建一个数据库
	// //工厂类，一个可选工厂类，当查询时调用来实例化一个光标
	// @Override
	// public Cursor newCursor(SQLiteDatabase db,
	// SQLiteCursorDriver masterQuery, String editTable,
	// SQLiteQuery query) {
	// // TODO Auto-generated method stub
	// return null;
	// }
	// });
	//
	// SQLiteDatabase myDataBase=this.openOrCreateDatabase("myDataBase.db",
	// MODE_PRIVATE, new CursorFactory(){
	// //创建新的数据库，名称myDatabase，模式MODE_PRIVATE，鼠标工厂
	// //工厂类，一个可选工厂类，当查询时调用来实例化一个光标
	// @Override
	// public Cursor newCursor(SQLiteDatabase db,
	// SQLiteCursorDriver masterQuery, String editTable,
	// SQLiteQuery query) {
	// // TODO Auto-generated method stub
	// return null;
	// }
	// });
	//
	// 删除数据库
	// Context.deleteDatabase(Stringname)删除指定名称的数据库
	// 假如数据库成功删除则返回true，失败则为false(例如数据库不存在)
	// //删除指定名称的数据库
	// this.deleteDatabase("myDatabase.db");
	//
	// 打开数据库
	// Context.openDatabase(Stringfile,CursorFactory factory)打开一个存在的数据库并返回一个
	// SQLiteDatabase对象
	// 如果数据库不存在则抛出FileNotFoundException异常
	// //创建一个名为：myDataBase的数据库，后缀为.db
	// SQLiteDatabase
	// my_DataBase=this.openOrCreateDatabase("myDateBase.db",MODE_PRIVATE,
	// null);
	// my_DataBase.close();//不要忘记关闭数据库
	//
	//
	// 非查询SQL指令
	// SQLiteDatabase.execSQL(Stringsql)可以用来执行非查询SQL指令，这些指令没有结果
	// 包括：CREATETABLE/DROPTABLE/INSERT 等等
	// 例如：
	// //创建一个名为"test"并带两个参数的表
	// my_DataBase.execSQL("CREATE TABLE test (_id INTEGER PRIMARY KEY,someNumber INTERGER);");"
	// //在数据库中插入一个元组
	// my_DataBase.execSQL("INSERT INTO test (_id,someNumber) values(1,8);");
	// //删除表
	// my_DataBase.execSQL("DROP TABLE test");
	//
	//
	// //为了创建一个Cursor(游标)，必须执行一个查询，要么通过SQL使用rawQuery()方法
	// //或是更精心设计的方法，像query()方法
	// Cursor cur=my_DataBase.rawQuery("SELECT * FORM test", null);
	// if(cur!=null){//游标不为空
	// //返回给定名称的列的基于0开始的index，如果该属性列不存在则返回-1
	// //通过它们的index来检索属性值
	// int numColumn=cur.getColumnIndex("someNumber");
	// if(cur.moveToFirst()){
	// //cur.moveToFirst()让游标指向第一行，如果游标指向第一行，则返回true
	// do {
	// int num=cur.getInt(numColumn);//获得当前行该属性的值
	// /*Cursor提供了不同的方法来回索不同的数据类型
	// 例如getInt(int index)/getString(int index)等等*/
	// /*做一些事情*/
	// }while (cur.moveToNext());
	// /*游标移动到下一行，如果游标已经通过了结果集中的最后，
	// 即没有行可以移动时，则返回false*/
	// //其他可能移动的是previous()和first()方法
	// }
	// }

	/** Called when the activity is first created. */
	// 对代码级功能做详细说明，本代码在程序启动时穿件数据库以及数据表，然后通过监听键盘的上下左右抬起事件，来进行数据的增删查该等功能，主要是为了简单说明SqlLite数据库的简单使用，实际开发中不会如此使用，下次再介绍SQLiteOpenHelper的在实际应用开发中应用。
	// openOrCreateDatabase(DATABASE_NAME,MODE_PRIVATE, null);方法作用
	// 创建数据库,如果存在这个数据库直接打开，不存在，则创建。
	// 该方法具有三个参数，DATABASE_NAME:数据库名称，MODE_PRIVATE：数据库的创建模式，Cursor：Cursor工厂
	// 数据库创建成功后，得到了SQLiteDatabase对象，该对象作为笨应用的核心对象，建表，数据的增删查改都以该对象为核心进行操作。
	// 创建表 sqlLiteDatabase.execSQL("CREATE TABLE langsinTable("
	// + " _id Integer PRIMARY KEY," + " tel Integer," + " uname TEXT"
	// + ")");
	// 使用SQLiteDatabase对象的execSQL方法，把正常建表的SQL语句传入作为参数对象，就可以创建数据表。（注意使用SqlLite的数据库数据字段类型）。
	// 插入数据：sqlLiteDatabase.insert("langsinTable", null, cv);
	// long insert(String table, String nullColumnHack, ContentValues values)
	// Convenience method for inserting a row into the database.
	// String table:数据库标名称，values：出入的数据对象 如：ContentValues cv = new
	// ContentValues();
	// cv.put("tel", ++telNum);
	// cv.put("uname", "张三" + (++nameIndex));
	// 即构建ContentValues 对象cv 让“tel”字段的值++telNum，"uname"字段的值为"张三" +
	// (++nameIndex);插入的数据库表
	// 删除数据据表数据：sqlLiteDatabase.execSQL("DELETE FROM langsinTable WHERE _id=" +
	// lastId);使用执行SQL语句做删除。
	//
	// 更新表数据：sqlLiteDatabase.update("langsinTable", cv, "uname like '张三%'",
	// null);
	// 更新表数据使用SQLiteDatabase对象的update方法。
	// int update(String table, ContentValues values, String whereClause,
	// String[] whereArgs)
	// Convenience method for updating rows in the database.
	// String table:更像数据的表， ContentValues values：更像的数据，String whereClause：查询条件
	//
	// 查询数据库表数据使用 sqlLiteDatabase.query("langsinTable", new String[] {
	// "_id","tel", "uname" }, null, null, null, null, null);
	// Cursor query(String table, String[] columns, String selection, String[]
	// selectionArgs, String groupBy, String having, String orderBy, String
	// limit)
	// Query the given table, returning a Cursor over the result set.
	//
	// 最后使用ListView作为视图的显示控件
	// ListAdapter adapter = new SimpleCursorAdapter(this,
	// // ListView 显示模板
	// android.R.layout.simple_list_item_2, cur,
	// // 取得列
	// new String[] { "tel", "uname" },
	// //
	// ? new int[] { android.R.id.text1, android.R.id.text2 }
	// );
	// if (listView == null) {
	// listView = (ListView) this.findViewById(R.id.listView);
	// }
	// listView.setAdapter(adapter);
	// ListView
	// 显示模板采用了Android内置的模版显示android.R.layout.simple_list_item_2,该模版显示两个TextView，

	private static Integer telNum = 17010;
	private static Integer nameIndex = 1;
	private SQLiteDatabase sqlLiteDatabase;
	private static Integer lastId = 0;
	private final static String DATABASE_NAME = "langsin_db";

	private ListView listView;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.sqlite);

		// 创建数据库,如果存在这个数据库直接打开，不存在，则创建

		// 数据库名称，模式， Cursor工厂
		sqlLiteDatabase = this.openOrCreateDatabase(DATABASE_NAME,
				MODE_PRIVATE, null);
		listView = (ListView) this.findViewById(R.id.listView);
		// 创建数据表
		try {
			sqlLiteDatabase.execSQL("DROP TABLE langsinTable");
			sqlLiteDatabase.execSQL("CREATE TABLE langsinTable("
					+ " _id Integer PRIMARY KEY," + " tel Integer,"
					+ " uname TEXT" + ")");

			addData();
			updateData();
			deleteData();
		} catch (Throwable e) {
			updateListView();
		}
	}

	public void addData() {
		ContentValues cv = new ContentValues();
		cv.put("tel", ++telNum);
		cv.put("uname", "张三" + (++nameIndex));
		sqlLiteDatabase.insert("langsinTable", null, cv);
		updateListView();
	}

	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		return super.onKeyDown(keyCode, event);
	}

	@Override
	public boolean onKeyUp(int keyCode, KeyEvent event) {
		switch (keyCode) {
		case KeyEvent.KEYCODE_DPAD_UP: {
			System.out.println("addData");
			addData();
			break;

		}
		case KeyEvent.KEYCODE_DPAD_DOWN: {
			System.out.println("deleteData");
			deleteData();
			break;
		}
		case KeyEvent.KEYCODE_DPAD_LEFT: {
			System.out.println("updateData");
			updateData();
			break;
		}
		case KeyEvent.KEYCODE_DPAD_RIGHT: {
			System.out.println("close");
			close();
			break;
		}
		}
		return true;
	}

	public void close() {
		sqlLiteDatabase.close();
		this.finish();
	}

	public void updateData() {
		ContentValues cv = new ContentValues();
		cv.put("tel", ++telNum);
		cv.put("uname", "更新后的张三" + (++nameIndex));
		sqlLiteDatabase.update("langsinTable", cv, "uname like '张三%'", null);
		updateListView();
	}

	public void updateListView() {
		Cursor cur = sqlLiteDatabase.query("langsinTable", new String[] {
				"_id", "tel", "uname" }, null, null, null, null, null);
		lastId = cur.getCount();
		if (cur != null && cur.getCount() >= 0) {
			System.out.println(cur.isClosed());
			System.out.println(cur.getColumnIndex("uname"));
			// System.out.println(cur.getString(cur.getColumnIndex("uname")));
			// ListAdapter adapter = new SimpleCursorAdapter(this,
			// // ListView 显示模板
			// android.R.layout.simple_list_item_2, cur,
			// // 取得列
			// new String[] { "tel", "uname" },
			// //
			// new int[] { android.R.id.text1, android.R.id.text2 });
			// if (listView == null) {
			// listView = (ListView) this.findViewById(R.id.listView);
			// }
			// listView.setAdapter(adapter);
		}
	}

	public void deleteData() {
		sqlLiteDatabase.execSQL("DELETE FROM langsinTable WHERE _id=" + lastId);
		lastId--;
		if (lastId < 0) {
			lastId = 0;
		}
		updateListView();
	}

	// 一.建立数据库
	// sqlite3.exe test.db
	//
	// 二.双击sqlite-3_6_16目录下的程序sqlite3.exe，即可运行
	// 三.退出
	// .exit
	// 或者
	// .quit
	// 四.SQLite支持如下5种数据类型
	// 1.NULL：空值。
	// 2.INTEGER：带符号的整型，具体取决有存入数字的范围大小。
	// 3.REAL：浮点数字，存储为8-byte IEEE浮点数。
	// 4.TEXT：字符串文本。
	// 5.BLOB：二进制对象。
	//
	// 五.联系人表格结构如下
	// create table contact(id integer primary key autoincrement,
	// lastname varchar(20),firstname varchar(20),
	// mobile varchar(30), telephone varchar(20),
	// email varchar(30), company varchar(50),
	// department varchar(16),address varchar(80),
	// id1 interger,id2 integer, updatetime datetime);
	//
	// 六.查看数据库有哪些数据表
	// 命令是：.tables
	// 七.如何插入一条记录
	// insert into contact(lastname,firstname,mobile,telephone,updatetime)
	// values(‘刘’,'畅’,’13910128132′,’010-81749136′,’2009-07-22′);
	// 八.查看数据表的结构
	//
	// 针对整个数据库
	// .schema
	// 针对仅仅是contact联系人该表
	// .schema contact 注意没有分号
	//
	// 九.如何打开一个已经创建的数据库
	//
	// sqlite3 test.db
	// 十.如何解决如下问题
	// SQL error: near “sqlite3″: syntax error
	//
	// SQL指令都是以分号（;）结尾的。如果遇到两个减号（–）则代表注解，sqlite3会略过去
	//
	// 十一.如何建立索引
	// create index index_name on table_name(field_to_be_indexed);
	// 十二.如何删除一张数据表
	// drop table contact;
	//
	// 十三.查看当前的数据库
	// .database
	//
	// 十四.如何删除一个数据表的数据
	// delete from contact;
	// 十五.如何导入一个文件到某个表中
	// .import 文件路径 表名
	// 注意这是非SQL语句，所以不加分号
	// 十六.如何设置文件字段的分隔符
	// .separator “,”
	// .import e:/contact.txt contact
	// 十七.如何查看当前sqllite字段的分隔符是什么？
	// .show
	//
	// 十八.如何将查询结果导出到一个文件
	//
	// 第一步：.output a.txt
	// 第二步：执行要导出的SQL语句
	// 第三步：.output stdout
	// 十九.SQL查询语句
	// select * from film order by year limit 10;
	// select * from film order by year desc limit 10;
	// select count(*) from film;
	// select * from film where starring like ‘Jodie%’;
	//
	// select * from film where starring=’Jodie Foster’;
	// select title, year from film order by year desc limit 10;
	// select columns from table_name where expression;
	//
	// 最常见的用法，当然是倒出所有数据库的内容：
	//
	// select * from film;
	//
	// 如果资料太多了，我们或许会想限制笔数：
	//
	// select * from film limit 10;
	//
	// 或是照着电影年份来排列：
	//
	// select * from film order by year limit 10;
	//
	// 或是年份比较近的电影先列出来：
	//
	// select * from film order by year desc limit 10;
	//
	// 或是我们只想看电影名称跟年份：
	//
	// select title, year from film order by year desc limit 10;
	//
	// 查所有茱蒂佛斯特演过的电影：
	//
	// select * from film where starring=’Jodie Foster’;
	//
	// 查所有演员名字开头叫茱蒂的电影(‘%’ 符号便是 SQL 的万用字符）：
	//
	// select * from film where starring like ‘Jodie%’;
	//
	// 查所有演员名字以茱蒂开头、年份晚于1985年、年份晚的优先列出、最多十笔，只列出电影名称和年份：
	//
	// select title, year from film where starring like ‘Jodie%’ and year >=
	// 1985 order by year desc limit 10;
	//
	// 有时候我们只想知道数据库一共有多少笔资料：
	//
	// select count(*) from film;
	//
	// 有时候我们只想知道1985年以后的电影有几部：
	//
	// select count(*) from film where year >= 1985;
	//
	// （进一步的各种组合，要去看SQL专书，不过你大概已经知道SQL为什么这么流行了：这种语言允许你将各种查询条件组合在一起──而我们还没提到「跨数据库的联合查询」呢！）
	//
	// 如何更改或删除资料
	// 了解select的用法非常重要，因为要在sqlite更改或删除一笔资料，也是靠同样的语法。
	//
	// 例如有一笔资料的名字打错了：
	// update film set starring=’Jodie Foster’ where starring=’Jodee Foster’;
	// 就会把主角字段里，被打成’Jodee Foster’的那笔（或多笔）资料，改回成Jodie Foster。
	// delete from film where year < 1970;
	// 就会删除所有年代早于1970年（不含）的电影了。
	// 其他sqlite的特别用法
	// sqlite可以在shell底下直接执行命令：
	// sqlite3 film.db “select * from film;”
	// 输出 HTML 表格：
	// sqlite3 -html film.db “select * from film;”
	// 将数据库「倒出来」：
	// sqlite3 film.db “.dump” > output.sql
	// 利用输出的资料，建立一个一模一样的数据库（加上以上指令，就是标准的SQL数据库备份了）：
	// sqlite3 film.db < output.sql
	// 在大量插入资料时，你可能会需要先打这个指令：
	//
	// begin;
	// 插入完资料后要记得打这个指令，资料才会写进数据库中：
	// commit;
	//
	// 创建数据库文件:
	// >SQLite3 d:\test.db 回车
	// 就生成了一个test.db在d盘。
	// 这样同时也SQLite3挂上了这个test.db
	// 2)
	// 用.help可以看看有什么命令
	// >.help 回车即可
	// 3)可以在这里直接输入SQL语句创建表格 用;结束 ，然后回车就可以看到了
	// 4)看看有创建了多少表
	// >.tables
	// 5)看表结构
	// >.schema 表名
	// 6)看看目前的数据库
	// >.database
	// 7)如果要把查询输出到文件
	// >.output 文件名
	// > 查询语句；
	// 查询结果就输出到了文件c:\query.txt
	// 把查询结果用屏幕输出
	// >.output stdout
	// 8)把表结构输出，同时索引也会输出
	// .dump 表名
	// 9)退出
	// >.exit 或者.quit
	// 2。从http://sqlite.phxsoftware.com/ 下载Ado.net驱动。
	// 下载了安装，在安装目录中存在System.Data.SQLite.dll
	// 我们只需要拷贝这个文件到引用目录，并添加引用即可对SQLite数据库操作了
	// 所有的Ado.net对象都是以SQLite开头的，比如SQLiteConnection
	// 连接串只需要如下方式
	// Data Source=d:\test.db 或者DataSource=test.db–应用在和应用程序或者.net能够自动找到的目录
	// 剩下的就很简单了~~
	// 3。SQL语法
	// 由于以前用SQLServer或者ISeries，所以DDL的语法很汗颜
	// 1)创建一个单个Primary Key的table
	// CREATE TABLE [Admin] (
	// [UserName] [nvarchar] (20) PRIMARY KEY NOT NULL ,
	// [Password] [nvarchar] (50) NOT NULL ,
	// [Rank] [smallint] NOT NULL ,
	// [MailServer] [nvarchar] (50) NOT NULL ,
	// [MailUser] [nvarchar] (50) NOT NULL ,
	// [MailPassword] [nvarchar] (50) NOT NULL ,
	// [Mail] [nvarchar] (50) NOT NULL
	// ) ;
	// 2)创建一个多个Primary Key的table
	// CREATE TABLE [CodeDetail] (
	// [CdType] [nvarchar] (10) NOT NULL ,
	// [CdCode] [nvarchar] (20) NOT NULL ,
	// [CdString1] [ntext] NOT NULL ,
	// [CdString2] [ntext] NOT NULL ,
	// [CdString3] [ntext] NOT NULL,
	// PRIMARY KEY (CdType,CdCode)
	//
	// ) ;
	// 3)创建索引
	// CREATE INDEX [IX_Account] ON [Account]([IsCheck], [UserName]);
	//
	// 还可以视图等等。
	// 4.还有很有用的SQL
	// Select * from Sqlite_master
	// Select datetime(‘now’)
	// Select date(‘now’)
	// Select time(‘now’)
	//
	// SQLite 内建函数表
	// 算术函数
	// abs(X)
	// 返回给定数字表达式的绝对值。
	// max(X,Y[,...])
	// 返回表达式的最大值。
	// min(X,Y[,...])
	// 返回表达式的最小值。
	// random(*)
	// 返回随机数。
	// round(X[,Y])
	// 返回数字表达式并四舍五入为指定的长度或精度。
	// 字符处理函数
	// length(X)
	// 返回给定字符串表达式的字符个数。
	// lower(X)
	// 将大写字符数据转换为小写字符数据后返回字符表达式。
	// upper(X)
	// 返回将小写字符数据转换为大写的字符表达式。
	// substr(X,Y,Z)
	// 返回表达式的一部分。
	// randstr()
	//
	// quote(A)
	//
	// like(A,B)
	// 确定给定的字符串是否与指定的模式匹配。
	// glob(A,B)
	//
	// 条件判断函数
	// coalesce(X,Y[,...])
	//
	// ifnull(X,Y)
	//
	// nullif(X,Y)
	//
	// 集合函数
	// avg(X)
	// 返回组中值的平均值。
	// count(X)
	// 返回组中项目的数量。
	// max(X)
	// 返回组中值的最大值。
	// min(X)
	// 返回组中值的最小值。
	// sum(X)
	// 返回表达式中所有值的和。
	// 其他函数
	// typeof(X)
	// 返回数据的类型。
	// last_insert_rowid()
	// 返回最后插入的数据的 ID 。
	// sqlite_version(*)
	// 返回 SQLite 的版本。
	// change_count()
	// 返回受上一语句影响的行数。
	// last_statement_change_count()
	//
	// oh,还有就是看到有人说，好像成批插入的时候，启动事务，比不启动事务快n倍
	// 还有就是尽量使用参数化的SQL,估计和商用DB一样能够自动Prepare.
	// ===========
	// sqlite可以在shell/dos command底下直接执行命令：
	// sqlite3 film.db “select * from film;”
	// 输出 HTML 表格：
	// sqlite3 -html film.db “select * from film;”
	// 将数据库「倒出来」：
	// sqlite3 film.db “.dump” > output.sql
	// 利用输出的资料，建立一个一模一样的数据库（加上以上指令，就是标准的SQL数据库备份了）：
	// sqlite3 film.db < output.sql
	// 在大量插入资料时，你可能会需要先打这个指令：
	// begin;
	// 插入完资料后要记得打这个指令，资料才会写进数据库中：
	// commit;
	// SQLITE深入——常见问题
	// 如何建立自动增长字段?
	// 简短回答：声明为 INTEGER PRIMARY KEY 的列将会自动增长 。
	// 长一点的答案： 如果你声明表的一列为 INTEGER PRIMARY KEY，那么， 每当你在该列上插入一NULL值时，
	// NULL自动被转换为一个比该列中最大值大1的一个整数，如果表是空的， 将会是1。 (如果是最大可能的主键
	// 9223372036854775807，那个，将键值将是随机未使用的数。） 如，有下列表：
	// CREATE TABLE t1(
	// a INTEGER PRIMARY KEY,
	// b INTEGER
	// );
	// 在该表上，下列语句
	// INSERT INTO t1 VALUES(NULL,123);
	// 在逻辑上等价于：
	// INSERT INTO t1 VALUES((SELECT max(a) from t1)+1,123);
	// 有一个新的API叫做 sqlite3_last_insert_rowid()， 它将返回最近插入的整数值。
	// 注意该整数会比表中该列上的插入之前的最大值大1。
	// 该键值在当前的表中是唯一的。但有可能与已从表中删除的值重叠。要想建立在整个表的生命周期中唯一的键值，需要在 INTEGER PRIMARY KEY
	// 上增加AUTOINCREMENT声明。那么，新的键值将会比该表中曾能存在过的最大值大1。如果最大可能的整数值在数据表中曾经存在过，INSERT将会失败，
	// 并返回SQLITE_FULL错误代码。
	// 多个应用程序或一个应用程序的多个实例可以同时访问同一个数据库文件吗？
	// 多个进程可同时打开同一个数据库。多个进程可以同时进行SELECT 操作，但在任一时刻，只能有一个进程对数据库进行更改。
	// SQLite使用读、写锁控制对数据库的访问。（在Win95/98/ME等不支持读、写锁的系统下，使用一个概率性的模拟来代替。）但使用时要注意：
	// 如果数据库文件存放于一个NFS文件系统上，这种锁机制可能不能正常工作。 这是因为 fcntl() 文件锁在很多NFS上没有正确的实现。
	// 在可能有多个进程同时访问数据库的时候，应该避免将数据库文件放到NFS上。在Windows上，Microsoft的文档中说：如果使用 FAT
	// 文件系统而没有运行 share.exe
	// 守护进程，那么锁可能是不能正常使用的。那些在Windows上有很多经验的人告诉我：对于网络文件，文件锁的实现有好多Bug，是靠不住的。如果他们说的是对的，那么在两台或多台Windows机器间共享数据库可能会引起不期望的问题。
	// 我们意识到，没有其它嵌入式的 SQL 数据库引擎能象 SQLite
	// 这样处理如此多的并发。SQLite允许多个进程同时打开一个数据库，同时读一个数据库。当有任何进程想要写时，它必须在更新过程中锁住数据库文件。但那通常只是几毫秒的时间。其它进程只需等待写进程干完活结束。典型地，其它嵌入式的SQL数据库引擎同时只允许一个进程连接到数据库。
	// 但是，Client/Server数据库引擎（如 PostgreSQL, MySQL, 或
	// Oracle）通常支持更高级别的并发，并且允许多个进程同时写同一个数据库。这种机制在Client/Server结构的数据库上是可能的，因为总是有一个单一的服务器进程很好地控制、协调对数据库的访问。如果你的应用程序需要很多的并发，那么你应该考虑使用一个Client/Server
	// 结构的数据库。但经验表明，很多应用程序需要的并发，往往比其设计者所想象的少得多。
	// 当SQLite试图访问一个被其它进程锁住的文件时，缺省的行为是返回 SQLITE_BUSY。 可以在C代码中使用
	// sqlite3_busy_handler() 或 sqlite3_busy_timeout() API 函数调整这一行为。
	// 在SQLite数据库中如何列出所有的表和索引？
	// 如果你运行 sqlite3 命令行来访问你的数据库，可以键入 “.tables”来获得所有表的列表。或者，你可以输入 “.schema”
	// 来看整个数据库模式，包括所有的表的索引。输入这些命令，后面跟一个LIKE模式匹配可以限制显示的表。
	// 在一个 C/C++ 程序中（或者脚本语言使用 Tcl/Ruby/Perl/Python 等） 你可以在一个特殊的名叫 SQLITE_MASTER
	// 上执行一个SELECT查询以获得所有 表的索引。每一个 SQLite 数据库都有一个叫 SQLITE_MASTER 的表， 它定义数据库的模式。
	// SQLITE_MASTER 表看起来如下：
	// CREATE TABLE sqlite_master (
	// type TEXT,
	// name TEXT,
	// tbl_name TEXT,
	// rootpage INTEGER,
	// sql TEXT
	// );
	// 对于表来说，type 字段永远是 ‘table’，name 字段永远是表的名字。所以，要获得数据库中所有表的列表，使用下列SELECT语句：
	// SELECT name from sqlite_master
	// WHERE type=’table’
	// ORDER BY name;
	// 对于索引，type 等于 ‘index’, name 则是索引的名字，tbl_name 是该索引所属的表的名字。不管是表还是索引，sql
	// 字段是原先用 CREATE TABLE 或 CREATE INDEX 语句创建它们时的命令文本。对于自动创建的索引（用来实现 PRIMARY
	// KEY 或 UNIQUE 约束），sql字段为NULL。
	// SQLITE_MASTER 表是只读的。不能对它使用 UPDATE、INSERT 或 DELETE。 它会被 CREATE
	// TABLE、CREATE INDEX、DROP TABLE 和 DROP INDEX 命令自动更新。
	// 临时表不会出现在 SQLITE_MASTER 表中。临时表及其索引和触发器存放在另外一个叫 SQLITE_TEMP_MASTER
	// 的表中。SQLITE_TEMP_MASTER 跟 SQLITE_MASTER
	// 差不多，但它只是对于创建那些临时表的应用可见。如果要获得所有表的列表， 不管是永久的还是临时的，可以使用类似下面的命令：
	// SELECT name from
	// (SELECT * from sqlite_master UNION ALL
	// SELECT * from sqlite_temp_master)
	// WHERE type=’table’
	// ORDER BY name
	// 在SQLite中，VARCHAR字段最长是多少？
	// SQLite 不强制 VARCHAR 的长度。 你可以在 SQLITE 中声明一个
	// VARCHAR(10)，SQLite还是可以很高兴地允许你放入500个字符。 并且这500个字符是原封不动的，它永远不会被截断。
	// SQLite支持二进制大对象吗？
	// SQLite 3.0 及以后版本允许你在任何列中存储 BLOB 数据。 即使该列被声明为其它类型也可以。
	// 在SQLite中，如何在一个表上添加或删除一列？
	// SQLite 有有限地 ALTER TABLE 支持。你可以使用它来在表的末尾增加一列，可更改表的名称。
	// 如果需要对表结构做更复杂的改变，则必须重新建表。重建时可以先将已存在的数据放到一个临时表中，删除原表， 创建新表，然后将数据从临时表中复制回来。
	// 如，假设有一个 t1 表，其中有 “a”, “b”, “c” 三列， 如果要删除列 c ，以下过程描述如何做:
	// BEGIN TRANSACTION;
	// CREATE TEMPORARY TABLE t1_backup(a,b);
	// INSERT INTO t1_backup SELECT a,b from t1;
	// DROP TABLE t1;
	// CREATE TABLE t1(a,b);
	// INSERT INTO t1 SELECT a,b from t1_backup;
	// DROP TABLE t1_backup;
	// COMMIT;
	// 在数据库中删除了很多数据，但数据库文件没有变小，是Bug吗？
	// 不是。当你从SQLite数据库中删除数据时， 未用的磁盘空间将会加入一个内部的“自由列表”中。
	// 当你下次插入数据时，这部分空间可以重用。磁盘空间不会丢失，但也不会返还给操作系统。
	// 如果删除了大量数据，而又想缩小数据库文件占用的空间，执行 VACUUM 命令。 VACUUM
	// 将会从头重新组织数据库。这将会使用数据库有一个空的“自由链表”， 数据库文件也会最小。但要注意的是，VACUUM
	// 的执行会需要一些时间（在SQLite开发时，在Linux上，大约每M字节需要半秒种），并且， 执行过程中需要原数据库文件至多两倍的临时磁盘空间。
	// 对于 SQLite 3.1版本，一个 auto-vacumm 模式可以替代 VACUUM 命令。 可以使用 auto_vacuum pragma
	// 打开。
	// SQLITE_SCHEMA error是什么错误？为什么会出现该错误？
	// 当一个准备好的（prepared）SQL语句不再有效或者无法执行时， 将返回一个 SQLITE_SCHEMA
	// 错误。发生该错误时，SQL语句必须使用 sqlite3_prepare() API来重新编译. 在 SQLite 3 中, 一个
	// SQLITE_SCHEMA 错误只会发生在用
	// sqlite3_prepare()/sqlite3_step()/sqlite3_finalize() API 执行 SQL 时。而不会发生在使用
	// sqlite3_exec()时。 在版本2中不是这样。
	// 准备好的语句失效的最通常原因是：在语句准备好后， 数据库的模式又被修改了。另外的原因会发生在：
	// 数据库离线：DETACHed.
	// 数据库被 VACUUMed
	// 一个用户存储过程定义被删除或改变。
	// 一个 collation 序列定义被删除或改变。
	// 认证函数被改变。
	// 在所有情况下，解决方法是重新编译并执行该SQL语句。 因为一个已准备好的语句可以由于其它进程改变数据库模式而失效，所有使用
	// sqlite3_prepare()/sqlite3_step()/sqlite3_finalize() API 的代码都应准备处理
	// SQLITE_SCHEMA 错误。下面给出一个例子：
	// int rc;
	// sqlite3_stmt *pStmt;
	// char zSql[] = “SELECT …..”;
	// do {
	// /* Compile the statement from SQL. Assume success. */
	// sqlite3_prepare(pDb, zSql, -1, &pStmt, 0);
	// while( SQLITE_ROW==sqlite3_step(pStmt) ){
	// /* Do something with the row of available data */
	// }
	// /* Finalize the statement. If an SQLITE_SCHEMA error has
	// ** occured, then the above call to sqlite3_step() will have
	// ** returned SQLITE_ERROR. sqlite3_finalize() will return
	// ** SQLITE_SCHEMA. In this case the loop will execute again.
	// */
	// rc = sqlite3_finalize(pStmt);
	// } while( rc==SQLITE_SCHEMA );
	//
	// 如何在字符串中使用单引号(‘)？
	// SQL 标准规定，在字符串中，单引号需要使用逃逸字符，即在一行中使用两个单引号。在这方面 SQL 用起来类似 Pascal 语言。 SQLite
	// 尊循标准。如：
	// INSERT INTO xyz VALUES(’5 O”clock’);
	// Sqlite中如何返回本地化当前时间？
	// 在做ClinicOS的时候遇到一个问题，在保存病历登记时间时，我使用了“CURRENT_TIMESTAMP”，但这有个问题，它返回的是UTC
	// Time，这对我们中国人没啥用，一直希望能想办法将它转为localtime。今天刚好有空，所以去查了查Sqlite的Mail
	// List，果然也有人遇到了这个问题，我从一篇名为《translate time comparison
	// statement》（http://www.mail-archive.com/sqlite-users@sqlite.org
	// /msg12350.html）中看到这样的回复：
	// 二十.如何更新表中数据
	// update contact set lastname=’江南七怪’where id = 1028
	//
	// update contact set lastname=’江南七怪’, mobile=’13912345678′ where id=1028;
	// 二十一.如何一次插入多个数据
	// Insert into SAMPLE(PRJNUM, PRJNAME, EMYNUM, EMYNAME, SALCATEGORY,
	// SALPACKAGE)
	// values(100001, ‘TPMS’, 200001, ‘Johnson’, ‘A’, 2000), (100001, ‘TPMS’,
	// 200002,
	// ‘Christine’, ‘B’, 3000), (100001, ‘TPMS’, 200003, ‘Kevin’, ‘C’, 4000),
	// (100002,
	// ‘TCT’, 200001, ‘Johnson’, ‘A’, 2000), (100002, ‘TCT’, 200004, ‘Apple’,
	// ‘B’,
	// 3000);

}
