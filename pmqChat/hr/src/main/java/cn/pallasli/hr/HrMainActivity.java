package cn.pallasli.hr;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class HrMainActivity extends AppCompatActivity {
    ImageButton hrEmployeeRegistration;
    ImageButton hrEmployeeAdd;
    ImageButton hrEmployeeRegular;
    ImageButton hrEmployeePortExchange;
    ImageButton hrEmployeeLeaveOffice;
    ImageButton journalDailyReport;
    ImageButton journalWeekReport;
    ImageButton journalMonthReport;
    ImageButton dutySign;
    ImageButton dutyExtra;
    ImageButton dutyLeave;
    ImageButton dutyTravel;
    ImageButton dutyOut;
    ImageButton dutyExchange;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hr_main);

        hrEmployeeRegistration=findViewById(R.id.hr_employee_registration);
        hrEmployeeAdd=findViewById(R.id.hr_employee_add);
        hrEmployeeRegular=findViewById(R.id.hr_employee_regular);
        hrEmployeePortExchange=findViewById(R.id.hr_employee_port_exchange);
        hrEmployeeLeaveOffice=findViewById(R.id.hr_employee_leave_office);

        journalDailyReport=findViewById(R.id.journal_daily_report);
        journalWeekReport=findViewById(R.id.journal_week_report);
        journalMonthReport=findViewById(R.id.journal_month_report);

        dutySign =findViewById(R.id.duty_sign);
        dutyExtra =findViewById(R.id.duty_extra);
        dutyLeave =findViewById(R.id.duty_leave);
        dutyTravel =findViewById(R.id.duty_travel);
        dutyOut =findViewById(R.id.duty_out);
        dutyExchange =findViewById(R.id.duty_exchange);


        hrEmployeeRegistration.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(HrMainActivity.this,HrEmployeeRegistrationActivity.class);
                startActivity(intent);
            }
        });
        hrEmployeeAdd.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View view) {
                  Intent intent=new Intent(HrMainActivity.this,HrEmployeeListActivity.class);
                  startActivity(intent);
              }
        });
        hrEmployeeRegular.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View view) {
                  Intent intent=new Intent(HrMainActivity.this,HrEmployeeRegularListActivity.class);
                  startActivity(intent);
              }
        });
        hrEmployeePortExchange.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View view) {
                  Intent intent=new Intent(HrMainActivity.this,HrEmployeePortExchangeListActivity.class);
                  startActivity(intent);}
        });
        hrEmployeeLeaveOffice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(HrMainActivity.this,HrEmployeeLeaveOfficeListActivity.class);
                startActivity(intent);
            }
        });


          journalDailyReport.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View view) {
                  Intent intent=new Intent(HrMainActivity.this,JournalDailyReportActivity.class);
                  startActivity(intent);
              }
          });
          journalWeekReport.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View view) {
                  Intent intent=new Intent(HrMainActivity.this,JournalWeekReportActivity.class);
                  startActivity(intent);
              }
          });
          journalMonthReport.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View view) {
                  Intent intent=new Intent(HrMainActivity.this,JournalMonthReportActivity.class);
                  startActivity(intent);
              }
          });

        dutySign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(HrMainActivity.this,DutySignActivity.class);
                startActivity(intent);
            }
        });
        dutyExtra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(HrMainActivity.this,DutyExtraActivity.class);
                startActivity(intent);
            }
        });
        dutyLeave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(HrMainActivity.this,DutyLeaveActivity.class);
                startActivity(intent);
            }
        });
        dutyTravel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(HrMainActivity.this,DutyTravelActivity.class);
                startActivity(intent);
            }
        });
        dutyOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(HrMainActivity.this,DutyOutActivity.class);
                startActivity(intent);
            }
        });
        dutyExchange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(HrMainActivity.this,DutyExtraActivity.class);
                startActivity(intent);
            }
        });
    }
}
