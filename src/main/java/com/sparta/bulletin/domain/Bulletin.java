package com.sparta.bulletin.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Getter
@NoArgsConstructor //기본생성자 생성
@Entity // DB 테이블과 연동됨을 스프링에게 알려줌
public class Bulletin extends Timestamped {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;

    @Column(nullable = false)
    public String title;

    @Column(nullable = false)
    public String contents;

    public Bulletin(String title, String contents) {
        this.title = title;
        this.contents = contents;
    }

    public Bulletin(BulletinRequestDto requestDto) {
        this.title = requestDto.getTitle();
        this.contents = requestDto.getContents();
    }

    public void update(BulletinRequestDto requestDto) {
        this.title = requestDto.getTitle();
        this.contents = requestDto.getContents();
    }


}
