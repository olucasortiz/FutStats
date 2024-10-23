package com.fut.futstats.repositories;

import com.fut.futstats.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
