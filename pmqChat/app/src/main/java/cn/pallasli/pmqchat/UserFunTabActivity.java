package cn.pallasli.pmqchat;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import android.widget.ImageButton;

import cn.pallasli.pmqchat.fragment.FriendItemFragment;
import cn.pallasli.pmqchat.fragment.GroupItemFragment;
import cn.pallasli.pmqchat.fragment.LinkmanFragment;
import cn.pallasli.pmqchat.fragment.MessageItemFragment;
import cn.pallasli.pmqchat.fragment.UserSettingsFragment;
import cn.pallasli.pmqchat.fragment.WorkbenchFragment;
import cn.pallasli.pmqchat.fragment.dummy.DummyContent;
import cn.pallasli.pmqchat.fragment.dummy.MessageDummy;

public class UserFunTabActivity extends AppCompatActivity
        implements LinkmanFragment.OnFragmentInteractionListener, MessageItemFragment.OnListFragmentInteractionListener ,WorkbenchFragment.OnFragmentInteractionListener,UserSettingsFragment.OnFragmentInteractionListener {

    private SectionsPagerAdapter mSectionsPagerAdapter;

    private static ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_fun_tab);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);

//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });


        final   ImageButton mWeiXin;
        final    ImageButton mFriend;
        final    ImageButton mAddress;
        final    ImageButton mSetting;
        mWeiXin= (ImageButton) findViewById(R.id.id_tab_weixin_img);
        mFriend= (ImageButton) findViewById(R.id.id_tab_frd_img);
        mAddress= (ImageButton) findViewById(R.id.id_tab_address_img);
        mSetting= (ImageButton)  findViewById(R.id.id_tab_setting_img);
        mWeiXin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mViewPager.setCurrentItem(0);
            }
        });
        mFriend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mViewPager.setCurrentItem(1);
            }
        });
        mAddress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mViewPager.setCurrentItem(2);
            }
        });
        mSetting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mViewPager.setCurrentItem(3);
            }
        });


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_user_fun_tab, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onListFragmentInteraction(MessageDummy.DummyItem item) {

    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }


    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            if(position==0){
                return MessageItemFragment.newInstance(1);
            }else
            if(position==1){
                return LinkmanFragment.newInstance("","");
            }else
            if(position==2){
                return WorkbenchFragment.newInstance("","");
            }else {
                return UserSettingsFragment.newInstance("","");
            }
        }

        @Override
        public int getCount() {
            return 4;
        }
    }
}
