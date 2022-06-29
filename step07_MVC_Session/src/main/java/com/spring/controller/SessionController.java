package com.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SessionController {
	
	@RequestMapping("/cookieTest.do")
	public String cookieTest(@CookieValue("id") String ids) {
		System.out.println("Cookie : " + ids);
		return "redirect:/cookieView.jsp";
	}
}
