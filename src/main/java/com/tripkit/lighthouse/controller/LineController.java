package com.tripkit.lighthouse.controller;

import com.tripkit.lighthouse.data.dto.LineBasicDto;
import com.tripkit.lighthouse.service.LineService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/lines")
public class LineController {

    private LineService lineService;

    @GetMapping("user")
    public List<LineBasicDto> getLineByUser(
            @RequestParam String userName,
            @PageableDefault(size = 10, sort = "date", direction = Sort.Direction.DESC) Pageable pageable
    ) {
        return lineService(userName, pageable);

    }
}
