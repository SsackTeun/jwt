package com.github.ssackteun.portal.jwt.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.github.ssackteun.portal.jwt.entity.Member;

@Repository
public interface AuthRepository extends JpaRepository<Member, Long> {
    Optional<Member> findByUserName(String userName);

    Optional<Member> findById(Long id);

    boolean existsByUserName(String userName);

}
