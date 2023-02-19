package com.fufn.task.controller;

import com.fufn.task.entity.Code;
import com.fufn.task.service.CodeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1")
@RequiredArgsConstructor
public class CodeController {

    private final CodeService codeService;

    @GetMapping(value = "/codes")
    public Code getCode(){
        return codeService.getCode();
    }

}
