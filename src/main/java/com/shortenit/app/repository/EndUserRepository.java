package com.shortenit.app.repository;

import com.shortenit.app.model.EndUser;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EndUserRepository extends JpaRepository<EndUser, UUID> {
  boolean existsByEmail(String email);
}
