package com.kmall.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kmall.common.Const;
import com.kmall.common.ServerResponse;
import com.kmall.pojo.User;
import com.kmall.service.IUserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

import javax.servlet.http.HttpSession;

/**
 * Created by geely
 */

@RestController
@Api("用户管理模板")
@RequestMapping("/manage/user")
public class UserManageController {

    @Autowired
    private IUserService iUserService;

    @ApiOperation(value="用户登录")
    @ApiImplicitParams({
    	@ApiImplicitParam(name="username",required = true,dataType = "String",paramType = "query"),
    	@ApiImplicitParam(name="password",required = true,dataType = "String",paramType = "query")
    })
    @PostMapping("login")
    public ServerResponse<User> login(@RequestParam(value="username",required = true)String username,
    		@RequestParam(value="password" ,required = true)String password, HttpSession session){
        ServerResponse<User> response = iUserService.login(username,password);
        if(response.isSuccess()){
            User user = response.getData();
            if(user.getRole() == Const.Role.ROLE_ADMIN){
                //说明登录的是管理员
                session.setAttribute(Const.CURRENT_USER,user);
                return response;
            }else{
                return ServerResponse.createByErrorMessage("不是管理员,无法登录");
            }
        }
        return response;
    }

}
