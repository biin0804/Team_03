package com.bok.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/controller")
public class FrontControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cmd = request.getParameter("cmd");
		if (cmd == null) cmd = "mainUI";

		if ("getSprtCategory".equals(cmd) || "getSprtPerson".equals(cmd) || "getSprtContent".equals(cmd)) {
			Action a = ActionFactory.getAction(cmd);
			String jsonResponse = a.execute(request);  // ��û�� ó���ϰ� JSON ���ڿ��� ��ȯ����
			response.setContentType("application/json; charset=UTF-8");
			response.setCharacterEncoding("UTF-8");
			response.getWriter().write(jsonResponse);  // JSON ������ Ŭ���̾�Ʈ�� ��ȯ
		} else {
			Action a = ActionFactory.getAction(cmd);
			String url = a.execute(request); // URL ������
			request.getRequestDispatcher("/" + url).forward(request, response);
		}
	}
}


