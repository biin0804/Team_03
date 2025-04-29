package com.bok.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import com.bok.service.SprtManagerService;

public class SprtContentDeleteAction implements Action {

    @Override
    public String execute(HttpServletRequest request) throws ServletException, IOException {
        String sprtpNum = request.getParameter("sprtpNum");

        if (sprtpNum == null || sprtpNum.isEmpty()) {
            request.setAttribute("alertMessage", "������ �׸��� �����ϴ�.");
            return "sprtBfManagerUI.html"; 
        }

        SprtManagerService service = new SprtManagerService();
        boolean isDeleted = service.removeSprt(Integer.parseInt(sprtpNum));

        if (isDeleted) {
            request.setAttribute("alertMessage", "���� ����");
        } else {
            request.setAttribute("alertMessage", "���� ����. �ٽ� �õ��� �ּ���.");
        }

        return "sprtBfManagerUI.html";
    }
}
