package com.sparta.bulletin.domain;


import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter

public class BulletinRequestDto {
    private final String title;
    private final String contents;



}
