package com.dounine.springmvc.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.dounine.springmvc.entity.User;
import com.dounine.springmvc.service.UserService;
import com.dounine.springmvc.util.Email;


@Controller
public class AccessController{
	private static final Logger logger = LoggerFactory.getLogger(AccessController.class);
	private static int failNo = 0;
	@Resource
	UserService doctorService;
	@Resource
	Email sendMail;
	
	@RequestMapping("/index.html")
	public String loginasdf(){
		ModelAndView modelAndView = new ModelAndView();
		
		logger.info("into the index and welcome");
//		request.getSession().setAttribute("myuser","bush");
//		response.
//		logger.info("user is " + ((HttpServletRequest) response).getSession().getAttribute("myuser").toString());
		modelAndView.setViewName("welcome");
		
		
		return "welcome";
	}
	
	/**
	 * @param user
	 * @param code
	 * @param session
	 * @return
	 */
	@RequestMapping("/send")
	@Transactional
	public ModelAndView sendMail(User user,String code,HttpSession session){
		Map<String, Object> model=new HashMap<String, Object>();
		User userDB;
//		ModelAndView modelAndView = new ModelAndView();
//		modelAndView.addObject("sendto", msg.getSendto());
//		modelAndView.addObject("content", msg.getContent());
		

//		else{
//			model.put("error", "验证码不正确");
//			return new ModelAndView("welcome",model);
////			modelAndView.addObject("info", "���������֤�����");
//		}
		
//	    String username=user.getUsername();
//	    String password=user.getPassword();
	    //System.out.println("name-----"+name+"----password-----"+password);
//	    User user=new User();
//	    usersvo.setName(name);
//	    usersvo.setPwd(password);
	    
	    if((userDB=doctorService.getFromNamePwd(user)) == null){
//	    	session.setAttribute("failNo", failNo+1);
	    	failNo++;
	    	model.put("failNo", failNo);
			model.put("error", "账号与密码不匹配");
			return new ModelAndView("welcome",model);
	    	//	      usersvo=usersService.selectUsers(usersvo);
//	      System.out.println("�ܲ鵽��Ϣ");
//	      modelAndView.addObject("info", user.getUsername()+user.getPassword());
//	      model.put("user", user);
//	      return new ModelAndView("welcome",model);
//	    	ModelAndView modelAndView = new ModelAndView("doctor");
////			modelAndView.setViewName("doctor");
//	    	return modelAndView;
	    }
	    else if(!userDB.getRole().equals("doctor")) {
			model.put("error", "目前仅支持医生登录");
			return new ModelAndView("welcome",model);
	    }
	    
//	    logger.info("failNo"+failNo);
//	    else{
////	      System.out.println("�鲻����Ϣ");
////	      modelAndView.addObject("info", "�˺������벻ƥ��");
//	      model.put("error", "账号与密码不匹配");
//	      return new ModelAndView("welcome",model);
//	    }
		if((failNo>3) && (!code.equals(session.getAttribute("code").toString().toLowerCase()))){
			model.put("error", "验证码不正确");
			return new ModelAndView("welcome",model);			
//			if(msg.getContent().trim().length()==0||msg.getSendto().trim().length()==0){
//				modelAndView.addObject("info", "����������ݲ���Ϊ��");
//			}else{
//				studentService.add(msg);
//				sendMail.sendMail(msg.getSendto(), msg.getContent());
//			}
		}
		
		session.setAttribute("myuser", user.getUsername());
//		model.put("myuser", user.getUsername());
//		new ModelAndView("welcome",model);
		failNo = 0;
	    return new ModelAndView("doctor");
////		modelAndView.setViewName("doctor");
//    	return modelAndView;
//		return modelAndView;
	}

	@RequestMapping("/doctor")
	public void gotoDoctor(){
		logger.info("gotodoctor");
	}
}
