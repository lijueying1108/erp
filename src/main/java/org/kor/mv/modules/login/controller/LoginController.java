package org.kor.mv.modules.login.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.kor.mv.dto.ActiveUser;
import org.kor.mv.dto.BaseResponseMessage;
import org.kor.mv.dto.ResponseErrorMessage;
import org.kor.mv.dto.ResponseSuccessMessage;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("user")
@CrossOrigin
public class LoginController{
	private Logger logger = LogManager.getLogger();
	
	@RequestMapping(value = "/auth/login", method = RequestMethod.POST)
	@ResponseBody
	public BaseResponseMessage doLogin(@RequestParam ("username") String username,@RequestParam ("password") String password) throws Exception {
		ResponseSuccessMessage resp = new ResponseSuccessMessage();
		UsernamePasswordToken token = new UsernamePasswordToken(username, password);
		ActiveUser currentUser = new ActiveUser();
        try {
        	SecurityUtils.getSubject().login(token);
        	currentUser = (ActiveUser) SecurityUtils.getSubject().getPrincipal();
        	resp.setToken(SecurityUtils.getSubject().getSession().getId());
        	resp.setData(currentUser);
        	resp.setCode("20000");
        	resp.setSuccessMsg("Login success");
            return resp;
        } catch(IncorrectCredentialsException e) {
        	return new ResponseErrorMessage("Id or password is wrong","20000");
        } catch(UnknownAccountException e) {
        	return new ResponseErrorMessage("User does not exist","20000");
        }
	}
	
	@RequestMapping(value = "/logout")
	@ResponseBody
	public BaseResponseMessage logout(HttpServletRequest request) throws Exception {
		ResponseSuccessMessage resp = new ResponseSuccessMessage();
		Subject currentUser = SecurityUtils.getSubject();
		currentUser.logout();
		
		resp.setCode("");
		resp.setCode("20000");
		resp.setSuccessMsg("logout 성공");
		return resp;
	}
	@RequestMapping(value = "/error")
	@ResponseBody
	public BaseResponseMessage error(HttpServletRequest request) throws Exception {
		ResponseSuccessMessage resp = new ResponseSuccessMessage();
		resp.setCode("");
		resp.setSuccessMsg("서버오류 발생하였습니다");
		return resp;
	}
	@RequestMapping(value = "/unauth")
	@ResponseBody
	public BaseResponseMessage unauth(HttpServletRequest request) throws Exception {
		ResponseSuccessMessage resp = new ResponseSuccessMessage();
		resp.setCode("");
		resp.setSuccessMsg("다시 로그인 하세요");
		return resp;
	}	
}
