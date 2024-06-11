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
        user.setRole("USER");
        user.setStatus("Enable");
        service.save(user);
        System.out.println("Create new user: " + user);
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

    @PostMapping("/saveEditUser")
    public String saveEditUser(@ModelAttribute User user) {
        service.save(user);
        return "redirect:/gacnghi.admin.user_list";
    }

    @RequestMapping("/deleteUser/{id}")
    public String deleteUser(@PathVariable("id")int id) {
        service.deleteById(id);
        return "redirect:/gacnghi.admin.user_list";
    }

    @GetMapping("/api/userinfo")
    @ResponseBody
    public User getUserInfo(@RequestParam String username){
        return  service.findByName(username);
    }
    
}
