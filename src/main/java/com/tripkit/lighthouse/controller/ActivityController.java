package com.tripkit.lighthouse.controller;

import com.tripkit.lighthouse.data.dto.ActivityDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/activities")
public class ActivityController {

    @GetMapping("")
    public List<ActivityDto> getActivityByTime() {
        return
    }
}
