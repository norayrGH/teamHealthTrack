package org.health.track.teamhealthtrack.controller;

import lombok.RequiredArgsConstructor;
import org.health.track.teamhealthtrack.dto.TeamReportDTO;
import org.health.track.teamhealthtrack.dto.SignUpDto;
import org.health.track.teamhealthtrack.entity.AppUser;
import org.health.track.teamhealthtrack.entity.ManagerUser;
import org.health.track.teamhealthtrack.entity.TeamReport;
import org.health.track.teamhealthtrack.mapper.UserMapper;
import org.health.track.teamhealthtrack.service.TeamReportService;
import org.health.track.teamhealthtrack.service.UserService;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Objects;

@Controller
@RequiredArgsConstructor
public class TeamReportController {

	private final UserService userService;
	private final TeamReportService teamReportService;
	private final UserMapper mapper;

	@RequestMapping(method = RequestMethod.POST, path = "/submitForm")
	public ModelAndView submitReport(@ModelAttribute("teamreport") TeamReportDTO teamReportDTO,
			Authentication authentication) {
		teamReportService.teamReportProcessor(teamReportDTO, authentication.getName());
		var modelAndView = new ModelAndView();
		modelAndView = new ModelAndView("redirect:/teamreport");
		return modelAndView;
	}

	@RequestMapping(method = RequestMethod.GET, path = "/teamreport")
	public ModelAndView submitReportGet(Authentication authentication) {
		var modelAndView = new ModelAndView();
		modelAndView.setViewName("teamReport");
		modelAndView.addObject("teamreport", new TeamReportDTO());
		return modelAndView;
	}




}
