package com.tripkit.lighthouse.controller;

import com.tripkit.lighthouse.data.dto.ActivityDto;
import com.tripkit.lighthouse.service.ActivityService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/activities")
public class ActivityController {

    private final ActivityService activityService;

    @GetMapping("")
    public List<ActivityDto> getActivityByTime(
            @RequestParam String Time,
            @PageableDefault(size = 10, sort = "date", direction = Sort.Direction.DESC) Pageable pageable
    ) {
        return activityService.getActivityByTime();
    }
}
