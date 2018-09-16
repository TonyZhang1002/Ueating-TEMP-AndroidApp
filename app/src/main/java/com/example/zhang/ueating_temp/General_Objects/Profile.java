package com.example.zhang.ueating_temp.General_Objects;

/**
 * Created by TonyZhang on 2018/9/15.
 */

public class Profile {

    private int profileImageID;
    private String userName;

    public Profile(int profileImageID, String userName) {
        this.profileImageID = profileImageID;
        this.userName = userName;
    }

    public int getProfileImageID() {
        return profileImageID;
    }

    public String getUserName() {
        return userName;
    }
}
