package com.bok.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Action {

	public String execute(HttpServletRequest request) throws ServletException, IOException;
	
	

}