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
		request.setCharacterEncoding("utf-8");
		
		String cmd = request.getParameter("cmd");
		if (cmd == null) cmd = "mainUI";

		Action a = ActionFactory.getAction(cmd);
		String result = a.execute(request);

		// (1) ������ ���� ��ɾ�� �ٷ� JSON ����
		if ("getSprtCategory".equals(cmd) || "getSprtPerson".equals(cmd) || "getSprtContent".equals(cmd) || "getBfSprtPerson".equals(cmd) || "getBfSprtManagerPerson".equals(cmd)) {
			response.setContentType("application/json; charset=UTF-8");
			response.setCharacterEncoding("UTF-8");
			response.getWriter().write(result);
		}
		// (2) �װ� �ƴϰ�, ����� "json"�̸� request�� ����� JSON ��ȯ
		else if ("json".equals(result)) {
			response.setContentType("application/json; charset=UTF-8");
			response.setCharacterEncoding("UTF-8");
			String resultJson = (String) request.getAttribute("resultJson");
			response.getWriter().write(resultJson);
		}
		// (3) �� �ܿ��� �׳� ������ ������
		else {
			request.getRequestDispatcher("/" + result).forward(request, response);
		}
	}
}
