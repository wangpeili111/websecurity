package com.app.security.webapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.app.security.bean.Authorities;
import com.app.security.bean.Groupmembers;
import com.app.security.bean.Users;
import com.app.security.crud.AuthorCrud;
import com.app.security.crud.MenbersCrud;
import com.app.security.crud.UserCrud;

@Controller
@RequestMapping("/register")
public class RegisterController {
	@Autowired
	private UserCrud userCrud;
	@Autowired
	private AuthorCrud authorCrud;
	@Autowired
	private MenbersCrud menbersCrud;

	@PostMapping("/registerform")
	public String postregister(@RequestParam String username, @RequestParam String password,
			@RequestParam String authority, Model model) {
		if (userCrud.existsByUsername(username) || username.isEmpty() || password.isEmpty()) {
			model.addAttribute("message", "error");
			return "register";
		} else {
			Users users = new Users();
			users.setUsername(username);
			String passwordenc = new BCryptPasswordEncoder().encode(password);
			users.setPassword(passwordenc);
			users.setEnabled(true);
			userCrud.save(users);

			Authorities authorities = new Authorities();
			authorities.setUsername(username);
			authorities.setAuthority(authority);
			authorCrud.save(authorities);

			Groupmembers groupmembers = new Groupmembers();
			groupmembers.setUsername(username);
			groupmembers.setGroup_id(1);
			menbersCrud.save(groupmembers);
			// register User;
			return "redirect:/login";
		}
	}

	@GetMapping("/adduser")
	public @ResponseBody String getregisteruser(@RequestParam String username, @RequestParam String password,
			@RequestParam String authority) {
		if (userCrud.existsByUsername(username) || username.isEmpty() || password.isEmpty()) {
			return "error";
		} else {
			Users users = new Users();
			users.setUsername(username);
			String passwordenc = new BCryptPasswordEncoder().encode(password);
			users.setPassword(passwordenc);
			users.setEnabled(true);
			userCrud.save(users);

			Authorities authorities = new Authorities();
			authorities.setUsername(username);
			authorities.setAuthority(authority);
			authorCrud.save(authorities);

			Groupmembers groupmembers = new Groupmembers();
			groupmembers.setUsername(username);
			groupmembers.setGroup_id(1);
			menbersCrud.save(groupmembers);
			// register User;
			return "success";
		}
	}
	
	@PostMapping("/adduser")
	public @ResponseBody String postregisteruser(@RequestParam String username, @RequestParam String password,
			@RequestParam String authority) {
		if (userCrud.existsByUsername(username) || username.isEmpty() || password.isEmpty()) {
			return "error";
		} else {
			Users users = new Users();
			users.setUsername(username);
			String passwordenc = new BCryptPasswordEncoder().encode(password);
			users.setPassword(passwordenc);
			users.setEnabled(true);
			userCrud.save(users);

			Authorities authorities = new Authorities();
			authorities.setUsername(username);
			authorities.setAuthority(authority);
			authorCrud.save(authorities);

			Groupmembers groupmembers = new Groupmembers();
			groupmembers.setUsername(username);
			groupmembers.setGroup_id(1);
			menbersCrud.save(groupmembers);
			// register User;
			return "success";
		}
	}
}
