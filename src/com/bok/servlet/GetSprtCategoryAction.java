package com.bok.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bok.model.SprtInfoVO;
import com.bok.service.SprtService;
import com.google.gson.Gson;

public class GetSprtCategoryAction implements Action {
    @Override
    public String execute(HttpServletRequest request) throws ServletException, IOException {
        // ī�װ� ���� ��������
        SprtService service = new SprtService();
        List<SprtInfoVO> categoryList = service.getSprtInfo();

        // JSON���� ��ȯ
        Gson gson = new Gson();
        return gson.toJson(categoryList); // JSON ���ڿ� ��ȯ
    }
}
