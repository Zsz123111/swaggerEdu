package com.itbaizhan.swaggerdemo.controller;

import com.itbaizhan.swaggerdemo.config.NotIncludeSwagger;
import com.itbaizhan.swaggerdemo.domain.People;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping( "/people")
public class DemoController {


    @PostMapping( "/getPeople")
    @NotIncludeSwagger
    public People getPeople(Long id, String name){
        People peo = new People();
        peo.setId(id);
        peo.setName(name);
        peo.setAddress("海淀");
        return peo;
    }
}

