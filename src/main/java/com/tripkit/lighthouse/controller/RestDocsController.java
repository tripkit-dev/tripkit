package com.tripkit.lighthouse.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/docs")
public class RestDocsController {
    @GetMapping
    public String docs()  {
        return "html/docs/rest-test-api-guide";
    }
}
