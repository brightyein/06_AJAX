package com.ohgiraffers.gson;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import com.google.gson.Gson;
import com.ohgiraffers.model.dto.MemberDto;

@WebServlet("/gson/test1")
public class GsonTestServlet01 extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		// memberDro 객체 하나 생성
		MemberDto member = new MemberDto("M01", "다람쥐", '여', 900);
		
		//gson 의 toJson() 통해 java 객체를 json 문자열로 변환
		Gson gson = new Gson();
		
		String jsonString = gson.toJson(member);
		System.out.println(jsonString);
		
		// fromJson() : json 문자열을 java 객체로 변환
		MemberDto jsonMember = gson.fromJson(jsonString, MemberDto.class);
		
		// 화면에 내보내 준다
		response.setContentType("application/json; charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		out.print(jsonString);
		out.close();
	
	}
}
