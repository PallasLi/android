package cn.pallasli.hr;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class HrMainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hr_main);
        ImageButton hrEmployeeRegistration=findViewById(R.id.hr_employee_registration);
        hrEmployeeRegistration.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent=new Intent(HrMainActivity.this,HrEmployeeRegistrationActivity.class);
                startActivity(intent);
            }
        });
    }
}
