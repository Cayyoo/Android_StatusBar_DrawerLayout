package com.example.statusbar_drawerlayout;

import android.content.Intent;
import android.os.Build;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.statusbar_drawerlayout.base.BaseActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * 功能：
 * 1、沉侵式状态栏
 * 2、侧滑菜单，布局采用DrawerLayout+FrameLayout+NavigationView
 */
public class MainActivity extends BaseActivity {
    DrawerLayout mDrawerLayout;
    Toolbar mToolbar;
    ListView mListView;
    NavigationView mNavView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        navViewToTop();
    }

    private void initView() {
        mNavView = (NavigationView) findViewById(R.id.nav_view);
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        mListView = (ListView) findViewById(R.id.list);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);

        setUpDrawer();
        initList();
        initNavigationView();
    }

    private void setUpDrawer() {
        setSupportActionBar(mToolbar);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, mDrawerLayout, mToolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        mDrawerLayout.addDrawerListener(toggle);
        toggle.syncState();
    }

    private void initNavigationView() {
        mNavView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.nav_item1:
                        startActivity(TopImageActivity.class);
                        break;
                    case R.id.nav_item2:
                        startActivity(TabActivity.class);
                        break;
                    case R.id.nav_item3:
                        startActivity(PlanTwoActivity.class);
                        break;
                    case R.id.nav_item4:
                        startActivity(PlanThreeActivity.class);
                        break;
                    case R.id.nav_share:
                        Toast.makeText(MainActivity.this,"nav_share",Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.nav_send:
                        Toast.makeText(MainActivity.this,"nav_send",Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.nav_camera:
                        Toast.makeText(MainActivity.this,"nav_camera",Toast.LENGTH_SHORT).show();
                        break;
                    //还有三个没写

                    default:
                        break;
                }

                mDrawerLayout.closeDrawer(GravityCompat.START);

                return true;
            }
        });
    }

    private void initList() {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            list.add("主界面 item" + i);
        }

        ArrayAdapter adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, list);
        mListView.setAdapter(adapter);
    }

    private void navViewToTop() {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP) {
            mDrawerLayout.setFitsSystemWindows(true);
            mDrawerLayout.setClipToPadding(false);
        }
    }

    private void startActivity(Class<?> cls) {
        Intent intent = new Intent(MainActivity.this, cls);
        startActivity(intent);
    }
}
