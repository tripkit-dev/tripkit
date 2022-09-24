package com.tripkit.lighthouse.service;

import com.tripkit.lighthouse.data.ModelMapperUtils;
import com.tripkit.lighthouse.data.dto.SpotBasicDto;
import com.tripkit.lighthouse.data.entity.Spot;
import com.tripkit.lighthouse.repository.SpotRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SpotService {

    private final SpotRepository spotRepository;
    private final ModelMapperUtils modelMapperUtils;

    public List<Spot> getSpotByCategory(String category, Pageable pageable) {
        List<Spot> spots = new ArrayList<>();
        spots = spotRepository.findAllByCategoryIn(category, pageable);

        return spots;
    }

    public Spot addSpot(SpotBasicDto spotBasicDto) {
        Spot spot = new Spot();
        spot = modelMapperUtils.getModelMapper().map(spotBasicDto, spot.getClass());

        spotRepository.save(spot);
        return spot;
    }
}
