package com.tripkit.lighthouse.service;

import com.tripkit.lighthouse.repository.ActivityRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ActivityService {

    private final ModelMapper modelMapper;
    private final ActivityRepository activityRepository;
}
