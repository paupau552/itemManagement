package com.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.demo.bean.CreateUserAccountBean;
import com.demo.bean.SelectUserBean;
import com.demo.bean.LoginBean;
import com.demo.bean.UserInfoBean;

@Mapper
public interface HelloMapper {

    List<SelectUserBean> selectName();
    List<UserInfoBean> selectUserInfo(String userId);
    List<SelectUserBean> selectUser(String userId, String userPw);
    void createUserAccount(String userId, String userPw);
    void createItem(String itemName, int total, int cost, int auth);
    void renewItem(String targetItemname, int total, int cost, int auth);
    void removeItem(String targetItemname);

}