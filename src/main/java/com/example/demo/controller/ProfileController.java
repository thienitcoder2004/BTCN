package com.example.demo.controller;

import com.example.demo.entity.Profile;
import com.example.demo.repository.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class ProfileController {

    @Autowired
    private ProfileRepository profileRepository;

    @GetMapping("/")
    public String index(Model model) {
        if (profileRepository.count() == 0) {
            Profile p = new Profile(
                null,
                "Nguyễn Ngọc Thiện",
                "thienitcoder2004@gmail.com",
                "0372128662",
                "Đại học Công nghệ TP.HCM",
                "Công nghệ phần mềm"
            );
            profileRepository.save(p);
        }

        List<Profile> profiles = profileRepository.findAll();
        model.addAttribute("profiles", profiles);
        return "index";
    }
}