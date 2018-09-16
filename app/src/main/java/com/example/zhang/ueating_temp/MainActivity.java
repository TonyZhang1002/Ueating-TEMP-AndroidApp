package com.example.zhang.ueating_temp;

/**
 * Created by TonyZhang on 2018/9/15.
 */

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private HomeFragment mHome;
    private ProfileFragment mProfile;

    /*
    We set the default fragment to the HomeFragment
    @author TonyZhang
    */
    private void setDefaultFragment()
    {
        FragmentManager fm = getFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
        mHome = new HomeFragment();
        transaction.replace(R.id.content_fragment, mHome);
        transaction.commit();
    }

    /*
    Change the fragment when user click another navigation button
    @author TonyZhang
    */
    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            FragmentManager fm = getFragmentManager();
            FragmentTransaction transaction = fm.beginTransaction();
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    //mTextMessage.setText(R.string.title_home);
                    if (mHome == null) {
                        mHome = new HomeFragment();
                    }
                    transaction.replace(R.id.content_fragment, mHome);
                    transaction.commit();
                    return true;
                case R.id.navigation_orders:
                    //mTextMessage.setText(R.string.title_dashboard);
                    return true;
                case R.id.navigation_profile:
                    //mTextMessage.setText(R.string.title_notifications);
                    if (mProfile == null) {
                        mProfile = new ProfileFragment();
                    }
                    transaction.replace(R.id.content_fragment, mProfile);
                    transaction.commit();
                    return true;
            }
            return false;
        }

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setDefaultFragment();

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

}
