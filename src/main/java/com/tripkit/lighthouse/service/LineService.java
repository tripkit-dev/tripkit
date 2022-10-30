package com.tripkit.lighthouse.service;

import com.tripkit.lighthouse.data.dto.LineBasicDto;
import com.tripkit.lighthouse.repository.LineRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LineService {

    private final ModelMapper modelMapper;
    private final LineRepository lineRepository;

    public List<LineBasicDto> getLineByUser() {

    }
}
