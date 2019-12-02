package org.kor.mv.test;


import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
import org.junit.Test;

public class AuthenticationTest {

	@Test
	public void testLoginAndLogout() {
		Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:shiro/shiro.ini");
		SecurityManager securityManager = factory.getInstance();
		SecurityUtils.setSecurityManager(securityManager);
		
		Subject subject = SecurityUtils.getSubject();
		UsernamePasswordToken token = new UsernamePasswordToken("zhang","123");
		try {
			
			subject.login(token);
			System.out.println("SUCCESS");
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("ERROR");
		}
	}
	
	@Test
	public void testCustomRealm() {
		Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:shiro/shiro-realm.ini");
		SecurityManager securityManager = factory.getInstance();
		SecurityUtils.setSecurityManager(securityManager);
		
		Subject subject = SecurityUtils.getSubject();
		UsernamePasswordToken token = new UsernamePasswordToken("zhang","123");
		try {
			
			subject.login(token);
			System.out.println("SUCCESS");
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("ERROR");
		}
	}
	
	@Test
	public void testCustomRealmMD5() {
		Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:shiro/shiro-cryptography-MD5.ini");
		SecurityManager securityManager = factory.getInstance();
		SecurityUtils.setSecurityManager(securityManager);
		
		Subject subject = SecurityUtils.getSubject();
		UsernamePasswordToken token = new UsernamePasswordToken("zhang","123");
		System.out.println(token.getPrincipal());
		try {
			
			subject.login(token);
			System.out.println("SUCCESS");
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("ERROR");
		}
	}
}
