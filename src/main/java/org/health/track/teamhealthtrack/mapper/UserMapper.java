package org.health.track.teamhealthtrack.mapper;

import org.health.track.teamhealthtrack.dto.SignUpDto;
import org.health.track.teamhealthtrack.entity.AppUser;
import org.health.track.teamhealthtrack.entity.ManagerUser;

public interface UserMapper {

	AppUser mapDtoToEntity(SignUpDto signUpDto);

	ManagerUser mapDtoToManager(SignUpDto signUpDto);

}
