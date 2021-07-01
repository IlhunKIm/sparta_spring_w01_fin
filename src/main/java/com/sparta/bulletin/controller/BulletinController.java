package com.sparta.bulletin.controller;

import com.sparta.bulletin.domain.Bulletin;
import com.sparta.bulletin.domain.BulletinRepository;
import com.sparta.bulletin.domain.BulletinRequestDto;
import com.sparta.bulletin.service.BulletinService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class BulletinController {

    private final BulletinRepository bulletinRepository; // CRUD를 위한 DB 설정
    private final BulletinService bulletinService; //update를 위한 service 설정

    @PostMapping("/api/bulletins") // 글 게시하기
    Bulletin createBulletin(@RequestBody BulletinRequestDto requestDto) {
        Bulletin bulletin = new Bulletin(requestDto);
        return bulletinRepository.save(bulletin);
    }

    @GetMapping("/api/bulletins") // 게시한 글 읽어오기
    public List<Bulletin> readBulletins() {
        return bulletinRepository.findAllByOrderByModifiedAtDesc();
    }


    @PutMapping("/api/bulletins/{id}") // 게시한 글 수정하기
    Long updateBulletin(@PathVariable Long id, @RequestBody BulletinRequestDto requestDto) {
        bulletinService.update(id, requestDto);
        return id;
    }

    @DeleteMapping("/api/bulletins/{id}") // 게시한 글 삭제
    Long deleteBulletin(@PathVariable Long id) {
        bulletinRepository.deleteById(id);
        return id;
    }
}
