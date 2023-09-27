package com.codewitharjun.fullstackapp.repository;

import com.codewitharjun.fullstackapp.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
}
