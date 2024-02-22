package org.health.track.teamhealthtrack.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class ManagerUser extends AbstractUser {

    @OneToMany
    private List<AppUser> teammates;
    @Builder
    public ManagerUser(Long id,
            String username,
            String password,
            String name,
            String secondName,
            Boolean isAccountNonExpired,
            Boolean isAccountNonLocked,
            Boolean isCredentialsNonExpired,
            Boolean isEnabled,List<AppUser> teammates){
        super(id, username, password, name, secondName, isAccountNonExpired, isAccountNonLocked, isCredentialsNonExpired, isEnabled);
        this.teammates = teammates;
    }
}

