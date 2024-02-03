package org.health.track.teamhealthtrack.service;

import org.health.track.teamhealthtrack.entity.AppUser;
import org.health.track.teamhealthtrack.entity.ManagerUser;

import java.util.List;

public interface UserService {

	public AppUser saveUser(AppUser user);

	ManagerUser saveManager(ManagerUser user);

	public AppUser getByUsername(String userName);

	List<ManagerUser> getAllManagers();

	ManagerUser getManagerByUserName(String username);

}
