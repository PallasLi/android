package com.pallasli.officeautomation.bpm;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.pallasli.officeautomation.R;

public class FormDataActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bpm_form_data);


        LinearLayout ll = (LinearLayout)findViewById(R.id.bpm_form_data);
// 将TextView 加入到LinearLayout 中
        TextView tv = new TextView(this);
        tv.setText("af");
        ll. addView ( tv );


    }
}
