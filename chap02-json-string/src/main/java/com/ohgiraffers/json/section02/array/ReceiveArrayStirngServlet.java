package com.ohgiraffers.json.section02.array;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/receive/array")
public class ReceiveArrayStirngServlet extends HttpServlet { // 헤더 세팅을 안함

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		
		out.print("[{\"type\":\"get\",\"firstname\":\"squirrel\",\"lastname\":\"nam\",\"height\":200}"
				+ "{\"type\":\"get\",\"firstname\":\"pig\",\"lastname\":\"jung\",\"height\":500},"
				+ "{\"type\":\"get\",\"firstname\":\"tiger\",\"lastname\":\"kim\",\"height\":300},"
				+ "{\"type\":\"get\",\"firstname\":\"sheep\",\"lastname\":\"woo\",\"height\":170}]");
		out.close();
	}
}
