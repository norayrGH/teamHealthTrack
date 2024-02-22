package org.health.track.teamhealthtrack.controller;

import lombok.RequiredArgsConstructor;
import org.apache.commons.io.output.ByteArrayOutputStream;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.health.track.teamhealthtrack.config.ReflectionExample;
import org.health.track.teamhealthtrack.dto.TeamReportDTO;
import org.health.track.teamhealthtrack.entity.ManagerUser;
import org.health.track.teamhealthtrack.entity.TeamReport;
import org.health.track.teamhealthtrack.service.UserService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

@Controller
@RequiredArgsConstructor
public class DispatchController {

	private final UserService userService;
	@RequestMapping(method = RequestMethod.GET, path = "/dispatch")
	public ModelAndView submitReportGet(Authentication authentication) {
		ManagerUser managerByUserName = userService.getManagerByUserName(authentication.getName());
		if (Objects.nonNull(managerByUserName)){
			var modelAndView = new ModelAndView();
			modelAndView.setViewName("redirect:/managerreport");
			return modelAndView;
		}
		var modelAndView = new ModelAndView();
		modelAndView.setViewName("redirect:/teamreport");
		return modelAndView;
	}


}