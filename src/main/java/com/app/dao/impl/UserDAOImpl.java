package com.app.dao.impl;

import com.app.bean.User;
import com.app.dao.UserDAO;
import org.springframework.stereotype.Repository;

@Repository("userDAO")
public class UserDAOImpl implements UserDAO {

    private String SQLMAP_SPACE = "USER.";

    public User getById(Integer Id) {
        return null;
    }

    public int insert(User user) {
        return 0;
    }

    public int update(User user) {
        return 0;
    }
}
