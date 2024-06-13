package com.ohgiraffers.section03.map;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import com.ohgiraffers.model.dto.MemberDto;

@WebServlet("/receive/map")
public class ReceiveMapServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		MemberDto member1 = new MemberDto("get", "squirrel", "nam", 300);
		MemberDto member2 = new MemberDto("get", "pig", "jung", 200);
		MemberDto member3 = new MemberDto("get", "tiger", "kim", 500);
		MemberDto member4 = new MemberDto("get", "sheep", "woo", 170);
		
		Map<String, MemberDto> memberMap = new HashMap<>();
		memberMap.put("one", member1);
		memberMap.put("two", member2);
		memberMap.put("three", member3);
		memberMap.put("four", member4);
		
		System.out.println(memberMap);
		
		StringBuilder sb = new StringBuilder();
		Iterator<String> keyIter = memberMap.keySet().iterator();
		
		sb.append("{");
		while (keyIter.hasNext()) {
			String key = keyIter.next();
		
			sb.append("\"")
				.append(key)
				.append("\"")
				.append(":")
				.append(memberMap.get(key));
		
			if(keyIter.hasNext()) {
				sb.append(",");
			}
		}
		sb.append("}");
		
		System.out.println(sb);
		
		response.setContentType("application/json; charset=UTF-8");
		PrintWriter out = response.getWriter();
//		out.print(memberMap);
		out.print(sb);
		out.close();
	
	}
}
