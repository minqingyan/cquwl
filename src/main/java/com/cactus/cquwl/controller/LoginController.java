package com.cactus.cquwl.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.ExcessiveAttemptsException;
import org.apache.shiro.authc.ExpiredCredentialsException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.cactus.cquwl.Util.TextUtil;
import com.cactus.cquwl.Util.TimeUtil;
import com.cactus.cquwl.pojo.AdminUser;
import com.cactus.cquwl.service.IAdminUserService;
import com.cactus.cquwl.shiro.Md5Util;

import Exception.CustomException;

@Controller  
public class LoginController {
	private Logger logger =Logger.getLogger(LoginController.class);
	@Autowired  
	private IAdminUserService userService;  
    /*** 
     * 实现用户登录 
     *  
     * @param username 
     * @param password 
     * @return 
     * @throws Exception 
     */  
    @RequestMapping(value = "/login")
    public String Login(Model model,@RequestParam String phone,@RequestParam String password,String randomcode,
    									HttpServletRequest request,HttpSession session) throws Exception {  
    	
    	 logger.error("--------- i am login ");
         //String userName =  request.getParameter("username");
        // String password =  request.getParameter("password");
         String rememberMeParam =  request.getParameter("rememberMe");
         boolean isRemberMe =true;
         //String randomcode = request.getParameter("randomcode");
         String validateCode = (String) request.getSession().getAttribute("verifyCode");
         logger.error("----------userName:"+phone);
         logger.error("----------password:"+password);
         logger.error("----------rememberMeParam:"+rememberMeParam);
         logger.error("----------randomcode:"+randomcode);
         logger.error("----------validateCode:"+validateCode);
        // if(!randomcode.equals(validateCode)){
        //     throw  new CustomException("验证码错误");
       //  }

         Subject user = SecurityUtils.getSubject();
         logger.error("------:"+Md5Util.md5Encode(password));
           UsernamePasswordToken token = new UsernamePasswordToken(phone,password);
         token.setRememberMe(true);
         try {
             user.login(token);
             System.out.println("----------:" + user.getPrincipal());
             logger.error("----是否认证："+user.isAuthenticated());
            // AdminUser activeUser=(AdminUser)user.getPrincipal();
            // System.out.println("-------:"+activeUser);
           //  Boolean hasRole = user.hasRole("商品管理员");
            // logger.error("-----单个角色认证："+hasRole);
             if (user.isAuthenticated()) {  
            	 AdminUser resultUser=userService.selectAdminUserByPhone(phone);
            	 session.setAttribute("user", resultUser);
            	 System.out.println("用户[" + phone + "]登录认证通过(这里可以进行一些认证通过后的一些系统参数初始化操作)");
            	 return "views/index";   
             } else {  
            	 token.clear();
            	 return "login"; 
             }  
         } catch ( UnknownAccountException e ) {
        	 model.addAttribute("msg", "账号密码错误");
        	 return "login"; 
           //  throw new CustomException("账号不存在！msg:"+e.getMessage());
         } catch ( IncorrectCredentialsException e ) {
        	 model.addAttribute("msg", "账号密码错误");
        	 return "login"; 
            // throw new CustomException("用户名或密码错误！msg:"+e.getMessage());
         } catch (LockedAccountException e ) {
        	 model.addAttribute("msg", "账号密码错误");
        	 return "login"; 
            // throw new CustomException("账号已锁定！msg:"+e.getMessage());
         } catch (ExcessiveAttemptsException e ) {
            // throw new CustomException("登录失败次数过多！msg:"+e.getMessage());
         }catch (ExpiredCredentialsException e){
        	 return "login"; 
           //  throw new CustomException("过期的凭证！msg:"+e.getMessage());
         }catch(Exception e){
            // throw new CustomException("账号或密码错误！msg:"+e.getMessage());
        	 return "login"; 
         }
         return "login"; 
         // DisabledAccountException（禁用的帐号）、LockedAccountException（锁定的帐号）、UnknownAccountException（错误的帐号）
         // ExcessiveAttemptsException（登录失败次数过多）、IncorrectCredentialsException （错误的凭证）、ExpiredCredentialsException（过期的凭证）等
         //验证是否登录成功

      /*   //如果登录失败从request中获取认证异常信息，shrioLoginFailure就是shiro异常类的全限定名
         String exceptionClassName = (String)request.getAttribute("shiroLoginFailure");
         System.out.println("-----------exceptionClassName:"+exceptionClassName);
         if(exceptionClassName!=null){
             if(UnknownAccountException.class.getName().equals(exceptionClassName)){
                 throw new CustomException("账户不存在！");
             }else if(IncorrectCredentialsException.class.getName().equals(exceptionClassName)){
                 throw new CustomException("账号或密码错误！");
             }else if(exceptionClassName.equals("randomCodeError")){
                 throw new CustomException("验证码错误！");
             }else{
                 throw  new CustomException("未知错误!");
             }
         }*/
       /*  可以使用配置文件登录成功跳转页面 但是现在没用*/
        
       // AdminUser user = userService.authenticat(phone, password); 

        
    }  

    @RequestMapping("/logout")  
   	public String logout(HttpServletRequest request,RedirectAttributes redirectAttributes){ 
    	SecurityUtils.getSubject().logout();
    	return "redirect:/toLogin"; 
   	 } 
    
    @RequestMapping("/403")  
	public String toError(HttpServletRequest request,Model model){  
	    return "error-404";  
	 }  
    
	@RequestMapping("/showUser")  
	public String toIndex(HttpServletRequest request,Model model){  
	    int userId = Integer.parseInt(request.getParameter("id"));  
	    AdminUser user = this.userService.readAdminUserById(userId);  
	    model.addAttribute("user", user);  
	    return "showUser";  
	 }
	
	@RequestMapping("/register")
	public String register(@ModelAttribute AdminUser user, HttpSession session,HttpServletRequest request,Model model){
		// 先验证手机号是否重复
		AdminUser returnUser = userService.selectAdminUserByPhone(user.getPhone());
		if(TextUtil.isNullObject(returnUser)){
			user.setPassword(Md5Util.md5Encode(user.getPassword()));
			user.setCreateDate(TimeUtil.getCurrentDate());
			
			user.setUserName("u_"+TextUtil.getFiveNumberRandom());
			user.setIsDelete(1);
			//保存
			userService.saveAdminUser(user);
			//跳转  转发/重定向  
			request.setAttribute("user", user);
	        session.setAttribute("user", user);
	        model.addAttribute("user",user);
	        return "views/index";
		}else{
			request.setAttribute("msg", "手机号已经注册");
			return "login";
		}
		
	}
}
