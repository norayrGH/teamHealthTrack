package org.health.track.teamhealthtrack.service;

import org.health.track.teamhealthtrack.dto.TeamReportDTO;
import org.health.track.teamhealthtrack.entity.TeamReport;

import java.util.List;

public interface TeamReportService {

	TeamReport teamReportProcessor(TeamReportDTO teamReportDTO, String username);
	List<TeamReport> getTeamReportByUsername(String username);

}
