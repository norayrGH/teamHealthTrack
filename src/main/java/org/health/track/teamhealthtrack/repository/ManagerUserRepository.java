package org.health.track.teamhealthtrack.repository;

import org.health.track.teamhealthtrack.entity.ManagerUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ManagerUserRepository extends JpaRepository<ManagerUser, Long> {

	ManagerUser findManagerUserByUsername(String username);
}
