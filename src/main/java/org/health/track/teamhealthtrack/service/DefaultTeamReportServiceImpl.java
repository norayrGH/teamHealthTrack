package org.health.track.teamhealthtrack.service;

import lombok.RequiredArgsConstructor;
import org.health.track.teamhealthtrack.dto.TeamReportDTO;
import org.health.track.teamhealthtrack.entity.TeamReport;
import org.health.track.teamhealthtrack.repository.TeamReportRepository;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DefaultTeamReportServiceImpl implements TeamReportService {
	private final UserService userService;
	private final TeamReportRepository teamReportRepository;

	@Override
	public TeamReport teamReportProcessor(TeamReportDTO teamReportDTO, String username){
		return teamReportRepository.save(TeamReport.builder()
				.appUser(userService.getByUsername(username))
				.ankleLeft(teamReportDTO.getAnkleLeft())
				.ankleRight(teamReportDTO.getAnkleRight())
				.adductorMusLeft(teamReportDTO.getAdductorMusLeft())
				.adductorMusRight(teamReportDTO.getAdductorMusRight())
				.glutealLeft(teamReportDTO.getGlutealLeft())
				.glutealRight(teamReportDTO.getGlutealRight())
				.calfMuscleLeft(teamReportDTO.getCalfMuscleLeft())
				.calfMuscleRight(teamReportDTO.getCalfMuscleRight())
				.kneeLeft(teamReportDTO.getKneeLeft())
				.kneeRight(teamReportDTO.getKneeRight())
				.press(teamReportDTO.getPress())
				.lowerBack(teamReportDTO.getLowerBack())
				.hamstringsLeft(teamReportDTO.getHamstringsLeft())
				.hamstringsRight(teamReportDTO.getHamstringsRight())
				.quadricepsLeft(teamReportDTO.getQuadricepsLeft())
				.quadricepsRight(teamReportDTO.getQuadricepsRight())
				.tibialisAnteriorLeft(teamReportDTO.getTibialisAnteriorLeft())
				.tibialisAnteriorRight(teamReportDTO.getTibialisAnteriorRight())
				.createdDate(LocalTime.now())
				.build());
	}

	@Override
	public List<TeamReport> getTeamReportByUsername(String username) {
		var byUsername = userService.getByUsername(username);
		return teamReportRepository.findAllByAppUser(byUsername);
	}

}
