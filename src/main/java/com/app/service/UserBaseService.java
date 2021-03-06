package com.app.service;

import com.app.bean.User;
import com.app.dao.UserDAO;
import com.app.dao.impl.UserDAOImpl;
import com.app.utils.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("userBaseService")
public class UserBaseService {

    private static Logger logger = LoggerFactory.getLogger(UserBaseService.class);

    @Resource(name = "userDAO")
    private UserDAO userDAO;

    public Result userLogin(User user) {
        Result result = new Result();
        if(null != user.getName() && !"".equals(user.getName())
                && null != user.getPassword() && !"".equals(user.getPassword()) ) {
            result.setSuccess(userDAO.login(user) == 1);
            logger.info("===================用户"+ user.getName() +"登录成功=================");
        } else {
            result.setSuccess(false);
            result.setMsg("输入参数错误！");
        }
        return result;
    }
}
