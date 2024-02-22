package org.health.track.teamhealthtrack.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@MappedSuperclass
@NoArgsConstructor
@AllArgsConstructor
public class AbstractUser {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(nullable = false, unique = true)
	private String username;
	private String password;
	private String name;
	private String secondName;
	private Boolean isAccountNonExpired;
	private Boolean isAccountNonLocked;
	private Boolean isCredentialsNonExpired;
	private Boolean isEnabled;
}
