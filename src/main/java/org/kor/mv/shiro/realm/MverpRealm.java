package org.kor.mv.shiro.realm;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.authz.UnauthorizedException;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.kor.mv.dto.ActiveUser;
import org.kor.mv.mybatis.pojo.EmployeeDAO;
import org.kor.mv.mybatis.pojo.SysPermission;
import org.kor.mv.mybatis.pojo.SysUser;
import org.kor.mv.shiro.service.SysUserService;
import org.kor.mv.util.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;

public class MverpRealm extends AuthorizingRealm {

    private static final Logger LOGGER = LogManager.getLogger(MverpRealm.class);
	
	
	@Autowired
	private SysUserService sysUserService ;
    
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		// TODO Auto-generated method stub
        //String username = JWTUtil.getUsername(principals.toString());
		String username = (String) principals.getPrimaryPrincipal();
		LOGGER.debug(username);
        SysUser sysUser = new SysUser();
        
        if (username != null) {
        	sysUser = sysUserService.findSysUserByUserCode(username);;
        }
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
		List<SysPermission> permissionList = null;
		try {
			permissionList = sysUserService.findPermissionListByUserCode(sysUser.getId());
			LOGGER.debug(permissionList);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		List<String> permissions = new ArrayList<String>();
		 if (permissionList != null) {
			 for(SysPermission sysPermission:permissionList) {
				 permissions.add(sysPermission.getPercode());
			 }
		 }
        
        simpleAuthorizationInfo.addStringPermissions(permissions);
        return simpleAuthorizationInfo;
	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken auth) throws AuthenticationException {
		// TODO Auto-generated method stub
		//String token = (String) auth.getCredentials();
		UsernamePasswordToken token = (UsernamePasswordToken) auth;
		 //String username = (String) auth.getPrincipal();
		String username = (String) token.getUsername();
		 System.out.println(username);
		 SysUser sysUser = sysUserService.findSysUserByUserCode(username);
		 
		 List<SysPermission> menus = null;
		 
		 
		 if (sysUser == null) {
			 throw new UnknownAccountException();
		 }
		 
		
		 EmployeeDAO employeeDAO = new EmployeeDAO();
		 try {
				employeeDAO = sysUserService.selectEmployeeName(sysUser.getEmloyeeid()); 
				menus = sysUserService.findMenuListByUserCode(sysUser.getId());
		 }catch (Exception e) {
				 e.printStackTrace();
				 return null;
		}
		ActiveUser activeUser = new ActiveUser();
		activeUser.setId(sysUser.getId());
		activeUser.setUsercode(sysUser.getUsername());
		activeUser.setUsername(employeeDAO.getName());
		activeUser.setMenus(menus);
		 /*if (Boolean.TRUE.equals(sysUser.getLocked())) {
			 throw new LockedAccountException();
		 }*/
		System.out.println(sysUser.getUsername());
		 SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(activeUser,sysUser.getPassword(),getName());
		 
		 return authenticationInfo;

	}
	
	public void clearCache() {
		PrincipalCollection principals = SecurityUtils.getSubject().getPrincipals();
		super.clearCache(principals);
	}

}
