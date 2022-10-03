package com.tripkit.lighthouse.service;

import com.tripkit.lighthouse.data.dto.SpotBasicDto;
import com.tripkit.lighthouse.data.entity.Spot;
import com.tripkit.lighthouse.repository.SpotRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SpotService {

    private final ModelMapper modelMapper;
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

    public Spot addSpot(SpotBasicDto spotBasicDto) {
        Spot spot = new Spot();
        SpotBasicDto spotBasicDto = new SpotBasicDto();
        spot = modelMapper.map(spotBasicDto, spot.getClass());
        spotRepository.save(spot);
        return spot;
    }

    public List<SpotBasicDto> getSpotByTag(String tag, Pageable pageable) {

        List<SpotBasicDto> spotBasicDtos = new ArrayList<>();

        return spotBasicDtos;
    }
}
