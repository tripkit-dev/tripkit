package com.tripkit.lighthouse.controller;

import com.tripkit.lighthouse.service.LineService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/lines")
public class LineController {

    private LineService lineService;
}
