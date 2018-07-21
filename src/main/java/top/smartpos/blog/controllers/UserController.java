package top.smartpos.blog.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import top.smartpos.blog.beans.domains.UserDomain;
import top.smartpos.blog.services.UserService;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping(value = "/list")
    public ModelAndView list(@RequestParam(defaultValue = "1") int pageNumber, @RequestParam(defaultValue = "2") int pageSize) {
        List<UserDomain> users = userService.list(pageNumber, pageSize);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("users/list");
        modelAndView.addObject("users", users);
        modelAndView.addObject("title", "用户展示列表");
        return modelAndView;
    }

    @GetMapping(value = "/form")
    public ModelAndView form() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("users/form");
        modelAndView.addObject("title", "创建用户表单");
        return modelAndView;
    }

    @GetMapping(value = "/findById")
    public UserDomain findById(@RequestParam int id) {
        return userService.findById(id);
    }

    @PostMapping(value = "/save")
    public long save(@RequestParam @NotBlank @NotNull String name, @RequestParam @NotBlank @NotNull String email) {
        System.out.println("nihao1");
        System.out.println(name);
        System.out.println(email);
        System.out.println("nihao2");
        return userService.save(name, email);
    }

    @GetMapping(value = "/update")
    public long update(@RequestParam int id, @RequestParam String name) {
        return userService.update(id, name);
    }

    @GetMapping(value = "/delete")
    public long delete(@RequestParam int id) {
        return userService.delete(id);
    }
}
