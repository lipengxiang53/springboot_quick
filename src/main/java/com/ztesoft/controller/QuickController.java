package com.ztesoft.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Auther Lee53
 * @Date 2019-11-11 22:23
 */
@Controller
public class QuickController {
    @ResponseBody
    @RequestMapping("/quick")
    public String quick(){
        return "Hello ";
    }
}
