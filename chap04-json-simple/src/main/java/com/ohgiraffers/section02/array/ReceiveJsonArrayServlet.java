package com.ohgiraffers.section02.array;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.ohgiraffers.model.dto.MemberDto;

@WebServlet("/chap04/receive/jsonarray")
public class ReceiveJsonArrayServlet extends HttpServlet {

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
		
		JSONArray jsonArray = new JSONArray(); // JSONArray
		for (MemberDto member : memberList) {
			JSONObject json = new JSONObject();
			json.put("type", member.getType());
			json.put("firstname", member.getFirstName());
			json.put("lastname", member.getLastName());
			json.put("height", member.getHeight());
			
			jsonArray.add(json);
		}
		
		response.setContentType("application/json; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.print(jsonArray);
		out.close();
	}
}
