package com.bok.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

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

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		String cmd = request.getParameter("cmd");
		if (cmd == null)
			cmd = "mainUI";

		// 1) �󼼺��� ��й�ȣ Ȯ�� AJAX �б�
		if ("soloAskDetailCheck".equals(cmd) && "true".equals(request.getParameter("ajax"))) {
			String askNum = request.getParameter("askNum");
			String password = request.getParameter("password");

			SoloAskVO vo = new SoloAskService().soloAskDetail(askNum);
			boolean ok = vo != null && vo.getAskPw().equals(password);

			Map<String, Object> result = new HashMap<>();
			result.put("success", ok);
			if (ok) {
				Map<String, String> detail = new HashMap<>();
				detail.put("askTitle", vo.getAskTitle());
				detail.put("soloContent", vo.getSoloContent());
				detail.put("soloAnswer", vo.getSoloAnswer());
				result.put("detail", detail);
			}

			String json = new Gson().toJson(result);
			response.setContentType("application/json; charset=UTF-8");
			response.getWriter().write(json);
			return;
		}

		// 2) 1:1 ���� ��ü ��� AJAX �б�
		if ("soloAskUI".equals(cmd) && "true".equals(request.getParameter("ajax"))) {
			Collection<SoloAskVO> list = new SoloAskService().getSoloAsk();
			writeJson(response, list);
			return;
		}

		// 3) �̸��� �˻� AJAX �б�
		if ("searchEmail".equals(cmd) && "true".equals(request.getParameter("ajax"))) {
			String email = request.getParameter("email");
			Collection<SoloAskVO> list = new SoloAskService().searchEmail(email);
			if (list == null || list.isEmpty()) {
				list = new SoloAskService().getSoloAsk();
			}
			writeJson(response, list);
			return;
		}

		// 4) **�󼼺��� ������ AJAX �б�** (�߰��� �κ�)
		if ("soloAskDetailUI".equals(cmd) && "true".equals(request.getParameter("ajax"))) {
			String askNum = request.getParameter("askNum");
			SoloAskVO vo = new SoloAskService().soloAskDetail(askNum);

			Map<String, String> detail = new HashMap<>();
			detail.put("askTitle", vo.getAskTitle());
			detail.put("soloContent", vo.getSoloContent());
			detail.put("soloAnswer", vo.getSoloAnswer() != null ? vo.getSoloAnswer() : "");

			writeJson(response, detail);
			return;
		}

		// 5) FAQ ��ü ��� AJAX �б�
		if ("askUI".equals(cmd) && "true".equals(request.getParameter("ajax"))) {
			Collection<AskVO> faqList = new AskService().getFaq();
			writeJson(response, faqList);
			return;
		}

		Action action = ActionFactory.getAction(cmd);
		String result = action.execute(request);

		// (1) ������/üũ����Ʈ ���� ��ɾ� �� JSON �ٷ� ����
		if ("getSprtCategory".equals(cmd) || "getSprtPerson".equals(cmd) || "getSprtContent".equals(cmd)
				|| "getBfSprtPerson".equals(cmd) || "getBfSprtManagerPerson".equals(cmd) || "getCkCategory".equals(cmd)
				|| "getCkHomeInfo".equals(cmd)) {

			response.setContentType("application/json; charset=UTF-8");
			response.setCharacterEncoding("UTF-8");
			response.getWriter().write(result);
			return;
		}

		// (2) 1:1 ���� ��ü ��� AJAX ó��
		if ("soloAskUI".equals(cmd) && "true".equals(request.getParameter("ajax"))) {
			Collection<SoloAskVO> list = new SoloAskService().getSoloAsk();
			writeJson(response, list);
			return;
		}

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

	/**
	 * ���� JSON ���� ��ƿ
	 */
	private void writeJson(HttpServletResponse response, Object data) throws IOException {
		String json = new Gson().toJson(data);
		response.setContentType("application/json; charset=UTF-8");
		try (PrintWriter out = response.getWriter()) {
			out.write(json);
			out.flush();
		}
	}

}
