package cn.pallasli.hr;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class HrEmployeeListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hr_employee_list);


        //返回
        ImageButton activityBack=findViewById(R.id.activity_back);
        activityBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                HrEmployeeListActivity.this.finish();
            }
        });
    }
}
