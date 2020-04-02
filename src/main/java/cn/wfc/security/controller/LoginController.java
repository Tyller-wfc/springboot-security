package cn.wfc.security.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {
    static String PATH_PREFIX = "pages/";

    @GetMapping("/")
    public String welcome() {
        return "welcome";
    }
    @GetMapping("/index")
    public String index(){
        return "index";
    }
    @GetMapping("/userLogin")
    public String userLogin(){
        return PATH_PREFIX + "login";
    }

    @GetMapping("/level1/{i}")
    public String level1(@PathVariable("i") String i) {
        return PATH_PREFIX + "level1/" + i;
    }

    @GetMapping("/level2/{i}")
    public String level2(@PathVariable("i") String i) {
        return PATH_PREFIX + "level2/" + i;
    }

    @GetMapping("/level3/{i}")
    public String level3(@PathVariable("i") String i) {
        return PATH_PREFIX + "level3/" + i;
    }
}
