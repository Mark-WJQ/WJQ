package com.wecash.wjq.service;

import com.wecash.wjq.bean.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2016/11/17.
 */

public interface UserService {
    Long getIdByName(String name);
    User findByName(String name);
    List<User> query(Map<String,Object> params);

}
