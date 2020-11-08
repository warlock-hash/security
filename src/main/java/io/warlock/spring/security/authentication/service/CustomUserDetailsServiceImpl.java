package io.warlock.spring.security.authentication.service;

import io.warlock.spring.security.authentication.model.CustomUserDetail;
import io.warlock.spring.security.entity.ApplicationUsers;
import io.warlock.spring.security.entity.Privilege;
import io.warlock.spring.security.entity.Role;
import io.warlock.spring.security.service.users.ApplicationUsersService;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class CustomUserDetailsServiceImpl implements CustomUserDetailsService {

    private final ApplicationUsersService usersService;

    public CustomUserDetailsServiceImpl(ApplicationUsersService usersService) {
        this.usersService = usersService;
    }

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        ApplicationUsers applicationUser = usersService.getActiveUserByUsername(username);
        if(applicationUser == null){
            throw new UsernameNotFoundException("Username not Found : " + username);
        }
        return new CustomUserDetail(applicationUser.getUsername(), applicationUser.getPassword(),
                getAuthorities(applicationUser.getRoleList()),
                true, true, true, true);
    }

    private Collection<? extends GrantedAuthority> getAuthorities(
            Collection<Role> roles) {

        return getGrantedAuthorities(getPrivileges(roles));
    }

    private List<String> getPrivileges(Collection<Role> roles) {

        List<String> privileges = new ArrayList<>();
        List<Privilege> collection = new ArrayList<>();
        for (Role role : roles) {
            collection.addAll(role.getPrivilegeList());
        }
        for (Privilege item : collection) {
            privileges.add(item.getName());
        }
        return privileges;
    }

    private List<GrantedAuthority> getGrantedAuthorities(List<String> privileges) {
        List<GrantedAuthority> authorities = new ArrayList<>();
        for (String privilege : privileges) {
            authorities.add(new SimpleGrantedAuthority(privilege));
        }
        return authorities;
    }
}
