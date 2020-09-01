package com.awesome.benxiaojia.controller.api;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;

import java.io.FileWriter;
import java.util.HashMap;
import java.util.Map;


@Slf4j
@RunWith(SpringRunner.class)
//@SpringBootTest
class UmsAdminControllerTest {
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Test
    void createPassword() {
        log.info(passwordEncoder.encode("123456"));
    }
    @Test
    public void generatorTest() throws java.io.IOException{

        //构造模板引擎
        ClassLoaderTemplateResolver resolver = new ClassLoaderTemplateResolver();
        resolver.setPrefix("templates/generator/");//模板所在目录，相对于当前classloader的classpath。
        resolver.setSuffix(".tpl");//模板文件后缀
        resolver.setTemplateMode(TemplateMode.TEXT);
        TemplateEngine templateEngine = new TemplateEngine();
        templateEngine.setTemplateResolver(resolver);

        //构造上下文(Model)
        Context context = new Context();
        Map<String,String> map = new HashMap<>(16);
        map.put("id","id");
        map.put("name","name");
        context.setVariable("name",map);

        //渲染模板
        FileWriter write = new FileWriter("src\\main\\java\\com\\awesome\\benxiaojia\\model\\Model.java");
        templateEngine.process("model", context, write);

    }




}
