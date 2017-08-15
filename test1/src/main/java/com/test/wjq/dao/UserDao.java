package com.test.wjq.dao;

import com.test.wjq.bean.User;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2016/11/17.
 */
@Repository
public interface UserDao {
    Long getIdByName(String name);
    User findByName(String name);
    List<User> query(Map<String,Object> params);
}
