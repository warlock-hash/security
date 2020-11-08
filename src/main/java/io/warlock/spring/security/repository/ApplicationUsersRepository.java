package io.warlock.spring.security.repository;

import io.warlock.spring.security.entity.ApplicationUsers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApplicationUsersRepository extends JpaRepository<ApplicationUsers, Long> {

    ApplicationUsers findByUsernameAndActive(String username, boolean isActive);

}
