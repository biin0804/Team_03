package com.bok.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import com.bok.service.SprtManagerService;



public class SetSprtDeleteAction implements Action {
	
	 @Override
	    public String execute(HttpServletRequest request) throws ServletException, IOException {
	        String sprtpNum = request.getParameter("sprtpNum");

	        if (sprtpNum == null || sprtpNum.isEmpty()) {
	            request.setAttribute("message", "������ �׸��� �����ϴ�.");
	            return "sprtManagerUI.html";  
	        }

	        
	        SprtManagerService service = new SprtManagerService();
	        boolean isDeleted = service.removeSprt(Integer.parseInt(sprtpNum));
	        
	        if (isDeleted) {
	            request.setAttribute("message", "���� ����");
	            return "sprtManagerUI.html";  
	        } else {
	            request.setAttribute("message", "���� ����");
	            return "tm.jsp"; 
	        }
	    }
	}