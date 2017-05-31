package com.app.action;

import com.app.bean.User;
import com.app.service.UserBaseService;
import com.app.utils.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;


@Controller
@RequestMapping(value = "/user")
public class UserAction {

    private static Logger logger = LoggerFactory.getLogger(UserAction.class);

    @Resource(name = "userBaseService")
    private UserBaseService userBaseService;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String userLogin(@ModelAttribute User user, ModelMap model) {
        Result result = new Result();
        if(null != user) {
            result = userBaseService.userLogin(user);
        }

        if(!result.isSuccess()) {
            return "/user/login";
        } else {
            model.addAttribute("user", user);
            return "/index";
        }
    }

    @RequestMapping(value = "/hello")
    public String hello() {
        return "/index";
    }
}
