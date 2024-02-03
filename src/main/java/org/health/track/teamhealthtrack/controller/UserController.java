package org.health.track.teamhealthtrack.controller;

import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.BooleanUtils;
import org.health.track.teamhealthtrack.dto.SignUpDto;
import org.health.track.teamhealthtrack.dto.TeamReportDTO;
import org.health.track.teamhealthtrack.entity.AbstractUser;
import org.health.track.teamhealthtrack.entity.AppUser;
import org.health.track.teamhealthtrack.entity.ManagerUser;
import org.health.track.teamhealthtrack.mapper.UserMapper;
import org.health.track.teamhealthtrack.service.TeamReportService;
import org.health.track.teamhealthtrack.service.UserService;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.stream.Collectors;

import static org.apache.commons.lang3.BooleanUtils.*;

@Controller
@RequiredArgsConstructor
public class UserController {

	private final UserService userService;
	private final TeamReportService teamReportService;
	private final UserMapper mapper;

	@GetMapping("/signUp")
	public ModelAndView signUp() {
		var modelAndView = new ModelAndView();
		modelAndView.addObject("user", new SignUpDto());
		modelAndView.setViewName("signUp");

		modelAndView.addObject("managers",
				userService.getAllManagers().stream().map(AbstractUser::getUsername).collect(Collectors.toList()));
		return modelAndView;
	}

	@PostMapping("/signUp")
	public ModelAndView processSignup(@ModelAttribute("user") SignUpDto user) {
		if (toBoolean(user.getIsManager())) {
			userService.saveManager(mapper.mapDtoToManager(user));
		} else {
			var selectedManager = user.getSelectedManager();
			var managerByUserName = userService.getManagerByUserName(selectedManager);
			var appUser = userService.saveUser(mapper.mapDtoToEntity(user));
			managerByUserName.getTeammates().add(appUser);
			userService.saveManager(managerByUserName);
		}
		var modelAndView = new ModelAndView();
		modelAndView.addObject("createdUser", user.getUsername());
		modelAndView.setViewName("login");
		return modelAndView;
	}

	@GetMapping("/login.html")
	public String login() {
		return "login.html";
	}

	@GetMapping("/login-error.html")
	public String loginError(Model model) {
		model.addAttribute("loginError", true);
		return "login.html";
	}

}
