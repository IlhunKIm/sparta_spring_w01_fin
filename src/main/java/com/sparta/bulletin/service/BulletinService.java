package com.sparta.bulletin.service;

import com.sparta.bulletin.domain.Bulletin;
import com.sparta.bulletin.domain.BulletinRepository;
import com.sparta.bulletin.domain.BulletinRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;


@RequiredArgsConstructor
@Service
public class BulletinService {

    private final BulletinRepository bulletinRepository;

    @Transactional //DB에 반영하기
    public Long update(Long id, BulletinRequestDto requestDto) {
        Bulletin bulletin = bulletinRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("아이디가 존재하지 않습니다.")
        );
        bulletin.update(requestDto);
        return bulletin.getId();
    }
}
