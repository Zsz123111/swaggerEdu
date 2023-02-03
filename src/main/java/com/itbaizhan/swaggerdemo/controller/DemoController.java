package com.itbaizhan.swaggerdemo.controller;

import com.itbaizhan.swaggerdemo.domain.People;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping( "/people")
//@RequestMapping( "/people2")//看到path生效了
public class DemoController {


    @PostMapping( "/getPeople")
//    @NotIncludeSwagger//加上注解就忽略了
    public People getPeople(Long id, String name){
        People peo = new People();
        peo.setId(id);
        peo.setName(name);
        peo.setAddress("海淀");
        return peo;
    }
}

