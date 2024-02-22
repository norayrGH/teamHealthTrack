package org.health.track.teamhealthtrack.mapper;

import lombok.RequiredArgsConstructor;
import org.health.track.teamhealthtrack.dto.SignUpDto;
import org.health.track.teamhealthtrack.entity.AppUser;
import org.health.track.teamhealthtrack.entity.ManagerUser;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@RequiredArgsConstructor
public class UserMapperImpl implements UserMapper {
	private final PasswordEncoder passwordEncoder;
	@Override
	public AppUser mapDtoToEntity(SignUpDto signUpDto){

		return AppUser.builder()
				.username(signUpDto.getUsername())
				.password(passwordEncoder.encode(signUpDto.getPassword()))
				.name(signUpDto.getName())
				.secondName(signUpDto.getSecondName())
				.isAccountNonLocked(true)
				.isAccountNonExpired(true)
				.isCredentialsNonExpired(true)
				.isEnabled(true)
				.build();
	}
	@Override
	public ManagerUser mapDtoToManager(SignUpDto signUpDto){
		return  ManagerUser.builder()
				.teammates(new ArrayList<>())
				.username(signUpDto.getUsername())
				.password(passwordEncoder.encode(signUpDto.getPassword()))
				.name(signUpDto.getName())
				.secondName(signUpDto.getSecondName())
				.isAccountNonLocked(true)
				.isAccountNonExpired(true)
				.isCredentialsNonExpired(true)
				.isEnabled(true)
				.build();
	}
}
