package edu.learn.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Need to add thymeleaf dependency
 * <dependency>
 *  <groupId>org.springframework.boot</groupId>
 *  <artifactId>spring-boot-starter-thymeleaf</artifactId>
 * </dependency>
 */
@Controller
public class IndexController {
    @RequestMapping(path = "/", method = RequestMethod.GET)
    public String index(){
        return "index";
    }
}
