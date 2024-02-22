package org.health.track.teamhealthtrack.controller;

import lombok.RequiredArgsConstructor;
import org.health.track.teamhealthtrack.dto.TeamReportDTO;
import org.health.track.teamhealthtrack.entity.ManagerUser;
import org.health.track.teamhealthtrack.mapper.UserMapper;
import org.health.track.teamhealthtrack.service.TeamReportService;
import org.health.track.teamhealthtrack.service.UserService;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.Objects;

@Controller
@RequiredArgsConstructor
public class ManagerReportController {

	private final UserService userService;
	private final TeamReportService teamReportService;
	private final UserMapper mapper;

	@RequestMapping(method = RequestMethod.GET, path = "/managerreport")
	public ModelAndView submitReportGet(Authentication authentication) {
		ManagerUser managerByUserName = userService.getManagerByUserName(authentication.getName());
		var modelAndView = new ModelAndView();
		modelAndView.setViewName("manager");
		return modelAndView;
	}



}
