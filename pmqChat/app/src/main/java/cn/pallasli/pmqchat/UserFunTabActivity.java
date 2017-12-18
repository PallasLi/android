package cn.pallasli.pmqchat;

import android.graphics.Color;
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

import cn.pallasli.pmqchat.fragment.LinkmanFragment;
import cn.pallasli.pmqchat.fragment.MessageItemFragment;
import cn.pallasli.pmqchat.fragment.SocialityFragment;
import cn.pallasli.pmqchat.fragment.ToolsFragment;
import cn.pallasli.pmqchat.fragment.WorkbenchFragment;
import cn.pallasli.pmqchat.fragment.dummy.MessageDummy;

public class UserFunTabActivity extends AppCompatActivity
        implements LinkmanFragment.OnFragmentInteractionListener,
        MessageItemFragment.OnListFragmentInteractionListener ,
        WorkbenchFragment.OnFragmentInteractionListener,
        ToolsFragment.OnFragmentInteractionListener,
        SocialityFragment.OnFragmentInteractionListener{

    private SectionsPagerAdapter mSectionsPagerAdapter;

    private static ViewPager mViewPager;

    private static    ImageButton mMessage;
    private static     ImageButton mLinkman;
    private static     ImageButton mWork;
    private static     ImageButton mTools;
    private static     ImageButton mDynamic;


    int selectColor=Color.parseColor("#ffcccccc");
    int unSelectColor=Color.parseColor("#00000000");
    private void clearTabTileColor(){
        mMessage.setBackgroundColor(unSelectColor);
        mLinkman.setBackgroundColor(unSelectColor);
        mWork.setBackgroundColor(unSelectColor);
        mDynamic.setBackgroundColor(unSelectColor);
        mTools.setBackgroundColor(unSelectColor);
    }
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


        mMessage= (ImageButton) findViewById(R.id.id_tab_message_img);
        mLinkman= (ImageButton) findViewById(R.id.id_tab_linkman_img);
        mWork= (ImageButton) findViewById(R.id.id_tab_work_img);
        mDynamic= (ImageButton)  findViewById(R.id.id_tab_dynamic_img);
        mTools= (ImageButton)  findViewById(R.id.id_tab_tools_img);
        mMessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mViewPager.setCurrentItem(0);
                clearTabTileColor();
                mMessage.setBackgroundColor(selectColor);
            }
        });
        mLinkman.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mViewPager.setCurrentItem(1);
                clearTabTileColor();
                mLinkman.setBackgroundColor(selectColor);
            }
        });
        mWork.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mViewPager.setCurrentItem(2);
                clearTabTileColor();
                mWork.setBackgroundColor(selectColor);
            }
        });
        mDynamic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mViewPager.setCurrentItem(3);
                clearTabTileColor();
                mDynamic.setBackgroundColor(selectColor);
            }
        });
        mTools.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mViewPager.setCurrentItem(4);
                clearTabTileColor();
                mTools.setBackgroundColor(selectColor);
            }
        });

//        mViewPager.setOnScrollChangeListener(new ViewPager.OnScrollChangeListener(){
//
//            @Override
//            public void onScrollChange(View view, int i, int i1, int i2, int i3) {
//
//            }
//        });
        mViewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                clearTabTileColor();
                if(position==0){
                    mMessage.setBackgroundColor(selectColor);
                }else
                if(position==1){
                    mLinkman.setBackgroundColor(selectColor);
                }else
                if(position==2){
                    mWork.setBackgroundColor(selectColor);
                }else
                if(position==3){
                    mDynamic.setBackgroundColor(selectColor);
                }else {
                    mTools.setBackgroundColor(selectColor);
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

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
                return   WorkbenchFragment.newInstance("","");
            }else
            if(position==3){
                return SocialityFragment.newInstance("","");
            }else {
                return ToolsFragment.newInstance("","");
            }
        }

        @Override
        public int getCount() {
            return 5;
        }


    }
}
