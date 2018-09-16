package com.example.zhang.ueating_temp;

import android.app.ListFragment;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.example.zhang.ueating_temp.Adapters.ProfileAdapter;
import com.example.zhang.ueating_temp.General_Objects.Profile;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by TonyZhang on 2018/9/15.
 */

public class ProfileFragment extends ListFragment {

    private List<Profile> proList = new ArrayList<Profile>();
    public static boolean profileRefreshFlag = true;

    private void createProfile() {
        Profile defaultProfile = new Profile(R.drawable.default_avater, this.getString(R.string.default_username));
        proList.add(defaultProfile);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if(profileRefreshFlag) {
            createProfile();
            ProfileAdapter adapter = new ProfileAdapter(getActivity(), R.layout.profile_item, proList);
            setListAdapter(adapter);
            profileRefreshFlag = false;
        }
    }

}
