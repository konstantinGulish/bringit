package com.example.bringit.security;

import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

public class CustomUserDetails extends  org.springframework.security.core.userdetails.User{

    private AppUser user;

    public CustomUserDetails(AppUser user, Collection<? extends GrantedAuthority> authorities){
        super(user.getUsername(), user.getPassword(), authorities);
        this.user = user;
    }

    public CustomUserDetails(AppUser user, String password, Collection<? extends GrantedAuthority> authorities){
        super(user.getUsername(), password, authorities);
        this.user = user;
    }

    public AppUser getUser() {
        return user;
    }
}
