package org.kor.mv.test;

import java.util.Arrays;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
import org.junit.Test;

/**
 * */
public class AuthorizationTest {
	
	
	//role authorization
	@Test
	public void testAuthorizationByRole() {
		
		Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:shiro/shiro-permission.ini");
		SecurityManager securityManager = factory.getInstance();
		SecurityUtils.setSecurityManager(securityManager);
		
		Subject subject = SecurityUtils.getSubject();
		UsernamePasswordToken token = new UsernamePasswordToken("zhang","123");
		
		try {
			subject.login(token);
		} catch (AuthenticationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("authen status:"+subject.isAuthenticated());
		
		//based on role authorization
		boolean ishasRole = subject.hasRole("role2");
		System.out.println("ishasRole:"+ishasRole);
		boolean isArrayhasRole = subject.hasAllRoles(Arrays.asList("role1","role2"));
		System.out.println("isArrayhasRole:"+isArrayhasRole);
		//based on role resource
		boolean isPermitted = subject.isPermitted("user:create:1");
		System.out.println("Single authorization permitted:"+isPermitted);
		boolean isPermittedAll = subject.isPermittedAll("user:create:1","user:delete:*");
		System.out.println("Multiple authorization permitted:"+isPermittedAll);
	}
	
	//resource authorization
	@Test
	public void testAuthorizationByResource() {
		Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:shiro/shiro-realm.ini");
		SecurityManager securityManager = factory.getInstance();
		SecurityUtils.setSecurityManager(securityManager);
		
		Subject subject = SecurityUtils.getSubject();
		UsernamePasswordToken token = new UsernamePasswordToken("zhang","123");
		
		try {
			subject.login(token);
		} catch (AuthenticationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("authen status:"+subject.isAuthenticated());
		
		//based on role resource
		boolean isPermitted = subject.isPermitted("user:create:1");
		System.out.println("Single authorization permitted:"+isPermitted);
		
		boolean isPermittedAll = subject.isPermittedAll("user:create:1","user:delete:*");
		System.out.println("Multiple authorization permitted:"+isPermittedAll);
		
	}
}
