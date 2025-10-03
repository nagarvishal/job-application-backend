package app.employee.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import app.employee.entity.User;

@Component
public class UserDetailsServiceImpl implements UserDetailsService {
    
    @Autowired
    UserService userService;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = this.userService.findByEmail(email);
        if(user!=null){
            UserDetails userDetails = org.springframework.security.core.userdetails.User.builder()
                                      .username(user.getUserId())
                                      .password(user.getPassword())
                                      .roles("USER")
                                      .build();
            return userDetails;
        }
        throw new UsernameNotFoundException("User not found with email: "+email);
    }

    

}
