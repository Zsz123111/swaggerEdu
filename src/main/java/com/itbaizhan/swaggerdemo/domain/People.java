package com.itbaizhan.swaggerdemo.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "人类",description = "人类类描述")
public class People {
    @ApiModelProperty(value = "编号",required = true,name = "id",example = "张三")
    private Long id;
    private String name;
    private String address;
}
