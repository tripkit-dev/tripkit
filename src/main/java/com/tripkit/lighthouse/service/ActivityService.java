package com.tripkit.lighthouse.service;

import com.tripkit.lighthouse.data.dto.ActivityDto;
import com.tripkit.lighthouse.repository.ActivityRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ActivityService {

    private final ModelMapper modelMapper;
    private final ActivityRepository activityRepository;

    public List<ActivityDto> getActivityByTime() {

        List<ActivityDto> activityDtos = new ArrayList<>();

        return activityDtos;
    }
}
