package com.app.dao;

import com.app.bean.User;
import org.springframework.stereotype.Controller;

@Controller
public interface UserDAO {

    User getById(Integer Id);

    int insert(User user);

    int update(User user);
}
