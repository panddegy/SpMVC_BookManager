package com.biz.book.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.biz.book.model.RentVO;
import com.biz.book.service.RentService;

@Controller
@RequestMapping("/rent")
public class RentController {

	@Autowired
	RentService rentService;
	
	@RequestMapping(value="/list", method=RequestMethod.GET)
	public String viewRentList(Model model) {
		
		model.addAttribute("BODY", "RENTLIST");
		model.addAttribute("LIST", rentService.selectAllRents());
		
		return "home";
	}
	
	@RequestMapping(value="/insert", method=RequestMethod.GET)
	public String insertRent(@ModelAttribute RentVO rentVO, Model model) {
		
		model.addAttribute("BODY", "RENTWRITE");
		model.addAttribute("rentVO", rentVO);
		
		return "home";
	}
	
	@RequestMapping(value="/insert", method=RequestMethod.POST)
	public String insertRent(@ModelAttribute RentVO rentVO, Model model, String _t) {
		
		int ret=rentService.insertRent(rentVO);
		
		if(ret>0) model.addAttribute("STATUS", "Insert Successed");
		else model.addAttribute("STATUS", "Insert Failed");
		
		return "redirect:/";
	}
	
	@RequestMapping(value="/update", method=RequestMethod.GET)
	public String updateRent(@ModelAttribute RentVO rentVO, @RequestParam long rent_seq, Model model) {
		
		model.addAttribute("BODY", "RENTWRITE");
		model.addAttribute("rentVO", rentService.findByRentID(rent_seq));
		
		return "home";
	}
	
	@RequestMapping(value="/update", method=RequestMethod.POST)
	public String updateRent(@ModelAttribute RentVO rentVO, Model model) {
		
		int ret=rentService.updateRent(rentVO);
		
		if(ret>0) model.addAttribute("STATUS", "Update Successed");
		else model.addAttribute("STATUS", "Update Failed");
		
		return "redirect:/";
	}
	
	@RequestMapping(value="/delete", method=RequestMethod.GET)
	public String deleteRent(@RequestParam long rent_seq, Model model) {
		
		int ret=rentService.deleteRent(rent_seq);
		
		if(ret>0) model.addAttribute("STATUS", "Delete Successed");
		else model.addAttribute("STATUS", "Delete Failed");
		
		return "redirect:/";
	}
	
	@RequestMapping(value="/find", method=RequestMethod.GET)
	public String findByRentISBN(@RequestParam String book_isbn, Model model) {
		
		model.addAttribute("BODY", "RENTLIST");
		model.addAttribute("LIST", rentService.findByRentISBN(book_isbn));
		
		return "home";
	}
	
	@RequestMapping(value="/search", method=RequestMethod.GET)
	public String findByRentDate(@RequestParam String searchDate, Model model) {
		
		model.addAttribute("BODY", "RENTLIST");
		model.addAttribute("LIST", rentService.selectAllRents());
		
		return "home";
	}
	
}





















