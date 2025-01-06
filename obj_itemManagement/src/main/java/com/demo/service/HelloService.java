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
    
    //ユーザ情報取得
    public List<SelectUserBean> selectUser(String userId, String userPw){
        return helloMapper.selectUser(userId,userPw);
    }
    
    //ユーザ作成
    public void createUserAccount(String userId, String userPw){
        helloMapper.createUserAccount(userId,userPw);
    }
    //アイテム追加
    public void addItem(String itemName, int total, int cost, int auth){
        helloMapper.addItem(itemName,total,cost,auth);
    }
    
    //アイテム更新
    public void updateItem(String targetItemname, int total, int cost, int auth){
        helloMapper.updateItem(targetItemname,total,cost,auth);
    }
    
    //アイテム削除
    public void deleteItem(String targetItemname){
        helloMapper.deleteItem(targetItemname);
    }
}