package top.smartpos.blog.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import top.smartpos.blog.beans.domains.CountryDomain;
import top.smartpos.blog.beans.domains.UserDomain;
import top.smartpos.blog.beans.models.UserModel;
import top.smartpos.blog.services.UserService;
import top.smartpos.blog.utils.SpringUtils;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    private List<UserDomain> getUserlist() {
        return userService.list();
    }

    @GetMapping(value = "/list")
    public ModelAndView list() {
        ModelAndView modelAndView = new ModelAndView("user/list", "users", getUserlist());
        modelAndView.addObject("title", "用户管理");
        return modelAndView;
    }

    @GetMapping(value = "/findById")
    public ModelAndView findById(@RequestParam int id) {
        ModelAndView modelAndView = new ModelAndView("/user/view", "user", userService.findById(id));
        modelAndView.addObject("title", "查看用户");
        return modelAndView;
    }

    @GetMapping(value = "/form")
    public ModelAndView form() {
        ModelAndView modelAndView = new ModelAndView("user/form", "user", new UserDomain());
        modelAndView.addObject("title", "创建用户");
        return modelAndView;
    }


    @PostMapping(value = "/saveOrUpdate")
    public ModelAndView saveOrUpdate() throws Exception {
        UserModel userModel = SpringUtils.validateAndThrow(UserModel.class);
        userService.saveOrUpdate(userModel);
        return new ModelAndView("redirect:/user/list");
    }

    @GetMapping(value = "/update")
    public ModelAndView update(@RequestParam int id) {
        ModelAndView modelAndView = new ModelAndView("user/form", "user", userService.findById(id));
        modelAndView.addObject("title", "修改用户");
        return modelAndView;
    }

    @GetMapping(value = "/delete")
    public ModelAndView delete(@RequestParam int id) {
        userService.delete(id);
        return new ModelAndView("redirect:/user/list");
    }
}
