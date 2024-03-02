package com.xwitter_java.repositories;

import com.xwitter_java.models.UserIn;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserIn, Long> {
}
