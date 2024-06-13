package com.ohgiraffers.section02.list;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import com.ohgiraffers.model.dto.MemberDto;

@WebServlet("/receive/list")
public class ReceiveListServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		MemberDto member1 = new MemberDto("get", "squirrel", "nam", 300);
		MemberDto member2 = new MemberDto("get", "pig", "jung", 200);
		MemberDto member3 = new MemberDto("get", "tiger", "kim", 500);
		MemberDto member4 = new MemberDto("get", "sheep", "woo", 170);
		
		List<MemberDto> memberList = new ArrayList<>();
		memberList.add(member1);
		memberList.add(member2);
		memberList.add(member3);
		memberList.add(member4);
		
		response.setContentType("application/json; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.print(memberList);
		out.close();
	}
}
