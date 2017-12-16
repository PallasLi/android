package com.pallasli.officeautomation;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity {


    Button signInBtn;
    Button registerBtn;
    EditText usernameText;
    EditText passwordText;

    protected void onStart() {
        super.onStart();

        signInBtn = (Button) findViewById(R.id.login_btn_sign_in);
        registerBtn = (Button) findViewById(R.id.login_btn_register);
        usernameText = (EditText) findViewById(R.id.login_form_username);
        passwordText = (EditText) findViewById(R.id.login_form_password);

        signInBtn.setOnClickListener(new Button.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent it= new Intent();
                it.setClass(LoginActivity.this,HomeActivity.class);
                startActivity(it);
            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }
}
