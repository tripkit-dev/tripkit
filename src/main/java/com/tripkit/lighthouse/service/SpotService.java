package com.tripkit.lighthouse.service;

import com.tripkit.lighthouse.data.dto.SpotBasicDto;
import com.tripkit.lighthouse.data.entity.Spot;
import com.tripkit.lighthouse.repository.SpotRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SpotService {

    private final ModelMapper modelMapper;  // Entity <-> DTO 변환
    private final SpotRepository spotRepository;

    public List<SpotBasicDto> getSpotByCategory(String category, Pageable pageable) {

        List<Spot> spots = new ArrayList<>();

        List<SpotBasicDto> spotBasicDtos = new ArrayList<>();

        spots = spotRepository.findAllByCategoryIn(category, pageable);

        for (Spot spot : spots) {
            spotBasicDtos.add(modelMapper.map(spot, SpotBasicDto.class));
        }

        return spotBasicDtos;
    }

    public SpotBasicDto addSpot(SpotBasicDto spotBasicDto) {

        Spot spot = new Spot();

        SpotBasicDto retDto = new SpotBasicDto();

        spot = modelMapper.map(spotBasicDto, spot.getClass());

        spotRepository.save(spot);

        return retDto;
    }

    public List<SpotBasicDto> getSpotByTitle(String title, Pageable pageable) {

        List<SpotBasicDto> spotBasicDtos = new ArrayList<>();

        return spotBasicDtos;
    }

    public List<SpotBasicDto> getSpotByTag(String tag, Pageable pageable) {

        List<SpotBasicDto> spotBasicDtos = new ArrayList<>();

        return spotBasicDtos;
    }
}
