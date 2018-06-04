package com.cactus.cquwl.shiro;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cactus.cquwl.pojo.AdminUser;
import com.cactus.cquwl.service.IAdminUserService;

@Component
public class MyShiroRealm extends AuthorizingRealm{

	@Autowired
	private IAdminUserService accountService;

	/*** 
     * 获取授权信息   ---权限的验证
     */  
    @Override  
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection pc) {  
        //根据自己系统规则的需要编写获取授权信息，这里为了快速入门只获取了用户对应角色的资源url信息  
    	// 获取登陆时输入的用户名
        String username = (String) pc.fromRealm(getName()).iterator().next();  
        // 到数据库查是否由此对象
        AdminUser user=accountService.getUserByUserName(username);
        //判断是否为空
        if (user != null) {
        	//权限信息对象info,用来存放查出的用户的所有的角色（role）及权限（permission）
        	SimpleAuthorizationInfo info = new SimpleAuthorizationInfo(); 
        	//info.setRoles(user.getRoles());
        	return info;
        	
           /* List<String> pers = accountService.getPermissionsByUserName(username);  
            if (pers != null && !pers.isEmpty()) {  
                //SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();  
                //用户角色集合
                info.setRoles(user.getRolesName());
                //  角色定义访问权限
                for (String each : pers) {  
                    //将权限资源添加到用户信息中  
                    info.addStringPermission(each);  
                }  
                return info;  
            }  
            */
        }  
        return null;  
    }  
    /*** 
     * 获取认证信息    --- 身份认证
     */  
    @Override  
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken at) throws AuthenticationException {  
        UsernamePasswordToken token = (UsernamePasswordToken) at;  
        // 通过表单接收的用户名 
        //查出是否有此用户  
        String username = token.getUsername();  
        if (username != null && !"".equals(username)) {  
            AdminUser user = accountService.getUserByUserName(username);  
            if (user != null) {  
                return new SimpleAuthenticationInfo(token.getUsername(), token.getPassword(), getName());  
            }  
        }
        return null;  
    }  
    
}
