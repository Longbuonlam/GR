package GR.gacnghi.controller;

import GR.gacnghi.entity.User;
import GR.gacnghi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.Objects;

@Controller
public class LoginController {
    @Autowired
    private UserService service;

    @GetMapping("/login")
    public String loginUser(@ModelAttribute User user){
        User oauthUser = service.login(user.getName(), user.getPassword());
        System.out.print(oauthUser + " logged in!");
        System.out.println();
        if(Objects.nonNull(oauthUser) && "Enable".equals(oauthUser.getStatus())){
            if ("ADMIN".equals(oauthUser.getRole())) {
                return "redirect:/gacnghi.admin";
            }else {
                return "redirect:/gacnghi.vn";
            }

        } else {
            return "redirect:/gacnghi.login";

        }
    }

}
