package com.cs.ssm.controller;

import com.cs.ssm.entity.User;
import com.cs.ssm.service.UserService;
import com.cs.ssm.utils.BaseException;
import com.cs.ssm.utils.BaseReult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
public class LoginController {

	@Autowired
	private UserService userService;

	@RequestMapping(value="/home", method = RequestMethod.GET)
	public String home(@CookieValue(value="JSESSIONID") String sessionId) {
		System.out.println(" CookieValue : " + sessionId);
		return "login";
	}

	@RequestMapping(value="/login", method = RequestMethod.POST)
	public String userLogin(@RequestParam("name") String name,
							@RequestParam("password")String password,
							HttpSession session, Model model) {

		try {
			User user = userService.userLogin(name, password);
			session.setAttribute("user", user);
			return "redirect:/emps/1";
		}catch(BaseException e) {
			model.addAttribute("msg", e.getMessage());
			return "login";
		}
	}

	@RequestMapping(value="/logout", method = RequestMethod.GET)
	public String logout(HttpSession session) {
		session.invalidate();
		return "login";
	}

	@RequestMapping(value="/toreg", method = RequestMethod.GET)
	public String toreg() {

		return "register";
	}

	@RequestMapping(value="/register", method = RequestMethod.POST)
	public String register(@RequestParam("name") String name,
						   @RequestParam("password") String password, Map<String, Object> map) {
		System.out.println(name);
		userService.registerUser(name, password);
		map.put("msg", "注册成功，请登录");
		return "login";
	}

	@RequestMapping(value="/checkuser", method = RequestMethod.GET)
	@ResponseBody
	public BaseReult checkUser(@RequestParam("name") String name) {
		System.out.println("===checkUser== " + name);
		if(userService.isExistUserName(name)) {
			return BaseReult.getBaseReult(1, "此用户名太受欢迎了，请更换一个", null);
		}else {
			return BaseReult.getBaseReult(0, "此用户名可以使用", null);
		}

	}
}
