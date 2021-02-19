package com.wjq.remote;

import java.rmi.Remote;
import java.util.List;

/**
 * Created by wangjianqiang on 2017/10/22.
 */
public interface PersonService extends Remote {


    public List<PersonEntity> getList();

}
