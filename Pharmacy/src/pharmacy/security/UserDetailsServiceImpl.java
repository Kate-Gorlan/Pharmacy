package pharmacy.security;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import pharmacy.service.UserService;

public class UserDetailsServiceImpl implements UserDetailsService{

    UserService userService;
    
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        
        pharmacy.entity.User user = userService.getUserByLogin(login);
        
        if (user == null) {
            throw new UsernameNotFoundException(login);
        }
        
        Collection<GrantedAuthority> authorities = new ArrayList<>();
        
        for (pharmacy.entity.Role role : user.getRoles()) {
            authorities.add(new SimpleGrantedAuthority(role.getRoleName()));
        }
        
        return new User(user.getLogin(), user.getPassword(), true, true, true, true, authorities);
    }

}
