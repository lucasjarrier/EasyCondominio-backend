package com.ufcg.backend.security;

import com.ufcg.backend.models.GenericUser;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;
import java.util.Map;

public class UserPrincipal implements UserDetails {

    private Long id;
    private GenericUser user;
    private String login;
    private String password;
    private Collection<? extends GrantedAuthority> authorities;
    private Map<String, Object> attributes;

    public UserPrincipal(Long id, GenericUser user, Collection<? extends GrantedAuthority> authorities) {
        this.id = id;
        this.user = user;
        this.authorities = authorities;
        this.login = user.getLogin();
        this.password = user.getPassword();
    }

    public static UserPrincipal create(GenericUser user) {
        if (user != null) {
            return new UserPrincipal(user.getId(), user, Collections.singletonList(new SimpleGrantedAuthority("ROLE_USER")));
        }
        return null;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return login;
    }

    public void setAttributes(Map<String, Object> attributes) {
        this.attributes = attributes;
    }

    public Long getId() {
        return id;
    }

    public GenericUser getUser() {
        return user;
    }
}
