package org.health.track.teamhealthtrack.service;

import lombok.RequiredArgsConstructor;
import org.health.track.teamhealthtrack.entity.ManagerUser;
import org.health.track.teamhealthtrack.entity.MyUserPrincipal;
import org.health.track.teamhealthtrack.entity.AppUser;
import org.health.track.teamhealthtrack.repository.ManagerUserRepository;
import org.health.track.teamhealthtrack.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserDetailsService, UserService {

	private final UserRepository userRepository;
	private final ManagerUserRepository managerUserRepository;

	@Override
	public UserDetails loadUserByUsername(String username) {
		var appUser = userRepository.findByUsername(username);
		var managerUser = managerUserRepository.findManagerUserByUsername(username);
		if (appUser == null && managerUser == null) {
			throw new UsernameNotFoundException(username);
		}
		return new MyUserPrincipal(Objects.nonNull(managerUser) ? managerUser : appUser);
	}

	@Override
	public AppUser saveUser(AppUser user) {
		return userRepository.save(user);
	}

	@Override
	public ManagerUser saveManager(ManagerUser user) {
		return managerUserRepository.save(user);
	}

	@Override
	public AppUser getByUsername(String userName) {
		return userRepository.findByUsername(userName);
	}

	@Override
	public List<ManagerUser> getAllManagers() {
		return managerUserRepository.findAll();
	}

	@Override
	public ManagerUser getManagerByUserName(String username) {
		return managerUserRepository.findManagerUserByUsername(username);
	}

}
