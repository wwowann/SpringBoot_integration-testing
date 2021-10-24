package com.myLesson.demo.service.profile;

import com.myLesson.demo.service.SystemProfile;


public class DevProfile implements SystemProfile {
    @Override
    public String getProfile() {
        return "Current profile is dev";
    }
}
