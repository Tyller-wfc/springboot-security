package cn.wfc.security.controller;

import cn.wfc.security.bean.LayuiTableResult;
import cn.wfc.security.bean.User;
import cn.wfc.security.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    @GetMapping("/getUsers")
    public LayuiTableResult<User> getUsers(){
        List<User> users =  userService.getUsers();
        LayuiTableResult<User> result = new LayuiTableResult<>(users);
        return result;
    }
}
