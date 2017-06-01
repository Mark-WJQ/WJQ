package com.wecash.wjq.service.serviceImpl;

import com.wecash.wjq.bean.User;
import com.wecash.wjq.dao.UserDao;
import com.wecash.wjq.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2016/11/17.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserDao userDao;

    public Long getIdByName(String name) {
        return userDao.getIdByName(name);
    }

    public User findByName(String name) {
        return userDao.findByName(name);
    }

    public List<User> query(Map<String, Object> params) {
        return userDao.query(params);
    }

    public static void main(String[] args){
        //TestStaticClass.getNumber();
        //TestStaticClass1.getNumber();
        /*double d = new BigDecimal("1.34222").setScale(2,BigDecimal.ROUND_HALF_UP).doubleValue();
        System.out.println(new BigDecimal("1.3434234").setScale(2,4));*/
        boolean result;
        if (!(result = false)){
            System.out.println(result + "");
        }

    }
}
