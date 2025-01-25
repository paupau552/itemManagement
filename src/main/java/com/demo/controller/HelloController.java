package com.demo.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.demo.bean.SelectUserBean;

import com.demo.bean.UserInfoBean;
import com.demo.bean.deleteItemBean;
import com.demo.bean.updateItemBean;
import com.demo.bean.AddItemBean;
import com.demo.bean.LoginBean;
import com.demo.service.HelloService;

@Controller
public class HelloController {

    @Autowired
    private HelloService helloService;
    
    // login画面に戻る
    @RequestMapping(value="login")
    public String login(Model model) {
    	LoginBean loginBean = new LoginBean();
    	loginBean.setUserId("");
    	loginBean.setUserPw("");
    	model.addAttribute("loginBean", loginBean);
        return "login";
    }
    // registerUser画面に戻る
	@RequestMapping(value="toRegisterUser")
    public String toRegisterUser() {
        return "toRegisterUser";
	}

	// addItem画面へ
	@RequestMapping(value="toAddItem")
    public String addItem(Model model, AddItemBean addItemBean) {
		model.addAttribute("addItemBean",addItemBean);
        return "toAddItem";
	}
	
	// updateItem画面へ
	@RequestMapping(value="toUpdateItem")
    public String toUpdateItem(Model model, updateItemBean updateItemBean) {
		model.addAttribute("updateItemBean",updateItemBean);
        return "toUpdateItem";
	}

	// deleteItem画面へ
	@RequestMapping(value="toDeleteItem")
    public String toDeleteItem(Model model, deleteItemBean deleteItemBean) {
		model.addAttribute("updateItemBean",deleteItemBean);
        return "toDeleteItem";
	}
	
	//createUserAccount画面新規ユーザ作成
    @RequestMapping(value="createUserAccount")
    public String createUserAccount(Model model,@ModelAttribute("loginId") String userId, @ModelAttribute("loginPw") String userPw) {
        helloService.createUserAccount(userId, userPw);
        return "login";
    }

	//createItem画面新規アイテム作成
    @RequestMapping(value="addItem")
    public String addItem(Model model, @ModelAttribute("itemName") String itemName, @ModelAttribute("total") int total, 
    		@ModelAttribute("cost") int cost, @ModelAttribute("auth") int auth, @ModelAttribute("userId") String userId) {
    	
        helloService.addItem(itemName, total, cost, auth);
    	
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
    @RequestMapping(value="updateItem")
    public String updateItem(Model model, @ModelAttribute("targetItemname") String targetItemname, @ModelAttribute("total") int total, 
    		@ModelAttribute("cost") int cost, @ModelAttribute("auth") int auth, @ModelAttribute("userId") String userId) {
    	
        helloService.updateItem(targetItemname, total,cost, auth);
    	
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
    @RequestMapping(value="deleteItem")
    public String deleteItem(Model model, @ModelAttribute("targetItemname") String targetItemname, 
    		@ModelAttribute("userId") String userId) {
    	
        helloService.deleteItem(targetItemname);
    	
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
    public String userInfo(@ModelAttribute @Validated  LoginBean loginBean, BindingResult result,Model model,@ModelAttribute("userId") String userId, @ModelAttribute("userPw") String userPw) {
    	
    	//入力確認
        if (result.hasErrors()) {
            return "login";
          }
    	
    	List<SelectUserBean> select_user = helloService.selectUser(userId, userPw);
    	
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