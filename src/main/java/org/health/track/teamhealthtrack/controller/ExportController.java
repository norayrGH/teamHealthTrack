package org.health.track.teamhealthtrack.controller;

import lombok.RequiredArgsConstructor;
import org.health.track.teamhealthtrack.dto.SignUpDto;
import org.health.track.teamhealthtrack.entity.AppUser;
import org.health.track.teamhealthtrack.entity.TeamReport;
import org.health.track.teamhealthtrack.mapper.UserMapper;
import org.health.track.teamhealthtrack.service.TeamReportService;
import org.health.track.teamhealthtrack.service.UserService;
import org.jxls.common.Context;
import org.jxls.util.JxlsHelper;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Objects;

@Controller
@RequiredArgsConstructor
public class ExportController {

	private final UserService userService;
	private final TeamReportService teamReportService;
	private final UserMapper mapper;
	/*@RequestMapping(method = RequestMethod.GET, path = "/export")
	public ModelAndView signUp(Authentication authentication) throws IOException {
		List<TeamReport> employeeList = teamReportService.getTeamReportByUsername(authentication.getName());
		try (InputStream is = Objects.requireNonNull(
				getClass().getClassLoader().getResource("excelTemplates/teamReport.xlsx")).openStream()) {
			try (ByteArrayOutputStream os = new ByteArrayOutputStream()) {
				Context context = new Context();
				String fileName = "Employee";
				context.putVar("employees", employeeList);
				JxlsHelper.getInstance().processTemplate(is, os, context);
			}
		}
	}*/


}
