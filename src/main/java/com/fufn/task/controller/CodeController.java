package com.fufn.task.controller;

import com.fufn.task.entity.Code;
import com.fufn.task.service.CodeService;
import lombok.RequiredArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1")
@RequiredArgsConstructor
public class CodeController {

    private final CodeService codeService;
    private final Logger logger = LogManager.getLogger(getClass());

    @GetMapping(value = "/codes")
    public Code getCode(){
        logger.info("GET request to get new unique code");
        return codeService.getCode();
    }

}
