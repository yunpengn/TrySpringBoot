package org.yunpeng.tryspringboot;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
    @RequestMapping("/")
    public String index(ModelMap map) {
        map.addAttribute("title", "Welcome to this website!");
        return "/index";
    }

    @RequestMapping("/createError")
    public String createError() throws Exception {
        throw new Exception("Create some error");
    }

    @RequestMapping("/login")
    public String login() {
        return "login";
    }
}
