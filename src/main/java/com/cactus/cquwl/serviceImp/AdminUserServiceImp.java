package com.cactus.cquwl.serviceImp;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSONObject;
import com.cactus.cquwl.Util.TextUtil;
import com.cactus.cquwl.dao.IAdminUserDao;
import com.cactus.cquwl.dao.IAdminUserPermissionDao;
import com.cactus.cquwl.pojo.AdminUser;
import com.cactus.cquwl.service.IAdminUserService;
import com.cactus.cquwl.shiro.Md5Util;

import Exception.CustomException;

@Service
public class AdminUserServiceImp implements IAdminUserService{

	@Autowired  
	private IAdminUserDao adminUserDao;
	
	/**** 
     * 通过用户名id获取用户对象 
     *  
     * @param userid
     * @return 
     */ 
	@Transactional
	public AdminUser readAdminUserById(int id) {
		// TODO Auto-generated method stub
		return this.adminUserDao.selectAdminUserById(id);
	}
	
	/**** 
     * 通过用户名获取用户对象 
     *  
     * @param username 
     * @return 
     */  
	@Transactional
    public AdminUser getUserByUserName(String username) {  
    	AdminUser user = (AdminUser) adminUserDao.findAdminUserByUserName(username);  
        return user;  
    }  
  
    /*** 
     * 通过用户名获取权限资源 
     *  
     * @param username 
     * @return 
    
    public List<String> getPermissionsByUserName(String username) {  
        System.out.println("调用");
        AdminUser user = getUserByUserName(username);  
        if (user == null) {  
            return null;  
        }
        List<String> list = new ArrayList<String>();  
        // System.out.println(user.getUserRoles().get(0).get);  
        for (AdminRole role : user.getRoles()) {
            List<AdminPermission> permissions = adminPermissionDao.findPermissionById(role.getRoleId());
            for (AdminPermission p : permissions) {  
                list.add(p.getPermissionURL());  
            }  
        }  
        return list;  
    }
 */  
	@Transactional
	public AdminUser selectAdminUserByPhone(String phone) {
		// TODO Auto-generated method stub
		AdminUser user = (AdminUser) adminUserDao.selectAdminUserByPhone(phone);  
        return user;
	}

	@Transactional
	public List<String> getPermissionsByUserName(String username) {
		// TODO Auto-generated method stub
		return null;
	}  

	@Transactional
	public AdminUser authenticat(String phone,String pwd) throws Exception{
		 if(TextUtil.isEmpty(phone)|| TextUtil.isEmpty(pwd))
			 return null;
		 
		 AdminUser user=adminUserDao.selectAdminUserByPhone(phone);
		  if(user==null){
              throw new CustomException("用户不存在！");
          }
		  if(!user.getPassword().equals(Md5Util.md5Encode(pwd))){
			  throw new CustomException("账号或密码错误！");
		  }
		  return user;
	 }

	@Override
	@Transactional
	public AdminUser saveAdminUser(AdminUser user) {
		// TODO Auto-generated method stub
		if(TextUtil.isNullObject(user))
			return null;
		return adminUserDao.saveAdminUser(user);
	}

}
