package com.pallasli.officeautomation.web;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.pallasli.officeautomation.R;

import java.io.File;

public class WebBrowserActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_browser);

    }

    @Override
    protected void onStart() {
        super.onStart();
        Button webbtn = (Button) findViewById(R.id.btn_web_open);
        webbtn.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                WebBrowserActivity.this.openWeb();
            }
        });
        Button audiobtn = (Button) findViewById(R.id.btn_audio_open);
        audiobtn.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                WebBrowserActivity.this.openAudio();
            }
        });
        Button imagebtn = (Button) findViewById(R.id.btn_image_open);
        imagebtn.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                WebBrowserActivity.this.openImage();
            }
        });
    }

    private void openWeb() {

        Uri uri = Uri.parse("http://127.0.0.1:8080/baodingOA/");
        Intent it = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(it);
    }

    private void openAudio() {
        Intent it = new Intent(Intent.ACTION_VIEW);
        File file = new File("/");
        it.setDataAndType(Uri.fromFile(file), "audio/*");
        startActivity(it);
    }

    private void openImage() {

        Intent it = new Intent(Intent.ACTION_VIEW);
        File file = new File("/");
        it.setDataAndType(Uri.fromFile(file), "image/*");
        startActivity(it);
    }
}
