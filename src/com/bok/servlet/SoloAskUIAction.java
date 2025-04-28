package com.bok.servlet;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.bok.model.SoloAskVO;
import com.bok.service.SoloAskService;

public class SoloAskUIAction implements Action {

	@Override
	public String execute(HttpServletRequest request) throws ServletException, IOException {

		// ������ ���۵� ������ �ޱ�
		String askEmail = request.getParameter("email"); // �̸���
		String askPw = request.getParameter("password"); // ��й�ȣ
		String askTitle = request.getParameter("title"); // ����
		String askContent = request.getParameter("content"); // ����
		String secret = request.getParameter("secret"); // ��б� ����

		// ��й�ȣ�� �̸����� �ʼ� �׸��̹Ƿ�, �Է��� ������ ó������ ����
		if (askEmail != null && !askEmail.isEmpty() && askPw != null && !askPw.isEmpty() && askTitle != null
				&& !askTitle.isEmpty() && askContent != null && !askContent.isEmpty()) {

			// ��б� ���� Ȯ�� (üũ�ڽ� ó��)
			int soloSecret = (secret != null && secret.equals("true")) ? 1 : 0;

			// SoloAskVO ��ü ���� �� ������ ����
			SoloAskVO soloAskVO = new SoloAskVO();
			soloAskVO.setEmail(askEmail);
			soloAskVO.setAskPw(askPw);
			soloAskVO.setAskTitle(askTitle);
			soloAskVO.setSoloSecret(soloSecret);
			soloAskVO.setSoloContent(askContent);

			// ���񽺿��� �����͸� DB�� ����
			SoloAskService soloAskService = new SoloAskService();
			soloAskService.addSoloAsk(soloAskVO); // DB�� �����ϴ� ���� �޼��� ȣ��
		}

		// 2. ������ soloList�� ��������
		SoloAskService ss = new SoloAskService();
		Collection<SoloAskVO> soloList = ss.getSoloAsk(); // DB���� ���� ���� �����
															// �����ɴϴ�.

		// 3. ���ǿ� soloList�� �����Ͽ� JSP�� ����
		HttpSession session = request.getSession(true);
		session.setAttribute("soloList", soloList);

		// 4. JSP �������� ������
		return "soloAskUI.jsp"; // ��û ó�� �� JSP �������� �̵�
	}
}
