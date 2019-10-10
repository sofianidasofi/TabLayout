package com.example.tablayout;

import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;
import com.google.android.material.tabs.TabLayout;
import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    VpAdapter vpAdapter;
    @BindView(R.id.tv_toolbar)
    TextView tvToolbar;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.view_pager_menu)
    ViewPager viewPagerMenu;
    @BindView(R.id.tab_layout_menu)
    TabLayout tabLayoutMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        initView();
    }

    void initView(){
        vpAdapter = new VpAdapter(getSupportFragmentManager());

        //fragment
        HomeFragment mHomeFragment = new HomeFragment();
        ProfileFragment mProfileFragment = new ProfileFragment();
        NotificationFragment mNotificationFragment = new NotificationFragment();

        vpAdapter.addFragment(mHomeFragment,"Home");
        vpAdapter.addFragment(mProfileFragment,"Profile");
        vpAdapter.addFragment(mNotificationFragment,"Notifikasi");
        viewPagerMenu.setAdapter(vpAdapter);
        tabLayoutMenu.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPagerMenu.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        //inflateDivider();
        tabLayoutMenu.setupWithViewPager(viewPagerMenu);

    }
}
