package com.wecash.wjq.bean;

import lombok.Data;
import lombok.Getter;

import java.util.Date;

/**
 * Created by Administrator on 2016/11/17.
 */
@Data
public class User {
    private Long id;

    private Long roleId;

    private String roleName;

    private Long positionId;

    private String positionName;

    private Date createDate;	//创建时间

    private String email;	//邮箱

    private Integer isdel;	//是否删除    0:不删除 	1:删除

    private String lastOprationUser;	//最后操作人

    private String password;	//密码

    private String phone;	//电话

    private String username;	//用户名

    private String realname;	//真实姓名

    private Long examineLimit;//审批max额度

}
