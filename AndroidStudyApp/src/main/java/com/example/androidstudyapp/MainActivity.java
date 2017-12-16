package com.example.androidstudyapp;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.Button;
import android.widget.EditText;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
		System.out.println("登录页面");
		Log.e("login","登录页面");
        super.onCreate(savedInstanceState);
        if(true){
        	setContentView(R.layout.activity_login);

    		Button loginButton = (Button) findViewById(R.id.login_button);
    		System.out.println("登录页面");
    		Log.e("login","登录页面");
    		
    		
    		loginButton.setOnTouchListener(new OnTouchListener() {
    			
    			@Override
    			public boolean onTouch(View view, MotionEvent event) {
    				Log.e("login","登录页面");
    				//Log.e("login",((EditText)view.findViewById(R.id.user_name)).getText());
    				System.out.println(((EditText)view.findViewById(R.id.user_name)).getText());
    				System.out.println(((EditText)view.findViewById(R.id.password)).getText());
    				System.out.println("touch");
    				return false;
    			}
    		});
    		loginButton.setOnClickListener(new OnClickListener() {

    			public void onClick(View view) {
    				Log.e("login","登录页面");
    				Log.e("login",((EditText)view.findViewById(R.id.user_name)).getText().toString());
    				System.out.println(view.findViewById(R.id.user_name));
    				System.out.println(view.findViewById(R.id.password));
    			}
    		});
        }else{
        	setContentView(R.layout.activity_main);
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
