package com.ohgiraffers.model.dto;

import java.io.Serializable;
import java.sql.Date;

import com.google.gson.annotations.SerializedName;

public class MemberDto implements Serializable {

	// JSON 의 key 와 객체의 필드가 다른 경우
	// 클래스의 필드에 @SerializedName('JSON key'> 어노테이션을 달아주면
	// 직렬화 및 역직렬화 시 JSON key와 필드를 매핑해 준다.
	@SerializedName("memberCode")
	private String code;
	private String name;
	private char gender;
	private int age;
	private Date enrollDate; // java.sql.Date 로 임포트 (db 연결 기준)
	
	public MemberDto() {
		super();
	}

	public MemberDto(String code, String name, char gender, int age, Date enrollDate) {
		super();
		this.code = code;
		this.name = name;
		this.gender = gender;
		this.age = age;
		this.enrollDate = enrollDate;
	}

	public MemberDto(String code, String name, char gender, int age) {
		super();
		this.code = code;
		this.name = name;
		this.gender = gender;
		this.age = age;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public char getGender() {
		return gender;
	}

	public void setGender(char gender) {
		this.gender = gender;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Date getEnrollDate() {
		return enrollDate;
	}

	public void setEnrollDate(Date enrollDate) {
		this.enrollDate = enrollDate;
	}

	@Override
	public String toString() {
		return "MemberDto [code=" + code + ", name=" + name + ", gender=" + gender + ", age=" + age + ", enrollDate="
				+ enrollDate + "]";
	}
	
}
