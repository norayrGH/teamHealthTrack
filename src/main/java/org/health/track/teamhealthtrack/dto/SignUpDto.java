package org.health.track.teamhealthtrack.dto;

import lombok.Data;

@Data
public class SignUpDto {
	private String username;
	private String Name;
	private String SecondName;
	private String password;
	private String repeatPassword;
	private Boolean isManager;
	private String selectedManager;
}
