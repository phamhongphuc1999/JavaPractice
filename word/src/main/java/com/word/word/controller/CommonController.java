package com.word.word.controller;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Common", description = "Fetch metadata, don't link to any database")
@RestController
@EnableAutoConfiguration
@RequestMapping("/common")
public class CommonController {

}
