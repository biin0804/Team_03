// com/bok/servlet/SoloAskManagerUIAction.java
package com.bok.servlet;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import javax.servlet.ServletException;

public class SoloAskManagerUIAction implements Action {
	@Override
	public String execute(HttpServletRequest request) throws ServletException, IOException {
		// AJAX �� ����� �������Ƿ�, ���ǿ� ���� ���� �ʿ� ����
		return "soloAskManagerUI.html";
	}
}
