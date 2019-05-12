package com.wjq.order.service.impl;

import com.wjq.order.dao.TesttableMapper;
import com.wjq.order.model.Testtable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by wangjianqiang on 2019/2/21.
 */
@Component
public class TestTableService {

    @Autowired
    TesttableMapper testtableMapper;

    @Transactional
    public void update(){
        Testtable testtable = new Testtable();
        testtable.setTestId(1);
        testtableMapper.delete(testtable);
        System.out.println(1/0);
    }

}
