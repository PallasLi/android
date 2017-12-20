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

import cn.pallasli.pmqchat.fragment.FriendsFragment;
import cn.pallasli.pmqchat.fragment.GroupsFragment;
import cn.pallasli.pmqchat.fragment.MyDevicesFragment;
import cn.pallasli.pmqchat.fragment.NearByPeopleFragment;
import cn.pallasli.pmqchat.fragment.OrganizationsFragment;
import cn.pallasli.pmqchat.fragment.TmpBlankFragment;
import cn.pallasli.pmqchat.fragment.LinkmanFragment;
import cn.pallasli.pmqchat.fragment.MessagesFragment;
import cn.pallasli.pmqchat.fragment.SocialityFragment;
import cn.pallasli.pmqchat.fragment.ToolsFragment;
import cn.pallasli.pmqchat.fragment.WorkbenchFragment;
import cn.pallasli.pmqchat.fragment.dummy.DummyContent;
import cn.pallasli.pmqchat.fragment.dummy.MessageDummy;

public class UserFunTabActivity extends AppCompatActivity
        implements LinkmanFragment.OnFragmentInteractionListener,
        MessagesFragment.OnListFragmentInteractionListener ,
        WorkbenchFragment.OnFragmentInteractionListener,
        ToolsFragment.OnFragmentInteractionListener,
        SocialityFragment.OnFragmentInteractionListener,
        TmpBlankFragment.OnFragmentInteractionListener{

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

//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });


        setContentView(R.layout.activity_user_fun_tab);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);
        mMessage= (ImageButton) findViewById(R.id.id_tab_message_img);
        mLinkman= (ImageButton) findViewById(R.id.id_tab_linkman_img);
        mWork= (ImageButton) findViewById(R.id.id_tab_work_img);
        mDynamic= (ImageButton)  findViewById(R.id.id_tab_dynamic_img);
        mTools= (ImageButton)  findViewById(R.id.id_tab_tools_img);
        mMessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mViewPager.setCurrentItem(1);
            }
        });
        mLinkman.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mViewPager.setCurrentItem(2);
            }
        });
        mWork.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mViewPager.setCurrentItem(3);
            }
        });
        mDynamic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mViewPager.setCurrentItem(4);
            }
        });
        mTools.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mViewPager.setCurrentItem(5);
            }
        });

//        mViewPager.setOnScrollChangeListener(new ViewPager.OnScrollChangeListener(){
//
//            @Override
//            public void onScrollChange(View view, int i, int i1, int i2, int i3) {
//
//            }
//        });
        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                clearTabTileColor();
                if(position==1){
                    mMessage.setBackgroundColor(selectColor);
                }else
                if(position==2){
                    mLinkman.setBackgroundColor(selectColor);
                }else
                if(position==3){
                    mWork.setBackgroundColor(selectColor);
                }else
                if(position==4){
                    mDynamic.setBackgroundColor(selectColor);
                }else
                if(position==5) {
                    mTools.setBackgroundColor(selectColor);
                }else if ( position < 1) {
                    position = 5;
                    mViewPager.setCurrentItem(position,false);
                } else if ( position > 5) { //末位之后，跳转到首位（1）
                    mViewPager.setCurrentItem(1,false); //false:不显示跳转过程的动画
                    position = 1;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        mViewPager.setCurrentItem(1,false);

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
            if(position==1){
                return MessagesFragment.newInstance(1);
            }else
            if(position==2){
                return LinkmanFragment.newInstance("","");
            }else
            if(position==3){
                return   WorkbenchFragment.newInstance("","");
            }else
            if(position==4){
                return SocialityFragment.newInstance("","");
            }else
            if(position==5){
                return ToolsFragment.newInstance("","");
            }else{
                return TmpBlankFragment.newInstance("","");
            }
        }

        @Override
        public int getCount() {
            return 7;
        }


    }
}
