package com.ohgiraffers.gson;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.ohgiraffers.model.dto.MemberDto;

@WebServlet("/gson/test3")
public class GsonTestServlet03 extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String jsonString = request.getParameter("jsonString");
		System.out.println(jsonString); // 값이 어떻게 넘어왔는지 출력해보자
		
//		Gson gson = new Gson();
		
		Gson gson = new GsonBuilder().setDateFormat("yyyy/mm/dd").create();
		// .setDateFormat() -> gsonBilder 를 반환
		
		String dateTest = gson.toJson(new java.sql.Date(System.currentTimeMillis()));
		System.out.println("[dateTest] " + dateTest);
		
		MemberDto member = gson.fromJson(jsonString, MemberDto.class); // 날짜 정보는 그냥 변환 불가
		System.out.println(member);
		
		// 다시 json 으로 변환해서 반환
		response.setContentType("application/json; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.print(gson.toJson(member));
		out.close();
	}
}
