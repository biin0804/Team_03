package com.bok.servlet;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.http.*;

import com.bok.model.SoloAskVO;
import com.bok.service.SoloAskService;

public class SoloAskUIAction implements Action {

	@Override
	public String execute(HttpServletRequest request) throws ServletException, IOException {
		// 1) ������ �Ѿ�� ����� �Ķ���� Ȯ��
		String email = request.getParameter("email");
		String askPw = request.getParameter("password");
		String askTitle = request.getParameter("title");
		String content = request.getParameter("content");
		String secret = request.getParameter("secret");

		// email �� password �� title �� content �� ��� �������� '����'���� ����
		if (email != null && askPw != null && askTitle != null && content != null) {
			SoloAskVO vo = new SoloAskVO();
			vo.setEmail(email);
			vo.setAskPw(askPw);
			vo.setAskTitle(askTitle);
			vo.setSoloContent(content);
			// üũ�ڽ� ó�� (üũ �� "true" �Ѿ���Ƿ�)
			vo.setSoloSecret("true".equals(secret) ? 1 : 0);

			// DB�� ���� (���� ���δ� ����)
			new SoloAskService().addSoloAsk(vo);
		}

		// 2) ���� ���ο� ������� �ֽ� ��� ��ȸ
		Collection<SoloAskVO> soloList = new SoloAskService().getSoloAsk();

		// 3) ���ǿ� ��Ƽ� soloAskUI.html �� JS�� AJAX ���̵�
		// session.getAttribute("soloList") �� Ȱ���ϰ� �� ���� �ְ�,
		// JS�� AJAX(fetch) ȣ���ؼ� ����ϰ� �� ���� �ֽ��ϴ�.
		HttpSession session = request.getSession(true);
		session.setAttribute("soloList", soloList);

		// 4) ���� ��
		return "soloAskUI.html";
	}
}
