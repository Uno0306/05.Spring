package com.spring.jdbc;


import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spring.dto.Dept;
import com.spring.service.DeptServiceImpl;


@Controller
public class DeptController {
	
	@Autowired
	private DeptServiceImpl deptService;
	
	@RequestMapping(value = "select.do", method = RequestMethod.GET)
	public String home(Locale locale, Model model, int deptno) {
		
//		System.out.println("-----------------------------"+deptService.getDeptByDeptno(10));
//		System.out.println("-----------------------------"+deptService.getDeptMap(10));
//		System.out.println("-----------------------------"+deptService.getDeptMap(deptno).get("dname"));
//		System.out.println("-----------------------------"+deptService.getAllDepts());
//		System.out.println("-----------------------------"+deptService.getAllDeptsMap());
		
//		deptService.insertDept(new Dept(50, "PROGRAMMING", "SEOUL"));
		
		// Q. update : where deptno = 50 and dname="PROGRAMMING" -> loc : MOON
//		Map<String, Object> data = new HashMap<String, Object>();
//		data.put("deptno", 50);
//		data.put("dname", "PROGRAMMING");
//		data.put("loc", "MOON");
//		deptService.updateDeptByDeptnoAndDname(data);
		
		// Q. delete : where loc = "MOON"
//		deptService.delteDept("MOON");
		
//		if(deptService.getDeptByDeptno(deptno) == null) {
//			return "home";
//		}else {
//			Dept dept  = deptService.getDeptByDeptno(deptno);
//			
//			if(deptno != 0) {
////				model.addAttribute("dept", deptService.getDeptByDeptno(deptno));
//				model.addAttribute("deptno", dept.getDeptno());
//				model.addAttribute("dname", dept.getDname());
//				model.addAttribute("loc", dept.getLoc());
////				return "../../view";
//				return "forward:/view.jsp";
//			}
//			
//		}
		return "home";
	}
	
	
	@GetMapping("depts")
	public Dept getDepts(){
		return this.deptService.getDeptByDeptno(10);
	}
	
}
