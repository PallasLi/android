package com.androidtest;

import android.app.Activity;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.ListView;

public class Sqlite extends Activity {

	// ���ʵǼ�����android.permission.ACCESS_CHECKIN_PROPERTIES
	// ����ȡ��д��Ǽ�check-in���ݿ����Ա��Ȩ��
	// ��ȡ����λ��android.permission.ACCESS_COARSE_LOCATION��ͨ��WiFi���ƶ���վ�ķ�ʽ��ȡ�û����Եľ�γ����Ϣ����λ���ȴ�������30~1500��
	// ��ȡ��ȷλ��android.permission.ACCESS_FINE_LOCATION��ͨ��GPSоƬ�������ǵĶ�λ��Ϣ����λ���ȴ�10������
	// ���ʶ�λ��������android.permission.ACCESS_LOCATION_EXTRA_COMMANDS�����������ʶ���Ķ�λ�ṩ��ָ��
	// ��ȡģ�ⶨλ��Ϣandroid.permission.ACCESS_MOCK_LOCATION����ȡģ�ⶨλ��Ϣ��һ�����ڰ��������ߵ���Ӧ��
	// ��ȡ����״̬android.permission.ACCESS_NETWORK_STATE����ȡ������Ϣ״̬���統ǰ�����������Ƿ���Ч
	// ����Surface Flinger
	// android.permission.ACCESS_SURFACE_FLINGER��Androidƽ̨�ϵײ��ͼ����ʾ֧�֣�һ��������Ϸ�������Ԥ������͵ײ�ģʽ����Ļ��ͼ
	// ��ȡWiFi״̬android.permission.ACCESS_WIFI_STATE����ȡ��ǰWiFi�����״̬�Լ�WLAN�ȵ����Ϣ
	// �˻�����android.permission.ACCOUNT_MANAGER����ȡ�˻���֤��Ϣ����ҪΪGMail�˻���Ϣ��ֻ��ϵͳ�����̲��ܷ��ʵ�Ȩ��
	// ��֤�˻�android.permission.AUTHENTICATE_ACCOUNTS������һ������ͨ���˻���֤��ʽ�����˻�����ACCOUNT_MANAGER�����Ϣ
	// ����ͳ��android.permission.BATTERY_STATS����ȡ��ص���ͳ����Ϣ
	// ��С���android.permission.BIND_APPWIDGET������һ���������appWidget������Ҫ����С��������ݿ⣬ֻ�зǳ��ٵ�Ӧ�ò��õ���Ȩ��
	// ���豸����android.permission.BIND_DEVICE_ADMIN������ϵͳ����Ա������receiver��ֻ��ϵͳ����ʹ��
	// �����뷨android.permission.BIND_INPUT_METHOD
	// ������InputMethodService����ֻ��ϵͳ����ʹ��
	// ��RemoteViewandroid.permission.BIND_REMOTEVIEWS������ͨ��RemoteViewsService����������ֻ��ϵͳ������
	// �󶨱�ֽandroid.permission.BIND_WALLPAPER������ͨ��WallpaperService����������ֻ��ϵͳ������
	// ʹ������android.permission.BLUETOOTH���������������Թ��������豸
	// ��������android.permission.BLUETOOTH_ADMIN�����������з��ֺ�����µ������豸
	// ���שͷandroid.permission.BRICK���ܹ������ֻ����ǳ�Σ�գ�����˼��������ֻ����שͷ
	// Ӧ��ɾ��ʱ�㲥android.permission.BROADCAST_PACKAGE_REMOVED����һ��Ӧ����ɾ��ʱ����һ���㲥
	// �յ�����ʱ�㲥android.permission.BROADCAST_SMS�����յ�����ʱ����һ���㲥
	// �����㲥android.permission.BROADCAST_STICKY������һ�������յ��㲥������յ���һ���㲥
	// WAP PUSH�㲥android.permission.BROADCAST_WAP_PUSH��WAP PUSH�����յ��󴥷�һ���㲥
	// ����绰android.permission.CALL_PHONE���������ӷ�ϵͳ������������绰����
	// ͨ��Ȩ��android.permission.CALL_PRIVILEGED��������򲦴�绰���滻ϵͳ�Ĳ���������
	// ����Ȩ��android.permission.CAMERA�������������ͷ��������
	// �ı����״̬android.permission.CHANGE_COMPONENT_ENABLED_STATE���ı�����Ƿ�����״̬
	// �ı�����android.permission.CHANGE_CONFIGURATION������ǰӦ�øı����ã��綨λ
	// �ı�����״̬android.permission.CHANGE_NETWORK_STATE���ı�����״̬���Ƿ�������
	// �ı�WiFi�ಥ״̬android.permission.CHANGE_WIFI_MULTICAST_STATE���ı�WiFi�ಥ״̬
	// �ı�WiFi״̬android.permission.CHANGE_WIFI_STATE���ı�WiFi״̬
	// ���Ӧ�û���android.permission.CLEAR_APP_CACHE�����Ӧ�û���
	// ����û�����android.permission.CLEAR_APP_USER_DATA�����Ӧ�õ��û�����
	// �ײ����Ȩ��android.permission.CWJ_GROUP������CWJ�˻�����ʵײ���Ϣ
	// �ֻ��Ż���ʦ��չȨ��android.permission.CELL_PHONE_MASTER_EX���ֻ��Ż���ʦ��չȨ��
	// ���ƶ�λ����android.permission.CONTROL_LOCATION_UPDATES���������ƶ����綨λ��Ϣ�ı�
	// ɾ�������ļ�android.permission.DELETE_CACHE_FILES������Ӧ��ɾ�������ļ�
	// ɾ��Ӧ��android.permission.DELETE_PACKAGES���������ɾ��Ӧ��
	// ��Դ����android.permission.DEVICE_POWER��������ʵײ��Դ����
	// Ӧ�����android.permission.DIAGNOSTIC���������RW�������Դ
	// ���ü�����android.permission.DISABLE_KEYGUARD�����������ü�����
	// ת��ϵͳ��Ϣandroid.permission.DUMP����������ȡϵͳdump��Ϣ��ϵͳ����
	// ״̬������android.permission.EXPAND_STATUS_BAR�����������չ������״̬��
	// ��������ģʽandroid.permission.FACTORY_TEST������������й�������ģʽ
	// ʹ�������android.permission.FLASHLIGHT��������������
	// ǿ�ƺ���android.permission.FORCE_BACK���������ǿ��ʹ��back���˰���������Activity�Ƿ��ڶ���
	// �����˻�Gmail�б�android.permission.GET_ACCOUNTS������GMail�˻��б�
	// ��ȡӦ�ô�Сandroid.permission.GET_PACKAGE_SIZE����ȡӦ�õ��ļ���С
	// ��ȡ������Ϣandroid.permission.GET_TASKS����������ȡ��ǰ��������е�Ӧ��
	// ����ȫ������android.permission.GLOBAL_SEARCH���������ʹ��ȫ����������
	// Ӳ������android.permission.HARDWARE_TEST������Ӳ�������豸������Ӳ������
	// ע���¼�android.permission.INJECT_EVENTS��������ʱ�����ĵײ��¼�����ȡ�������켣����¼���
	// ��װ��λ�ṩandroid.permission.INSTALL_LOCATION_PROVIDER����װ��λ�ṩ
	// ��װӦ�ó���android.permission.INSTALL_PACKAGES���������װӦ��
	// �ڲ�ϵͳ����android.permission.INTERNAL_SYSTEM_WINDOW�����������ڲ����ڣ����Ե�����Ӧ�ó��򿪷Ŵ�Ȩ��
	// ��������android.permission.INTERNET�������������ӣ����ܲ���GPRS����
	// ������̨����android.permission.KILL_BACKGROUND_PROCESSES������������killBackgroundProcesses(String).����������̨����
	// �����˻�android.permission.MANAGE_ACCOUNTS������������AccountManager�е��˻��б�
	// �����������android.permission.MANAGE_APP_TOKENS�����������ݻ١�Z��˳�򣬽�����ϵͳ
	// �߼�Ȩ��android.permission.MTWEAK_USER������mTweak�û����ʸ߼�ϵͳȨ��
	// ����Ȩ��android.permission.MTWEAK_FORUM������ʹ��mTweak����Ȩ��
	// ���ʽ��android.permission.MASTER_CLEAR���������ִ�����ʽ����ɾ��ϵͳ������Ϣ
	// �޸���������android.permission.MODIFY_AUDIO_SETTINGS���޸�����������Ϣ
	// �޸ĵ绰״̬android.permission.MODIFY_PHONE_STATE���޸ĵ绰״̬�������ģʽ�����������滻ϵͳ����������
	// ��ʽ���ļ�ϵͳandroid.permission.MOUNT_FORMAT_FILESYSTEMS����ʽ�����ƶ��ļ�ϵͳ�������ʽ�����SD��
	// �����ļ�ϵͳandroid.permission.MOUNT_UNMOUNT_FILESYSTEMS�����ء��������ⲿ�ļ�ϵͳ
	// ����NFCͨѶandroid.permission.NFC���������ִ��NFC������ͨѶ�����������ƶ�֧��
	// ����Activityandroid.permission.PERSISTENT_ACTIVITY������һ�����õ�Activity���ù��ܱ��Ϊ���������Ƴ�
	// �������绰android.permission.PROCESS_OUTGOING_CALLS�����������ӣ��޸Ļ���������绰
	// ��ȡ�ճ�����android.permission.READ_CALENDAR����������ȡ�û����ճ���Ϣ
	// ��ȡ��ϵ��android.permission.READ_CONTACTS������Ӧ�÷�����ϵ��ͨѶ¼��Ϣ
	// ��Ļ��ͼandroid.permission.READ_FRAME_BUFFER����ȡ֡����������Ļ��ͼ
	// ��ȡ�ղؼк���ʷ��¼com.android.browser.permission.READ_HISTORY_BOOKMARKS����ȡ������ղؼк���ʷ��¼
	// ��ȡ����״̬android.permission.READ_INPUT_STATE����ȡ��ǰ��������״̬��������ϵͳ
	// ��ȡϵͳ��־android.permission.READ_LOGS����ȡϵͳ�ײ���־
	// ��ȡ�绰״̬android.permission.READ_PHONE_STATE�����ʵ绰״̬
	// ��ȡ��������android.permission.READ_SMS����ȡ��������
	// ��ȡͬ������android.permission.READ_SYNC_SETTINGS����ȡͬ�����ã���ȡGoogle����ͬ������
	// ��ȡͬ��״̬android.permission.READ_SYNC_STATS����ȡͬ��״̬�����Google����ͬ��״̬
	// �����豸android.permission.REBOOT������������������豸
	// �����Զ�����android.permission.RECEIVE_BOOT_COMPLETED��������򿪻��Զ�����
	// ���ղ���android.permission.RECEIVE_MMS�����ղ���
	// ���ն���android.permission.RECEIVE_SMS�����ն���
	// ����Wap Pushandroid.permission.RECEIVE_WAP_PUSH������WAP PUSH��Ϣ
	// ¼��android.permission.RECORD_AUDIO��¼������ͨ���ֻ�����������
	// ����ϵͳ����android.permission.REORDER_TASKS����������ϵͳZ�������е�����
	// ����ϵͳ����android.permission.RESTART_PACKAGES����������ͨ��restartPackage(String)�������÷�ʽ������������
	// ���Ͷ���android.permission.SEND_SMS�����Ͷ���
	// ����Activity�۲���android.permission.SET_ACTIVITY_WATCHER������Activity�۲���һ������monkey����
	// ������������com.android.alarm.permission.SET_ALARM��������������
	// ���������˳�android.permission.SET_ALWAYS_FINISH�����ó����ں�̨�Ƿ������˳�
	// ���ö�������android.permission.SET_ANIMATION_SCALE������ȫ�ֶ�������
	// ���õ��Գ���android.permission.SET_DEBUG_APP�����õ��Գ���һ�����ڿ���
	// ������Ļ����android.permission.SET_ORIENTATION��������Ļ����Ϊ�������׼��ʽ��ʾ����������ͨӦ��
	// ����Ӧ�ò���android.permission.SET_PREFERRED_APPLICATIONS������Ӧ�õĲ������Ѳ��ٹ�������鿴addPackageToPreferred(String)
	// ����
	// ���ý�������android.permission.SET_PROCESS_LIMIT����������������Ľ�������������
	// ����ϵͳʱ��android.permission.SET_TIME������ϵͳʱ��
	// ����ϵͳʱ��android.permission.SET_TIME_ZONE������ϵͳʱ��
	// ���������ֽandroid.permission.SET_WALLPAPER�����������ֽ
	// ���ñ�ֽ����android.permission.SET_WALLPAPER_HINTS�����ñ�ֽ����
	// �������ý����ź�android.permission.SIGNAL_PERSISTENT_PROCESSES������һ�����õĽ����ź�
	// ״̬������android.permission.STATUS_BAR���������򿪡��رա�����״̬��
	// ���ʶ�������android.permission.SUBSCRIBED_FEEDS_READ�����ʶ�����Ϣ�����ݿ�
	// д�붩������android.permission.SUBSCRIBED_FEEDS_WRITE��д����޸Ķ������ݵ����ݿ�
	// ��ʾϵͳ����android.permission.SYSTEM_ALERT_WINDOW����ʾϵͳ����
	// �����豸״̬android.permission.UPDATE_DEVICE_STATS�������豸״̬
	// ʹ��֤��android.permission.USE_CREDENTIALS���������������֤��AccountManager
	// ʹ��SIP��Ƶandroid.permission.USE_SIP���������ʹ��SIP��Ƶ����
	// ʹ����android.permission.VIBRATE��������
	// ��������android.permission.WAKE_LOCK������������ֻ���Ļ�رպ��̨������Ȼ����
	// д��GPRS���������android.permission.WRITE_APN_SETTINGS��д������GPRS���������
	// д���ճ�����android.permission.WRITE_CALENDAR��д���ճ̣������ɶ�ȡ
	// д����ϵ��android.permission.WRITE_CONTACTS��д����ϵ�ˣ������ɶ�ȡ
	// д���ⲿ�洢android.permission.WRITE_EXTERNAL_STORAGE���������д���ⲿ�洢����SD����д�ļ�
	// д��Google��ͼ����android.permission.WRITE_GSERVICES���������д��Google Map��������
	// д���ղؼк���ʷ��¼com.android.browser.permission.WRITE_HISTORY_BOOKMARKS��д���������ʷ��¼���ղؼУ������ɶ�ȡ
	// ��дϵͳ��������android.permission.WRITE_SECURE_SETTINGS����������дϵͳ��ȫ���е�������
	// ��дϵͳ����android.permission.WRITE_SETTINGS�������дϵͳ������
	// ��д����android.permission.WRITE_SMS�������д����
	// д������ͬ������ android.permission.WRITE_SYNC_SETTINGS��д��Google����ͬ������

	// �������ݿ�
	// Context.createDatabase(Stringname,intversion,int
	// mode,CursorFactoryfactory)����һ���µ����ݿⲢ
	// ����һ��SQLiteDatabase����
	// �������ݿⲻ�ܱ����������׳�FileNotFoundException�쳣
	// �´���SQLite���ݿⷽ��
	// SQLiteDatabase mydataBase=SQLiteDatabase.create(new CursorFactory(){
	// //����һ�����ݿ�
	// //�����࣬һ����ѡ�����࣬����ѯʱ������ʵ����һ�����
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
	// //�����µ����ݿ⣬����myDatabase��ģʽMODE_PRIVATE����깤��
	// //�����࣬һ����ѡ�����࣬����ѯʱ������ʵ����һ�����
	// @Override
	// public Cursor newCursor(SQLiteDatabase db,
	// SQLiteCursorDriver masterQuery, String editTable,
	// SQLiteQuery query) {
	// // TODO Auto-generated method stub
	// return null;
	// }
	// });
	//
	// ɾ�����ݿ�
	// Context.deleteDatabase(Stringname)ɾ��ָ�����Ƶ����ݿ�
	// �������ݿ�ɹ�ɾ���򷵻�true��ʧ����Ϊfalse(�������ݿⲻ����)
	// //ɾ��ָ�����Ƶ����ݿ�
	// this.deleteDatabase("myDatabase.db");
	//
	// �����ݿ�
	// Context.openDatabase(Stringfile,CursorFactory factory)��һ�����ڵ����ݿⲢ����һ��
	// SQLiteDatabase����
	// ������ݿⲻ�������׳�FileNotFoundException�쳣
	// //����һ����Ϊ��myDataBase�����ݿ⣬��׺Ϊ.db
	// SQLiteDatabase
	// my_DataBase=this.openOrCreateDatabase("myDateBase.db",MODE_PRIVATE,
	// null);
	// my_DataBase.close();//��Ҫ���ǹر����ݿ�
	//
	//
	// �ǲ�ѯSQLָ��
	// SQLiteDatabase.execSQL(Stringsql)��������ִ�зǲ�ѯSQLָ���Щָ��û�н��
	// ������CREATETABLE/DROPTABLE/INSERT �ȵ�
	// ���磺
	// //����һ����Ϊ"test"�������������ı�
	// my_DataBase.execSQL("CREATE TABLE test (_id INTEGER PRIMARY KEY,someNumber INTERGER);");"
	// //�����ݿ��в���һ��Ԫ��
	// my_DataBase.execSQL("INSERT INTO test (_id,someNumber) values(1,8);");
	// //ɾ����
	// my_DataBase.execSQL("DROP TABLE test");
	//
	//
	// //Ϊ�˴���һ��Cursor(�α�)������ִ��һ����ѯ��Ҫôͨ��SQLʹ��rawQuery()����
	// //���Ǹ�������Ƶķ�������query()����
	// Cursor cur=my_DataBase.rawQuery("SELECT * FORM test", null);
	// if(cur!=null){//�α겻Ϊ��
	// //���ظ������Ƶ��еĻ���0��ʼ��index������������в������򷵻�-1
	// //ͨ�����ǵ�index����������ֵ
	// int numColumn=cur.getColumnIndex("someNumber");
	// if(cur.moveToFirst()){
	// //cur.moveToFirst()���α�ָ���һ�У�����α�ָ���һ�У��򷵻�true
	// do {
	// int num=cur.getInt(numColumn);//��õ�ǰ�и����Ե�ֵ
	// /*Cursor�ṩ�˲�ͬ�ķ�����������ͬ����������
	// ����getInt(int index)/getString(int index)�ȵ�*/
	// /*��һЩ����*/
	// }while (cur.moveToNext());
	// /*�α��ƶ�����һ�У�����α��Ѿ�ͨ���˽�����е����
	// ��û���п����ƶ�ʱ���򷵻�false*/
	// //���������ƶ�����previous()��first()����
	// }
	// }

	/** Called when the activity is first created. */
	// �Դ��뼶��������ϸ˵�����������ڳ�������ʱ�������ݿ��Լ����ݱ�Ȼ��ͨ���������̵���������̧���¼������������ݵ���ɾ��õȹ��ܣ���Ҫ��Ϊ�˼�˵��SqlLite���ݿ�ļ�ʹ�ã�ʵ�ʿ����в������ʹ�ã��´��ٽ���SQLiteOpenHelper����ʵ��Ӧ�ÿ�����Ӧ�á�
	// openOrCreateDatabase(DATABASE_NAME,MODE_PRIVATE, null);��������
	// �������ݿ�,�������������ݿ�ֱ�Ӵ򿪣������ڣ��򴴽���
	// �÷�����������������DATABASE_NAME:���ݿ����ƣ�MODE_PRIVATE�����ݿ�Ĵ���ģʽ��Cursor��Cursor����
	// ���ݿⴴ���ɹ��󣬵õ���SQLiteDatabase���󣬸ö�����Ϊ��Ӧ�õĺ��Ķ��󣬽������ݵ���ɾ��Ķ��Ըö���Ϊ���Ľ��в�����
	// ������ sqlLiteDatabase.execSQL("CREATE TABLE langsinTable("
	// + " _id Integer PRIMARY KEY," + " tel Integer," + " uname TEXT"
	// + ")");
	// ʹ��SQLiteDatabase�����execSQL�����������������SQL��䴫����Ϊ�������󣬾Ϳ��Դ������ݱ���ע��ʹ��SqlLite�����ݿ������ֶ����ͣ���
	// �������ݣ�sqlLiteDatabase.insert("langsinTable", null, cv);
	// long insert(String table, String nullColumnHack, ContentValues values)
	// Convenience method for inserting a row into the database.
	// String table:���ݿ�����ƣ�values����������ݶ��� �磺ContentValues cv = new
	// ContentValues();
	// cv.put("tel", ++telNum);
	// cv.put("uname", "����" + (++nameIndex));
	// ������ContentValues ����cv �á�tel���ֶε�ֵ++telNum��"uname"�ֶε�ֵΪ"����" +
	// (++nameIndex);��������ݿ��
	// ɾ�����ݾݱ����ݣ�sqlLiteDatabase.execSQL("DELETE FROM langsinTable WHERE _id=" +
	// lastId);ʹ��ִ��SQL�����ɾ����
	//
	// ���±����ݣ�sqlLiteDatabase.update("langsinTable", cv, "uname like '����%'",
	// null);
	// ���±�����ʹ��SQLiteDatabase�����update������
	// int update(String table, ContentValues values, String whereClause,
	// String[] whereArgs)
	// Convenience method for updating rows in the database.
	// String table:�������ݵı� ContentValues values����������ݣ�String whereClause����ѯ����
	//
	// ��ѯ���ݿ������ʹ�� sqlLiteDatabase.query("langsinTable", new String[] {
	// "_id","tel", "uname" }, null, null, null, null, null);
	// Cursor query(String table, String[] columns, String selection, String[]
	// selectionArgs, String groupBy, String having, String orderBy, String
	// limit)
	// Query the given table, returning a Cursor over the result set.
	//
	// ���ʹ��ListView��Ϊ��ͼ����ʾ�ؼ�
	// ListAdapter adapter = new SimpleCursorAdapter(this,
	// // ListView ��ʾģ��
	// android.R.layout.simple_list_item_2, cur,
	// // ȡ����
	// new String[] { "tel", "uname" },
	// //
	// ? new int[] { android.R.id.text1, android.R.id.text2 }
	// );
	// if (listView == null) {
	// listView = (ListView) this.findViewById(R.id.listView);
	// }
	// listView.setAdapter(adapter);
	// ListView
	// ��ʾģ�������Android���õ�ģ����ʾandroid.R.layout.simple_list_item_2,��ģ����ʾ����TextView��

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

		// �������ݿ�,�������������ݿ�ֱ�Ӵ򿪣������ڣ��򴴽�

		// ���ݿ����ƣ�ģʽ�� Cursor����
		sqlLiteDatabase = this.openOrCreateDatabase(DATABASE_NAME,
				MODE_PRIVATE, null);
		listView = (ListView) this.findViewById(R.id.listView);
		// �������ݱ�
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
		cv.put("uname", "����" + (++nameIndex));
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
		cv.put("uname", "���º������" + (++nameIndex));
		sqlLiteDatabase.update("langsinTable", cv, "uname like '����%'", null);
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
			// // ListView ��ʾģ��
			// android.R.layout.simple_list_item_2, cur,
			// // ȡ����
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

	// һ.�������ݿ�
	// sqlite3.exe test.db
	//
	// ��.˫��sqlite-3_6_16Ŀ¼�µĳ���sqlite3.exe����������
	// ��.�˳�
	// .exit
	// ����
	// .quit
	// ��.SQLite֧������5����������
	// 1.NULL����ֵ��
	// 2.INTEGER�������ŵ����ͣ�����ȡ���д������ֵķ�Χ��С��
	// 3.REAL���������֣��洢Ϊ8-byte IEEE��������
	// 4.TEXT���ַ����ı���
	// 5.BLOB�������ƶ���
	//
	// ��.��ϵ�˱��ṹ����
	// create table contact(id integer primary key autoincrement,
	// lastname varchar(20),firstname varchar(20),
	// mobile varchar(30), telephone varchar(20),
	// email varchar(30), company varchar(50),
	// department varchar(16),address varchar(80),
	// id1 interger,id2 integer, updatetime datetime);
	//
	// ��.�鿴���ݿ�����Щ���ݱ�
	// �����ǣ�.tables
	// ��.��β���һ����¼
	// insert into contact(lastname,firstname,mobile,telephone,updatetime)
	// values(������,'����,��13910128132��,��010-81749136��,��2009-07-22��);
	// ��.�鿴���ݱ�Ľṹ
	//
	// ����������ݿ�
	// .schema
	// ��Խ�����contact��ϵ�˸ñ�
	// .schema contact ע��û�зֺ�
	//
	// ��.��δ�һ���Ѿ����������ݿ�
	//
	// sqlite3 test.db
	// ʮ.��ν����������
	// SQL error: near ��sqlite3��: syntax error
	//
	// SQLָ����Էֺţ�;����β�ġ���������������ţ��C�������ע�⣬sqlite3���Թ�ȥ
	//
	// ʮһ.��ν�������
	// create index index_name on table_name(field_to_be_indexed);
	// ʮ��.���ɾ��һ�����ݱ�
	// drop table contact;
	//
	// ʮ��.�鿴��ǰ�����ݿ�
	// .database
	//
	// ʮ��.���ɾ��һ�����ݱ������
	// delete from contact;
	// ʮ��.��ε���һ���ļ���ĳ������
	// .import �ļ�·�� ����
	// ע�����Ƿ�SQL��䣬���Բ��ӷֺ�
	// ʮ��.��������ļ��ֶεķָ���
	// .separator ��,��
	// .import e:/contact.txt contact
	// ʮ��.��β鿴��ǰsqllite�ֶεķָ�����ʲô��
	// .show
	//
	// ʮ��.��ν���ѯ���������һ���ļ�
	//
	// ��һ����.output a.txt
	// �ڶ�����ִ��Ҫ������SQL���
	// ��������.output stdout
	// ʮ��.SQL��ѯ���
	// select * from film order by year limit 10;
	// select * from film order by year desc limit 10;
	// select count(*) from film;
	// select * from film where starring like ��Jodie%��;
	//
	// select * from film where starring=��Jodie Foster��;
	// select title, year from film order by year desc limit 10;
	// select columns from table_name where expression;
	//
	// ������÷�����Ȼ�ǵ����������ݿ�����ݣ�
	//
	// select * from film;
	//
	// �������̫���ˣ����ǻ���������Ʊ�����
	//
	// select * from film limit 10;
	//
	// �������ŵ�Ӱ��������У�
	//
	// select * from film order by year limit 10;
	//
	// ������ݱȽϽ��ĵ�Ӱ���г�����
	//
	// select * from film order by year desc limit 10;
	//
	// ��������ֻ�뿴��Ӱ���Ƹ���ݣ�
	//
	// select title, year from film order by year desc limit 10;
	//
	// ��������ٷ�˹���ݹ��ĵ�Ӱ��
	//
	// select * from film where starring=��Jodie Foster��;
	//
	// ��������Ա���ֿ�ͷ����ٵĵ�Ӱ(��%�� ���ű��� SQL �������ַ�����
	//
	// select * from film where starring like ��Jodie%��;
	//
	// ��������Ա��������ٿ�ͷ���������1985�ꡢ�����������г������ʮ�ʣ�ֻ�г���Ӱ���ƺ���ݣ�
	//
	// select title, year from film where starring like ��Jodie%�� and year >=
	// 1985 order by year desc limit 10;
	//
	// ��ʱ������ֻ��֪�����ݿ�һ���ж��ٱ����ϣ�
	//
	// select count(*) from film;
	//
	// ��ʱ������ֻ��֪��1985���Ժ�ĵ�Ӱ�м�����
	//
	// select count(*) from film where year >= 1985;
	//
	// ����һ���ĸ�����ϣ�Ҫȥ��SQLר�飬���������Ѿ�֪��SQLΪʲô��ô�����ˣ��������������㽫���ֲ�ѯ���������һ�𩤩������ǻ�û�ᵽ�������ݿ�����ϲ�ѯ���أ���
	//
	// ��θ��Ļ�ɾ������
	// �˽�select���÷��ǳ���Ҫ����ΪҪ��sqlite���Ļ�ɾ��һ�����ϣ�Ҳ�ǿ�ͬ�����﷨��
	//
	// ������һ�����ϵ����ִ���ˣ�
	// update film set starring=��Jodie Foster�� where starring=��Jodee Foster��;
	// �ͻ�������ֶ������ɡ�Jodee Foster�����Ǳʣ����ʣ����ϣ��Ļس�Jodie Foster��
	// delete from film where year < 1970;
	// �ͻ�ɾ�������������1970�꣨�������ĵ�Ӱ�ˡ�
	// ����sqlite���ر��÷�
	// sqlite������shell����ֱ��ִ�����
	// sqlite3 film.db ��select * from film;��
	// ��� HTML ���
	// sqlite3 -html film.db ��select * from film;��
	// �����ݿ⡸����������
	// sqlite3 film.db ��.dump�� > output.sql
	// ������������ϣ�����һ��һģһ�������ݿ⣨��������ָ����Ǳ�׼��SQL���ݿⱸ���ˣ���
	// sqlite3 film.db < output.sql
	// �ڴ�����������ʱ������ܻ���Ҫ�ȴ����ָ�
	//
	// begin;
	// ���������Ϻ�Ҫ�ǵô����ָ����ϲŻ�д�����ݿ��У�
	// commit;
	//
	// �������ݿ��ļ�:
	// >SQLite3 d:\test.db �س�
	// ��������һ��test.db��d�̡�
	// ����ͬʱҲSQLite3���������test.db
	// 2)
	// ��.help���Կ�����ʲô����
	// >.help �س�����
	// 3)����������ֱ������SQL��䴴����� ��;���� ��Ȼ��س��Ϳ��Կ�����
	// 4)�����д����˶��ٱ�
	// >.tables
	// 5)����ṹ
	// >.schema ����
	// 6)����Ŀǰ�����ݿ�
	// >.database
	// 7)���Ҫ�Ѳ�ѯ������ļ�
	// >.output �ļ���
	// > ��ѯ��䣻
	// ��ѯ�������������ļ�c:\query.txt
	// �Ѳ�ѯ�������Ļ���
	// >.output stdout
	// 8)�ѱ�ṹ�����ͬʱ����Ҳ�����
	// .dump ����
	// 9)�˳�
	// >.exit ����.quit
	// 2����http://sqlite.phxsoftware.com/ ����Ado.net������
	// �����˰�װ���ڰ�װĿ¼�д���System.Data.SQLite.dll
	// ����ֻ��Ҫ��������ļ�������Ŀ¼����������ü��ɶ�SQLite���ݿ������
	// ���е�Ado.net��������SQLite��ͷ�ģ�����SQLiteConnection
	// ���Ӵ�ֻ��Ҫ���·�ʽ
	// Data Source=d:\test.db ����DataSource=test.db�CӦ���ں�Ӧ�ó������.net�ܹ��Զ��ҵ���Ŀ¼
	// ʣ�µľͺܼ���~~
	// 3��SQL�﷨
	// ������ǰ��SQLServer����ISeries������DDL���﷨�ܺ���
	// 1)����һ������Primary Key��table
	// CREATE TABLE [Admin] (
	// [UserName] [nvarchar] (20) PRIMARY KEY NOT NULL ,
	// [Password] [nvarchar] (50) NOT NULL ,
	// [Rank] [smallint] NOT NULL ,
	// [MailServer] [nvarchar] (50) NOT NULL ,
	// [MailUser] [nvarchar] (50) NOT NULL ,
	// [MailPassword] [nvarchar] (50) NOT NULL ,
	// [Mail] [nvarchar] (50) NOT NULL
	// ) ;
	// 2)����һ�����Primary Key��table
	// CREATE TABLE [CodeDetail] (
	// [CdType] [nvarchar] (10) NOT NULL ,
	// [CdCode] [nvarchar] (20) NOT NULL ,
	// [CdString1] [ntext] NOT NULL ,
	// [CdString2] [ntext] NOT NULL ,
	// [CdString3] [ntext] NOT NULL,
	// PRIMARY KEY (CdType,CdCode)
	//
	// ) ;
	// 3)��������
	// CREATE INDEX [IX_Account] ON [Account]([IsCheck], [UserName]);
	//
	// ��������ͼ�ȵȡ�
	// 4.���к����õ�SQL
	// Select * from Sqlite_master
	// Select datetime(��now��)
	// Select date(��now��)
	// Select time(��now��)
	//
	// SQLite �ڽ�������
	// ��������
	// abs(X)
	// ���ظ������ֱ��ʽ�ľ���ֵ��
	// max(X,Y[,...])
	// ���ر��ʽ�����ֵ��
	// min(X,Y[,...])
	// ���ر��ʽ����Сֵ��
	// random(*)
	// �����������
	// round(X[,Y])
	// �������ֱ��ʽ����������Ϊָ���ĳ��Ȼ򾫶ȡ�
	// �ַ�������
	// length(X)
	// ���ظ����ַ������ʽ���ַ�������
	// lower(X)
	// ����д�ַ�����ת��ΪСд�ַ����ݺ󷵻��ַ����ʽ��
	// upper(X)
	// ���ؽ�Сд�ַ�����ת��Ϊ��д���ַ����ʽ��
	// substr(X,Y,Z)
	// ���ر��ʽ��һ���֡�
	// randstr()
	//
	// quote(A)
	//
	// like(A,B)
	// ȷ���������ַ����Ƿ���ָ����ģʽƥ�䡣
	// glob(A,B)
	//
	// �����жϺ���
	// coalesce(X,Y[,...])
	//
	// ifnull(X,Y)
	//
	// nullif(X,Y)
	//
	// ���Ϻ���
	// avg(X)
	// ��������ֵ��ƽ��ֵ��
	// count(X)
	// ����������Ŀ��������
	// max(X)
	// ��������ֵ�����ֵ��
	// min(X)
	// ��������ֵ����Сֵ��
	// sum(X)
	// ���ر��ʽ������ֵ�ĺ͡�
	// ��������
	// typeof(X)
	// �������ݵ����͡�
	// last_insert_rowid()
	// ��������������ݵ� ID ��
	// sqlite_version(*)
	// ���� SQLite �İ汾��
	// change_count()
	// ��������һ���Ӱ���������
	// last_statement_change_count()
	//
	// oh,���о��ǿ�������˵��������������ʱ���������񣬱Ȳ����������n��
	// ���о��Ǿ���ʹ�ò�������SQL,���ƺ�����DBһ���ܹ��Զ�Prepare.
	// ===========
	// sqlite������shell/dos command����ֱ��ִ�����
	// sqlite3 film.db ��select * from film;��
	// ��� HTML ���
	// sqlite3 -html film.db ��select * from film;��
	// �����ݿ⡸����������
	// sqlite3 film.db ��.dump�� > output.sql
	// ������������ϣ�����һ��һģһ�������ݿ⣨��������ָ����Ǳ�׼��SQL���ݿⱸ���ˣ���
	// sqlite3 film.db < output.sql
	// �ڴ�����������ʱ������ܻ���Ҫ�ȴ����ָ�
	// begin;
	// ���������Ϻ�Ҫ�ǵô����ָ����ϲŻ�д�����ݿ��У�
	// commit;
	// SQLITE���롪����������
	// ��ν����Զ������ֶ�?
	// ��̻ش�����Ϊ INTEGER PRIMARY KEY ���н����Զ����� ��
	// ��һ��Ĵ𰸣� ������������һ��Ϊ INTEGER PRIMARY KEY����ô�� ÿ�����ڸ����ϲ���һNULLֵʱ��
	// NULL�Զ���ת��Ϊһ���ȸ��������ֵ��1��һ��������������ǿյģ� ������1�� (����������ܵ�����
	// 9223372036854775807���Ǹ�������ֵ�������δʹ�õ������� �磬�����б�
	// CREATE TABLE t1(
	// a INTEGER PRIMARY KEY,
	// b INTEGER
	// );
	// �ڸñ��ϣ��������
	// INSERT INTO t1 VALUES(NULL,123);
	// ���߼��ϵȼ��ڣ�
	// INSERT INTO t1 VALUES((SELECT max(a) from t1)+1,123);
	// ��һ���µ�API���� sqlite3_last_insert_rowid()�� ��������������������ֵ��
	// ע���������ȱ��и����ϵĲ���֮ǰ�����ֵ��1��
	// �ü�ֵ�ڵ�ǰ�ı�����Ψһ�ġ����п������Ѵӱ���ɾ����ֵ�ص���Ҫ�뽨���������������������Ψһ�ļ�ֵ����Ҫ�� INTEGER PRIMARY KEY
	// ������AUTOINCREMENT��������ô���µļ�ֵ����ȸñ������ܴ��ڹ������ֵ��1����������ܵ�����ֵ�����ݱ����������ڹ���INSERT����ʧ�ܣ�
	// ������SQLITE_FULL������롣
	// ���Ӧ�ó����һ��Ӧ�ó���Ķ��ʵ������ͬʱ����ͬһ�����ݿ��ļ���
	// ������̿�ͬʱ��ͬһ�����ݿ⡣������̿���ͬʱ����SELECT ������������һʱ�̣�ֻ����һ�����̶����ݿ���и��ġ�
	// SQLiteʹ�ö���д�����ƶ����ݿ�ķ��ʡ�����Win95/98/ME�Ȳ�֧�ֶ���д����ϵͳ�£�ʹ��һ�������Ե�ģ�������档����ʹ��ʱҪע�⣺
	// ������ݿ��ļ������һ��NFS�ļ�ϵͳ�ϣ����������ƿ��ܲ������������� ������Ϊ fcntl() �ļ����ںܶ�NFS��û����ȷ��ʵ�֡�
	// �ڿ����ж������ͬʱ�������ݿ��ʱ��Ӧ�ñ��⽫���ݿ��ļ��ŵ�NFS�ϡ���Windows�ϣ�Microsoft���ĵ���˵�����ʹ�� FAT
	// �ļ�ϵͳ��û������ share.exe
	// �ػ����̣���ô�������ǲ�������ʹ�õġ���Щ��Windows���кܶྭ����˸����ң����������ļ����ļ�����ʵ���кö�Bug���ǿ���ס�ġ��������˵���ǶԵģ���ô����̨���̨Windows�����乲�����ݿ���ܻ��������������⡣
	// ������ʶ����û������Ƕ��ʽ�� SQL ���ݿ��������� SQLite
	// ����������˶�Ĳ�����SQLite����������ͬʱ��һ�����ݿ⣬ͬʱ��һ�����ݿ⡣�����κν�����Ҫдʱ���������ڸ��¹�������ס���ݿ��ļ�������ͨ��ֻ�Ǽ������ʱ�䡣��������ֻ��ȴ�д���̸������������͵أ�����Ƕ��ʽ��SQL���ݿ�����ͬʱֻ����һ���������ӵ����ݿ⡣
	// ���ǣ�Client/Server���ݿ����棨�� PostgreSQL, MySQL, ��
	// Oracle��ͨ��֧�ָ��߼���Ĳ�������������������ͬʱдͬһ�����ݿ⡣���ֻ�����Client/Server�ṹ�����ݿ����ǿ��ܵģ���Ϊ������һ����һ�ķ��������̺ܺõؿ��ơ�Э�������ݿ�ķ��ʡ�������Ӧ�ó�����Ҫ�ܶ�Ĳ�������ô��Ӧ�ÿ���ʹ��һ��Client/Server
	// �ṹ�����ݿ⡣������������ܶ�Ӧ�ó�����Ҫ�Ĳ��������������������������ٵöࡣ
	// ��SQLite��ͼ����һ��������������ס���ļ�ʱ��ȱʡ����Ϊ�Ƿ��� SQLITE_BUSY�� ������C������ʹ��
	// sqlite3_busy_handler() �� sqlite3_busy_timeout() API ����������һ��Ϊ��
	// ��SQLite���ݿ�������г����еı��������
	// ��������� sqlite3 ������������������ݿ⣬���Լ��� ��.tables����������б���б����ߣ���������� ��.schema��
	// �����������ݿ�ģʽ���������еı��������������Щ��������һ��LIKEģʽƥ�����������ʾ�ı�
	// ��һ�� C/C++ �����У����߽ű�����ʹ�� Tcl/Ruby/Perl/Python �ȣ� �������һ����������� SQLITE_MASTER
	// ��ִ��һ��SELECT��ѯ�Ի������ ���������ÿһ�� SQLite ���ݿⶼ��һ���� SQLITE_MASTER �ı� ���������ݿ��ģʽ��
	// SQLITE_MASTER ���������£�
	// CREATE TABLE sqlite_master (
	// type TEXT,
	// name TEXT,
	// tbl_name TEXT,
	// rootpage INTEGER,
	// sql TEXT
	// );
	// ���ڱ���˵��type �ֶ���Զ�� ��table����name �ֶ���Զ�Ǳ�����֡����ԣ�Ҫ������ݿ������б���б�ʹ������SELECT��䣺
	// SELECT name from sqlite_master
	// WHERE type=��table��
	// ORDER BY name;
	// ����������type ���� ��index��, name �������������֣�tbl_name �Ǹ����������ı�����֡������Ǳ���������sql
	// �ֶ���ԭ���� CREATE TABLE �� CREATE INDEX ��䴴������ʱ�������ı��������Զ�����������������ʵ�� PRIMARY
	// KEY �� UNIQUE Լ������sql�ֶ�ΪNULL��
	// SQLITE_MASTER ����ֻ���ġ����ܶ���ʹ�� UPDATE��INSERT �� DELETE�� ���ᱻ CREATE
	// TABLE��CREATE INDEX��DROP TABLE �� DROP INDEX �����Զ����¡�
	// ��ʱ��������� SQLITE_MASTER ���С���ʱ���������ʹ��������������һ���� SQLITE_TEMP_MASTER
	// �ı��С�SQLITE_TEMP_MASTER �� SQLITE_MASTER
	// ��࣬����ֻ�Ƕ��ڴ�����Щ��ʱ���Ӧ�ÿɼ������Ҫ������б���б� ���������õĻ�����ʱ�ģ�����ʹ��������������
	// SELECT name from
	// (SELECT * from sqlite_master UNION ALL
	// SELECT * from sqlite_temp_master)
	// WHERE type=��table��
	// ORDER BY name
	// ��SQLite�У�VARCHAR�ֶ���Ƕ��٣�
	// SQLite ��ǿ�� VARCHAR �ĳ��ȡ� ������� SQLITE ������һ��
	// VARCHAR(10)��SQLite���ǿ��Ժܸ��˵����������500���ַ��� ������500���ַ���ԭ�ⲻ���ģ�����Զ���ᱻ�ضϡ�
	// SQLite֧�ֶ����ƴ������
	// SQLite 3.0 ���Ժ�汾���������κ����д洢 BLOB ���ݡ� ��ʹ���б�����Ϊ��������Ҳ���ԡ�
	// ��SQLite�У������һ��������ӻ�ɾ��һ�У�
	// SQLite �����޵� ALTER TABLE ֧�֡������ʹ�������ڱ��ĩβ����һ�У��ɸ��ı�����ơ�
	// �����Ҫ�Ա�ṹ�������ӵĸı䣬��������½����ؽ�ʱ�����Ƚ��Ѵ��ڵ����ݷŵ�һ����ʱ���У�ɾ��ԭ�� �����±�Ȼ�����ݴ���ʱ���и��ƻ�����
	// �磬������һ�� t1 �������� ��a��, ��b��, ��c�� ���У� ���Ҫɾ���� c �����¹������������:
	// BEGIN TRANSACTION;
	// CREATE TEMPORARY TABLE t1_backup(a,b);
	// INSERT INTO t1_backup SELECT a,b from t1;
	// DROP TABLE t1;
	// CREATE TABLE t1(a,b);
	// INSERT INTO t1 SELECT a,b from t1_backup;
	// DROP TABLE t1_backup;
	// COMMIT;
	// �����ݿ���ɾ���˺ܶ����ݣ������ݿ��ļ�û�б�С����Bug��
	// ���ǡ������SQLite���ݿ���ɾ������ʱ�� δ�õĴ��̿ռ佫�����һ���ڲ��ġ������б��С�
	// �����´β�������ʱ���ⲿ�ֿռ�������á����̿ռ䲻�ᶪʧ����Ҳ���᷵��������ϵͳ��
	// ���ɾ���˴������ݣ���������С���ݿ��ļ�ռ�õĿռ䣬ִ�� VACUUM ��� VACUUM
	// �����ͷ������֯���ݿ⡣�⽫��ʹ�����ݿ���һ���յġ����������� ���ݿ��ļ�Ҳ����С����Ҫע����ǣ�VACUUM
	// ��ִ�л���ҪһЩʱ�䣨��SQLite����ʱ����Linux�ϣ���ԼÿM�ֽ���Ҫ�����֣������ң� ִ�й�������Ҫԭ���ݿ��ļ�������������ʱ���̿ռ䡣
	// ���� SQLite 3.1�汾��һ�� auto-vacumm ģʽ������� VACUUM ��� ����ʹ�� auto_vacuum pragma
	// �򿪡�
	// SQLITE_SCHEMA error��ʲô����Ϊʲô����ָô���
	// ��һ��׼���õģ�prepared��SQL��䲻����Ч�����޷�ִ��ʱ�� ������һ�� SQLITE_SCHEMA
	// ���󡣷����ô���ʱ��SQL������ʹ�� sqlite3_prepare() API�����±���. �� SQLite 3 ��, һ��
	// SQLITE_SCHEMA ����ֻ�ᷢ������
	// sqlite3_prepare()/sqlite3_step()/sqlite3_finalize() API ִ�� SQL ʱ�������ᷢ����ʹ��
	// sqlite3_exec()ʱ�� �ڰ汾2�в���������
	// ׼���õ����ʧЧ����ͨ��ԭ���ǣ������׼���ú� ���ݿ��ģʽ�ֱ��޸��ˡ������ԭ��ᷢ���ڣ�
	// ���ݿ����ߣ�DETACHed.
	// ���ݿⱻ VACUUMed
	// һ���û��洢���̶��屻ɾ����ı䡣
	// һ�� collation ���ж��屻ɾ����ı䡣
	// ��֤�������ı䡣
	// ����������£�������������±��벢ִ�и�SQL��䡣 ��Ϊһ����׼���õ������������������̸ı����ݿ�ģʽ��ʧЧ������ʹ��
	// sqlite3_prepare()/sqlite3_step()/sqlite3_finalize() API �Ĵ��붼Ӧ׼������
	// SQLITE_SCHEMA �����������һ�����ӣ�
	// int rc;
	// sqlite3_stmt *pStmt;
	// char zSql[] = ��SELECT ��..��;
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
	// ������ַ�����ʹ�õ�����(��)��
	// SQL ��׼�涨�����ַ����У���������Ҫʹ�������ַ�������һ����ʹ�����������š����ⷽ�� SQL ���������� Pascal ���ԡ� SQLite
	// ��ѭ��׼���磺
	// INSERT INTO xyz VALUES(��5 O��clock��);
	// Sqlite����η��ر��ػ���ǰʱ�䣿
	// ����ClinicOS��ʱ������һ�����⣬�ڱ��没���Ǽ�ʱ��ʱ����ʹ���ˡ�CURRENT_TIMESTAMP���������и����⣬�����ص���UTC
	// Time����������й���ûɶ�ã�һֱϣ������취����תΪlocaltime������պ��пգ�����ȥ���˲�Sqlite��Mail
	// List����ȻҲ����������������⣬�Ҵ�һƪ��Ϊ��translate time comparison
	// statement����http://www.mail-archive.com/sqlite-users@sqlite.org
	// /msg12350.html���п��������Ļظ���
	// ��ʮ.��θ��±�������
	// update contact set lastname=�������߹֡�where id = 1028
	//
	// update contact set lastname=�������߹֡�, mobile=��13912345678�� where id=1028;
	// ��ʮһ.���һ�β���������
	// Insert into SAMPLE(PRJNUM, PRJNAME, EMYNUM, EMYNAME, SALCATEGORY,
	// SALPACKAGE)
	// values(100001, ��TPMS��, 200001, ��Johnson��, ��A��, 2000), (100001, ��TPMS��,
	// 200002,
	// ��Christine��, ��B��, 3000), (100001, ��TPMS��, 200003, ��Kevin��, ��C��, 4000),
	// (100002,
	// ��TCT��, 200001, ��Johnson��, ��A��, 2000), (100002, ��TCT��, 200004, ��Apple��,
	// ��B��,
	// 3000);

}
