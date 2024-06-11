package GR.gacnghi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
public class ProjectController {
    @GetMapping("/gacnghi.login")
    public String LoginPage(){
        return "login";
    }

    @GetMapping("/Home")
    public String HomeNotSignIn(){
        return "homeNotSignedIn";
    }

    @GetMapping("/gacnghi.vn")
    public String HomeSignIn(){
        return "homeSignedIn";
    }

    @GetMapping("/gacnghi.signup")
    public String SignUpPage(){
        return "signup";
    }
    @GetMapping("/gacnghi.admin")
    public String AdminHome(){
        return "admin";
    }

    @GetMapping("/gacnghi.addbook")
    public String AddBookPage(){
        return "AddBook";
    }

    @GetMapping("/gacnghi/access-denied")
    public String AccessDeniedPage(){
        return "access-denied";
    }
}
