package com.bok.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import com.bok.servlet.Action;

public class SoloAskDetailUIAction implements Action {

	@Override
	public String execute(HttpServletRequest request) throws ServletException, IOException {
		// �� �̻� session.setAttribute ���� �ʽ��ϴ�.
		// AJAX ����� `soloAskDetailCheck`�� JSON�� �޾ƿ� �������ϹǷ�
		// �ܼ��� detail HTML�� ��ȯ�� �ϸ� �˴ϴ�.
		return "soloAskDetailUI.html";
	}
}
