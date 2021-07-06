package com.sparta.homework.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Setter
@Getter
@RequiredArgsConstructor
public class PersonRequestDto {
    private final String name;
    private final int age;
    private final String address;
    private final String job;
}
