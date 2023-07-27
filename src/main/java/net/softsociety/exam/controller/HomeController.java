package net.softsociety.exam.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class HomeController {
	
	/**
	 * 메인화면
	 * 차재헌이 홈페이지 연결했어요.
	 */
	
	/**
	 * 
	 * @return
	 */
	@GetMapping({"", "/"})
	public String home() {
		return "home";
	}
	@GetMapping("/ddddd")
	public String test() {
		return "home";
	}
}
