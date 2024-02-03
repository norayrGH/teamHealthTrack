package org.health.track.teamhealthtrack.entity;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;

import static org.apache.commons.lang3.BooleanUtils.toBoolean;

public class MyUserPrincipal implements UserDetails {
    private final AbstractUser user;

    public MyUserPrincipal(AbstractUser appUser) {
        this.user = appUser;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return new ArrayList<>();
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return toBoolean(user.getIsAccountNonExpired());
    }

    @Override
    public boolean isAccountNonLocked() {
        return toBoolean(user.getIsAccountNonLocked());
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return toBoolean(user.getIsCredentialsNonExpired());
    }

    @Override
    public boolean isEnabled() {
        return toBoolean(user.getIsEnabled());
    }
}