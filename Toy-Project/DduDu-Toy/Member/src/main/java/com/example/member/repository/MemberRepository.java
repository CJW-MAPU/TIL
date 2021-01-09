package com.example.member.repository;

import com.example.member.model.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Integer> {

    Member findByUsername(String username);
}
