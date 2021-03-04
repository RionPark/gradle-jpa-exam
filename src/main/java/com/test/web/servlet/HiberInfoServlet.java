package com.test.web.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test.web.entity.HiberInfo;
import com.test.web.service.HiberInfoService;
import com.test.web.service.impl.HiberInfoServiceImpl;


@WebServlet(value = "/hiber-info/*")
public class HiberInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private HiberInfoService hiberInfoService = new HiberInfoServiceImpl();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri = request.getRequestURI();
		int idx = uri.lastIndexOf("/");
		String cmd = uri.substring(idx+1);
		response.setContentType("text/html;charset=UTF-8");
		if("hiber-list".equals(cmd)) {
			List<HiberInfo> hiberInfoList = hiberInfoService.getHiberInfoList();
			request.setAttribute("list", hiberInfoList);
		}else if("hiber-view".equals(cmd) || "hiber-update".equals(cmd)) {
			int hiNum = Integer.parseInt(request.getParameter("hiNum"));
			HiberInfo hi = hiberInfoService.getHiberInfo(hiNum);
			request.setAttribute("hi", hi);
		}
		RequestDispatcher rd = request.getRequestDispatcher("/hiber/" + cmd + ".jsp");
		rd.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		Integer hiNum = Integer.parseInt(request.getParameter("hiNum"));
		String hiId = request.getParameter("hiId");
		String hiName = request.getParameter("hiName");
		HiberInfo hi = new HiberInfo();
		hi.setHiNum(hiNum);
		hi.setHiName(hiName);
		hi.setHiId(hiId);
		String uri = request.getRequestURI();
		int idx = uri.lastIndexOf("/");
		String cmd = uri.substring(idx+1);
		int result = 1;
		String url = "hiber-update";
		if("insert".equals(cmd)) {
			result = hiberInfoService.saveHiberInfo(hi);
		}else if("update".equals(cmd)) {
			result = hiberInfoService.updateHiberInfo(hi);
		}else if("delete".equals(cmd)) {
			url = "hiber-view";
			result = hiberInfoService.deleteHiberInfo(hiNum);
		}
		request.setAttribute("result", result);
		RequestDispatcher rd = request.getRequestDispatcher("/hiber/" + url + ".jsp");
		rd.forward(request, response);
		
	}

}
