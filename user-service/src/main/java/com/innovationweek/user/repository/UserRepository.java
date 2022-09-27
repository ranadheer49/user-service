package com.innovationweek.user.repository;

import com.innovationweek.user.entity.DeptUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<DeptUser, Long> {
    DeptUser findByUserId(Long userId);
}
