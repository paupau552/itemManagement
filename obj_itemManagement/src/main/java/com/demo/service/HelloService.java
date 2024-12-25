package com.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.bean.CreateUserAccountBean;
import com.demo.bean.SelectUserBean;
import com.demo.bean.LoginBean;
import com.demo.bean.UserInfoBean;
import com.demo.mapper.HelloMapper;

@Service
public class HelloService {

    @Autowired
    private HelloMapper helloMapper;

    public List<SelectUserBean> selectName(){
        return helloMapper.selectName();
    }
    
    public List<UserInfoBean> selectUserInfo(String userId){
        return helloMapper.selectUserInfo(userId);
    }
    
    //userInfoSelect
    public List<SelectUserBean> selectUser(String userId, String userPw){
        return helloMapper.selectUser(userId,userPw);
    }
    
    //createUserAccount
    public void createUserAccount(String userId, String userPw){
        helloMapper.createUserAccount(userId,userPw);
    }
    //createItem
    public void createItem(String itemName, int total, int cost, int auth){
        helloMapper.createItem(itemName,total,cost,auth);
    }
    
    //renewItem
    public void renewItem(String targetItemname, int total, int cost, int auth){
        helloMapper.renewItem(targetItemname,total,cost,auth);
    }
    
    //removeItem
    public void removeItem(String targetItemname){
        helloMapper.removeItem(targetItemname);
    }
}