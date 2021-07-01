package com.sparta.bulletin.domain;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BulletinRepository extends JpaRepository<Bulletin, Long> {
    List<Bulletin> findAllByOrderByModifiedAtDesc();
}
