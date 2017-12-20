package cn.pallasli.pmqchat;

import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;
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

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener ,
         LinkmanFragment.OnFragmentInteractionListener,
        MessagesFragment.OnListFragmentInteractionListener ,
        WorkbenchFragment.OnFragmentInteractionListener,
        ToolsFragment.OnFragmentInteractionListener,
        SocialityFragment.OnFragmentInteractionListener,
        TmpBlankFragment.OnFragmentInteractionListener,

        OrganizationsFragment.OnFragmentInteractionListener,
        GroupsFragment.OnListFragmentInteractionListener,
        FriendsFragment.OnListFragmentInteractionListener,
        MyDevicesFragment.OnFragmentInteractionListener,
        NearByPeopleFragment.OnFragmentInteractionListener{

    private MainActivity.SectionsPagerAdapter mSectionsPagerAdapter;

    private static ViewPager mViewPager;

    private static ImageButton mMessage;
    private static ImageButton mLinkman;
    private static ImageButton mWork;
    private static ImageButton mTools;
    private static ImageButton mDynamic;


    int selectColor= Color.parseColor("#ffcccccc");
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
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        mSectionsPagerAdapter = new MainActivity.SectionsPagerAdapter(getSupportFragmentManager());
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
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onListFragmentInteraction(MessageDummy.DummyItem item) {

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
