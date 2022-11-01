package com.tripkit.lighthouse.service;

import com.tripkit.lighthouse.data.dto.LineBasicDto;
import com.tripkit.lighthouse.data.entity.Line;
import com.tripkit.lighthouse.repository.LineRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class LineService {

    private final ModelMapper modelMapper;
    private final LineRepository lineRepository;

    public List<LineBasicDto> getLineByUser(String userName, Pageable pageable ) {

        List<LineBasicDto> lineBasicDtos = new ArrayList<>();


        return lineBasicDtos;

    }

    public LineBasicDto postLine(LineBasicDto lineBasicDto) {
        return lineBasicDto;
    }
}
