package com.bok.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

public class AskUIAction implements Action {

	@Override
	public String execute(HttpServletRequest request) throws ServletException, IOException {
		// �ܼ��� askUI.html �� �̸��� ��ȯ
		return "askUI.html";
	}
}
