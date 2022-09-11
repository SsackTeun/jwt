package com.github.ssackteun.portal.jwt.auth.repository;

import com.github.ssackteun.portal.jwt.auth.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface AuthRepository extends JpaRepository<Member, Long> {
    //로그인
    Optional<Member> findByUserId(String userId);

    Optional<Member> findById(Long id);
    //아이디 중복체크
    boolean existsByUserId(String userId);
}
