package com.app.dao.impl;

import com.app.bean.User;
import com.app.dao.UserDAO;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

@Repository("userDAO")
public class UserDAOImpl implements UserDAO {

    @Resource(name = "sqlSessionTemplate")
    private SqlSessionTemplate sqlSessionTemplate;

    private String NAME_SPACE = "User.";

    public User getById(Integer id) {
        return sqlSessionTemplate.selectOne(NAME_SPACE + "getById", id);
    }

    public int insert(User user) {
        return sqlSessionTemplate.insert(NAME_SPACE + "insert", user);
    }

    public int update(User user) {
        return sqlSessionTemplate.update(NAME_SPACE + "update", user);
    }
}
