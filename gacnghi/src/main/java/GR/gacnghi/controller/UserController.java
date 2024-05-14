package GR.gacnghi.controller;

import GR.gacnghi.entity.User;
import GR.gacnghi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class UserController{
    @Autowired
    private UserService service;

    @PostMapping("/save")
    public String addUser(@ModelAttribute User user) {
        service.save(user);
        return "redirect:/gacnghi.login";
    }

    @GetMapping("/gacnghi.admin.user_list")
    public ModelAndView getAllUser(){
        List<User>list = service.getAllUser();
        return new ModelAndView("UserList", "user",list);
    }

    @RequestMapping("/editUser/{id}")
    public String editUser(@PathVariable("id") int id, Model model) {
        User user = service.getUserById(id);
        model.addAttribute("user",user);
        return "UserEdit";
    }

    @PostMapping("/editUser")
    public String EditUser(@ModelAttribute User user) {
        service.save(user);
        return "redirect:/gacnghi.admin.user_list";
    }

    @RequestMapping("/deleteUser/{id}")
    public String deleteUser(@PathVariable("id")int id) {
        service.deleteById(id);
        return "redirect:/gacnghi.admin.user_list";
    }
    
}
