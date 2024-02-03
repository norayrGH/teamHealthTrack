package org.health.track.teamhealthtrack.repository;

import org.health.track.teamhealthtrack.entity.AppUser;
import org.health.track.teamhealthtrack.entity.TeamReport;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TeamReportRepository extends JpaRepository<TeamReport, Long> {
	List<TeamReport> findAllByAppUser(AppUser appUser);
}
