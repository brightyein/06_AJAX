package com.ohgiraffers.gson;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.ohgiraffers.model.dto.MemberDto;

@WebServlet("/gson/test4")
public class GsonTestServlet04 extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		// 객체를 생성 
		MemberDto member = new MemberDto("M01", "다람쥐", '남', 900, new java.sql.Date(System.currentTimeMillis()));
	
		Gson gson = new GsonBuilder()
				.setDateFormat("yyyy-MM-dd hh:mm:ss") // 날짜 형식 지정
				.setPrettyPrinting() // json 문자열을 콘솔에 한줄로 찍히지 않고 보기좋게 찍힘
//				.setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_DASHES)
				.setFieldNamingPolicy(FieldNamingPolicy.IDENTITY)// 필드명 명명 정책
				.serializeNulls() //null 이 있더라도 직렬화처리
				.disableHtmlEscaping() // 직렬화 시 이스케이프 시퀀스를 처리하지 않겠다 (꺽쇠를 html 태그로 인식하겠다)
				.create();
		
		String jsonString = gson.toJson(member);
		System.out.println(jsonString);
		
		// 응답 스트림 얻어와서 내보내기
		response.setContentType("application/json; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.print(jsonString);
		out.close();
	}
}
