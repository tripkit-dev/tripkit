package com.tripkit.lighthouse.service;

import com.tripkit.lighthouse.data.ModelMapperUtils;
import com.tripkit.lighthouse.data.dto.SpotBasicDto;
import com.tripkit.lighthouse.data.dto.SpotFullDto;
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

    private final SpotRepository spotRepository;

    public List<SpotBasicDto> getSpotByCategory(String category, Pageable pageable) {
        List<Spot> spots = new ArrayList<>();
        List<SpotBasicDto> spotBasicDtos = new ArrayList<>();
        spots = spotRepository.findAllByCategoryIn(category, pageable);

        ModelMapper modelMapper = ModelMapperUtils.getModelMapper();

        for (Spot spot : spots) {
            spotBasicDtos.add(modelMapper.map(spot, SpotBasicDto.class));
        }

        return spotBasicDtos;
    }

    public Spot addSpot(SpotBasicDto spotBasicDto) {
        Spot spot = new Spot();
        spot = getModelMapper().map(spotBasicDto, spot.getClass());

        spotRepository.save(spot);
        return spot;
    }
}
