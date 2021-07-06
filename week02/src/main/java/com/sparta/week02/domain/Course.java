package com.sparta.week02.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter // lombok으로 Getter 직접 만들지 않고 사용
@NoArgsConstructor // lombok이 기본생성자를 대신 생성해줌
@Entity // 테이블임을 나타냄
public class Course extends Timestamped {

    @Id // ID 값, Primary Key로 사용하겠다는 뜻
    @GeneratedValue(strategy = GenerationType.AUTO) // 자동 증가
    private Long id;

    @Column(nullable = false) // 컬럼 값이고 반드시 값이 존재해야 함
    private String title;

    @Column(nullable = false)
    private String tutor;

    public Course(String title, String tutor) {
        this.title = title;
        this.tutor = tutor;
    }

    public Course(CourseRequestDto requestDto) {
        this.title = requestDto.getTitle();
        this.tutor = requestDto.getTutor();
    }

    public void update(CourseRequestDto requestDto) {
        this.title = requestDto.getTitle();
        this.tutor = requestDto.getTutor();
    }
}