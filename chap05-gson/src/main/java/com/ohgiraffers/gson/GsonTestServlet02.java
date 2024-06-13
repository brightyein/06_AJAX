package com.ohgiraffers.gson;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;

import com.google.gson.Gson;
import com.ohgiraffers.model.dto.MemberDto;

@WebServlet("/gson/test2")
public class GsonTestServlet02 extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		// parameter 에서 값을 꺼내서 
		String memberCode = request.getParameter("memberCode");
		String name = request.getParameter("name");
		char gender = request.getParameter("gender").charAt(0);
		int age = Integer.parseInt(request.getParameter("age"));
		Date enrollDate = Date.valueOf(request.getParameter("enrollDate"));
		
		// MemberDto 객체로 생성
		MemberDto member = new MemberDto(memberCode, name, gender, age, enrollDate);
		String jsonString = new Gson().toJson(member);
		
		// 반환
		response.setContentType("application/json; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.print(jsonString);
		out.close();	
	}
}
