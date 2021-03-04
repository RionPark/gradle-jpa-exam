package com.test.web.servlet;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.test.web.entity.HiberInfo;
import com.test.web.service.HiberInfoService;
import com.test.web.service.impl.HiberInfoServiceImpl;

@WebServlet("/ajax-hiber/*")
public class AjaxHiberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private HiberInfoService hiberInfoService = new HiberInfoServiceImpl();
	private Gson gson = new Gson();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json;charset=UTF-8");
		String uri = request.getRequestURI();
		int idx = uri.lastIndexOf("/");
		String cmd = uri.substring(idx+1);
		System.out.println("uri : " + uri);
		System.out.println("cmd : " + cmd);
		String json = "";
		if("list".equals(cmd)) {
			List<HiberInfo> hiberInfoList = hiberInfoService.getHiberInfoList();
			json = gson.toJson(hiberInfoList);
		}else if("view".equals(cmd)) {
			int hiNum = Integer.parseInt(request.getParameter("hiNum"));
			HiberInfo hiber = hiberInfoService.getHiberInfo(hiNum);
			json = gson.toJson(hiber);
		}
		response.getWriter().append(json);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		BufferedReader br = request.getReader();
		String json = "";
		String str;
		while((str=br.readLine())!=null) {
			json += str;
		}
		HiberInfo hiber = gson.fromJson(json, HiberInfo.class);
		String uri = request.getRequestURI();
		int idx = uri.lastIndexOf("/");
		String cmd = uri.substring(idx+1);
		int result = 0;
		if("insert".equals(cmd)) {
			result = hiberInfoService.saveHiberInfo(hiber);
		}else if("update".equals(cmd)) {
			result = hiberInfoService.updateHiberInfo(hiber);
		}else if("delete".equals(cmd)) {
			result = hiberInfoService.deleteHiberInfo(hiber.getHiNum());
		}
		Map<String,Integer> rMap = new HashMap<>();
		rMap.put("result", result);
		json = gson.toJson(rMap);
		response.getWriter().append(json);
	}

}
