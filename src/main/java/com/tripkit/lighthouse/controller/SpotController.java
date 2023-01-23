package com.tripkit.lighthouse.controller;

import com.tripkit.lighthouse.data.dto.SpotBasicDto;
import com.tripkit.lighthouse.data.dto.SpotDetailDto;
import com.tripkit.lighthouse.service.SpotService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/spots")
public class SpotController {

    private final SpotService spotService;

    @GetMapping("/{location}")
    public List<SpotBasicDto> getSpotByLocation(
            @PathVariable String location,
            @PageableDefault(size = 10, sort = "title", direction = Sort.Direction.DESC) Pageable pageable
    ) throws IOException {
        return spotService.getSpotByLocation(location, pageable);
    }

    @GetMapping("/{location}/{category}")
    public List<SpotBasicDto> getSpotByLocationCategory(
            @PathVariable String location,
            @PathVariable String category,
            @PageableDefault(size = 10, sort = "title", direction = Sort.Direction.DESC) Pageable pageable
    ) throws IOException {
        return spotService.getSpotByLocationCategory(location, category, pageable);
    }

    @GetMapping("/{location}/{category}/{tag}")
    public List<SpotBasicDto> getSpotByLocationCategoryTag(
            @PathVariable String location,
            @PathVariable String category,
            @PathVariable String tag,
            @PageableDefault(size = 10, sort = "title", direction = Sort.Direction.DESC) Pageable pageable
    ) throws IOException {
        return spotService.getSpotByLocationCategoryTag(location, category, tag, pageable);
    }

    @GetMapping("/{location}/{category}/{tag}/{title}")
    public SpotDetailDto getSpot(
            @PathVariable String location,
            @PathVariable String category,
            @PathVariable String tag,
            @PathVariable String title
    ) throws IOException {
        return spotService.getSpot(location, category, tag, title);
    }

    // 카테고리별 장소 불러오기. 카테고리는 data/SpotCategory 참고
    @GetMapping("/category")
    public List<SpotBasicDto> getSpotByCategory(
            @RequestParam(required = false, defaultValue = "카페") String category,
            @PageableDefault(size = 10, sort = "date", direction = Sort.Direction.DESC) Pageable pageable) throws IOException {

        return spotService.getSpotByCategory(category, pageable);
    }

    // 태그별 장소 불러오기. 태그는 data/SpotTag 참고
    @GetMapping("/tag")
    public List<SpotBasicDto> getSpotByTag(
            @RequestParam(required = false, defaultValue = "육식") String tag,
            @PageableDefault(size = 10, sort = "title", direction = Sort.Direction.DESC) Pageable pageable) throws IOException {

        return spotService.getSpotByTag(tag, pageable);
    }

    @PostMapping("")
    @ResponseBody
    public SpotBasicDto addSpot(@RequestBody SpotBasicDto spotBasicDto) {
        return spotService.addSpot(spotBasicDto);
    }

    // TODO 좋아요한 장소들만 불러오기
}
