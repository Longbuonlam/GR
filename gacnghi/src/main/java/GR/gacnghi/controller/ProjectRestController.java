package GR.gacnghi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class ProjectRestController {
    @RequestMapping("/LoginPage")
    public String LoginPage(){
        return "login";
    }

    @RequestMapping("/Home")
    public String HomeNotSignIn(){
        return "homeNotSignedIn";
    }

    @RequestMapping("/HomePage")
    public String HomeSignIn(){
        return "homeSignedIn";
    }

    @RequestMapping("/SignupPage")
    public String SignUpPage(){
        return "signup";
    }


}
