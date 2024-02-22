package org.health.track.teamhealthtrack.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class AppUser extends AbstractUser {

    @Builder
    public AppUser(Long id,
    String username,
    String password,
    String name,
    String secondName,
    Boolean isAccountNonExpired,
    Boolean isAccountNonLocked,
    Boolean isCredentialsNonExpired,
    Boolean isEnabled){
        super(id, username, password, name, secondName, isAccountNonExpired, isAccountNonLocked, isCredentialsNonExpired, isEnabled);

    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "appUser", cascade = CascadeType.ALL)
    private List<TeamReport> userReports;
}

