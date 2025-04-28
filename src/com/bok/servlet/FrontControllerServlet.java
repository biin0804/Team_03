package com.bok.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import com.bok.model.AskVO;
import com.bok.model.SoloAskVO;
import com.bok.service.AskService;
import com.bok.service.SoloAskService;
import com.google.gson.Gson;

@WebServlet("/controller")
public class FrontControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
		
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		String cmd = request.getParameter("cmd");
		if (cmd == null) {
			cmd = "mainUI";
		}

		// 1:1 ���� ��ü ��� AJAX �б�
		if ("soloAskUI".equals(cmd) && "true".equals(request.getParameter("ajax"))) {
			Collection<SoloAskVO> list = new SoloAskService().getSoloAsk();
			writeJson(response, list);
			return;
		}

		// **�̸��� �˻� AJAX �б� �߰�**
		if ("searchEmail".equals(cmd) && "true".equals(request.getParameter("ajax"))) {
			String email = request.getParameter("email");
			Collection<SoloAskVO> list = new SoloAskService().searchEmail(email);
			if (list == null || list.isEmpty()) {
				list = new SoloAskService().getSoloAsk();
			}
			writeJson(response, list);
			return;
		}

		// FAQ ��ü ��� AJAX �б�
		if ("askUI".equals(cmd) && "true".equals(request.getParameter("ajax"))) {
			Collection<AskVO> faqList = new AskService().getFaq();
			writeJson(response, faqList);
			return;
		}

		// �� �ܴ� ActionFactory �� Action �� �� ������
		Action action = ActionFactory.getAction(cmd);
		String view = action.execute(request);

		// ������ API JSON �б�...
		if ("getSprtCategory".equals(cmd) || "getSprtPerson".equals(cmd) || "getSprtContent".equals(cmd)
				|| "getBfSprtPerson".equals(cmd) || "getBfSprtManagerPerson".equals(cmd)) {
			response.setContentType("application/json; charset=UTF-8");
			response.getWriter().write(view);
			return;
		}
		// result="json" �б�...
		else if ("json".equals(view)) {
			response.setContentType("application/json; charset=UTF-8");
			String resultJson = (String) request.getAttribute("resultJson");
			response.getWriter().write(resultJson);
			return;
		}
		// HTML/JSP ������
		else {
			request.getRequestDispatcher("/" + view).forward(request, response);
		}
	}

	private void writeJson(HttpServletResponse response, Object data) throws IOException {
		String json = new Gson().toJson(data);
		response.setContentType("application/json; charset=UTF-8");
		try (PrintWriter out = response.getWriter()) {
			out.write(json);
			out.flush();
		}
	}
}
