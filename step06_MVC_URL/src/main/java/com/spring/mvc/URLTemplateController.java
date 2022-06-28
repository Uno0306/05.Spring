package com.spring.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import model.domain.Customer;

@Controller
public class URLTemplateController {
		
	// http://localhost:8080/mvc/urlTest.do/1
	@GetMapping(value = "urlTest.do/{id}")
	public String urlTest1(@PathVariable int id) {
		System.out.println("value = " + id);
		return "forward:../view.jsp";
	}
	
	// Model API 활용하기
	// http://localhost:8080/mvc/urlTest2.do/1/home/27 
	// -> id/age --> view.jsp
	// 객체로 다 가져오기
//	@GetMapping(value = "urlTest2.do/{id}/home/{age}")
//	public ModelAndView urlTest2(@ModelAttribute("customer") Customer customer) {
//		System.out.println("value = " + customer);
//		ModelAndView model = new ModelAndView();
//		model.setViewName("view2");
//		return model;
//	}

	// 하나씩 가져오기
//	@GetMapping(value = "urlTest2.do/{id}/home/{age}")
//	public ModelAndView urlTest2(@PathVariable int id, @PathVariable int age) {
//		System.out.println("value = " + id + ", " + age);
//		ModelAndView model = new ModelAndView();
//		model.setViewName("view2");
//		
//		return model;
//	}
	
	@GetMapping(value = "urlTest2.do/{id}/home/{age}")
	public String urlTest2(@ModelAttribute("id") int id, @ModelAttribute("age") int age) {
		System.out.println("value = " + id + ", " + age);
		
		return "forward:../../../view.jsp";
	}

//	@GetMapping(value = "urlTest2.do/{id}/home/{age}")
//	public String urlTest2(@RequestParam("id") int id, @RequestParam("age") int age) {
//		System.out.println("value = " + id + ", " + age);
//		ModelAndView model = new ModelAndView();
//		model.addObject("id", id);
//		model.addObject("age", age);
////		model.setViewName("view2");
//		
//		return "forward:/view.jsp";
//	}

		
	
}
