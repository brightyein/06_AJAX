package com.ohgiraffers.section01.simple;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import org.json.simple.JSONObject;

import com.ohgiraffers.model.dto.MemberDto;

@WebServlet("/receive/simple")
public class ReceiveSimpleJsonObjectServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		MemberDto member = new MemberDto("get", "squirrel", "nam", 200);
		
		// HashMap class 를 확장해서 만든 JSONObject -> key value 형태, put 사용
		JSONObject json = new JSONObject();
		json.put("type", member.getType());
		json.put("firstname", member.getFirstName());
		json.put("lastname", member.getLastName());
		json.put("height", member.getHeight());
		
		
		response.setContentType("application/json; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.print(json.toJSONString());
		out.close();
	}
}
