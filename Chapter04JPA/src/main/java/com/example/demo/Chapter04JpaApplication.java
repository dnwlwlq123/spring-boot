package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@ComponentScan(basePackages = {"main.controller", "user.controller", "user.service", "user.bean"
								,"user.dao"})
@EntityScan("user.bean")
@EnableJpaRepositories("user.dao")
@SpringBootApplication
public class Chapter04JpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(Chapter04JpaApplication.class, args);
	}

}
/*
스프링 JPA(Java Persistence API)

스프링 JPA
스프링에서 데이터를 처리할 수 있도록 돕는 라이브러리이다
데이터베이스에 종속적인 SQL문 없이도 개발이 가능하기 때문에 개발의 생산성을 높일 수 있다
기존의 JDBC 등을 이용해서 직접 구현했던 데이터베이스 관련 작업을 대신 처리해주는 추상화된 계층의 구현 스펙이다

Spring Boot + MySQL + JPA

스프링 데이터 JPA를 사용하는 경우는 별도의 구현 클래스를 만들지 않고 인터페이스만 정의함으로써 기능을 사용할 수 있다. 스프링 부트가 내부적으로 인터페이스에 대한 구현 객체를 자동으로 생성해준다. 또한 JPA를 이용해서 데이터베이스를 연동하기 위해서 사용했었던 EntityManagerFactory, 
EntityManager, EntityTransaction 같은 객체도 필요 없다.
이 모든 객체들의 생성과 활용이 스프링 데이터 JPA 에서는 내부적으로 처리되기 때문이다.

@Entity
JPA에서는 엔티티는 테이블에 대응하는 하나의 클래스라고 생각하면 된다
spring-boot-starter-data-jpa 의존성을 추가하고 @Entity 어노테이션을 붙이면 테이블과 자바 클래스가 매핑이 된다.
그래서 JPA에서 '하나의 엔티티 타입을 생성한다'라는 의미는 '하나의 클래스'를 작성한다는 의미가 된다.
엔티티라는 용어는 때로는 클래스를 의미하는 경우도 있고, 클래스에 의해 생성된 인스턴스를 의미하는 경우가 있다.
정확히 얘기하자면, 엔티티 클래스와 엔티티 인스턴스 혹은 엔티티 객체라는 표현이 정확하다.

@EntityScan
어노테이션으로 엔티티 클래스를 스캔할 곳을 지정하는데 사용한다.
메인 어플리케이션 패키지 내에 엔티티 클래스가 없는 경우 어노테이션을 사용해서 패키지밖에 존재하는 
엔티티를 지정할 수 있다.
기본적으로 @EnableAutoConfiguration 어노테이션에 의해서 지정한 곳에서 엔티티를 스캔한다.

@EnableJpaRepositories
JpaRepository에 대한 설정정보를 자동적으로 로딩하고 이 정보를 토대로 Repository 빈을 등록하는 역할을 한다

*/