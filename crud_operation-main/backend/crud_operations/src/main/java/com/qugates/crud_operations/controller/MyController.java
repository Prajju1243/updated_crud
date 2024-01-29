package com.qugates.crud_operations.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.qugates.crud_operations.dto.User;
import com.qugates.crud_operations.service.UserService;

import jakarta.servlet.http.HttpSession;

@Controller
public class MyController {

	@Autowired
	UserService service;

	@GetMapping("/signup")
	public String loadmain() {
		return "/html/signup";
	}

	@GetMapping("/")
	public String loadmain1() {
		return "/html/Login1";
	}

	@PostMapping("/signup")
	public String signup(User user, HttpSession session) {
		return service.signup(user, session);
	}

	@PostMapping("/login")
	public String login(User user, HttpSession session) {
		return service.login(user, session);
	}

	@GetMapping("/home")
	public String loadHome() {
		return "/html/project.html";
	}

	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.removeAttribute("user");
		session.setAttribute("pass", "Logout Success");
		return "redirect:/";
	}

	@GetMapping("/sql")
	public String loadSql() {
		return "html/sql";
	}

	@GetMapping("/web")
	public String loadWeb() {
		return "html/web";
	}

	@GetMapping("/java")
	public String loadJava() {
		return "html/java";
	}

}
