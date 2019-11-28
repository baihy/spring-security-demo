package com.baihy.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @projectName: spring-security-demo
 * @packageName: com.baihy.domain
 * @description:
 * @author: huayang.bai
 * @date: 2019/11/28 11:34
 */
@Data
@AllArgsConstructor
@Accessors(chain = true)
public class Premission {

    private Integer id;

    private String code;

    private String description;

    private String url;
}
