package com.spring.jdbc;


import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spring.dto.Dept;
import com.spring.service.DeptServiceImpl;


@Controller
public class DeptController {
	
	@Autowired
	private DeptServiceImpl deptService;
	
	@RequestMapping(value = "select.do", method = RequestMethod.POST)
	public String home(Locale locale, Model model, int deptno) {
		System.out.println(deptno);
		if(deptService.getDeptByDeptno(deptno) == null) {
			return "home";
		}else {
			System.out.println(deptService.getDeptByDeptno(deptno));
			
			Dept dept  = deptService.getDeptByDeptno(deptno);
			
			
			if(deptno != 0) {
				model.addAttribute("dept", deptService.getDeptByDeptno(deptno));
				model.addAttribute("deptno", dept.getDeptno());
				model.addAttribute("dname", dept.getDname());
				model.addAttribute("loc", dept.getLoc());
//				return "../../view";
				return "forward:/view.jsp";
			}
			
		}
		
		return "home";
	}
	
	
	
	
}
