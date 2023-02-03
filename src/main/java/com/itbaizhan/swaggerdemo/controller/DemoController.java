package com.itbaizhan.swaggerdemo.controller;

import com.itbaizhan.swaggerdemo.domain.People;
import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping( "/people")
//@RequestMapping( "/people2")//看到path生效了
//@ApiIgnore//和上面类似，自带的注解，会忽略注解
@Api(tags = "人类"/*名字*/,description = "人类类"/*描述*/)
public class DemoController {


    @PostMapping( "/getPeople")
    @ApiOperation(value = "人类信息获取",notes = " 人类信息获取描述信息，提示信息")
//    @NotIncludeSwagger//加上注解就忽略了
//    @ApiIgnore//和上面类似，自带的注解，会忽略注解
    @ApiImplicitParam(name = "id",value = "编号",required = true,paramType = "path",dataType = "string")//某个参数配置,类似@ApiParam
//    @ApiImplicitParams(value={@ApiImplicitParam(name= "id",value = "编号",required = true),@ApiImplicitParam(name= "name",value = "姓名",required = true)})//常用在多个参数配置

    public People getPeople(Long id, @ApiParam(value = "描述信息",required = true,name = "name") String name){
        People peo = new People();
        peo.setId(id);
        peo.setName(name);
        peo.setAddress("海淀");
        return peo;
    }
}

