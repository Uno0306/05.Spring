package com.spring.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import model.domain.Customer;

@Controller
@RequestMapping("session")
@SessionAttributes({"job", "id", "age", "customer"})
public class SessionController {

	// Cookie
	@RequestMapping("/cookieTest.do")
	public String cookieTest(@CookieValue("id") String ids) {
		return "redirect:/cookieView.jsp";
	}

	// Session
//	@GetMapping("session/sessionTest1.do")
	@GetMapping("sessionTest1.do")
	public String sessionTest1(HttpSession session) {
		session.setAttribute("job", "programmer");
		return "redirect:/sessionView1.jsp";
	}

	// job 세션 데이터 삭제
//	@GetMapping("session/jobDelete.do")
	@GetMapping("jobDelete.do")
	public String jobDelete(@ModelAttribute("job") String job, SessionStatus status) {
		// 세션 무효화
		status.setComplete();
		return "redirect:/sessionView1.jsp";
	}

	// 세션 자체를 삭제하는 메소드
//	@GetMapping("sessin/sessionDelete.do")
	@GetMapping("sessionDelete.do")
	public String sessionDelete(@ModelAttribute("id") String id, @ModelAttribute("age") int age, SessionStatus status) {
		// 세션 무효화
		status.setComplete();
		return "redirect:/sessionView1.jsp";
	}

	// http://localhost:8080/session/sessionTest2.do?id=spring&age=29
//	@GetMapping("session/sessionTest2.do")
	@GetMapping("sessionTest2.do")
	public String sessionTest2DTO(Model model, Customer customer) {
		model.addAttribute("customer", customer);
		return "redirect:/sessionView2.jsp";
	}

	// customer 객체 삭제
//	@GetMapping("session/customerDelete.do")
	@GetMapping("customerDelete.do")
	public String sessionCustomerDelete(SessionStatus status) {
		// 세션 무효화
		status.setComplete();
		return "redirect:/sessionView2.jsp";
	}


	@RequestMapping(value= "loginForm.do", method=RequestMethod.GET)
	public String moveLoginForm() {
		
		return "loginForm";
	}
	
	
	@RequestMapping(value="login.do", method=RequestMethod.POST)
	public String login(HttpSession session, String password, HttpServletResponse response ) {
		System.out.println(password);
		
		
		// 조건 : pw가 1234일 때, admin 인정
		// 만약 아니라면, index.jsp로 화면 전환
		if("1234".equals(password)) {
			session.setAttribute("password", password);
			System.out.println("관리자님 환영합니다.");

			return "redirect:/index.jsp";
		}else {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out;
			try {
				System.out.println("관리자 아님");
				out = response.getWriter();
				out.println("<script language='javascript'>");
				out.println("alert('비밀번호가 틀립니다.')");
				out.println("</script>");
				
				out.flush();
//				return "../../index";
				return "loginForm";
			} catch (IOException e) {
				e.printStackTrace();
			}finally {
			}

		}
		return null;
	}
	
	@RequestMapping(value ="logout.do")
	public String logout(HttpSession session) {
		
		// index.jsp의 로그아웃 버튼 클릭시
		// 해당 세션은 해제 중 -> index.jsp로 화면 전환s
		session.invalidate();
		return "redirect:/index.jsp";
	}
	
	
	
}
