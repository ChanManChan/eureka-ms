package com.u4.api.users.service;

import com.u4.api.users.shared.UserDto;
import org.springframework.security.core.userdetails.UserDetailsService;

// extending UserDetailsService because of configure method inside WebSecurity
public interface UsersService extends UserDetailsService {
    UserDto createUser(UserDto userDetails);
    UserDto getUserDetailsByEmail(String email); // <- used inside AuthenticationFilter successfulAuthentication method
}
