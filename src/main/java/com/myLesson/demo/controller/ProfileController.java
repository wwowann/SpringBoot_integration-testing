package com.myLesson.demo.controller;

import com.myLesson.demo.service.SystemProfile;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class ProfileController {

    private final SystemProfile profile;

    public ProfileController(SystemProfile profile) {
        this.profile = profile;
    }

    @GetMapping("service/profile")
    public String getProfile() {
        return profile.getProfile();
    }
}