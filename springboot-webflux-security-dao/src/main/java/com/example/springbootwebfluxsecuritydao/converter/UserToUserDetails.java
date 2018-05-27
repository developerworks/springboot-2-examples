package com.example.springbootwebfluxsecuritydao.converter;

import com.example.springbootwebfluxsecuritydao.entity.User;
import com.example.springbootwebfluxsecuritydao.service.impl.UserDetailsImpl;
import org.springframework.core.convert.converter.Converter;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;

@Component
public class UserToUserDetails implements Converter<User, UserDetails> {
    @Override
    public UserDetails convert(User user) {
        UserDetailsImpl userDetails = new UserDetailsImpl();
        userDetails.setUsername(user.getUsername());
        userDetails.setPassword(user.getEncryptedPassword());
        userDetails.setEnabled(user.getEnabled());
        // 已授权职责
        Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
        user.getRoles().forEach(role -> {
            authorities.add(new SimpleGrantedAuthority(role.getRole()));
        });
        userDetails.setAuthorities(authorities);
        return userDetails;
    }
}