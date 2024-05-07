package GR.gacnghi.controller;

import GR.gacnghi.entity.User;
import GR.gacnghi.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/SignUpPage")
public class UserController {
    private UserService userService;

    public UserController(UserService theUserService) {
        userService = theUserService;
    }

    @PostMapping("/save")
    public String saveUser(@ModelAttribute("user") User theUser) {

        // save the user
        userService.save(theUser);

        // use a redirect to prevent duplicate submissions
        return "redirect: LoginPage";
    }
}
