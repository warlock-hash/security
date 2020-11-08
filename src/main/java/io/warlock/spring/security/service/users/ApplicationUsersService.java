package io.warlock.spring.security.service.users;

import io.warlock.spring.security.entity.ApplicationUsers;

public interface ApplicationUsersService {
    ApplicationUsers getActiveUserByUsername(String username);
}
