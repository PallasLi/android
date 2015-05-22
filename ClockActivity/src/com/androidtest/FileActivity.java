package com.androidtest;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class FileActivity extends Activity implements Button.OnClickListener {
	/** Called when the activity isfirst created. */
	/* Ҫʹ�õĶ��󡢱������� */
	/* ���沿�� */
	private EditText inputArt;/* �༭�������û��ַ��� */
	private Button saveButton;/* ��ť������ */
	private String Text_of_input;/* �ַ������û�������ַ��� */
	private OutputStream os;/* �ļ�������������ļ��� */
	/* ��ȡ���� */
	private TextView showmyText;/* TextView����ʾ��ȡ�ļ����� */
	private Button openTxt, cleanTxt;/* ��ť�����ļ� */
	private String Text_of_output;/* �ַ��������ļ��ж�ȡ�����ַ��� */
	private InputStream is;/* �ļ�����������ȡ�ļ��� */
	private byte[] b;/* �ֽ����飬������ȡ�ļ����� */

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setLayoutShow(R.layout.file1);/* ������������ */
		UIinit("main");/* ��ʼ��UIԪ�ط��� */
		Logic("main");/* ����¼��߼����� */
	}

	/* �������� */
	private void setLayoutShow(int layoutID) {
		// TODO Auto-generated method stub
		setContentView(layoutID);/* ���õ�ǰ�������� */
	}

	private void UIinit(String mainROopen) {

		/* ��ʼ��UI */
		if (mainROopen.equals("main")) {
			inputArt = (EditText) findViewById(R.id.EditText_Txt);
			saveButton = (Button) findViewById(R.id.Button_Save);
			/* ���ļ�������������txtME */
			try {
				is = this.openFileInput("txtME");
				/* ��ʼ���ֽ����� */
				b = new byte[1024];
				/* ���ļ��������ж�ȡ���ݵ��ֽ������У��������ݳ��� */
				int length = is.read(b);
				/* ���ֽ�����ת�����ַ��� */
				Text_of_output = new String(b);
				/* ���ñ��⣬��ʾ�ļ����ݳ��� */
				setTitle("�ļ�������" + length);
				/* ��ʾ�ļ����� */
				inputArt.setText(Text_of_output);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else if (mainROopen.equals("open")) {
			showmyText = (TextView) findViewById(R.id.TextView_showTxt);
			openTxt = (Button) findViewById(R.id.Button_openTxt);
			cleanTxt = (Button) findViewById(R.id.Button_clean);
		}

	}

	private void Logic(String string) {
		// TODO Auto-generated method stub
		/* Ϊ��ť����¼����� */
		if (string.equals("main")) {
			saveButton.setOnClickListener(this);
		} else if (string.equals("open")) {
			openTxt.setOnClickListener(this);
			cleanTxt.setOnClickListener(this);
		}
	}

	@Override
	public void onClick(View v) {
		/* ����ID�жϰ�ť�¼� */
		switch (v.getId()) {
		case R.id.Button_Save: {
			/* ��ʾ */
			NoteDebug("�ļ�����");
			// TODO Auto-generated method stub
			/* ����û�������ַ��� */
			Text_of_input = inputArt.getText().toString();

			try {

				/* ���ļ������������txtME���Բ�����ģʽ�� */
				os = this.openFileOutput("txtME", MODE_PRIVATE);
				/* ���ַ���ת�����ֽ����飬д���ļ��� */
				os.write(Text_of_input.getBytes());
			} catch (FileNotFoundException e) {
				/* �ļ�δ�ҵ����쳣 */
				// TODO Auto-generated catch block
				NoteDebug("�ļ��ر�ʧ��" + e);
			} catch (IOException e) {
				/* �ļ�д����� */
				// TODO Auto-generated catch block
				NoteDebug("�ļ�д��ʧ��" + e);
			} finally {
				try {
					/* �ر��ļ������ */
					os.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					NoteDebug("�ļ��ر�ʧ��" + e);
				}
			}
			/* �������� */
			inputArt.setText("");
		}
			break;
		case R.id.Button_openTxt: {
			NoteDebug("�ļ���");
			try {
				/* ���ļ�������������txtME */
				is = this.openFileInput("txtME");
				/* ��ʼ���ֽ����� */
				b = new byte[1024];
				/* ���ļ��������ж�ȡ���ݵ��ֽ������У��������ݳ��� */
				int length = is.read(b);
				/* ���ֽ�����ת�����ַ��� */
				Text_of_output = new String(b);
				/* ���ñ��⣬��ʾ�ļ����ݳ��� */
				setTitle("�ļ�������" + length);
				/* ��ʾ�ļ����� */
				showmyText.setText(Text_of_output);
			} catch (FileNotFoundException e) {
				/* �ļ�δ�ҵ����쳣 */
				// TODO Auto-generated catch block
				NoteDebug("�ļ���ʧ��" + e);
			} catch (IOException e) {
				/* �ļ���ȡ�����쳣 */
				// TODO Auto-generated catch block
				NoteDebug("�ļ���ȡʧ��" + e);
			} finally {
				try {
					/* �ر��ļ������� */
					is.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					NoteDebug("�ļ��ر�ʧ��" + e);
				}
			}
		}
			break;
		case R.id.Button_clean: {
			/* ��� */
			showmyText.setText("");
			NoteDebug("���");
		}
			break;
		default:
			break;
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// TODO Auto-generated method stub
		/* ��������˵���Ŀ��������ͼƬ */
		menu.add(0, 1, 1, "Edit").setIcon(R.drawable.ic_launcher);
		menu.add(0, 2, 2, "Open").setIcon(R.drawable.ic_launcher);
		menu.add(0, 3, 3, "Exit").setIcon(R.drawable.ic_launcher);
		return super.onCreateOptionsMenu(menu);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		switch (item.getItemId()) {
		case 1:
			/* ��ʾmain.xmlΪ�������� */
			setLayoutShow(R.layout.file1);
			UIinit("main");
			Logic("main");
			NoteDebug("�༭�ļ�Layout");
			break;
		case 2:
			/* ��ʾopen.xmlΪ�������� */
			setLayoutShow(R.layout.file2);
			UIinit("open");
			Logic("open");
			NoteDebug("���ļ�Layout");
			break;
		case 3:
			/* �˳� */
			finish();
			NoteDebug("Byebye");
			break;
		default:
			break;
		}
		return super.onOptionsItemSelected(item);
	}

	private void NoteDebug(String showString) {
		/* ��ʾToast��ʾ */
		Toast.makeText(this, showString, Toast.LENGTH_SHORT).show();
	}
}