package edu.learn.controllers;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.security.Principal;

/**
 * Need to add thymeleaf dependency
 * <dependency>
 *  <groupId>org.springframework.boot</groupId>
 *  <artifactId>spring-boot-starter-thymeleaf</artifactId>
 * </dependency>
 */
@Controller
public class ThymeController {
    @RequestMapping(path = "/", method = RequestMethod.GET)
    public String index(@AuthenticationPrincipal Principal principal, Model model){
        model.addAttribute("loggedInUser",principal);
        return "index";
    }

    @RequestMapping(path = "/login", method = RequestMethod.GET)
    public String login(){
        return "login";
    }
}
