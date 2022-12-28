package com.tripkit.lighthouse.controller;

import com.tripkit.lighthouse.data.dto.SpotBasicDto;
import com.tripkit.lighthouse.service.SpotService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/spots")
public class SpotController {

    private final SpotService spotService;

    // 카테고리별 장소 불러오기. 카테고리는 data/SpotCategory 참고
    @GetMapping("/category")
    public List<SpotBasicDto> getSpotByCategory(
            @RequestParam(required = false, defaultValue = "카페") String category,
            @PageableDefault(size = 10, sort = "date", direction = Sort.Direction.DESC) Pageable pageable) {

        return spotService.getSpotByCategory(category, pageable);
    }

    // 태그별 장소 불러오기. 태그는 data/SpotTag 참고
    @GetMapping("/tag")
    public List<SpotBasicDto> getSpotByTag(
            @RequestParam(required = false, defaultValue = "육식") String tag,
            @PageableDefault(size = 10, sort = "title", direction = Sort.Direction.DESC) Pageable pageable) {

        return spotService.getSpotByTag(tag, pageable);
    }

    // TODO 좋아요한 장소들만 불러오기
    @GetMapping("/title")
    public String getSpotByTitle(
            @RequestParam(required = false) String title,
            @PageableDefault(size = 10, sort = "title", direction = Sort.Direction.DESC) Pageable pageable) {

        return spotService.getSpotByTitle(title, pageable);
    }

    @GetMapping("/search")
    public String getSpotSearch(
            @RequestParam(required = false, defaultValue = "서울역 카페") String query,
            @PageableDefault(size = 10, sort = "title", direction = Sort.Direction.DESC) Pageable pageable) {

        return spotService.getSpotSearch(query, pageable);
    }

    @PostMapping("/")
    public SpotBasicDto addSpot(@RequestBody SpotBasicDto spotBasicDto) {
        return spotService.addSpot(spotBasicDto);
    }
}
