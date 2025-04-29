package com.bok.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bok.model.AskVO;
import com.bok.model.SoloAskManagerVO;
import com.bok.model.SoloAskVO;
import com.bok.service.AskService;
import com.bok.service.SoloAskManagerService;
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

			writeJson(response, result);
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

		// 4) �󼼺��� ������ AJAX �б�
		if ("soloAskDetailUI".equals(cmd) && "true".equals(request.getParameter("ajax"))) {
			String askNum = request.getParameter("askNum");
			SoloAskVO vo = new SoloAskService().soloAskDetail(askNum);
			if (vo == null) {
				response.setStatus(HttpServletResponse.SC_NOT_FOUND);
				writeJson(response, Collections.singletonMap("error", "���Ǳ��� �����ϴ�."));
				return;
			}

			Map<String, String> detail = new HashMap<>();
			detail.put("askTitle", vo.getAskTitle());
			detail.put("soloContent", vo.getSoloContent());
			detail.put("soloAnswer", vo.getSoloAnswer() != null ? vo.getSoloAnswer() : "");

			writeJson(response, detail);
			return;
		}

		// 5) �亯 ���� �б�
		if ("soloAskAnswer".equals(cmd)) {
			String askNum = request.getParameter("askNum");
			String answer = request.getParameter("answer");

			SoloAskManagerVO vo = new SoloAskManagerVO();
			vo.setAskNum(askNum);
			vo.setSoloAnswer(answer);

			boolean ok = new SoloAskManagerService().soloAskSend(vo);
			if (ok) {
				response.setStatus(HttpServletResponse.SC_OK);
			} else {
				response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
			}
			return;
		}

		// 6) FAQ ��ü ��� AJAX �б�
		if ("askUI".equals(cmd) && "true".equals(request.getParameter("ajax"))) {
			Collection<AskVO> faqList = new AskService().getFaq();
			writeJson(response, faqList);
			return;
		}

		// Action ó�� (�� �̸� or JSON ���ڿ�)
		Action action = ActionFactory.getAction(cmd);

		String view = action.execute(request); // �������� 'view'�� ����

		// (1) ������/üũ����Ʈ ���� AJAX JSON
		if ("getSprtCategory".equals(cmd) || "getSprtPerson".equals(cmd) || "getSprtContent".equals(cmd)
				|| "getBfSprtPerson".equals(cmd) || "getBfSprtManagerPerson".equals(cmd) || "getCkCategory".equals(cmd)
				|| "getCkHomeInfo".equals(cmd)) {
			response.setContentType("application/json; charset=UTF-8");
			response.getWriter().write(view);
			return;
		}

		// (2) JSON ��� ���� �б�
		if ("json".equals(view)) {
			response.setContentType("application/json; charset=UTF-8");
			String resultJson = (String) request.getAttribute("resultJson");
			response.getWriter().write(resultJson);
			return;
		}

		// �� ��: JSP/HTML ������
		request.getRequestDispatcher("/" + view).forward(request, response);
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
