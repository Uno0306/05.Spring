package com.spring.api;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = {"http://localhost:3000"})
public class DeployRestController {
	
	@GetMapping("/deploy")
	public String deploytTest() {
		return "배포 테스트 RestController 입니다.";
	}

}
