package com.sparta.week02;

import com.sparta.week02.domain.Course;
import com.sparta.week02.domain.CourseRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class Week02Application {

	public static void main(String[] args) {
		SpringApplication.run(Week02Application.class, args);
	}

	// 프로젝트를 생성하지 않고 repository에 대한 이해를 돕기 위한 코드
	// 현업에선 이런 코드 작성 안함
	@Bean
	public CommandLineRunner demo(CourseRepository repository) {
		return (args) -> {

			Course course1 = new Course("웹개발의 봄 Spring", "남병관");
			repository.save(course1);

			List<Course> courseList = repository.findAll();
			for (int i = 0; i < courseList.size(); i++) {
				Course c = courseList.get(i);
				System.out.println(c.getTitle());
				System.out.println(c.getTutor());
			}

		};
	}
}
