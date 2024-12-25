package com.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.demo.bean.SelectUserBean;
import com.demo.bean.LoginBean;
import com.demo.bean.UserInfoBean;
import com.demo.bean.deleteItemBean;
import com.demo.bean.updateItemBean;
import com.demo.bean.AddItemBean;
import com.demo.service.HelloService;

@Controller
public class HelloController {

    @Autowired
    private HelloService helloService;
    
    // login画面に戻る
    @RequestMapping(value="login")
    public String login(Model model) {
        return "login";
    }
    // registerUser画面に戻る
	@RequestMapping(value="registerUser")
    public String registerUser() {
        return "registerUser";
	}

	// addItem追加し、にユーザ情報画面へ
	@RequestMapping(value="addItem")
    public String addItem(Model model, AddItemBean addItemBean) {
		model.addAttribute("addItemBean",addItemBean);
        return "addItem";
	}
	
	// updateItem画面へ
	@RequestMapping(value="updateItem")
    public String delItem(Model model, updateItemBean updateItemBean) {
		model.addAttribute("updateItemBean",updateItemBean);
        return "updateItem";
	}

	// deleteItem画面へ
	@RequestMapping(value="deleteItem")
    public String deleteItem(Model model, deleteItemBean deleteItemBean) {
		model.addAttribute("updateItemBean",deleteItemBean);
        return "deleteItem";
	}
	
	//createUserAccount画面新規ユーザ作成
    @RequestMapping(value="createUserAccount")
    public String createUserAccount(Model model,@ModelAttribute("loginId") String arg1, @ModelAttribute("loginPw") String arg2) {
    	String userId = arg1;
    	String userPw = arg2;
//        List<LoginBean> list = helloService.selectUser(arg1,arg2);
        //List<HelloBean> list = helloService.selectUserInfo(arg1);
        helloService.createUserAccount(arg1, arg2);
        //model.addAttribute("list",list);
        return "login";
    }

	//createItem画面新規アイテム作成
    @RequestMapping(value="createItem")
    public String createItem(Model model, @ModelAttribute("itemName") String itemName, @ModelAttribute("total") int total, 
    		@ModelAttribute("cost") int cost, @ModelAttribute("auth") int auth, @ModelAttribute("userId") String userId) {
    	
        helloService.createItem(itemName, total, cost, auth);
    	
    	//userがしない場合、ログイン画面に戻る
    	if(userId == null){
            return "login";
    	}
    	
        List<UserInfoBean> list = helloService.selectUserInfo(userId);
        model.addAttribute("userId", userId);
        model.addAttribute("list",list);
        return "userInfo";
    }

	//updateItem画面アイテム更新
    @RequestMapping(value="renewItem")
    public String renewItem(Model model, @ModelAttribute("targetItemname") String targetItemname, @ModelAttribute("total") int total, 
    		@ModelAttribute("cost") int cost, @ModelAttribute("auth") int auth, @ModelAttribute("userId") String userId) {
    	
        helloService.renewItem(targetItemname, total,cost, auth);
    	
    	//userがしない場合、ログイン画面に戻る
    	if(userId == null){
            return "login";
    	}
    	
        List<UserInfoBean> list = helloService.selectUserInfo(userId);
        model.addAttribute("userId", userId);
        model.addAttribute("list",list);
        return "userInfo";
    }
   
	//removeItem画面アイテム更新
    @RequestMapping(value="removeItem")
    public String renewItem(Model model, @ModelAttribute("targetItemname") String targetItemname, 
    		@ModelAttribute("userId") String userId) {
    	
        helloService.removeItem(targetItemname);
    	
    	//userがしない場合、ログイン画面に戻る
    	if(userId == null){
            return "login";
    	}
    	
        List<UserInfoBean> list = helloService.selectUserInfo(userId);
        model.addAttribute("userId", userId);
        model.addAttribute("list",list);
        return "userInfo";
    }
    
    // userInfo画面に遷移
    @RequestMapping(value="userInfo")
    public String userInfo(Model model,@ModelAttribute("loginId") String arg1, @ModelAttribute("loginPw") String arg2) {
    	String userId = arg1;
    	String userPw = arg2;

    	List<SelectUserBean> select_user = helloService.selectUser(arg1, arg2);
    	
    	//userがしない場合、ログイン画面に戻る
    	if(select_user.size() == 0){
            return "login";
    	}
    	
        List<UserInfoBean> list = helloService.selectUserInfo(select_user.get(0).getUserId());
        model.addAttribute("userId", userId);
        model.addAttribute("list",list);
        return "userInfo";
    }
}