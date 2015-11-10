package com.dounine.springmvc.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
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
	
	@Resource
	UserService doctorService;
	@Resource
	Email sendMail;
	
	@RequestMapping("/index.html")
	public String loginasdf(){
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("welcome");
		logger.info("������ҳ");
		
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
		ModelAndView modelAndView = new ModelAndView("welcome");
//		modelAndView.addObject("sendto", msg.getSendto());
//		modelAndView.addObject("content", msg.getContent());
		
//		if(code.equals(session.getAttribute("code").toString().toLowerCase())){
//			if(msg.getContent().trim().length()==0||msg.getSendto().trim().length()==0){
//				modelAndView.addObject("info", "����������ݲ���Ϊ��");
//			}else{
//				studentService.add(msg);
//				sendMail.sendMail(msg.getSendto(), msg.getContent());
//			}
//		}else{
//			modelAndView.addObject("info", "���������֤�����");
//		}
		
	    String username=user.getUsername();
	    String password=user.getPassword();
	    //System.out.println("name-----"+name+"----password-----"+password);
//	    User user=new User();
//	    usersvo.setName(name);
//	    usersvo.setPwd(password);
	    Map<String, Object> model=new HashMap<String, Object>();
	    if(doctorService.getFromNamePwd(user)!=null){
//	      usersvo=usersService.selectUsers(usersvo);
	      System.out.println("�ܲ鵽��Ϣ");
	      modelAndView.addObject("info", user.getUsername()+user.getPassword());
//	      model.put("user", user);
//	      return new ModelAndView("welcome",model);
	    }else{
	      System.out.println("�鲻����Ϣ");
	      modelAndView.addObject("info", "�û������������");
//	      model.put("error", "�û������������");
//	      return new ModelAndView("welcome",model);
	    }
	    
		return modelAndView;
	}

}
