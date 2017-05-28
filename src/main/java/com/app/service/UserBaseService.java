package com.app.service;

import com.app.bean.User;
import com.app.dao.UserDAO;
import com.app.dao.impl.UserDAOImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("userBaseService")
public class UserBaseService {


    @Resource(name = "userDAO")
    private UserDAO userDAO;

    public boolean userLogin(User user) {
        userDAO = new UserDAOImpl();
        User userTemp = userDAO.getById(user.getId());
        if(null == userTemp) {
            return false;
        }
        if(!user.getName().equals(userTemp.getName())
                || !user.getPassword().equals(userTemp.getPassword())) {
            return false;
        }
        return true;
    }
}
