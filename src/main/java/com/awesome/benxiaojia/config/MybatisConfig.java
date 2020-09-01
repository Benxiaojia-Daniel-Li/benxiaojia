package com.awesome.benxiaojia.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * MyBatis配置类
 */
@Configuration
@MapperScan({"com.awesome.benxiaojia.mbg.mapper","com.awesome.benxiaojia.dao"})
public class MybatisConfig {

}
