package com.biz.book.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.biz.book.model.AdminVO;
import com.biz.book.model.SearchVO;
import com.biz.book.service.LoginService;

@Controller
public class HomeController {
	
	@Autowired
	LoginService loginService;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(HttpSession session, Model model, @ModelAttribute AdminVO adminVO, @ModelAttribute SearchVO searchVO) {
		
		if(session.getAttribute("Admin")==null) {
			model.addAttribute("BODY", "LOGIN");
			model.addAttribute("adminVO", adminVO);
		}
		else {
			model.addAttribute("BODY", "HOME");
			model.addAttribute("searchVO", searchVO);
		}
		
		return "home";
	}
	
	@RequestMapping(value="login", method=RequestMethod.POST)
	public String login(HttpSession session, Model model, @ModelAttribute AdminVO adminVO) {
		
		if(loginService.findByAdminID(adminVO)) {
			model.addAttribute("BODY", "HOME");
			session.setAttribute("Admin", adminVO);
		}
		else {
			model.addAttribute("BODY", "LOGIN");
			model.addAttribute("adminVO", adminVO);
		}
		
		return "redirect:/";
	}
	
	@RequestMapping(value="logout", method=RequestMethod.GET)
	public String logout(HttpSession session, Model model, @ModelAttribute AdminVO adminVO) {
		
		session.setAttribute("Admin", null);
		session.removeAttribute("Admin");
		
		return "redirect:/";
	}
	
}











