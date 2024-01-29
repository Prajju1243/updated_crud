package com.qugates.crud_operations.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.qugates.crud_operations.dao.UserDao;
import com.qugates.crud_operations.dto.User;

import jakarta.servlet.http.HttpSession;

@Service
public class UserService {

	@Autowired
	UserDao dao;

	public void removeSession() {
		ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) RequestContextHolder
				.getRequestAttributes();
		HttpSession session = servletRequestAttributes.getRequest().getSession();
		session.removeAttribute("pass");
		session.removeAttribute("fail");
	}

	public String signup(User user, HttpSession session) {
		if (dao.checkEmail(user.getEmail())) {
			session.setAttribute("fail", "Email Already Exists Enter Different Email");
			return "redirect:/signup";
		} else {
			dao.save(user);
			session.setAttribute("pass", "Account Created Success");
			return "redirect:/";
		}
	}

	public String login(User user, HttpSession session) {
		User user2 = dao.findByEmail(user.getEmail());
		if (user2 == null) {
			session.setAttribute("fail", "Invalid Email");
			return "redirect:/";
		} else {
			if (user2.getPassword().equals(user.getPassword())) {
				session.setAttribute("user", user2);
				session.setAttribute("pass", "Login Success");
				return "redirect:/home";
			} else {
				session.setAttribute("fail", "Invalid Password");
				return "redirect:/";
			}
		}
	}

}
