package com.test.web.servlet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.test.web.entity.HiberInfo;
import com.test.web.entity.MemberInfo;
import com.test.web.service.MemberInfoService;
import com.test.web.service.impl.MemberInfoServiceImpl;
import com.test.web.util.Pson;

@WebServlet("/member-info/*")
public class MemberInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MemberInfoService memberInfoService = new MemberInfoServiceImpl();
	private Gson gson = new Gson();
	private static Pson pson = new Pson();
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json;charset=UTF-8");
		String uri = request.getRequestURI();
		int idx = uri.lastIndexOf("/");
		String cmd = uri.substring(idx+1);
		String json = "";
		if("list".equals(cmd)) {
			json = gson.toJson(memberInfoService.selectMemberInfoList(null));
		}
		PrintWriter pw = response.getWriter();
		pw.write(json);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		BufferedReader br = request.getReader();
		String json = "";
		String str;
		while((str=br.readLine())!=null) {
			json += str;
		}
		MemberInfo memberInfo = gson.fromJson(json, MemberInfo.class);
		String uri = request.getRequestURI();
		int idx = uri.lastIndexOf("/");
		String cmd = uri.substring(idx+1);
		Map<String,Integer> rMap = new HashMap<>();
		if("insert".equals(cmd)) {
			rMap.put("result", memberInfoService.saveMemberInfo(memberInfo));
		}
		json = gson.toJson(rMap);
		response.setContentType("application/json;charset=UTF-8");
		PrintWriter pw = response.getWriter();
		pw.write(json);
	}
}
