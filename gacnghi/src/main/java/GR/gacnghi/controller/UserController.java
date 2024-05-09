package GR.gacnghi.controller;

import GR.gacnghi.entity.User;
import GR.gacnghi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController{
    @Autowired
    private UserService service;

    @PostMapping("/save")
    public String addUser(@ModelAttribute User user) {
        service.save(user);
        return "redirect:/gacnghi.login";
    }
    
}
