package com.redi.shortener.repository;

import com.redi.shortener.model.UserI;
import java.util.Optional;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserI, UUID> {
  Optional<UserI> findByEmail(String email);
}
