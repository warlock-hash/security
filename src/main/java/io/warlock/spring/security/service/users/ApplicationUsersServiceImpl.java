package io.warlock.spring.security.service.users;

import io.warlock.spring.security.entity.ApplicationUsers;
import io.warlock.spring.security.repository.ApplicationUsersRepository;
import org.springframework.stereotype.Service;

@Service
public class ApplicationUsersServiceImpl implements ApplicationUsersService {

    private final ApplicationUsersRepository usersRepository;

    public ApplicationUsersServiceImpl(ApplicationUsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    @Override
    public ApplicationUsers getActiveUserByUsername(String username){
        return usersRepository.findByUsernameAndActive(username, true);
    }
}
