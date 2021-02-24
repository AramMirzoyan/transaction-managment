package com.transaction.model.trasnaction.repository;

import com.transaction.model.trasnaction.dto.request.UserRequestDto;
import com.transaction.model.trasnaction.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
    boolean existsUserByUsername(final String username);

    User findByUsername(final String username);

}
