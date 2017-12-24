package cn.pallasli.hr;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewParent;
import android.widget.ImageButton;
import android.widget.TextView;

import cn.pallasli.hr.fragment.HrEmployeeRegistrationFragment;
import cn.pallasli.hr.fragment.HrEmployeeRegistrationListFragment;
import cn.pallasli.hr.fragment.dummy.DummyContent;

public class HrEmployeeRegistrationActivity extends AppCompatActivity
implements HrEmployeeRegistrationFragment.OnFragmentInteractionListener,
HrEmployeeRegistrationListFragment.OnListFragmentInteractionListener{

    private ViewPager hrEmployeeRegistrationViewPager;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.hr_employee_registration_tab_list:
                    hrEmployeeRegistrationViewPager.setCurrentItem(0);
                    return true;
                case R.id.hr_employee_registration_tab_check:
                    hrEmployeeRegistrationViewPager.setCurrentItem(1);
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hr_employee_registration);

        SectionsPagerAdapter mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());
        hrEmployeeRegistrationViewPager =  findViewById(R.id.hrEmployeeRegistrationViewPager);
        hrEmployeeRegistrationViewPager.setAdapter(mSectionsPagerAdapter);


        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        //返回
        ImageButton activityBack=findViewById(R.id.activity_back);
        activityBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               HrEmployeeRegistrationActivity.this.finish();
            }
        });
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    @Override
    public void onListFragmentInteraction(DummyContent.DummyItem item) {

    }

    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }
        @Override
        public Fragment getItem(int position) {
            if(position==0){
                return HrEmployeeRegistrationListFragment.newInstance(1);
            }else{
                return HrEmployeeRegistrationFragment.newInstance("","");
            }
        }

        @Override
        public int getCount() {
            return 2;
        }


    }
}
