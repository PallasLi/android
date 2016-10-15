package com.pallasli.bpmoa;

import android.app.Activity;
import android.app.usage.UsageEvents;
import android.content.res.Configuration;
import android.os.Bundle;
import android.preference.PreferenceActivity;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewConfiguration;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class HomeActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    /**
     * 定义手势检测实例
     */
    public static GestureDetector detector;
    /**
     * 做标签，记录当前是哪个fragment
     */
    public int MARK = 0;
    /**
     * 定义手势两点之间的最小距离
     */
    final int FLING_MIN_DISTANCE = 5;

    final float FLING_MIN_VELOCITY = 1;
    private HomeActivity homeActivity = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        final Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        View tabsView = findViewById(R.id.main_content);
        //创建手势检测器
        detector = new GestureDetector(tabsView.getContext(), new GestureDetector.OnGestureListener() {


            @Override
            public boolean onDown(MotionEvent e) {
                return false;
            }

            @Override
            public void onShowPress(MotionEvent e) {

            }

            @Override
            public boolean onSingleTapUp(MotionEvent e) {
                return false;
            }

            @Override
            public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
                return false;
            }

            @Override
            public void onLongPress(MotionEvent e) {

            }


//            OnDown(MotionEvent e)：用户按下屏幕就会触发；
//            onShowPress(MotionEvent e)：如果是按下的时间超过瞬间，而且在按下的时候没有松开或者是拖动的，那么onShowPress就会执行，具体这个瞬间是多久，我也不清楚呃……
//            onLongPress(MotionEvent e)：长按触摸屏，超过一定时长，就会触发这个事件
//            触发顺序：
//            onDown->onShowPress->onLongPress
//            onSingleTapUp(MotionEvent e)：从名子也可以看出,一次单独的轻击抬起操作,也就是轻击一下屏幕，立刻抬起来，才会有这个触发，当然,如果除了Down以外还有其它操作,那就不再算是Single操作了,所以也就不会触发这个事件
//            触发顺序：
//            点击一下非常快的（不滑动）Touchup：
//            onDown->onSingleTapUp->onSingleTapConfirmed
//            点击一下稍微慢点的（不滑动）Touchup：
//            onDown->onShowPress->onSingleTapUp->onSingleTapConfirmed
//            onFling(MotionEvent e1, MotionEvent e2, float velocityX,float velocityY) ：滑屏，用户按下触摸屏、快速移动后松开，由1个MotionEvent ACTION_DOWN, 多个ACTION_MOVE, 1个ACTION_UP触发
//            参数解释：
//            e1：第1个ACTION_DOWN MotionEvent
//            e2：最后一个ACTION_MOVE MotionEvent
//            velocityX：X轴上的移动速度，像素/秒
//            velocityY：Y轴上的移动速度，像素/秒
//            onScroll(MotionEvent e1, MotionEvent e2,float distanceX, float distanceY)：在屏幕上拖动事件。无论是用手拖动view，或者是以抛的动作滚动，都会多次触发,这个方法       在ACTION_MOVE动作发生时就会触发
//            滑屏：手指触动屏幕后，稍微滑动后立即松开
//            onDown-----》onScroll----》onScroll----》onScroll----》………----->onFling
//                    拖动
//            onDown------》onScroll----》onScroll------》onFiling
//
//            可见，无论是滑屏，还是拖动，影响的只是中间OnScroll触发的数量多少而已，最终都会触发onFling事件！
//

            public boolean onTouchEvent(MotionEvent ev) {
                Toast.makeText(HomeActivity.this, "fling", Toast.LENGTH_SHORT).show();
                return true;
            }

            @Override
            public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {

                Toast.makeText(HomeActivity.this, "fling", Toast.LENGTH_SHORT).show();
                if (e1.getX() - e2.getX() > FLING_MIN_DISTANCE
                        && Math.abs(velocityX) > FLING_MIN_VELOCITY) {
                    // Fling left
                    Toast.makeText(HomeActivity.this, "Fling Left", Toast.LENGTH_SHORT).show();
                } else if (e2.getX() - e1.getX() > FLING_MIN_DISTANCE
                        && Math.abs(velocityX) > FLING_MIN_VELOCITY) {
                    // Fling right
                    Toast.makeText(HomeActivity.this, "Fling Right", Toast.LENGTH_SHORT).show();
                }
                return true;
            }
        });

        tabsView.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {

                return detector.onTouchEvent(event);
            }
        });


        Toast.makeText(HomeActivity.this, "create", Toast.LENGTH_SHORT).show();
        //初始化设置事件
        //消息列表float FLING_MIN_VELOCITY;
        View messageTab = findViewById(R.id.linear_layout_message);
        messageTab.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                HomeFragmentUtils.openPersonalMessageListFragment(homeActivity);
            }
        });
        //通讯录
        View adressTab = findViewById(R.id.linear_layout_address);
        adressTab.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                HomeFragmentUtils.openCommunityImFriendGroupListFragment(homeActivity);
            }
        });
        //工作台
        View workbenchTab = findViewById(R.id.linear_layout_workbench);
        workbenchTab.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                HomeFragmentUtils.openPersonalWorkbenchFragment(homeActivity);
            }
        });
        //朋友圈
        View zoneTab = findViewById(R.id.linear_layout_zone);
        zoneTab.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                HomeFragmentUtils.openCommunityZoneFragment(homeActivity);
            }
        });
        HomeFragmentUtils.openPersonalWorkbenchFragment(homeActivity);
    }


    @Override
    protected void onStart() {
        super.onStart();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        View header=navigationView.getHeaderView(0);
        ImageView userPhotoView = (ImageView)header. findViewById(R.id.user_photo);
        TextView userCaptionView = (TextView)header. findViewById(R.id.user_caption);
        TextView userEmailView = (TextView)header. findViewById(R.id.user_email);
        userPhotoView.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                HomeFragmentUtils.openPersonalUserInfoFragment(homeActivity);

                DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
                drawer.closeDrawer(GravityCompat.START);
            }
        });
        userCaptionView.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                HomeFragmentUtils.openPersonalUserInfoFragment(homeActivity);

                DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
                drawer.closeDrawer(GravityCompat.START);
            }
        });
        userEmailView.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                HomeFragmentUtils.openPersonalUserInfoFragment(homeActivity);

                DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
                drawer.closeDrawer(GravityCompat.START);
            }
        });

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
        getMenuInflater().inflate(R.menu.home, menu);
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

        if (id == R.id.nav_bpm_start) {
            HomeFragmentUtils.openBpmStartFragment(homeActivity);
        } else if (id == R.id.nav_bpm_my_apply) {
            HomeFragmentUtils.openBpmMyApplyFragment(homeActivity);
        } else if (id == R.id.nav_bpm_my_todo) {
            HomeFragmentUtils.openBpmMyTodoFragment(homeActivity);
        } else if (id == R.id.nav_bpm_my_done) {
            HomeFragmentUtils.openBpmMyDoneFragment(homeActivity);
        } else if (id == R.id.nav_bpm_my_draft) {
            HomeFragmentUtils.openBpmMyDraftFragment(homeActivity);
        } else if (id == R.id.nav_personal_care) {
            HomeFragmentUtils.openPersonalCareListFragment(homeActivity);
        } else if (id == R.id.nav_personal_favorite) {
            HomeFragmentUtils.openPersonalFavoriteListFragment(homeActivity);
        } else if (id == R.id.nav_personal_upload) {
            HomeFragmentUtils.openPersonalUploadFileListFragment(homeActivity);
        } else if (id == R.id.nav_personal_download) {
            HomeFragmentUtils.openPersonalDownloadFileListFragment(homeActivity);
        } else if (id == R.id.nav_personal_setting) {
            HomeFragmentUtils.openPersonalUserSettingFragment(homeActivity);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

}
