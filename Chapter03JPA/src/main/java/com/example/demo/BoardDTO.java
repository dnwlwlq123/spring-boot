package com.example.demo;

import java.sql.Timestamp;
import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="board")
@Getter
@Setter
public class BoardDTO {
	@Id
	@Column(name="seq")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Board_SEQ_GENERATOR")
	private int seq;

	
	@Column(name="id", nullable=false, unique=true, length=30)
	private String id;
	
	@Column(name="name", nullable=false, length=30)
	private String name;
	
	@Column(name="subject")
	private String subject;
	
	@Column(name="content")
	private String content;
	
	//@CreationTimestamp //엔티티가 생성되는 시점의 시간등록 - insert할 때 자동으로 시간 등록
	@UpdateTimestamp //- update할 때 자동으로 시간 등록
	private LocalDateTime logtime = LocalDateTime.now();
}
