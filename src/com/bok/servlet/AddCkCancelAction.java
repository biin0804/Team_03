package com.bok.servlet;

import javax.servlet.http.HttpServletRequest;
import com.bok.model.CkVO;
import com.bok.service.CkService;

public class AddCkCancelAction implements Action {

	@Override
	public String execute(HttpServletRequest request) {
		try {
			String category = request.getParameter("category"); // category �ޱ�

			// category�� �ֽ� ckNum ��ȸ
			CkVO latestCk = new CkService().getLatestCk(category);
			if (latestCk == null) {
				request.setAttribute("resultJson", "{\"success\":false, \"message\":\"ckNum ã�� �� ����\"}");
				return "json";
			}
			int ckNum = latestCk.getCkNum();

			boolean result = new CkService().cancelCkCategory(ckNum);

			if (result) {
				request.setAttribute("resultJson", "{\"success\":true}");
			} else {
				request.setAttribute("resultJson", "{\"success\":false, \"message\":\"���� ����\"}");
			}
			return "json";

		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("resultJson", "{\"success\":false, \"message\":\"���� ����\"}");
			return "json";
		}
	}
}